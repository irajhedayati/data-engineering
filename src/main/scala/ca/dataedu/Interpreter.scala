package ca.dataedu

import akka.http.scaladsl.server.Route
import ca.dataedu.savro.{ AvroProtocol, AvroSchema, HiveSchema }
import io.circe.parser._
import org.apache.avro.{ AvroTypeException, Protocol, Schema, SchemaFormatter, SchemaParseException }
import sttp.tapir.server.akkahttp.{ AkkaHttpServerInterpreter, AkkaHttpServerOptions }

import scala.concurrent.{ ExecutionContext, Future }
import scala.util.Try

//noinspection DuplicatedCode
class Interpreter(implicit ec: ExecutionContext) {

  private val customServerOptions: AkkaHttpServerOptions = AkkaHttpServerOptions.customiseInterceptors.options
  private val interpreter = AkkaHttpServerInterpreter(customServerOptions)

  private val avroFromJsonRoute: Route = interpreter.toRoute(AvroAPI.AvroFromJsonEndpoint.serverLogic { jsonDocument =>
    Future {
      parse(jsonDocument).left
        .map(_.message)
        .flatMap(in =>
          Either.cond(!in.asArray.exists(_.size > 1000), in, "The array size shouldn't exceed a 1000 records")
        )
        .flatMap(AvroSchema(_, "TestObject", Some("ca.dataedu")))
        .map(SchemaFormatter.format("json/pretty", _))
        .left
        .map(_.toString)
    }
  })

  private val idlFromAvroRoute: Route = interpreter.toRoute(AvroAPI.AvroToIdlEndpoint.serverLogic { avroSchema =>
    Future {
      parse(avroSchema).left
        .map(_.message)
        .map(_.asObject)
        .flatMap(_.toRight("The input value is not a JSON object"))
        .flatMap { in =>
          import ca.dataedu.savro.AvroImplicits._
          if (in.contains("protocol")) {
            Right(AvroProtocol.toIdl(Protocol.parse(avroSchema)))
          } else {
            try {
              new Schema.Parser().parse(avroSchema).toIdl("AvroSchemaTool").left.map(_.toString())
            } catch {
              case e: AvroTypeException    => Left(e.getMessage)
              case e: SchemaParseException => Left(e.getMessage)
            }
          }
        }
    }
  })

  private val idlToAvroRoute: Route = interpreter.toRoute(AvroAPI.IdlToAvroEndpoint.serverLogic { idl =>
    Future(Right(AvroProtocol(idl).toString(true)).withLeft[String])
  })

  private val avroToHiveRoute: Route = interpreter.toRoute(AvroAPI.AvroToHiveEndpoint.serverLogic { avroSchema =>
    Future(Try(HiveSchema(new Schema.Parser().parse(avroSchema))).toEither.flatten.left.map(_.toString()))
  })

  private val flatAvroTour: Route = interpreter.toRoute(AvroAPI.FlatAvroEndpoint.serverLogic { avroSchema =>
    Future {
      import ca.dataedu.savro.AvroImplicits._
      new Schema.Parser()
        .parse(avroSchema)
        .flat
        .map(SchemaFormatter.format("json/pretty", _))
        .left
        .map(error => s"Unable to flatten the input because: ${error.toString()}")
    }
  })

  val routes: Route = {
    import akka.http.scaladsl.server.Directives._
    concat(avroFromJsonRoute, idlFromAvroRoute, idlToAvroRoute, avroToHiveRoute, flatAvroTour)
  }

}

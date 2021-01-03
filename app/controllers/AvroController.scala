package controllers

import ca.dataedu.savro.{ AvroProtocol, AvroSchema }
import javax.inject.{ Inject, Singleton }
import org.apache.avro.{ AvroTypeException, Protocol, Schema, SchemaParseException }
import play.api.libs.json.{ JsArray, JsObject, JsValue }
import play.api.mvc._

@Singleton
class AvroController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.avro())
  }

  def avroFromJsonDocument(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val jsonDocument = request.body.asJson.get
    if (jsonDocument.isInstanceOf[JsArray] && jsonDocument.as[JsArray].value.size > 1000)
      BadRequest("The array size shouldn't exceed a 1000 records")
    AvroSchema(jsonDocument.toString(), "TestObject", Some("ca.dataedu")) match {
      case Left(error)  => BadRequest(error.toString)
      case Right(value) => Ok(value.toString(true))
    }
  }

  def idlFromAvro(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val jsonDocument: JsValue = request.body.asJson.get
    val jsonDocumentAsString: String = jsonDocument.toString()
    val parser = new Schema.Parser()
    import ca.dataedu.savro.AvroImplicits._
    if (jsonDocument.as[JsObject].keys.contains("protocol")) {
      Ok(AvroProtocol.toIdl(Protocol.parse(jsonDocumentAsString)))
    } else {
      try {
        parser.parse(jsonDocumentAsString).toIdl("AvroSchemaTool") match {
          case Left(error)  => BadRequest(error.toString())
          case Right(value) => Ok(value)
        }
      } catch {
        case e: AvroTypeException    => BadRequest(e.getMessage)
        case e: SchemaParseException => BadRequest(e.getMessage)
      }
    }
  }

  def avroFromIdl(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val idl: String = request.body.asText.get
    Ok(AvroProtocol(idl).toString(true))
  }
}

package controllers

import javax.inject.{Inject, Singleton}
import org.apache.avro.{AvroTypeException, Protocol, Schema}
import play.api.libs.json.{JsArray, JsObject, JsValue, Json}
import play.api.mvc._
import utils.{AvroProtocolToIdl, AvroSchema}

@Singleton
class AvroController @Inject()(cc: ControllerComponents) extends AbstractController(cc)  {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.avro())
  }

  def avroFromJsonDocument(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val jsonDocument = request.body.asJson.get
    if (jsonDocument.isInstanceOf[JsArray] && jsonDocument.as[JsArray].value.size > 1000)
      BadRequest("The array size shouldn't exceed a 1000 records")
    val output: String = AvroSchema(Json.toJson(jsonDocument), "TestObject").toString()
    Ok(output)
  }

  def idlFromAvro(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val jsonDocument: JsValue = request.body.asJson.get
    val jsonDocumentAsString: String = jsonDocument.toString()
    val parser = new Schema.Parser()
    import AvroSchema._
    if (jsonDocument.as[JsObject].keys.contains("protocol"))
      Ok(new AvroProtocolToIdl(Protocol.parse(jsonDocumentAsString)).convert())
    else {
      try {
        Ok(parser.parse(jsonDocumentAsString).toIdl("AvroSchemaTool"))
      } catch {
        case e: AvroTypeException => BadRequest(e.getMessage)
      }
    }
  }

  def avroFromIdl(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val idl: String = request.body.asText.get
    Ok(AvroSchema.idlToSchema(idl))
  }
}

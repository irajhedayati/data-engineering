package controllers

import javax.inject.{Inject, Singleton}
import org.apache.avro.Schema
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import utils.AvroSchema

@Singleton
class AvroController @Inject()(cc: ControllerComponents) extends AbstractController(cc)  {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.avro())
  }

  def avroFromJsonDocument(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val jsonDocument = request.body.asJson.get
    Ok(AvroSchema(Json.toJson(jsonDocument), "TestObject").toString())
  }

  def idlFromAvro(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val jsonDocument: String = request.body.asJson.get.toString()
    val parser = new Schema.Parser()
    import AvroSchema._
    Ok(parser.parse(jsonDocument).toIdl("AvroSchemaTool"))
  }

  def avroFromIdl(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val idl: String = request.body.asText.get
    Ok(AvroSchema.idlToSchema(idl))
  }
}

package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._

@Singleton
class JsonController @Inject()(cc: ControllerComponents) extends AbstractController(cc)  {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.jsoneditor())
  }

}

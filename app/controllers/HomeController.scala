package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(""))
  }

  def kafka(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.kafka())
  }

  def spark(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.spark())
  }

  def aws(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.aws())
  }

  def hadoop(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.hadoop())
  }
}

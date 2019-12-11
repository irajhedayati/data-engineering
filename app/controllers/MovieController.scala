package controllers

import javax.inject.{Inject, Singleton}
import models.Payload
import play.api.libs.json.Json
import play.api.mvc._
import repositories.DataRepository

@Singleton
class MovieController @Inject()(cc: ControllerComponents,
                                dataRepository: DataRepository)
  extends AbstractController(cc) {

  def list(page: Int = 1): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(Payload(page, dataRepository.pageSize, dataRepository.countMovies(), dataRepository.getMovies(page.toInt))))
  }

  def get(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    dataRepository.getMovie(id) map { post => Ok(Json.toJson(post)) } getOrElse NotFound
  }

  def post(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val jsonDocument = request.body.asJson.get
    Created(Json.toJson(dataRepository.add(jsonDocument)))
  }

  def put(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val jsonDocument = request.body.asJson.get
    Accepted(Json.toJson(dataRepository.update(jsonDocument)))
  }

  def delete(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Accepted("")
  }

  def ajaxCall(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("Ajax Call!")
  }

}

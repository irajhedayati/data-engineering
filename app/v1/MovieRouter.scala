package v1

import controllers.MovieController
import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class MovieRouter @Inject()(controller: MovieController) extends SimpleRouter {
  val prefix = "/api/v1/movies"
  override def routes: Routes = {
    case GET(p"/" ? q"page=$page") => controller.list(page.toInt)
    case GET(p"/") => controller.list()
    case GET(p"/$id") => controller.get(id.toInt)
    case POST(p"/") => controller.post()
    case PUT(p"/") => controller.put()
    case DELETE(p"/$id") => controller.delete(id.toInt)
  }
}

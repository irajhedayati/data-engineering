package ca.dataedu

import akka.actor.ActorSystem
import akka.http.scaladsl.Http

import scala.util.{ Failure, Success }

object Main extends App {

  implicit val actorSystem: ActorSystem = ActorSystem()

  import actorSystem.dispatcher

  Http()
    .newServerAt(interface = "0.0.0.0", port = 8080)
    .bind(CorsHandler.handler(new Interpreter().routes))
    .onComplete {
      case Success(binding) =>
        val address = binding.localAddress
        // noinspection HttpUrlsUsage
        actorSystem.log.info(s"Server online at http://${address.getHostString}:${address.getPort.toString}/")
      case Failure(ex) =>
        actorSystem.log.error(s"Failed to bind HTTP endpoint, terminating system ${ex.getMessage}")
        actorSystem.terminate()
    }

}

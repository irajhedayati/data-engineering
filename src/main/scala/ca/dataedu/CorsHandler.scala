package ca.dataedu

import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.headers.{`Access-Control-Allow-Credentials`, `Access-Control-Allow-Headers`, `Access-Control-Allow-Methods`, `Access-Control-Allow-Origin`}
import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.{complete, concat, options, respondWithHeaders}
import akka.http.scaladsl.server.Route

object CorsHandler {

  private val corsResponseHeaders = List(
    `Access-Control-Allow-Origin`.*,
    `Access-Control-Allow-Credentials`(true),
    `Access-Control-Allow-Headers`("Authorization", "Content-Type", "X-Requested-With")
  )

  //this handles preflight OPTIONS requests.
  private def preflightRequestHandler: Route = options {
    complete(
      HttpResponse(StatusCodes.OK).withHeaders(
        `Access-Control-Allow-Methods`(OPTIONS, POST, PUT, GET, DELETE)
      )
    )
  }

  def handler(r: Route): Route =
    respondWithHeaders(corsResponseHeaders) { concat(preflightRequestHandler, r) }

}

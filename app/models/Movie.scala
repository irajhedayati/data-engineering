package models

import play.api.libs.json.{Json, OFormat}

case class Movie(mId: Int, title: String, year: Int, director: Option[String])

object Movie {
  implicit val format: OFormat[Movie] = Json.format[Movie]
}

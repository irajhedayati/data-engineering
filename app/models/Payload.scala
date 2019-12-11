package models

import play.api.libs.json.{Json, OFormat}

case class Payload(page: Int, perPage: Int, total: Int, data: List[Movie])

object Payload {
  implicit val format: OFormat[Payload] = Json.format[Payload]
}

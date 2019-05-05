package models

import play.api.libs.json.{Json, OFormat, Reads, Writes}

case class CommandResults( result : List[(String, String)]) {
}
object CommandResults {
  implicit val traceReads: Reads[CommandResults] = Json.reads[CommandResults]
  implicit val traceWrites: Writes[CommandResults] = Json.writes[CommandResults]
  implicit def jsonFormat: OFormat[CommandResults] = Json.using[Json.WithDefaultValues].format[CommandResults]
}
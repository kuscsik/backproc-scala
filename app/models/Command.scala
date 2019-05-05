package models

import play.api.libs.json.{Json, OFormat, Reads, Writes}

case class Command(commands : List[String])
{

}
object Command {
  implicit val traceReads: Reads[Command] = Json.reads[Command]
  implicit val traceWrites: Writes[Command] = Json.writes[Command]
  implicit def jsonFormat: OFormat[Command] = Json.using[Json.WithDefaultValues].format[Command]
}
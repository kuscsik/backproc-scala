package controllers

import java.util.Base64

import javax.inject._
import models.{Command, CommandResults, ValidCommands}
import play.api._
import play.api.libs.json.{JsResult, Json}
import play.api.mvc._

import sys.process._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }


  def pipe(async : Option[Int]) = Action { implicit request: Request[AnyContent] =>
    val data = request.body.asJson.get

    val w: JsResult[Command] = Json.fromJson[Command](data)
    
    val c: Command = w.get

    val validCommands = c.commands.filter( ValidCommands.isValidCommand(_))

    val results : List[String] = validCommands.map(_.!!)

    val bytesEncoded  : List[String] = results.map( x => java.util.Base64.getEncoder.encodeToString(x.toString.getBytes()))

    val res = CommandResults((validCommands zip bytesEncoded))

    Ok(Json.toJson(res))
  }
}

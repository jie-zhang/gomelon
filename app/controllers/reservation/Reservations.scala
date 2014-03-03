package controllers.reservation

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data.Form

object Reservations extends Controller{
	def hairReservation = Action {
	  Ok(views.html.haircatalog.hairReservation("hello"))
	}
}
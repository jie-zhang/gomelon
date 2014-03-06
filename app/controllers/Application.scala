package controllers

import play.api.mvc._
import controllers.user.Users

object Application extends Controller {
	def index = Action {
		Ok(views.html.index("Your new application is ready."))
	}

  def login() = Action {
    Ok(views.html.user.login(Users.loginForm))
  }

  def register() = Action {
    Ok(views.html.user.register(Users.registerForm()))
  }
}

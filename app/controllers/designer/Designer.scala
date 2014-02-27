package controllers.designer

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data.Form

object Designer extends Controller {
	def designermain = Action{
	  Ok(views.html.designer.designermain("hello"))
	}
	def designersearch = Action{
	  Ok(views.html.designer.designersearch("hello"))
	}
	def designerview = Action{
		Ok(views.html.designer.designerview("hello"))
	}
	def designerTask = Action {
	  Ok(views.html.designer.designerTask("hello"))
	}
}
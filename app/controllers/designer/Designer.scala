package controllers.designer

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data.Form
import java.util.Date
import java.text.SimpleDateFormat
import java.util
;

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
	   
	  var date:Date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2005-06-09 06:30")
	  var list:List[java.util.Date]=Nil
	  val from = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	  for(i<-1 to 25){
	    date.setMinutes(date.getMinutes() - 30)
	    println("date......."+from.format(date))
	    list:::=List(new Date(date.toString())) //error
	  }
	  Ok(views.html.designer.designerTask(list.reverse))
	}
}
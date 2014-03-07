package controllers

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data.Form
import models.User
import scala.util.matching.Regex
import play.libs.Json


object Users extends Controller {

  val loginForm = Form(
	    tuple("name" -> text(minLength = 6),
	    	  "password" -> nonEmptyText(minLength = 6)
	    	  )
	  )
  val registerForm = Form(
     tuple("name" -> text(minLength = 6),
	    "password" -> tuple(
        "main" -> text(minLength = 6),
        "confirm" -> text
      ).verifying(
        // Add an additional constraint: both passwords must match
        "Passwords don't match", passwords => passwords._1 == passwords._2
      ),"email" -> nonEmptyText,
        "phone" -> nonEmptyText,
        "sex" -> text,
        "city" -> tuple(
            "first" -> text,
            "second" -> text),
        "intro" -> text
        
	    	  ) 
  )
  	/**
  	 * 进入登录页面
  	 */
	def login = Action{
		 Ok(views.html.login(loginForm))
	}
  	/**
  	 * 登录用户名及密码验证  	 */
  
  // 需要判斷用戶的類型 by wu 
  	def tologin = Action{implicit request =>
  	 loginForm.bindFromRequest.fold(
	    error =>BadRequest(views.html.index("鍙戠幇閿欒")), 
	    {
	      case(name,password)=>
	      val isexists = User.checkUserName(name)
	      if(isexists){
	        val isPassword: Boolean= User.checkPassword(name, password)
	        if(isPassword){
	          val user_id = User.findId(name)
//	         Redirect(controllers.record.routes.Records.recordmain(1)).withSession(request.session + ("records" ->"spahome"))
	          Redirect(routes.MyPages.myPageMain).withSession(request.session+("user_id" -> user_id.toString()))
	        }else{
	          Ok(views.html.index("密码错误"))
	        }
	      }else{
	        Ok(views.html.index("用户名不存在"))
	      }
	    }
	)
  	}
  	/**
  	 * 登录成功页面
  	 */
  	def loginSuccess = Action {
  		Ok(views.html.loginSuccess("登录成功"))
  	}
  	/**
  	 * 进入注册页面
  	 * 
  	 */
  	def register = Action {
  	  Ok(views.html.register(registerForm))
  	}
  	/**
  	 * 后台注册
  	 */
  	def toregister = Action {implicit request =>
  	  registerForm.bindFromRequest.fold(
  	    error =>BadRequest(views.html.index("发现错误")),
  	    {
  	      case(name,(main,confirm),email,phone,sex,(first,second),intro)=>
  	      val isexists = User.checkUserName(name)
  	      if(isexists){
  	        Ok(views.html.index("用户名已存在"))
  	      }else{
  	        User.toRegister(name, main, email,phone, sex, first, intro)
  	        Ok(views.html.index("注册成功"))
  	      }
  	    }
  	  )
  	  
  	}
  	/**
  	 * 进到用户信息更新页面
  	 */
  	def updateUserInfo = Action{implicit request =>
  	  val name = request.session.get("user").get
  	  if(name.isEmpty){
  	    Redirect(routes.Users.login)
  	  }else{
  	    val user: User= User.findUserByName(name)
  	    Ok(views.html.updateUser(user,registerForm))
  	  }
  	}
  	/**
  	 * ajax异步验证用户名是否存在
  	 */
  	def checkNameisexit(name: String) = Action{
  	   val isexit = User.checkUserName(name)
  	   println("name check "+name)
  	   println("isexit"+isexit)
  	   if(isexit){
  	     Ok("用户名已存在")
  	   }else{
  	     println("for ajax ..........")
  	     Ok("可以使用")
  	   }
  	   
  	 }
}
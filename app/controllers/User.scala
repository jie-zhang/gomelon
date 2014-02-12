package controllers

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data.Form
import models.Users
import scala.util.matching.Regex
object User extends Controller {

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
  	 * 跳转登录页面
  	 */
	def login = Action{
		 Ok(views.html.login(loginForm))
	}
  	/**
  	 * 登录信息的验证
  	 */
  	def tologin = Action{implicit request =>
  	 loginForm.bindFromRequest.fold(
	    error =>BadRequest(views.html.index("发现错误")), 
	    {
	      case(name,password)=>
	        println(name)
	      val isexists = Users.checkUserName(name)
	      println("isexists"+isexists)
	      if(isexists){
	        val isPassword: Boolean= Users.checkPassword(name, password)
	        println(isPassword)
	        if(isPassword){
	         Ok(views.html.loginSuccess("登录成功")).withSession(request.session + ("user" ->name))
	        }else{
	          Ok(views.html.index("密码错误"))
	        }
	      }else{
	        Ok(views.html.index("用户名不存在"))
	      }
	    }
	)
  	}
  	def loginSuccess = Action {
  		Ok(views.html.loginSuccess("登陸成功"))
  	}
  	/**
  	 * 跳转注册
  	 * 
  	 */
  	def register = Action {
  	  Ok(views.html.register(registerForm))
  	}
  	/**
  	 * 注册用户
  	 */
  	def toregister = Action {implicit request =>
  	  registerForm.bindFromRequest.fold(
  	    error =>BadRequest(views.html.index("发现错误")),
  	    {
  	      case(name,(main,confirm),email,phone,sex,(first,second),intro)=>
  	      val isexists = Users.checkUserName(name)
  	      if(isexists){
  	        Ok(views.html.index("用户名已存在"))
  	      }else{
  	        Users.toRegister(name, main, email,phone, sex, first, intro)
  	        Ok(views.html.index("注册成功"))
  	      }
  	    }
  	  )
  	  
  	}
  	/**
  	 * 个人信息修改
  	 */
  	def updateUserInfo = Action{implicit request =>
  	  val name = request.session.get("user").get
  	  if(name.isEmpty){
  	    Redirect(routes.User.login)
  	  }else{
  	    val user: Users= Users.findUserByName(name)
  	    Ok(views.html.updateUser(user,registerForm))
  	  }
  	   
  	  
  	}
}
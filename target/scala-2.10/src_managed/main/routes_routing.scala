// @SOURCE:E:/PD/playtest/forTest/conf/routes
// @HASH:a3d70c4149cd0289168e09955c337eb60b16383a
// @DATE:Tue Feb 11 19:16:07 CST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:11
private[this] lazy val controllers_User_login2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:13
private[this] lazy val controllers_User_tologin3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tologin"))))
        

// @LINE:15
private[this] lazy val controllers_User_loginSuccess4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("loginSuccess"))))
        

// @LINE:17
private[this] lazy val controllers_User_register5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
        

// @LINE:19
private[this] lazy val controllers_User_toregister6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("toregister"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.User.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tologin""","""controllers.User.tologin"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """loginSuccess""","""controllers.User.loginSuccess"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.User.register"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """toregister""","""controllers.User.toregister""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:11
case controllers_User_login2(params) => {
   call { 
        invokeHandler(controllers.User.login, HandlerDef(this, "controllers.User", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:13
case controllers_User_tologin3(params) => {
   call { 
        invokeHandler(controllers.User.tologin, HandlerDef(this, "controllers.User", "tologin", Nil,"POST", """""", Routes.prefix + """tologin"""))
   }
}
        

// @LINE:15
case controllers_User_loginSuccess4(params) => {
   call { 
        invokeHandler(controllers.User.loginSuccess, HandlerDef(this, "controllers.User", "loginSuccess", Nil,"GET", """""", Routes.prefix + """loginSuccess"""))
   }
}
        

// @LINE:17
case controllers_User_register5(params) => {
   call { 
        invokeHandler(controllers.User.register, HandlerDef(this, "controllers.User", "register", Nil,"GET", """""", Routes.prefix + """register"""))
   }
}
        

// @LINE:19
case controllers_User_toregister6(params) => {
   call { 
        invokeHandler(controllers.User.toregister, HandlerDef(this, "controllers.User", "toregister", Nil,"GET", """""", Routes.prefix + """toregister"""))
   }
}
        
}

}
     
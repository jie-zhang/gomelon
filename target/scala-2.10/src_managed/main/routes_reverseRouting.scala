// @SOURCE:E:/PD/playtest/forTest/conf/routes
// @HASH:a3d70c4149cd0289168e09955c337eb60b16383a
// @DATE:Tue Feb 11 19:16:07 CST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:6
package controllers {

// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
class ReverseUser {
    

// @LINE:13
def tologin(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "tologin")
}
                                                

// @LINE:19
def toregister(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "toregister")
}
                                                

// @LINE:15
def loginSuccess(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "loginSuccess")
}
                                                

// @LINE:17
def register(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "register")
}
                                                

// @LINE:11
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
class ReverseUser {
    

// @LINE:13
def tologin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.tologin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tologin"})
      }
   """
)
                        

// @LINE:19
def toregister : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.toregister",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "toregister"})
      }
   """
)
                        

// @LINE:15
def loginSuccess : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.loginSuccess",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loginSuccess"})
      }
   """
)
                        

// @LINE:17
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.register",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:11
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:19
// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
class ReverseUser {
    

// @LINE:13
def tologin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.tologin(), HandlerDef(this, "controllers.User", "tologin", Seq(), "POST", """""", _prefix + """tologin""")
)
                      

// @LINE:19
def toregister(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.toregister(), HandlerDef(this, "controllers.User", "toregister", Seq(), "GET", """""", _prefix + """toregister""")
)
                      

// @LINE:15
def loginSuccess(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.loginSuccess(), HandlerDef(this, "controllers.User", "loginSuccess", Seq(), "GET", """""", _prefix + """loginSuccess""")
)
                      

// @LINE:17
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.register(), HandlerDef(this, "controllers.User", "register", Seq(), "GET", """""", _prefix + """register""")
)
                      

// @LINE:11
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.login(), HandlerDef(this, "controllers.User", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    
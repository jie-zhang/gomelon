
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object loginSuccess extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
	<body id="loginsuccess" onload="success();">
    <h2>"""),_display_(Seq[Any](/*5.10*/message)),format.raw/*5.17*/("""</h2>
    <span id="times">5</span>秒后跳转。。。。。。
	</body>
""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Feb 11 15:13:11 CST 2014
                    SOURCE: E:/PD/playtest/forTest/app/views/loginSuccess.scala.html
                    HASH: f5b55c2bb86ca1a025b11e81a8d4115a5a79c7b3
                    MATRIX: 563->1|674->18|713->23|744->46|783->48|876->106|904->113
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5
                    -- GENERATED --
                */
            
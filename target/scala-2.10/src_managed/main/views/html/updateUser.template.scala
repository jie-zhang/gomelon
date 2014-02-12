
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
object updateUser extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Users,Form[scala.Tuple7[String, scala.Tuple2[String, String], String, String, String, scala.Tuple2[String, String], String]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user:Users,registerForm:Form[(String,(String,String),String,String,String,(String,String),String)]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.102*/("""
"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("updateInfo")/*5.20*/{_display_(Seq[Any](format.raw/*5.21*/("""
	<div class="updateuser-content">
	<div class="registerForm">
		<h2>注册用户</h2>
		
		"""),_display_(Seq[Any](/*10.4*/form(routes.User.toregister)/*10.32*/{_display_(Seq[Any](format.raw/*10.33*/("""
			<table>
			<tr>
				<td align="right"><label id="usernameinf">用户名：</label></td>
				<td><input class="base-input" id="name" name="name" disabled="disabled" value=""""),_display_(Seq[Any](/*14.85*/user/*14.89*/.name)),format.raw/*14.94*/(""""></td>
				<td><span id="nameMsg"></span></td>
			</tr>
			<tr>
				<td align="right"><label id="label">密码：</label></td>
				<td><input type="password" class="base-input" id="password-main" name="password.main" value=""""),_display_(Seq[Any](/*19.99*/user/*19.103*/.password)),format.raw/*19.112*/(""""></td>
				<td><span id="passwordMainMsg"></span></td>
			</tr>
			<tr>
				<td align="right"><label>确认密码：</label></td>
				<td><input type="password" class="base-input" id="password-confirm" name="password.confirm"></td>
				<td><span id="passwordConfirmMsg"></span></td>
			</tr>
			<tr>
	            <td align="right"><label>email：</label></td>        
	            <td class="width70"><input name="email" type="text" class="base-input" value=""""),_display_(Seq[Any](/*29.93*/user/*29.97*/.email)),format.raw/*29.103*/("""" /></td>
	            <td><span id="emailMsg"></span></td>
	        </tr>
	        <tr>
	            <td align="right"><label>手机号码：</label></td>        
	            <td class="width70"><input name="phone" id="phone" class="base-input" value=""""),_display_(Seq[Any](/*34.92*/user/*34.96*/.phone)),format.raw/*34.102*/(""""/></td>
	            <td><span id="phoneMsg"></span></td>
	        </tr>
	        <tr>
	            <td align="right"><label>性别：</label></td>        
	            <td class="width70"><input type="radio" name="sex" value="0" />男
	            <input type="radio" name="sex" value="1">女</td>
	        </tr>
	        <tr>
	        	<td colspan="2">
	        	<select id="provice" name="city.first">
	        		<option>--选择省份--</option>
	        	</select>
	        	<select id="citys" name="city.second">
	        		<option>--选择城市--</option>
	        	</select>
	        	</td>
	        </tr>
	        <tr>
	        	<td align="right"><label>自我介绍：</label></td>
	        	<td rowspan="1"><textarea name="intro" rows="4" cols="22"></textarea></td>
	        </tr>
			<tr>
				<td colspan="2"><input type="submit" class="submit" value="注册">
				</td>
			</tr>
		</table>
		<div class="otheruser">
			
		</div>
		""")))})),format.raw/*64.4*/("""
		</div>
</div>
""")))})))}
    }
    
    def render(user:Users,registerForm:Form[scala.Tuple7[String, scala.Tuple2[String, String], String, String, String, scala.Tuple2[String, String], String]]): play.api.templates.HtmlFormat.Appendable = apply(user,registerForm)
    
    def f:((Users,Form[scala.Tuple7[String, scala.Tuple2[String, String], String, String, String, scala.Tuple2[String, String], String]]) => play.api.templates.HtmlFormat.Appendable) = (user,registerForm) => apply(user,registerForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Feb 12 14:29:03 CST 2014
                    SOURCE: E:/PD/playtest/forTest/app/views/updateUser.scala.html
                    HASH: 691f5ff0d7827ef5f7a3e933e3e98e6949cd4297
                    MATRIX: 679->1|926->101|954->156|991->159|1017->177|1055->178|1180->268|1217->296|1256->297|1464->469|1477->473|1504->478|1765->703|1779->707|1811->716|2306->1175|2319->1179|2348->1185|2634->1435|2647->1439|2676->1445|3643->2381
                    LINES: 19->1|25->1|26->4|27->5|27->5|27->5|32->10|32->10|32->10|36->14|36->14|36->14|41->19|41->19|41->19|51->29|51->29|51->29|56->34|56->34|56->34|86->64
                    -- GENERATED --
                */
            
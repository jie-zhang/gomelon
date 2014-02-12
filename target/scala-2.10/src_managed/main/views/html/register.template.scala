
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
object register extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[scala.Tuple7[String, scala.Tuple2[String, String], String, String, String, scala.Tuple2[String, String], String]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(registerForm:Form[(String,(String,String),String,String,String,(String,String),String)]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.91*/("""
"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("register")/*5.18*/{_display_(Seq[Any](format.raw/*5.19*/("""
<div class="register-content">
	<div class="registerForm">
		<h2>注册用户</h2>
		
		"""),_display_(Seq[Any](/*10.4*/form(routes.User.toregister)/*10.32*/{_display_(Seq[Any](format.raw/*10.33*/("""
			<table>
			<tr>
				<td align="right"><label id="usernameinf">用户名：</label></td>
				<td><input class="base-input" id="name" name="name"></td>
				<td><span id="nameMsg">20长度以内的汉字、字母和数字的组合</span></td>
			</tr>
			<tr>
				<td align="right"><label id="label">密码：</label></td>
				<td><input type="password" class="base-input" id="password-main" name="password.main"></td>
				<td><span id="passwordMainMsg">4~20字母开头，数字或下划线组合</span></td>
			</tr>
			<tr>
				<td align="right"><label>确认密码：</label></td>
				<td><input type="password" class="base-input" id="password-confirm" name="password.confirm"></td>
				<td><span id="passwordConfirmMsg"></span></td>
			</tr>
			<tr>
	            <td align="right"><label>email：</label></td>        
	            <td class="width70"><input name="email" id="email" type="text" class="base-input" /></td>
	            <td><span id="emailMsg"></span></td>
	        </tr>
	        <tr>
	            <td align="right"><label>手机号码：</label></td>        
	            <td><input name="phone" id="phone" class="base-input" /></td>
	            <td><span id="phoneMsg"></span></td>
	        </tr>
	        <tr>
	            <td align="right"><label>性别：</label></td>        
	            <td colspan="2"><input type="radio" name="sex" value="0" />男
	            <input type="radio" name="sex" value="1">女</td>
	            
	        </tr>
	        <tr>
	        	<td></td>
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
		""")))})),format.raw/*66.4*/("""
		</div>
</div>
""")))})))}
    }
    
    def render(registerForm:Form[scala.Tuple7[String, scala.Tuple2[String, String], String, String, String, scala.Tuple2[String, String], String]]): play.api.templates.HtmlFormat.Appendable = apply(registerForm)
    
    def f:((Form[scala.Tuple7[String, scala.Tuple2[String, String], String, String, String, scala.Tuple2[String, String], String]]) => play.api.templates.HtmlFormat.Appendable) = (registerForm) => apply(registerForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Feb 12 14:35:57 CST 2014
                    SOURCE: E:/PD/playtest/forTest/app/views/register.scala.html
                    HASH: a0d2d9c0fd264ba42c794de309b07929f4001b93
                    MATRIX: 671->1|906->90|934->145|971->148|995->164|1033->165|1155->252|1192->280|1231->281|3307->2326
                    LINES: 19->1|25->1|26->4|27->5|27->5|27->5|32->10|32->10|32->10|88->66
                    -- GENERATED --
                */
            
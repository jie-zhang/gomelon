
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*10.74*/("""" type="text/javascript"></script>
        <script language="javascript" type="text/javascript">
			$(function()"""),format.raw/*12.16*/("""{"""),format.raw/*12.17*/("""
				$("#emailLogin").click(function()"""),format.raw/*13.38*/("""{"""),format.raw/*13.39*/("""
					$("#usernameinf").text("邮箱：");
					$("#name").attr("name","email");
				"""),format.raw/*16.5*/("""}"""),format.raw/*16.6*/(""");
				$("#nameLogin").click(function()"""),format.raw/*17.37*/("""{"""),format.raw/*17.38*/("""
					$("#usernameinf").text("用户名：");
					$("#name").attr("name","name");
				"""),format.raw/*20.5*/("""}"""),format.raw/*20.6*/(""");
				$("#provice").click(function()"""),format.raw/*21.35*/("""{"""),format.raw/*21.36*/("""
					var provices=new Array("吉林省","辽宁省");
				"""),format.raw/*23.5*/("""}"""),format.raw/*23.6*/(""");
				$("#name").blur(function()"""),format.raw/*24.31*/("""{"""),format.raw/*24.32*/("""
					var name=$(this).val();
					var isname=/^[a-zA-Z][a-zA-Z0-9_]"""),format.raw/*26.39*/("""{"""),format.raw/*26.40*/("""4,15"""),format.raw/*26.44*/("""}"""),format.raw/*26.45*/("""$/;
					
					if(!isname.test(name))"""),format.raw/*28.28*/("""{"""),format.raw/*28.29*/("""
						$("#nameMsg").text("用户名无效").removeClass("trueMsg").addClass("errorMsg");
						return;
					"""),format.raw/*31.6*/("""}"""),format.raw/*31.7*/("""
					$("#nameMsg").text("可以使用").removeClass("errorMsg").addClass("trueMsg");
				"""),format.raw/*33.5*/("""}"""),format.raw/*33.6*/(""");
				$("#password-main").blur(function()"""),format.raw/*34.40*/("""{"""),format.raw/*34.41*/("""
					var password=$(this).val();
					var ispassword=/^[a-zA-Z]\w"""),format.raw/*36.33*/("""{"""),format.raw/*36.34*/("""5,17"""),format.raw/*36.38*/("""}"""),format.raw/*36.39*/("""$/;
					if(!ispassword.test(password))"""),format.raw/*37.36*/("""{"""),format.raw/*37.37*/("""
						$("#passwordMainMsg").text("密码无效").removeClass("trueMsg").addClass("errorMsg");
						return;
					"""),format.raw/*40.6*/("""}"""),format.raw/*40.7*/("""
					$("#passwordMainMsg").text("可以使用").removeClass("errorMsg").addClass("trueMsg");
				"""),format.raw/*42.5*/("""}"""),format.raw/*42.6*/(""");
				
				$("#password-confirm").blur(function()"""),format.raw/*44.43*/("""{"""),format.raw/*44.44*/("""
					var password=$(this).val();
					var ispassword=/^[a-zA-Z]\w"""),format.raw/*46.33*/("""{"""),format.raw/*46.34*/("""5,17"""),format.raw/*46.38*/("""}"""),format.raw/*46.39*/("""$/;
					if(!ispassword.test(password))"""),format.raw/*47.36*/("""{"""),format.raw/*47.37*/("""
						$("#passwordConfirmMsg").text("密码无效").removeClass("trueMsg").addClass("errorMsg");
						return;
					"""),format.raw/*50.6*/("""}"""),format.raw/*50.7*/("""
					var firstPassword=$("#password-main").val();
					if(password!=firstPassword)"""),format.raw/*52.33*/("""{"""),format.raw/*52.34*/("""
						$("#passwordConfirmMsg").text("两次密码输入需一致").removeClass("trueMsg").addClass("errorMsg");
						return;
					"""),format.raw/*55.6*/("""}"""),format.raw/*55.7*/("""
					$("#passwordConfirmMsg").text("输入正确").removeClass("errorMsg").addClass("trueMsg");
				"""),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""");
				$("#email").blur(function()"""),format.raw/*58.32*/("""{"""),format.raw/*58.33*/("""
					var email=$(this).val();
					var isemail=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
					if(!isemail.test(email))"""),format.raw/*61.30*/("""{"""),format.raw/*61.31*/("""
						$("#emailMsg").text("邮箱无效").removeClass("trueMsg").addClass("errorMsg");
						return;
					"""),format.raw/*64.6*/("""}"""),format.raw/*64.7*/("""
					$("#emailMsg").text("可以使用").removeClass("errorMsg").addClass("trueMsg");
				"""),format.raw/*66.5*/("""}"""),format.raw/*66.6*/(""");
				$("#phone").blur(function()"""),format.raw/*67.32*/("""{"""),format.raw/*67.33*/("""
					var phone=$(this).val();
					var isphone=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d"""),format.raw/*69.83*/("""{"""),format.raw/*69.84*/("""8"""),format.raw/*69.85*/("""}"""),format.raw/*69.86*/("""$/;
					if(!isphone.test(phone))"""),format.raw/*70.30*/("""{"""),format.raw/*70.31*/("""
						$("#phoneMsg").text("号码无效").removeClass("trueMsg").addClass("errorMsg");
						return;
					"""),format.raw/*73.6*/("""}"""),format.raw/*73.7*/("""
					$("#phoneMsg").text("号码有效").removeClass("errorMsg").addClass("trueMsg");
				"""),format.raw/*75.5*/("""}"""),format.raw/*75.6*/(""");
			"""),format.raw/*76.4*/("""}"""),format.raw/*76.5*/(""")
			var timer = null;
			var i=5;
			function success()"""),format.raw/*79.22*/("""{"""),format.raw/*79.23*/("""
				timer=window.setInterval(showTimes,1000);
				window.setTimeout("go()",6000);
					
					if(i==0)"""),format.raw/*83.14*/("""{"""),format.raw/*83.15*/("""
						clearInterval(timer);
					"""),format.raw/*85.6*/("""}"""),format.raw/*85.7*/("""
					
				"""),format.raw/*87.5*/("""}"""),format.raw/*87.6*/("""
			function go( ) """),format.raw/*88.19*/("""{"""),format.raw/*88.20*/("""//定义函数
	            window.location="findAll";//页面跳转
	    	 """),format.raw/*90.8*/("""}"""),format.raw/*90.9*/("""
			function showTimes()"""),format.raw/*91.24*/("""{"""),format.raw/*91.25*/("""
					document.getElementById("times").innerHTML=i;
					i--;
				"""),format.raw/*94.5*/("""}"""),format.raw/*94.6*/("""	
         </script>
    </head>
    <body>
        """),_display_(Seq[Any](/*98.10*/content)),format.raw/*98.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Feb 12 14:35:57 CST 2014
                    SOURCE: E:/PD/playtest/forTest/app/views/main.scala.html
                    HASH: 45dc13f36aed7e92685961757a78752ddb075182
                    MATRIX: 560->1|684->31|772->84|798->89|895->151|909->157|964->191|1060->252|1074->258|1127->290|1188->315|1203->321|1270->366|1410->478|1439->479|1505->517|1534->518|1640->597|1668->598|1735->637|1764->638|1870->717|1898->718|1963->755|1992->756|2066->803|2094->804|2155->837|2184->838|2280->906|2309->907|2341->911|2370->912|2435->949|2464->950|2590->1049|2618->1050|2727->1132|2755->1133|2825->1175|2854->1176|2948->1242|2977->1243|3009->1247|3038->1248|3105->1287|3134->1288|3267->1394|3295->1395|3412->1485|3440->1486|3518->1536|3547->1537|3641->1603|3670->1604|3702->1608|3731->1609|3798->1648|3827->1649|3963->1758|3991->1759|4102->1842|4131->1843|4272->1957|4300->1958|4420->2051|4448->2052|4510->2086|4539->2087|4693->2214|4722->2215|4848->2314|4876->2315|4986->2398|5014->2399|5076->2433|5105->2434|5246->2547|5275->2548|5304->2549|5333->2550|5394->2583|5423->2584|5549->2683|5577->2684|5687->2767|5715->2768|5748->2774|5776->2775|5860->2831|5889->2832|6019->2934|6048->2935|6109->2969|6137->2970|6175->2981|6203->2982|6250->3001|6279->3002|6366->3062|6394->3063|6446->3087|6475->3088|6568->3154|6596->3155|6685->3208|6714->3215
                    LINES: 19->1|22->1|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|33->12|33->12|34->13|34->13|37->16|37->16|38->17|38->17|41->20|41->20|42->21|42->21|44->23|44->23|45->24|45->24|47->26|47->26|47->26|47->26|49->28|49->28|52->31|52->31|54->33|54->33|55->34|55->34|57->36|57->36|57->36|57->36|58->37|58->37|61->40|61->40|63->42|63->42|65->44|65->44|67->46|67->46|67->46|67->46|68->47|68->47|71->50|71->50|73->52|73->52|76->55|76->55|78->57|78->57|79->58|79->58|82->61|82->61|85->64|85->64|87->66|87->66|88->67|88->67|90->69|90->69|90->69|90->69|91->70|91->70|94->73|94->73|96->75|96->75|97->76|97->76|100->79|100->79|104->83|104->83|106->85|106->85|108->87|108->87|109->88|109->88|111->90|111->90|112->91|112->91|115->94|115->94|119->98|119->98
                    -- GENERATED --
                */
            
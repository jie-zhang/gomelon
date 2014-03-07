package models

import play.api.Play.current
import java.sql.Date
import util.MongodbColl
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import play.api.libs.json._
import play.api.libs.functional.syntax._

import se.radley.plugin.salat._
import se.radley.plugin.salat.Binders._
import mongoContext._




case class User(id: ObjectId = new ObjectId,
				name: String,
				password: String,
				email: String,
				phone: String,
				pic: String = "",
				sex: Int,
				status: Int = 0,
				city: String,
				intro: String
				)
object User extends UserDAO with UserJson

trait UserDAO extends ModelCompanion[User, ObjectId]{
	val dao = new SalatDAO[User, ObjectId](collection = mongoCollection("user")) {}
	val db = MongodbColl.getDB()
	val coll = db("user")
	/**
	 * 鏌ョ湅鐢ㄦ埛鏄惁瀛樺湪	 */
	def checkUserName(name: String): Boolean = {
	  val user = coll.find(MongoDBObject("name" -> name))
	  if(user.hasNext){
	    println(user.next)
	     return true
	  }
	  println("user is not exits")
	  return false  
	}
	
	// pj start by wu 
	/**
	 * 根據用戶名查找他的ObjectId
	 */
	def findId(name : String) = {	  
  	  val p = dao.find(MongoDBObject("name" -> name))
  	  val id = p.next.id
	  id	  
	}
	
	def getUsername(id : Object) = 
    {
    val p = dao.find(MongoDBObject("_id" -> id))
    val username = p.next.name
    username
    }
	
	// pj end by wu
	/**
	 * 鏌ョ湅瀵嗙爜
	 */
	def checkPassword(name: String, password: String):Boolean ={
	   val user =  coll.find(MongoDBObject("name" -> name))
	  val pwd = user.next.get("password")
	  if(pwd.equals(password)){
	    return true
	  }
	   return false
	}
	/**
	 * 娉ㄥ唽鐢ㄦ埛
	 */
	def toRegister(userName: String, password: String, email: String,phone: String, 
    sex: String, city: String, intro: String){
	  coll.insert(MongoDBObject("name" -> userName, "password" -> password, "email" -> email,
	      "phone" -> phone, "sex" -> sex, "city" -> city, "intro" -> intro))
	}
	/**
	 * 鏍规嵁鐢ㄦ埛鍚嶆煡鎵剧敤鎴�	 */
	def findUserByName(name: String): User= dao.findOne(MongoDBObject("name" -> name)).get
	 /* val user = coll.find(MongoDBObject("userName" -> name))
	  var  re:Users = null*/
	  
	  /*while(user.hasNext){
	    val r = user.next
	    val id=r.get("_id").toString().toLong
	    val name = r.get("userName").toString()
	    val password = r.get("password").toString()
	    val email = r.get("email").toString()
	    val phone = r.get("phone").toString()
	    val pic = r.get("pic").toString()
	    val sex = r.get("sex").toString().toInt
	    val status = r.get("status").toString().toInt
	    val city = r.get("city").toString()
	    val intro = r.get("intro").toString()
	    re = new Users(Option(id),name,password,email,phone,pic,sex,status,city,intro)
	  }*/
	  
	
}
trait UserJson{
	  implicit val userJsonWrite = new Writes[User]{
	    def writes(u: User): JsValue = {
	      Json.obj(
	    		"id" -> u.id,
	    		"name" -> u.name,
	    		"password" -> u.password,
	    		"email" -> u.email,
	    		"pic" -> u.pic,
	    		"phone" -> u.phone,
	    		"sex" -> u.sex,
	    		"status" -> u.status,
	    		"city"	-> u.city,
	    		"intro" -> u.intro
	      )
	    }
	  }
	  implicit val productReads = (
			  (__ \ 'id).read[ObjectId] ~
			  (__ \ 'name).read[String] ~
			  (__ \ 'password).read[String] ~
			  (__ \ 'email).read[String] ~
			  (__ \ 'phone).read[String] ~
			  (__ \ 'pic).read[String] ~
			  (__ \ 'sex).read[Int] ~
			  (__ \ 'status).read[Int] ~
			  (__ \ 'city).read[String] ~
			  (__ \ 'intro).read[String]
			  )(User.apply _)
	}
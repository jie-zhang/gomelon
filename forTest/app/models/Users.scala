package models

import java.sql.Date
import util.MongodbColl
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.MongoConnection

case class Users(id: Option[Long], 
				name: String,
				password: String,
				email: String,
				phone: String,
				pic: String,
				sex: Int,
				status: Int,
				city: String,
				intro: String)

object Users{
	
	val db = MongodbColl.getDB()
	val coll = db("user")
	/**
	 * 查看用户是否存在	 */
	def checkUserName(name: String): Boolean = {
	  val user = coll.find(MongoDBObject("name" -> name))
	  if(user.hasNext){
	    println(user.next)
	     return true
	  }
	  return false  
	}
	/**
	 * 查看密码
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
	 * 注册用户
	 */
	def toRegister(userName: String, password: String, email: String,phone: String, 
    sex: String, city: String, intro: String){
	  coll.insert(MongoDBObject("userName" -> userName, "password" -> password, "email" -> email,
	      "phone" -> phone, "sex" -> sex, "city" -> city, "intro" -> intro))
	}
	/**
	 * 根据用户名查找用户
	 */
	def findUserByName(name: String): Users={
	  val user = coll.find(MongoDBObject("userName" -> name))
	  var  re:Users = null
	  while(user.hasNext){
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
	  }
	   return re
	}
}
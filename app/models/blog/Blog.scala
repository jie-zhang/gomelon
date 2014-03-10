package models

import play.api.Play.current
import java.util.Date
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import mongoContext._
import models._



    
case class Blog(
    id : ObjectId = new ObjectId,
    userId: ObjectId, 
    createdTime: Date = new Date, 
    status : Int, 
    title : String, 
    blogTyp : String,
    tags : String,
    content : String)

object Blog extends ModelCompanion[Blog, ObjectId] {
  val dao = new SalatDAO[Blog, ObjectId](collection = mongoCollection("blog")) {}
  
  def newBlog(userId : ObjectId, title : String, content : String, blogTyp : String,tags: String) = {
    dao.save(Blog(userId = userId, status = 0, title = title, blogTyp = blogTyp, tags = tags, content = content))    
  }
  
  def showBlog(userId : ObjectId) = {
    val blog = dao.find(MongoDBObject("userId" -> userId, "status" -> 0)).toList
    blog
  }
  

  def showBlogById(id : ObjectId) = {
    val blog = dao.find(MongoDBObject("_id" -> id, "status" -> 0)).toList
    blog
  }
  
  def findByUserId(userId : ObjectId) : List[Blog] = {
    dao.find(MongoDBObject("userId" -> userId, "status" -> 0)).toList
  }
  
  def delete(id : ObjectId) = {
    val blog = dao.findOneById(id).get
    dao.save(Blog(id = id, userId = blog.userId, status = 1, title = blog.title, blogTyp = blog.blogTyp, tags = blog.tags, content = blog.content), WriteConcern.Safe)
  }

}
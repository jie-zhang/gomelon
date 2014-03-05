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



    
case class BlogCatagory(
  id : ObjectId = new ObjectId,
  userId : ObjectId,
  catagory : List[String],
  status : Int
  )

object BlogCatagory extends ModelCompanion[BlogCatagory, ObjectId] {
  val dao = new SalatDAO[BlogCatagory, ObjectId](collection = mongoCollection("blogCatagory")) {}
  
  // 创建新的分类  status=0代表新建
  var list : List[String] = Nil
  def newBlogCatagory(userId : ObjectId, catagory : String) = {
    
//    catagory :: list
    list :::= List(catagory)
    dao.save(BlogCatagory(userId = userId, status = 0, catagory = list))    
  }
//  
//  def showBlog(userId : ObjectId) = {
//    val blog = dao.find(MongoDBObject("userId" -> userId, "status" -> 0)).toList
//    blog
//  }
//  
////  var list : List[Comments] = Nil
//  implicit var list = List.empty[Blogs]
//  def all(id : ObjectId): List[Blogs] =   
//    {
////    val i = Comments.list.distinct
//     val l = dao.find(MongoDBObject("commentedId" -> id, "status" -> 0)).toList
//     if (!l.isEmpty){
//     l.foreach(
//       {
//           r =>list :::= List(r)
//           all(r.id)
//       })
//     }
//     list
////     i
//     
//    
//    }
//  
//  
////  def addComment(cmUsername : String, cmTime : String, cmContent : String, cmService : String, cmAddContent : String) {
////    dao.insert(Comment_m(cmUsername = cmUsername,cmTime = cmTime,cmContent = cmContent,cmService = cmService, cmAddContent = cmAddContent))
////  }
//  
//  def addComment(userId : ObjectId, content : String, commentedId : ObjectId, relevantUser : ObjectId) = {
////    dao.save(Blogs(userId = userId, status = 0, commentedId = commentedId, relevantUser = relevantUser, commentedType = 1, content = content))    
//  }
//  
//  
//  def delete(id : ObjectId) = {
//    val blog = dao.findOneById(id).get
//    dao.save(Blogs(id = id, userId = blog.userId, status = 1, title = blog.title, blogTyp = blog.blogTyp, tags = blog.tags, content = blog.content), WriteConcern.Safe)
//  }
//  
//  def huifu(id : ObjectId, content : String, userId : ObjectId) {
//    val model = dao.findOneById(id)
    
//    val model = dao.findOne(MongoDBObject("id" -> new ObjectId(id))).get
//    dao.save(Blogs(userId = userId, status = 0, commentedId = id, relevantUser = userId, commentedType = 3, content = content))
    
//  }
}
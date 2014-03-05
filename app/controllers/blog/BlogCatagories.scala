package controllers

import play.api._
import java.util.Date
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.templates._
import models._
import com.mongodb.casbah.Imports.ObjectId


object BlogCatagories extends Controller {
    
  
    val formBlogCatagory = Form((
    "catagory" -> nonEmptyText
    ))

    def newBlogCatagory(userId : ObjectId) = Action {
      Ok(views.html.blog.newBlogCatagory(userId, formBlogCatagory))
    }
    
    def writeBlogCatagory(userId : ObjectId) = Action {
      implicit request =>
      formBlogCatagory.bindFromRequest.fold(
        //处理错误
        errors => BadRequest(views.html.blog.newBlogCatagory(userId, errors)),
        {
          case (catagory) =>         
	        BlogCatagory.newBlogCatagory(userId, catagory)
	        Ok("创建成功！")
        }
                
          
            
        )
    }


  
//  def newBlog(id : ObjectId) = Action {
//    Ok(views.html.blog.blog(id, formBlog))
//  }
//  
//  def deleteBlog(id : ObjectId) = Action {
//     implicit request =>
//      val user_id = request.session.get("user_id").get
//      val userId = new ObjectId(user_id)
//    Blog.delete(id)
//    Redirect(routes.Blogs.showBlog(userId))
//  }
  
//  def test = Action  {
//    
//    implicit request =>      
//      val user_id = request.session.get("user_id").get
//      val userId = new ObjectId(user_id)
//      val username = User.getUsername(userId)
//   Redirect(routes.Blog.showBlog(userId))
//
//
//  }
  
//  def showBlog(id : ObjectId) = Action {
//    val list = Blog.showBlog(id)
//    Ok(views.html.blog.findBlogs(id, list))
//  }
//  
//  def writeBlog(id : ObjectId) = Action {
//      implicit request =>
//      formBlog.bindFromRequest.fold(
//        //处理错误
//        errors => BadRequest(views.html.blog.blog(id, errors)),
//        {
//          case (title,content,blogTyp,tags) =>
////            val userId = new ObjectId(user_id) // 这边需要用session取得用户名之类的东西
////            val commentedId = new ObjectId(user_id)
////            val relevantUser = new ObjectId(user_id)            
//	        Blog.newBlog(id, title,content,blogTyp,tags)
//	        Ok(views.html.blog.showBlog(id))
//        }
//                
//          
//            
//        )
//  }
  
//  implicit def clean() = {
//    Comments.list = Nil
//  }
  
//  def addComment = Action {
//    Ok(views.html.addComment(formAddComment))
//  }
  
//  def addC = Action {
//    implicit request =>
//      val user_id = request.session.get("user_id").get
//      formAddComment.bindFromRequest.fold(
//        //处理错误
//        errors => BadRequest(views.html.addComment(errors)),
//        {
////          case (cmUsername, cmTime, cmContent, cmService, cmAddContent) =>
//          case (content) =>
//            val userId = new ObjectId(user_id) // 这边需要用session取得用户名之类的东西
////            val time = nowTime
////            val status = 0
//            val commentedId = new ObjectId(user_id)
//            val relevantUser = new ObjectId(user_id)
//            
//	        Comments.addComment(userId, content, commentedId, relevantUser)
//	        
////            Ok(Html("评论成功"))
////	        Redirect(routes.Comment.find).withSession(request.session+("_id" -> _id))
//	        Redirect(routes.Comment.find)
//        }
//                
//          
//            
//        )
//  }
  
//  def complaint = Action {
//    Ok(views.html.complaint(request.session.get("_id").get))
//  }
  
//  def complaint(id : ObjectId) = Action {
//    Ok(Html("我要申诉的评论Id是" + id))
//  }
  
//  def answer(id : ObjectId) = Action {
//    Ok(views.html.answer(id, formHuifuComment))
//  }
  
//  def delete(id : ObjectId) = Action {
//    Comments.delete(id)
//    Redirect(routes.Comment.find)
//  }
  
//  def huifu(id : ObjectId) = Action {
//    implicit request =>
//      val user_id = request.session.get("user_id").get
//      formHuifuComment.bindFromRequest.fold(
//        //处理错误
//        errors => BadRequest(views.html.answer(id, errors)),
//        {
////          case (cmUsername, cmTime, cmContent, cmService, cmAddContent) =>
//          case (content) =>
//            val username = new ObjectId(user_id)
//            println("content" + content, "username" + username)
//	        Comments.huifu(id, content, username)
//
////            Ok(Html("评论成功"))
////	        Redirect(routes.Comment.find).withSession(request.session+("_id" -> _id))
//	        Redirect(routes.Comment.find)
////	        Ok(Html("test"))
//        } 
//        )
//  }



}
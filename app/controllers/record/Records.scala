package controllers.record

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Record
import org.bson.types.ObjectId
import views._
import se.radley.plugin.salat.Binders._

import models._

object Records extends Controller{
  val pageSize:Int = 5	 //每个页面有多少记录
  val recordForm:Form[Record] = Form(
	    mapping(
	        "store" -> text,
	        "serviceStatus" -> number,
	        "serviceStart" ->date("yyyy-MM-dd") ,
	        "serviceEnd" -> date("yyyy-MM-dd"),
	        "serviceDesigner" -> text,
	        "serviceItem" -> text,
	        "userName" -> text,
	        "userPhone" -> text,
	        "userLeaveMessage" -> text,
	        "costTotal" -> number
	        ){
	      (store,serviceStatus,serviceStart,serviceEnd,serviceDesigner,serviceItem,userName,userPhone,userLeaveMessage,costTotal) =>
	          Record(new ObjectId,store,serviceStatus,serviceStart,serviceEnd,serviceDesigner,serviceItem,userName,userPhone,userLeaveMessage,costTotal)
	    }
	    {
	      record=> Some((record.store,record.serviceStatus,record.serviceStart,record.serviceEnd,record.serviceDesigner,record.serviceItem,record.userName,record.userPhone,record.userLeaveMessage,record.costTotal))
	    }
	)
  
	/**
	 * 分页查询，默认第一页
	 * 当前设置的pageSize为5
	 */
	def recordmain(page:Int) = Action{implicit request =>
	  val re = request.session.get("records").get
	  val records = Record.findAllrecord(re,page,pageSize)
	  val count = Record.counts(re)
	  var pages:Int = 0
	  if(count % pageSize == 0){
	    pages = count.toInt/ pageSize
	  }else{
		pages = count.toInt/pageSize+1
	  }
	  Ok(views.html.record.recordmain(records,count,pages,page))
	}
  	/**
  	 * 预约记录详细查看
  	 */
	def recordview(id:ObjectId) = Action{
	  Record.findOneById(id).map { record =>
	  	Ok(views.html.record.recordview(record))
	  }getOrElse {
		  NotFound
    }
	  
	}
	/**
	 * 进入页面，自己录入一个预约记录
	 */
	def createrecord = Action{
	  Ok(views.html.record.createrecord(recordForm))
	}
	/**
	 * 将录入预约记录插入数据库中
	 */
	def toCreateRecords = Action{implicit request =>
	  recordForm.bindFromRequest.fold(
	    error =>BadRequest(views.html.errorMsg(error)),
	    {
	      case(record)=>
	        println("println....record  "+record.store+record.serviceStatus+record.serviceStart+record.serviceEnd+record.costTotal)
	       Record.createRecord(record)
	       Redirect(controllers.record.routes.Records.recordmain(1))
	    }
	)
	}
	/**
	 * 添加预约，暂时用不到，功能流程需要更换
	 */
	def addRecord = Action {
	    Ok(views.html.record.addRecord(""))
	  } 
	/**
	 * 指定技师查看日程
	 */
	def selectDesignerRecord = Action {
	  Ok(views.html.record.selectDesignerRecord(""))
	}
	
	/**
	 *变更预约状态
	 * -1：已取消
	 * 0：已预约
	 * 1：已消费
	 * 2：已过期
	 *   
	 */
	
	/**
	 * 取消预约将状态改成-1
	 */
	def cancelRecord(id: ObjectId) = Action {
		Record.findOneById(id).map { record =>
		val records = new Record(new ObjectId,record.store,-1,record.serviceStart,record.serviceEnd,
		record.serviceDesigner,record.serviceItem,record.userName,record.userPhone,record.userLeaveMessage,record.costTotal)
		Record.save(records.copy(id = record.id))
		
		}
		Redirect(controllers.record.routes.Records.recordmain(1))
	}
	//将状态改成预约中0
	/*def inRecord(id: ObjectId) = Action {
		Record.findOneById(id).map { record =>
		val records = new Record(new ObjectId,record.store,0,record.serviceStart,record.serviceEnd,
		record.serviceDesigner,record.serviceItem,record.userName,record.userPhone,record.userLeaveMessage,record.costTotal)
		Record.save(records.copy(id = record.id))
		
		}
		Redirect(controllers.record.routes.Records.recordmain)
	}*/
	/**
	 * 将预约状态改成已完成消费1
	 */
	def finishRecord(id: ObjectId) = Action {
		Record.findOneById(id).map { record =>
		val records = new Record(new ObjectId,record.store,1,record.serviceStart,record.serviceEnd,
		record.serviceDesigner,record.serviceItem,record.userName,record.userPhone,record.userLeaveMessage,record.costTotal)
		Record.save(records.copy(id = record.id))
		
		}
		Redirect(controllers.record.routes.Records.recordmain(1))
	}
	/**
	 * 将预约状态改成已过期2
	 */
	def overdateRecord(id: ObjectId) = Action {
		Record.findOneById(id).map { record =>
		val records = new Record(new ObjectId,record.store,2,record.serviceStart,record.serviceEnd,
		record.serviceDesigner,record.serviceItem,record.userName,record.userPhone,record.userLeaveMessage,record.costTotal)
		Record.save(records.copy(id = record.id))
		
		}
		Redirect(controllers.record.routes.Records.recordmain(1))
	}
	
	
}
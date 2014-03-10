package controllers

import play.api._
import play.api.mvc._
import models.Stylist
import play.api.data._
import play.api.data.Forms._
import com.mongodb.casbah.commons.Imports._

import models._
import views._


object Stylists extends Controller {


  def index = TODO
  
   /**
   * 
   */
  def findById(stylistId: ObjectId) = Action { 
    val stylist: Seq[Stylist] = Stylist.findById(stylistId)
    Ok(html.stylist.overview(stylist))
  }
  
  def findBySalon(salonId: ObjectId) = Action {
    val salon: Option[Salon] = Salon.findById(salonId)    
    val stylistsOfSalon: Seq[Stylist] = Stylist.findBySalon(salonId)    

    // TODO
    Ok(html.salon.store.salonInfoStylistAll(salon.get, stylistsOfSalon))
  }
  
  
   def findStylist = Action{
      Ok(views.html.stylist.findStylist("hello"))
   }
    
    def checkStylist = Action{
      Ok(views.html.stylist.checkStylist("hello"))
    }

}

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
<<<<<<< HEAD
    val salon: Option[Salon] = Salon.findById(salonId)
    val nav: String = "style"
    val stylistsOfSalon: Seq[Stylist] = Stylist.findBySalon(salonId)    
    Ok(html.stylist.overview(stylistsOfSalon))
    val style: Seq[Style] = Style.findBySalonId(salonId) 
    
    Ok(html.salon.store.homepage(navInSalon = nav, salon = salon.get, style = style,  stylist = stylistsOfSalon))
    
=======
    val salon: Option[Salon] = Salon.findById(salonId)    
    val stylistsOfSalon: Seq[Stylist] = Stylist.findBySalon(salonId)    

    // TODO
    Ok(html.salon.store.salonInfoStylistAll(salon.get, stylistsOfSalon))
>>>>>>> 2f0a55ed316c166a8933b0a2bdc30bf8afccbb55
  }
  
  
   def findStylist = Action{
      Ok(views.html.stylist.findStylist("hello"))
   }
    
    def checkStylist = Action{
      Ok(views.html.stylist.checkStylist("hello"))
    }

}

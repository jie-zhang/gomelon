package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import com.mongodb.casbah.commons.Imports._

import models._
import views._


object Salons extends Controller {

  def index = Action {
    val salons: Seq[Salon] = Salon.findAll()
//    Ok(views.html.salon.overview(salons))
      Ok(views.html.salon.general.index(""))
  }

  
  def getSalon(salonId: ObjectId) = Action {
    val salon: Option[Salon] = Salon.findById(salonId)

    // TODO
    // Option when null
    // enum for nav.
    val nav: String = "salon-basic"
    Ok(views.html.salon.store.homepage(navInSalon = nav, salon = salon.get))
  }


}

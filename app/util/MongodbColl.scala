package util

import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.MongoDB

object MongodbColl {
	val mongoclient = MongoClient("localhost", 27017)
	val db = mongoclient("fashion-mongo")
	
	def getDB():MongoDB = {
	  db
	}
}
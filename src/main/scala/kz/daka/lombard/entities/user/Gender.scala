package kz.daka.lombard.entities.user

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject

trait Gender {
  def name: String

  def toBson: DBObject = {
    MongoDBObject("name" -> name)
  }
}

object Male extends Gender {
  val name = "Male"
}

object Female extends Gender {
  val name = "Female"
}

object Gender {
  def fromBson(obj: DBObject): Gender = {
    if (obj == null) return null
    val value = obj.get("name").asInstanceOf[String]
    value match {
      case Male.name => Male
      case Female.name => Female
    }
  }
}
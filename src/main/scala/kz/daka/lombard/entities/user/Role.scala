package kz.daka.lombard.entities.user

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject

trait Role {
  def name: String
  def toBson: DBObject = {
    MongoDBObject("name" -> name)
  }
}
object Administrator extends Role {
  val name = "Administrator"
}
object Moderator extends Role {
  val name = "Moderator"
}
case class CustomRole(val name: String) extends Role

object Role {
  def fromBson(obj: DBObject): Role = {
    if (obj == null) return null
    val value = obj.get("name").asInstanceOf[String]
    value match {
      case Administrator.name => Administrator
      case Moderator.name => Moderator
      case _ => CustomRole(value)
    }
  }
}
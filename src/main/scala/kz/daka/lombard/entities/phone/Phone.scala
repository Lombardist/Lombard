package kz.daka.lombard.entities.phone

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject

trait PhoneType {
  def name: String

  def toBson: DBObject = {
    MongoDBObject("phoneType" -> name)
  }
}

object Cell extends PhoneType {
  val name = "Cell"
}

object Home extends PhoneType {
  val name = "Home"
}

object Work extends PhoneType {
  val name = "Work"
}

case class Custom(val name: String) extends PhoneType

case class Phone(countryCode: String, number: String, phoneType: PhoneType)

object Phone {
  def toBson(obj: Phone): DBObject = {
    MongoDBObject(
      "countryCode" -> obj.countryCode,
      "number" -> obj.number,
      "phoneType" -> obj.phoneType.toBson
    )
  }

  def fromBson(obj: DBObject): Phone = {
    Phone(
      countryCode = obj.get("countryCode").asInstanceOf[String],
      number = obj.get("number").asInstanceOf[String],
      phoneType = fromBsonPhoneType(obj.get("phoneType").asInstanceOf[DBObject])
    )
  }

  def fromBsonPhoneType(obj: DBObject): PhoneType = {
    if (obj == null) return null
    val value = obj.get("phoneType").asInstanceOf[String]
    value match {
      case Cell.name => Cell
      case Home.name => Home
      case Work.name => Work
      case _ => Custom(value)
    }
  }
}
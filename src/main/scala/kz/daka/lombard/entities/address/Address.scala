package kz.daka.lombard.entities.address

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject

object Home extends AddressType {
  val name = "Home"
}
object Work extends AddressType {
  val name = "Work"
}
case class Custom(val name: String) extends AddressType
trait AddressType {
  def name: String
  def toBson: DBObject = {
    MongoDBObject(
    "addressType"->name
    )
  }
}

case class Address(
                    country: String,
                    city: String,
                    street: String,
                    building: String,
                    apartment: String,
                    addressType: AddressType)

object Address {

  def toBson(obj: Address): DBObject = {
    MongoDBObject(
    "country" -> obj.country,
    "city" -> obj.city,
    "street" -> obj.street,
    "building" -> obj.building,
    "apartment" -> obj.apartment,
    "addressType" -> obj.addressType.toBson
    )
  }

  def fromBsonAddressType(obj: DBObject): AddressType = {
    if (obj==null) return null
    val value = obj.get("addressType").asInstanceOf[String]
    value match {
      case Home.name => Home
      case Work.name => Work
      case _ => Custom(value)
    }
  }

  def fromBson(obj: DBObject): Address = {
    Address(
    obj.get("country").asInstanceOf[String],
    obj.get("city").asInstanceOf[String],
    obj.get("street").asInstanceOf[String],
    obj.get("building").asInstanceOf[String],
    obj.get("apartment").asInstanceOf[String],
    fromBsonAddressType(obj.get("addressType").asInstanceOf[DBObject])
    )
  }

}
package kz.daka.lombard.entities

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject
import kz.daka.lombard.entities.address.Address
import org.bson.types.ObjectId

case class Organization(id: Int, name: String, legalAddress: Address)

object Organization {

  def toBson(obj: Organization): DBObject = {
    MongoDBObject(
    "_id" -> obj.id,
    "name" -> obj.name,
    "legalAddress" -> Address.toBson(obj.legalAddress)
    )
  }

  def fromBson(obj: DBObject): Organization = {
    Organization(
    id = obj.get("_id").asInstanceOf[Int],
    name = obj.get("name").asInstanceOf[String],
    legalAddress = Address.fromBson(obj.get("legalAddress").asInstanceOf[DBObject])
    )
  }

}
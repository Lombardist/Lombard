package kz.daka.lombard.entities.organization

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject
import kz.daka.lombard.entities.address.Address

case class Pawnshop(id: Int, name: String, address: Address)

object Pawnshop {

  def toBson(obj: Pawnshop): DBObject = {
    MongoDBObject(
      "_id" -> obj.id,
      "name" -> obj.name,
      "address" -> Address.toBson(obj.address)
    )
  }

  def fromBson(obj: DBObject): Pawnshop = {
    Pawnshop(
      id = obj.get("_id").asInstanceOf[Int],
      name = obj.get("name").asInstanceOf[String],
      address = Address.fromBson(obj.get("address").asInstanceOf[DBObject])
    )
  }

}

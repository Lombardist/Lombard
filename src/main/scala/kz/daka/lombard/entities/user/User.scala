package kz.daka.lombard.entities.user

import java.util.function.Consumer

import com.mongodb.casbah.Imports
import com.mongodb.{BasicDBObject, BasicDBList, DBObject}
import com.mongodb.casbah.commons.MongoDBObject
import kz.daka.lombard.db.DefaultDbConfig

case class User(_id: String,
                firstName: String,
                lastName: String,
                email: String,
                gender: Gender) {
  var roles: List[Role] = List[Role]()

  override def toString = {

  }
}

object User {
  def toBson(obj: User): DBObject = {
    MongoDBObject(
    "_id" -> obj._id,
    "firstName" -> obj.firstName,
    "lastName" -> obj.lastName,
    "email" -> obj.email,
    "gender" -> obj.gender.toBson,
    "roles" -> obj.roles.map((role: Role) => role.toBson)
    )
  }
  def fromBson(obj: DBObject): User = {
    val user = User(
    _id = obj.get("_id").asInstanceOf[String],
    firstName = obj.get("firstName").asInstanceOf[String],
    lastName = obj.get("lastName").asInstanceOf[String],
    email = obj.get("email").asInstanceOf[String],
    gender = Gender.fromBson(obj.get("gender").asInstanceOf[DBObject])
    )
    val roles = obj.get("roles").asInstanceOf[BasicDBList]
    val iter = roles.iterator()
    while (iter.hasNext) {
      val role = iter.next()
      if (role.isInstanceOf[DBObject]) {
        user.roles = Role.fromBson(role.asInstanceOf[DBObject]) :: user.roles
      }
    }
    user
  }

  def initialize: Unit = {
    val administrator = User(_id = "root", firstName = "Dauren", lastName = "Mussa", email = "dauren.mussa@gmail.com", gender = Male)
    administrator.roles = Administrator :: administrator.roles
    administrator.roles = Moderator :: administrator.roles
    val adminDBObject = User.toBson(administrator)
    val res = DefaultDbConfig.users.findOneByID("root")
    if (res == null) {
      DefaultDbConfig.users.save(adminDBObject)
    }
  }
}
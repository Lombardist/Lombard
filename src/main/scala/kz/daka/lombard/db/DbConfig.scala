package kz.daka.lombard.db

import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.{MongoClient}

object Collections {
  val organizations = "organizations"
  val pawnshops = "pawnshops"
  val sequence = "sequence"
  val users = "users"
  val sessions = "sessions"
  val itemTypes = "itemTypes"
  val items = "items"
}

trait DbConfig {
  def host: String

  def port: Int

  def dbName: String

  val db = MongoClient(host, port)(dbName)

  def collection(collection: String) = db(collection)

  val sequence = collection(Collections.sequence)
  val sessions = collection(Collections.sessions)
  val users = collection(Collections.users)
  val organizations = collection(Collections.organizations)
  val pawnshops = collection(Collections.pawnshops)
  val itemTypes = collection(Collections.itemTypes)
  val items = collection(Collections.items)

  def nextId(collection: String) = sequence.findAndModify(MongoDBObject("_id" -> collection),
    null, null, false, MongoDBObject("$inc" -> MongoDBObject("seq" -> 1.toInt)), true, true)
    .get.get("seq").asInstanceOf[Int]
}

object DefaultDbConfig extends DbConfig {
  def host = "localhost"

  def port = 27017

  def dbName = "lombard"
}
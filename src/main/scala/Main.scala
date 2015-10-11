import kz.daka.lombard.db.{Collections, DefaultDbConfig}
import kz.daka.lombard.entities.{Pawnshop, Organization}
import kz.daka.lombard.entities.address.{Home, Custom, Work, Address}
import org.bson.types.ObjectId

object Main extends App {

  val org = Organization(DefaultDbConfig.nextId(Collections.organizations), "Organization", Address(country = "Kazakhstan", city = "Astana", street = "Republic street", building = "5", apartment = "22", addressType = Custom("super Address")))
  val obj = Organization.toBson(org)

  DefaultDbConfig.organizations.save(obj)

}

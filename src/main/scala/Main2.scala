import kz.daka.lombard.db.DefaultDbConfig
import kz.daka.lombard.entities.organization.Organization

object Main2 extends App {

  val cursor = DefaultDbConfig.organizations.find()

  while (cursor.hasNext) {
    println(Organization.fromBson(cursor.next))
  }
}

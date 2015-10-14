import kz.daka.lombard.db.{Collections, DefaultDbConfig}
import kz.daka.lombard.entities.business.MotorTransport
import kz.daka.lombard.entities.user.User
import kz.daka.lombard.entities.address.{Home, Custom, Work, Address}

object Main extends App {

  User.initialize

  val itemType = MotorTransport

  println(itemType.name)

}

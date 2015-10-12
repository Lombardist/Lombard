import java.util.function.Consumer

import com.mongodb.casbah.Imports
import kz.daka.lombard.db.{Collections, DefaultDbConfig}
import kz.daka.lombard.entities.user.User
import kz.daka.lombard.entities.{Pawnshop, Organization}
import kz.daka.lombard.entities.address.{Home, Custom, Work, Address}

object Main extends App {

  User.initialize

  DefaultDbConfig.users.find().foreach((obj: Imports.DBObject) => {
    println(obj)

    val user = User.fromBson(obj)

    println(user)

  })

}

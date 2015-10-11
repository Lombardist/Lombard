package kz.daka.lombard.entities.phone

trait PhoneType {
  def name: String
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
package kz.daka.lombard.entities.business

trait ItemType {
  def name: String
}

case object Gold extends ItemType {
  val name = "Gold"
}

case object Silver extends ItemType {
  val name = "Silver"
}

case object RealEstate extends ItemType {
  val name = "RealEstate"
}

case object MotorTransport extends ItemType {
  val name = "MotorTransport"
}

case object WhiteGoods extends ItemType {
  val name = "WhiteGoods"
}

case object Jewelry extends ItemType {
  val name = "Jewelry"
}

case class CustomItemType(val name: String) extends ItemType
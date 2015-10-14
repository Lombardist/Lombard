package kz.daka.lombard.entities.business

trait Quality {
  def name: String
}
case object Excellent extends Quality {
  val name = "Excellent"
}
case object Normal extends Quality {
  val name = "Normal"
}
case object Poor extends Quality {
  val name = "Poor"
}
case class CustomQuality(val name: String) extends Quality
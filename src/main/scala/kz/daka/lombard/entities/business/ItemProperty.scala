package kz.daka.lombard.entities.business

trait ItemProperty {
  def name: String
  def value: Any
}

case class StringProperty(val name: String, val value: String) extends ItemProperty
case class IntProperty(val name: String, val value: Int) extends ItemProperty
case class DoubleProperty(val name: String, val value: Double) extends ItemProperty
case class CustomProperty(val name: String, val value: Any) extends ItemProperty
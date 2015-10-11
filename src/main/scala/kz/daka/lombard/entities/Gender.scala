package kz.daka.lombard.entities

trait Gender {
  def name: String
}
object Male extends Gender {
  val name = "Male"
}
object Female extends Gender {
  val name = "Female"
}
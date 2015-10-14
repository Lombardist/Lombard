package kz.daka.lombard.entities.business

import kz.daka.lombard.db.{Collections, DefaultDbConfig}

trait Item {
  def _id: Int = DefaultDbConfig.nextId(Collections.items)
  def itemType: ItemType
  def comment: String = null
  def properties: List[ItemProperty] = List()
}

case class JewelryItem(val itemType: ItemType) extends Item

case class CustomItem()

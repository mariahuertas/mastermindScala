package models

object Color extends Enumeration {
  type Color = Value
  val RED, BLUE, YELLOW, GREEN, ORANGE, PURPLE = Value

  def length: Int = Color.values.size

  // TODO add get random values

}
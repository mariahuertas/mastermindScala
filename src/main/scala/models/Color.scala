package models

object Color extends Enumeration {
  type Color = Value
  val RED = Value("R")
  val BLUE = Value("B")
  val YELLOW = Value("Y")
  val GREEN = Value("G")
  val ORANGE = Value("O")
  val PURPLE = Value("P")

  def length: Int = Color.values.size

  def getRandomColor(): Color=
    Color(scala.util.Random.nextInt(Color.maxId))
}
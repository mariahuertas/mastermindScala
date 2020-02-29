package models

object Color extends Enumeration {
  type Color = Value
  val RED = Value("R")
  val BLUE = Value("B")
  val YELLOW = Value("Y")
  val GREEN = Value("G")
  val ORANGE = Value("O")
  val PURPLE = Value("P")

  val all = List(Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.PURPLE)

  def length: Int = Color.values.size

  def getRandomColor(): Color=
    Color(scala.util.Random.nextInt(Color.maxId))

  def isColor(value: Char) = {
    value match {
      case 'R' => true
      case 'B' => true
      case 'Y' => true
      case 'G' => true
      case 'O' => true
      case 'P' => true
      case _ => false
    }
  }

  def getColor(value: Char): Color = {
    value match {
      case 'R' => Color.RED
      case 'B' => Color.BLUE
      case 'Y' => Color.YELLOW
      case 'G' => Color.GREEN
      case 'O' => Color.ORANGE
      case 'P' => Color.PURPLE
    }
  }
}


package views

import models.Color

object ColorView {

  def isColor(proposedColor: String): Boolean = {
    proposedColor match {
      case "" => true
      case _ if Color.isColor(proposedColor.head) => isColor(proposedColor.tail)
      case _ => false
    }
  }

  def getColorList(proposedColor: String): List[Color.Color] = {
    proposedColor match {
      case "" => Nil
      case _ => Color.getColor(proposedColor.head)::getColorList(proposedColor.tail)
    }
  }
}

package models

class ProposedCombination(proposedCombination: List[Color.Color],secretCombination: List[Color.Color]) {
  private val MAX_COLOR = 4
  val proposedCombination_ = proposedCombination

  def getProposedCombination: List[Color.Color] =
    proposedCombination_

  def calculateBlackToken(proposedCombination: List[Color.Color], secretCombination: List[Color.Color]): Int = {
    proposedCombination match {
      case Nil => 0
      case head :: tail if head == secretCombination.head => 1 +  calculateBlackToken(tail, secretCombination.tail)
      case _ :: tail => calculateBlackToken(tail, secretCombination.tail)
    }
  }

  def isWinner(): Boolean =
    calculateBlackToken(proposedCombination, secretCombination) == this.MAX_COLOR
}


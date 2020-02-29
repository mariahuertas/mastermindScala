package models

class ProposedCombination(proposedCombination: List[Color.Color]) {
  private val MAX_COLOR = 4
  val proposedCombination_ = proposedCombination
  var blackToken = 0
  var whiteToken = 0

  def getProposedCombination: List[Color.Color] =
    proposedCombination_

  def getTokens (secretCombination: List[Color.Color]): (Int, Int) = {
    blackToken = calculateBlackToken(proposedCombination, secretCombination)
    whiteToken = calculateWhiteToken(proposedCombination, secretCombination)
    (getBlackToken, getWhiteToken)
  }

  def calculateBlackToken(proposedCombination: List[Color.Color], secretCombination: List[Color.Color]): Int = {
    proposedCombination match {
      case Nil => 0
      case head :: tail if head == secretCombination.head => 1 + calculateBlackToken(tail, secretCombination.tail)
      case _ :: tail => calculateBlackToken(tail, secretCombination.tail)
    }
  }

   def calculateWhiteToken(proposedCombination: List[Color.Color], secretCombination: List[Color.Color]): Int = {
     proposedCombination match {
      case Nil => 0
      case head::tail if isMember(head, secretCombination) => 1 + calculateWhiteToken(tail, secretCombination)
      case _::tail => calculateWhiteToken(tail, secretCombination)
    }
  }

  def isMember(value: Color.Color, list: List[Color.Color]): Boolean = {
    list match {
      case Nil => false
      case head::_ if head eq value => true
      case _::tail => isMember(value, tail)
    }
  }

  def getWhiteToken: Int = whiteToken-blackToken

  def getBlackToken: Int = blackToken

  def isWinner(secretCombination: List[Color.Color]): Boolean =
    calculateBlackToken(proposedCombination, secretCombination) == this.MAX_COLOR
}


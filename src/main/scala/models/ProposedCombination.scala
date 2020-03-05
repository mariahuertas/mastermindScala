package models

class ProposedCombination(proposedCombination: List[Color.Color]) {
  private val MAX_COLOR = 4
  val proposedCombination_ = proposedCombination
  var blackToken = 0
  var whiteToken = 0

  def getProposedCombination: List[Color.Color] =
    proposedCombination_

  def getTokens(): (Int, Int) = {
    (getBlackToken, getWhiteToken)
  }

  def calculateTokens (secretCombination: List[Color.Color]) = {
    blackToken = calculateBlackToken(proposedCombination, secretCombination)
    whiteToken = calculateWhiteToken(getNewCombination(secretCombination,proposedCombination), getNewCombination(proposedCombination, secretCombination))
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

  def getNewCombination(combination1 : List[Color.Color], combination2 : List[Color.Color]) : List[Color.Color] = {
    combination1 match {
      case Nil => combination1
      case head::tail if head == combination2.head => getNewCombination(tail, combination2.tail)
      case head::tail => head::getNewCombination(tail, combination2.tail)
    }
  }

  def isMember(color: Color.Color, combination: List[Color.Color]): Boolean = {
    combination match {
      case Nil => false
      case head::_ if head eq color => true
      case _::tail => isMember(color, tail)
    }
  }

  def getWhiteToken: Int = whiteToken

  def getBlackToken: Int = blackToken

  def isWinner: Boolean =
    getBlackToken == this.MAX_COLOR

  override def equals(that: Any): Boolean =
    that match {
      case that: ProposedCombination =>
        this.proposedCombination_ == that.proposedCombination_
      case _ => false
    }
}


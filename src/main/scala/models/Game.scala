package models

class Game(proposedCombination: List[ProposedCombination], secretCombination: SecretCombination) {
  def this() = this (Nil, secretCombination = new SecretCombination())
  private val MAX_LONG = 10
  private val proposedCombination_ = proposedCombination
  private val secretCombination_ = secretCombination

  def addProposedCombination(newProposedCombination: ProposedCombination): Game = {
    newProposedCombination.calculateTokens(secretCombination_.getSecretCombination)
    new Game(newProposedCombination::this.proposedCombination_, this.secretCombination_)
  }

  def isComplete: Boolean = {
    isWinner || getTurn == this.MAX_LONG
  }

  def isWinner: Boolean =
   proposedCombination_.head.isWinner

  def getProposedCombination: List[ProposedCombination] = proposedCombination_
  def getSecretCombination: SecretCombination = secretCombination_
  def getTurn = this.proposedCombination_.length

  override def equals(that: Any): Boolean =
    that match {
      case that: Game => this.secretCombination_ == that.secretCombination_ && this.proposedCombination_.head == that.proposedCombination_.head
      case _ => false
    }
}
package models

class Game(attempt : Int = 0, proposedCombination: ProposedCombination = new ProposedCombination(), secretCombination: secretCombination = new SecretCombination()) {

  private val attempt_ = attempt
  private val proposedCombination_ = proposedCombination

  def put(color: Color): Game = {
    val newAttempts = this.attempt_ +1
    val newProposedCombination = this.proposedCombination_.put(color, this.attempt_)
    new Game(newAttempts, newProposedCombination)
  }

  def isMastermind: Boolean = proposedCombination.isMastermind

  def isComplete: Boolean = proposedCombination.isComplete

  def getProposedCombination = this.proposedCombination_

  def getAttempt = this.attempt_

  override def toString():String =
    s"[$attempt, $proposedCombination]"
}


package models

class Game(proposedCombination: List[ProposedCombination] = new ProposedCombination(), secretCombination: SecretCombination = new SecretCombination()) {

  private val MAX_LONG = 10
  private val proposedCombination_ = proposedCombination
  private val secretCombination_ = secretCombination

  def addProposedCombination(newProposedCombination: ProposedCombination): Game = {
    new  Game(newProposedCombination::this.proposedCombination_, this.secretCombination_)
  }

  def isLooser: Boolean =
    this.proposedCombination_.length == this.MAX_LONG

  def isWinner: Boolean =
    proposedCombination_ match {
      case head::_ => head == this.secretCombination_.get // TODO: return value to compare with proposedCombination head
      case _ => false
    }
}
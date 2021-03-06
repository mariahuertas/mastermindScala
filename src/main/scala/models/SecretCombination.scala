package models

import scala.util.Random
class SecretCombination(secretCombination: List[Color.Color] = Nil) {

  val secretCombination_ =
    secretCombination match {
      case Nil => generateSecretCombination
      case _ => secretCombination
    }

  def getSecretCombination: List[Color.Color] =
    secretCombination_

  def generateSecretCombination: List[Color.Color] =
    (0 to 3).map(_ => Color.getRandomColor()).toList

  override def equals(that: Any): Boolean =
    that match {
      case that: SecretCombination =>
        this.secretCombination_ == that.secretCombination_
      case _ => false
    }
}


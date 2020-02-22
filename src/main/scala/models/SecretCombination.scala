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
    (0 to 4).map(_ => (new util.Random).nextInt(4)).toList // TODO move nextgIn to Color enum

}


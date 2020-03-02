package views

import models.SecretCombination

object SecretCombinationView {
  def write(secretCombination: SecretCombination) = {
    print("SECRET COMBINATION: ")
    secretCombination.getSecretCombination.map(print)
    println()
  }
}

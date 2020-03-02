package models

import org.scalatest.FunSuite

class ProposedCombinationTest extends FunSuite {

    test("hay aciertos blancos y aciertos negros") {
      val secretCombination = new SecretCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE))
      val proposedCombination = new ProposedCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE))
      proposedCombination.calculateTokens(secretCombination.getSecretCombination)
      assert(proposedCombination.getTokens() == (2,2))
    }

    test("solo aciertos negros") {
      val secretCombination = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED, Color.RED))
      val proposedCombination = new ProposedCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE))
      proposedCombination.calculateTokens(secretCombination.getSecretCombination)
      assert(proposedCombination.getTokens == (1,0))
    }

    test("solo aciertos blancos") {
      val secretCombination = new SecretCombination(List(Color.BLUE, Color.RED, Color.RED, Color.RED, Color.RED))
      val proposedCombination = new ProposedCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE))
      proposedCombination.calculateTokens(secretCombination.getSecretCombination)
      assert(proposedCombination.getTokens == (0,2))
    }

    test("ninguna combinacion acertada") {
      val secretCombination = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED, Color.RED))
      val proposedCombination = new ProposedCombination(List(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE))
      proposedCombination.calculateTokens(secretCombination.getSecretCombination)
      assert(proposedCombination.getTokens == (0,0))
    }

    test("todos los tokens son negros") {
      val secretCombination = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED, Color.RED))
      val proposedCombination = new ProposedCombination(List(Color.RED, Color.RED, Color.RED, Color.RED, Color.RED))
      proposedCombination.calculateTokens(secretCombination.getSecretCombination)
      assert(proposedCombination.getTokens == (5,0))
    }

    test("todos los tokens son blancos") {
      val secretCombination = new SecretCombination(List(Color.RED, Color.BLUE, Color.RED, Color.BLUE, Color.RED))
      val proposedCombination = new ProposedCombination(List(Color.BLUE, Color.RED, Color.BLUE, Color.RED, Color.BLUE))
      proposedCombination.calculateTokens(secretCombination.getSecretCombination)
      assert(proposedCombination.getTokens == (0,5))
    }

    test ("se propone una combinacion con los mismos valores"){
      val secretCombination = new SecretCombination(List(Color.PURPLE, Color.RED, Color.GREEN, Color.BLUE))
      val proposedCombination = new ProposedCombination(List(Color.PURPLE, Color.PURPLE, Color.PURPLE, Color.PURPLE))
      proposedCombination.calculateTokens(secretCombination.getSecretCombination)
      assert(proposedCombination.getTokens() == (1,0))
  }
}

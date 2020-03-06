package models

import org.scalatest.FunSuite

class GameTest extends FunSuite {
  test("one attemp") {
    val secretCombination = new SecretCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW))
    val proposedCombination = new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW))
    val game = new Game(List(proposedCombination), secretCombination)
    game.addProposedCombination(proposedCombination)
    assert(game.getProposedCombination.head.getTokens() == (2, 2))
    assert(!game.isComplete)
    assert(!game.isWinner)
    assert(game.getTurn == 1)
  }

  test("two attemps") {
    val secretCombination = new SecretCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW))
    val proposedCombinations = List(new ProposedCombination(List(Color.GREEN, Color.RED, Color.GREEN, Color.YELLOW)),
      new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)))
    val game = new Game(proposedCombinations, secretCombination)
    assert(!game.isComplete)
    assert(!game.isWinner)
    assert(game.getTurn == 2)
  }

  test("game complete because is winner") {
    val secretCombination = new SecretCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW))
    val proposedCombination = new ProposedCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW))
    val game = new Game(List(proposedCombination), secretCombination)
    game.addProposedCombination(proposedCombination)
    assert(game.getProposedCombination.head.getTokens() == (4, 0))
    assert(game.isComplete)
    assert(game.isWinner)
    assert(game.getTurn == 1)
  }

  test("game complete because after 10 all the attemps") {
    val secretCombination = new SecretCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW))
    val proposedCombinations = List(new ProposedCombination(List(Color.GREEN, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)),
                                    new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW)))
    val game = new Game(proposedCombinations, secretCombination)
    assert(game.isComplete)
    assert(!game.isWinner)
    assert(game.getTurn == 10)
  }

  test("add proposed combination") {
    val secretCombination = new SecretCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW))
    val proposedCombination = new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW))
    val game = new Game(List(proposedCombination), secretCombination)
    assert(game.addProposedCombination(proposedCombination) ==
      new Game(List(new ProposedCombination(List(Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW))),
               game.getSecretCombination))
    assert(!game.isComplete)
    assert(!game.isWinner)
    assert(game.getTurn == 1)
  }
}
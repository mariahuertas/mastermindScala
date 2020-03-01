import models.Game
import views.{GameView, ProposedCombinationView}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

   GameView.writeSecret(game)
    do {
      game = game.addProposedCombination(ProposedCombinationView.read)
      GameView.writeCombinations(game)
    } while (!game.isComplete)

    GameView.writeEndGame(game)
  }

}

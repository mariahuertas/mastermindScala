import models.Game
import views.{GameView, ProposedCombinationView}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

   GameView.writeSecret(game)
    do {
      game = game.addProposedCombination(ProposedCombinationView.read)
      //GameView.write(game)
    } while (!game.isComplete)

    GameView.writeEndGame(game)
  }

}

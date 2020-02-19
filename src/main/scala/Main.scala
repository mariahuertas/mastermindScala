import mastermind.models.Game
import mastermind.views.{GameView, ProposedCombinationView}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

    GameView.write(game)
    do {
      if (!game.isComplete){
        game = game.put(ProposedCombinationView.read)
      }
      GameView.write(game)
    } while (!game.mastermind)
  }

}

import models.Game

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {

    GameView.write(game)
    do {
      if (!game.isComplete){
        game = game.addProposedCombination(ProposedCombinationView.read)
      }
      GameView.write(game)
    } while (!game.isComplete)
  }

}

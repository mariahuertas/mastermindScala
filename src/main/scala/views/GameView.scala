package views

import models.Game
import views.SecretCombinationView

object GameView {
  def writeCombinations(game: Game) = {
    ProposedCombinationView.writeV(game)
  }

  def writeSecret(game: Game) =
    SecretCombinationView.write(game.getSecretCombination)

  def writeEndGame(game: Game) = {
    if (game.isWinner){
      println("Has ganado la partida")
    }
    else {
      println("Lo siento, no has adivinado la combinacion secreta")
    }
  }
}

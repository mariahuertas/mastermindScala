package views

import models.{Game, ProposedCombination, Color}

object ProposedCombinationView {
  def writeV(game: Game) = {
    val proposedCombination = game.getProposedCombination
    println("-----------------------------")
    for (combination <- proposedCombination.indices) {
      proposedCombination(combination).getProposedCombination.map(print)
      print(" | ")
      print("black - " + proposedCombination(combination).getBlackToken + " | ")
      print("white - " + proposedCombination(combination).getWhiteToken)
      println("")
    }
    println("-----------------------------")
  }

  def read(): ProposedCombination = {
    GestorIO.writeln("La combinacion debe de tener 4 elementos")
    GestorIO.writeln("Colores posibles: R B Y G O P")
    val proposedColor = GestorIO.readString("COMBINACION")

    proposedColor.length match {
      case 4 if ColorView.isColor(proposedColor) => new ProposedCombination(ColorView.getColorList(proposedColor))
      case _ =>  read()
    }
  }


}

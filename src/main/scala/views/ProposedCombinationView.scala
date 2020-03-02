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
      case 4 if isColor(proposedColor) => new ProposedCombination(getColorList(proposedColor))
      case _ =>  read()
    }
  }

  def isColor(proposedColor: String): Boolean = {
    proposedColor match {
      case "" => true
      case _ if Color.isColor(proposedColor.head) => isColor(proposedColor.tail)
      case _ => false
    }
  }

  def getColorList(proposedColor: String): List[Color.Color] = {
    proposedColor match {
      case "" => Nil
      case _ => Color.getColor(proposedColor.head)::getColorList(proposedColor.tail)
    }
  }

}

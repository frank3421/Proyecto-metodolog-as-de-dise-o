package cl.uchile.dcc.citric
package model.TestGame

import model.Controller.Controller
import model.Units.Player
import model.States.{Recovery,PlayerTurn}

class TestChapter extends munit.FunSuite {
  var controller:Controller= _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller
    controller.createTableAndPlayersConfig1()
    controller.startGame()
  }
  test("If we want to do a newChapter but is not the turn of the player that has the last turn, then its not possible to start a new chapter"){
    val exception = intercept[Exception] {
      controller.newChapter()
    }
    assertEquals(exception.getMessage, "The turn of the last player it doesnt happen yet")
  }
  test("If it is the last player's turn then the transition of new chapter is valid, then turns will rest and the chapter increase by one"){
    assert(controller.turn==0)
    controller.turn=controller.TotalPlayers-1
    assert(controller.chapter==1)
    assert(controller.turn!=0)
    controller.newChapter()
    assert(controller.turn==0)
    assert(controller.chapter==2)
  }
  test("If a player wants to win but has not norma six, then the player cannot wins and the transition not occur"){
    val player1:Player=controller.playerCharacters(controller.turn)
    assert(player1.norma==1)
    player1.norma=5
    assert(player1.norma==5)
    val exception = intercept[Exception] {
      controller.normaSixReached()
    }
    assertEquals(exception.getMessage, "The norma of the player is not 6 so the player can not win")
  }
  test("If a player wants to win but the player is ko then cannot win"){
    val player1: Player = controller.playerCharacters(controller.turn)
    assert(player1.norma == 1)
    player1.norma = 6
    assert(player1.norma == 6)
    player1.changeKo()
    assert(player1.ko)
    val exception = intercept[Exception] {
      controller.normaSixReached()
    }
    assertEquals(exception.getMessage, "The player is Ko so the player can not win")
  }
  test("If a player achieve the conditions required then the player wins when normaSixReached activated"){
    val player1: Player = controller.playerCharacters(controller.turn)
    assert(player1.norma == 1)
    player1.norma = 6
    assert(player1.norma == 6)
    assert(!player1.ko)
    val outputStream = new java.io.ByteArrayOutputStream()
    Console.withOut(outputStream) {
      controller.normaSixReached()
    }
    val output = outputStream.toString.trim
    val name = player1.name
    assert(output == s"The player called $name wins the game due to the player already reached norma 6", s"$output")
  }
  test("if the player is not ko and wants the transition from chapter to recovery throws an exception "){
    val player1: Player = controller.playerCharacters(controller.turn)
    assert(!player1.ko)
    val exception = intercept[Exception]{
      controller.Ko()
    }
    assertEquals(exception.getMessage, "The player is not Ko so the player cannot be in recovery state")
  }
  test("if the player is ko and a transition is made from chapter to recovery, then the transition is valid and the controller change their state"){
    val player1: Player = controller.playerCharacters(controller.turn)
    assert(!player1.ko)
    player1.changeKo()
    assert(player1.ko)
    controller.Ko()
    assert(controller.state.isInstanceOf[Recovery])
  }
  test("if the player is ko and a transition is made from chapter to playerTurn, then its a invalid transition"){
    val player1: Player = controller.playerCharacters(controller.turn)
    assert(!player1.ko)
    player1.changeKo()
    assert(player1.ko)
    val exception = intercept[Exception]{
      controller.playTurn()
    }
    assertEquals(exception.getMessage,"The player is Ko so the player can not initiate their turn")
  }
  test("If the player is not ko and a transition is made from chapter to playerTurn, then its a valid transition"){
    val player1: Player = controller.playerCharacters(controller.turn)
    assert(!player1.ko)
    controller.playTurn()
    assert(controller.state.isInstanceOf[PlayerTurn])
  }
}

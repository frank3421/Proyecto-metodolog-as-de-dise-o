package cl.uchile.dcc.citric
package model.TestGame
import model.Controller.Controller

import cl.uchile.dcc.citric.model.Units.Player
import model.States.Combat
class TestWait extends munit.FunSuite{
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller
    controller.createTableAndPlayersConfig1()
    controller.setState(controller.getState("Wait"))

  }
  test("When the method evade is activated and the player choose the mode combat defend, then throws an exception"){
    controller.setAttack(1)
    val playerAttacked:Player = controller.playerCharacters(controller.attackTo)
    playerAttacked.ModeCombat=1
    assert(playerAttacked.ModeCombat==1)
    val exception=intercept[Exception]{
      controller.evade()
    }
    assertEquals(exception.getMessage,"The mode combat chosen is defend so the transition is invalid")
  }
  test("When the method evade is activated and the player choose the mode combat evade, then a transition from wait to combat succeed"){
    controller.setAttack(1)
    val playerAttacked: Player = controller.playerCharacters(controller.attackTo)
    playerAttacked.ModeCombat = 2
    assert(playerAttacked.ModeCombat == 2)
    controller.evade()
    assert(controller.state.isInstanceOf[Combat])
  }
  test("When the method defend is activated and the player choose the mode combat evade, then throws an exception") {
    controller.setAttack(1)
    val playerAttacked: Player = controller.playerCharacters(controller.attackTo)
    playerAttacked.ModeCombat = 2
    assert(playerAttacked.ModeCombat == 2)
    val exception = intercept[Exception] {
      controller.defend()
    }
    assertEquals(exception.getMessage, "The mode combat chosen is evade so the transition is invalid")
  }
  test("When the method defend is activated and the player choose the mode combat defend, then a transition from wait to combat succeed") {
    controller.setAttack(1)
    val playerAttacked: Player = controller.playerCharacters(controller.attackTo)
    playerAttacked.ModeCombat = 1
    assert(playerAttacked.ModeCombat == 1)
    controller.defend()
    assert(controller.state.isInstanceOf[Combat])
  }

}

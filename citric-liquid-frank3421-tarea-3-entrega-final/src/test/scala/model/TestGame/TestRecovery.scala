package cl.uchile.dcc.citric
package model.TestGame
import model.Controller.Controller
import model.States._

class TestRecovery extends munit.FunSuite {
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller
    controller.createTableAndPlayersConfig1()
    controller.setState(controller.getState("Recovery"))
  }
  test("If the time of recovery is higher than the number of Dice and is not the turn of the last player, then a transition from recovery to chapter is made"){
    controller.setRecovery(7)
    assertEquals(controller.getRecoveryOfPlayer,7)
    assert(controller.turn==0)
    controller.tryOutRecovery()
    assert(controller.state.isInstanceOf[Chapter])
    assert(controller.turn==1)
  }
  test("if the time of recovery is higher than the number of Dice and is the turn of the last player, then a transition from recovery to chapter is valid"){
    controller.setRecovery(7)
    assertEquals(controller.getRecoveryOfPlayer, 7)
    assert(controller.turn == 0)
    controller.nextTurn()
    assert(controller.turn == 1)
    controller.tryOutRecovery()
    assert(controller.state.isInstanceOf[Chapter])
    assert(controller.turn == 0)
  }
  test("If the time of recovery is lower than number of Dice or equal, then a transition from chapter to player turn is valod "){
    controller.setRecovery(0)
    assertEquals(controller.getRecoveryOfPlayer, 0)
    assert(controller.turn == 0)
    controller.tryOutRecovery()
    assert(controller.state.isInstanceOf[PlayerTurn])
    assert(controller.turn == 0)
    assert(controller.getRecoveryOfPlayer==6)
  }
}

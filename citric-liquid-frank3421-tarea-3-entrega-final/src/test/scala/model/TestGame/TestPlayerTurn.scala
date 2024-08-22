package cl.uchile.dcc.citric
package model.TestGame
import model.Controller.Controller
import model.States._
class TestPlayerTurn extends munit.FunSuite {
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller
    controller.createTableAndPlayersConfig1()
    controller.setState(controller.getState("PlayerTurn"))
  }
  test("When rollDice is activated then a transition from PlayerTurn to Moving is made"){
    assert(controller.state.isInstanceOf[PlayerTurn])
    assert(controller.movements==0)
    controller.rollDice()
    assert(controller.movements()>0)
    assert(controller.state.isInstanceOf[Moving])
  }
}

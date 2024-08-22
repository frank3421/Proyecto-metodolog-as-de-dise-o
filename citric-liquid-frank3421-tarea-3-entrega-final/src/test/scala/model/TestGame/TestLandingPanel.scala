package cl.uchile.dcc.citric
package model.TestGame
import model.Controller.Controller
import model.States._
class TestLandingPanel extends munit.FunSuite {
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller
    controller.createTableAndPlayersConfig1()
    controller.setState(controller.getState("LandingPanel"))
  }
  test("When the method DoEffect is activated and the players turn is not the last player, then the effect of the panel is activated and change the turn by one and transition from landing to chapter happens"){
    controller.doEffect()
    assert(controller.state.isInstanceOf[Chapter])
    assert(controller.turn==1)
  }
  test("When the method DoEffect is activated and the players turn is the last player, then the effect of the panel is activated and change the turn by one and transition from landing to chapter happens") {
    controller.nextTurn()
    controller.doEffect()
    assert(controller.state.isInstanceOf[Chapter])
    println(controller.turn)
    assert(controller.turn == 0)
  }
}

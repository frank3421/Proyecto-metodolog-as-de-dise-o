package cl.uchile.dcc.citric
package model.TestGame
import model.Controller._
import model.States._
class TestPreGame extends munit.FunSuite{
  var controller:Controller= _
  override def beforeEach(context: BeforeEach): Unit = {
    controller=new Controller
  }
  test("The transition is not possible if there are not players playing the game"){
    val exception = intercept[Exception] {
      controller.startGame()
    }
    assertEquals(exception.getMessage, "The game can not start without players")
  }
  test("If there are players in the game, then the game can start"){
    controller.createTableAndPlayersConfig1()
    assert(controller.chapter==0)
    assert(controller.state.isInstanceOf[PreGame])
    controller.startGame()
    assert(controller.chapter==1)
    assert(controller.state.isInstanceOf[Chapter])
  }

}

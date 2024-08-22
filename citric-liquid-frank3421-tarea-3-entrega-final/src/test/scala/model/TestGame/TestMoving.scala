package cl.uchile.dcc.citric
package model.TestGame
import model.Controller._
import model.States._
import model.Panels._
import cl.uchile.dcc.citric.model.Panels.NeutralPanel
class TestMoving extends munit.FunSuite {
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller
    controller.createTableAndPlayersConfig1()
    controller.setState(controller.getState("Moving"))
  }
  test("When the method choosePath is activated but the direction selected is invalid, then throws an exception"){
    controller.setDirection(-1)
    assert(controller.direction==(-1))
    val exception=intercept[Exception]{
      controller.choosePath()
    }
    assertEquals(exception.getMessage,"There are not such direction in this panel")
  }
  test("When the method choosePath is activated but there are not movements remaining, then throws an exception"){
    controller.setMovements(0)
    assert(controller.movements==0)
    val exception = intercept[Exception] {
      controller.choosePath()
    }
    assertEquals(exception.getMessage, "The Player has not more movements")
  }
  test("When the method choosePath is activated and the direction is a valid direction and there are movements remaining, then the move is realized "){
    controller.setMovements(1)
    assert(controller.movements==1)
    val player1=controller.playerCharacters(controller.turn)
    assert(player1.inPanel.get.isInstanceOf[NeutralPanel])
    controller.choosePath()
    assert(controller.movements==0)
    assert(player1.inPanel.get.isInstanceOf[EncounterPanel])
  }
  test("When the method stopMovement is activated and the player is in their home panel, a transition from moving to combat sucess"){
    val player1=controller.playerCharacters(controller.turn)
    player1.HomePanel=new HomePanel(player1)
    player1.setPanel(player1.HomePanel.get)
    controller.stopMovement()
    assert(controller.movements()==0)
  }
  test("When the method stopMovement is activated and the player is not in their Home Panel, then throws an Exception"){
    val player1=controller.playerCharacters(controller.turn)
    val exception=intercept[Exception]{
      controller.stopMovement()
    }
    assertEquals(exception.getMessage,"The player is in a HomePanel but is not their Home Panel and has movements")
  }
  test("When the method outOfMovements is activated and the player has more movements remaining, then throws an exception"){
    assert(controller.movements==0)
    controller.setMovements(1)
    assert(controller.movements==1)
    val exception=intercept[Exception] {
      controller.outOfMovements()
    }
    assertEquals(exception.getMessage,"The character has moves remaining")
  }
  test("When the method outOfMovements is activated and the player has not more movements remaining, then a transition from moving to combat happens"){
    assert(controller.movements == 0)
    assert(controller.state.isInstanceOf[Moving])
    controller.outOfMovements()
    assert(controller.state.isInstanceOf[Combat])
  }
}

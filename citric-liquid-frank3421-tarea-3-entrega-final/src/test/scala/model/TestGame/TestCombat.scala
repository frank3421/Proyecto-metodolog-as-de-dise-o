package cl.uchile.dcc.citric
package model.TestGame
import model.Controller.Controller
import model.States._
class TestCombat extends munit.FunSuite {
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller
    controller.createTableAndPlayersConfig1()
    controller.setState(controller.getState("Combat"))
  }
  test("When the method attack is used in the state combat and the character choose not attack(attackTo==-1), then throws an exception"){
    val exception=intercept[Exception]{
      controller.attack()
    }
    assertEquals(exception.getMessage,"The player doesnt want to attack other player")
  }
  test("When the method attack is used in the state combat and the character choose an invalid target, then throws an exception"){
    controller.setAttack(4)
    val exception = intercept[Exception] {
      controller.attack()
    }
    assertEquals(exception.getMessage, "The player doesnt choose a right target")
  }
  test("When the method attack is used in the state combat and the player choose a valid target, then happens a transition from combat to wait"){
    controller.setAttack(1)
    controller.attack()
    assert(controller.state.isInstanceOf[Wait])
  }
  test("If the player that is their turn attacked other player, then the other player attack that player if the other player is not ko"){
    controller.combat=1
    controller.setAttack(1)
    assert(controller.combat==1)
    controller.attack()
    assert(controller.combat==2)
  }
  test("When the method endCombat is activated and the combat is not finished yet, then throws a Exception"){
    controller.combat=1
    val exception=intercept[Exception]{
      controller.endCombat()
    }
    assertEquals(exception.getMessage,"The player that defended has hp>0 and has to attack")
  }
  test("When the method endCombat is activated and the player has not started a combat or the other player has attacked their agressor, the a transition from combat to landing panel happens"){
    controller.combat=2
    assert(controller.combat==2)
    controller.endCombat()
    assert(controller.state.isInstanceOf[LandingPanel])
  }
}

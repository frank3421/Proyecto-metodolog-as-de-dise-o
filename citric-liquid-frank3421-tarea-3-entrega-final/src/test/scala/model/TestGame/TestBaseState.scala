package cl.uchile.dcc.citric
package model.TestGame
import model.States.BaseState
import model.Controller.Controller
import model.States._


class TestBaseState extends munit.FunSuite {

  var baseState: BaseState = _
  var controller: Controller=_

  override def beforeEach(context: BeforeEach): Unit = {
    baseState = new BaseState
    controller = new Controller
  }

  test("The transition with the method startGame gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.startGame(controller)
    }
  }
  test("The transition with the method newChapter gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.newChapter(controller)
    }
  }
  test("The transition with the method normaSixReached gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.normaSixReached(controller)
    }
  }
  test("The transition with the method Ko gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.Ko(controller)
    }
  }
  test("The transition with the method playTurn gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.playTurn(controller)
    }
  }
  test("The transition with the method tryOutRecovery gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.tryOutRecovery(controller)
    }
  }
  test("The transition with the method rollDice gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.rollDice(controller)
    }
  }
  test("The transition with the method choosePath gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.choosePath(controller)
    }
  }
  test("The transition with the method outOfMovements gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.outOfMovements(controller)
    }
  }
  test("The transition with the method stopMovement gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.stopMovement(controller)
    }
  }
  test("The transition with the method attack gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.attack(controller)
    }
  }
  test("The transition with the method defend gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.defend(controller)
    }
  }
  test("The transition with the method evade gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.evade(controller)
    }
  }
  test("The transition with the method endCombat gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.endCombat(controller)
    }
  }
  test("The transition with the method doEffect gives an error by default") {
    interceptMessage[Exception]("Invalid transition") {
      baseState.doEffect(controller)
    }
  }
  test("The baseState can change the state of the controller"){
    val initialState=controller.state
    assert(initialState.isInstanceOf[PreGame])
    baseState.changeState(controller,controller.getState("EndGame"))
    assert(controller.state==controller.getState("EndGame"))
  }
}

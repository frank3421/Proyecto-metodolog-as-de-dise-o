package cl.uchile.dcc.citric
package model.States
import model.Controller.Controller
import exceptions.States.WrongModeCombat
import model.Units.Player

/**This class simulate the response of the defender when someone decide to attack
 *
 * @throws WrongModeCombat Happens when the mode of combat that is selected is not the same of the method
 *
 * @example
 * {{{
 *   val controller=new Controller
 *   val wait=new Wait
 *   wait.evade(controller)
 *   wait.defend(controller)
 * }}}
 */
class Wait extends BaseState {

  /** The method that represents the evading of a character.   Allows a transition from wait to combat
   *
   * @param controller The class that has the current information of the game
   *
   * @throws WrongModeCombat Happens when the mode of combat is not the same with method
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   val wait=new Wait
   *   wait.evade(controller)
   * }}}
   */
  override def evade(controller:Controller):Unit={
    try{
      val playerAttacking=controller.playerCharacters(controller.turn)
      val playerAttacked:Player = controller.playerCharacters(controller.attackTo)
      if (playerAttacked.ModeCombat == 1) {
        throw new WrongModeCombat("The mode combat chosen is defend so the transition is invalid")
      }
      else{
        playerAttacking.attack(playerAttacked)
        if (!playerAttacked.ko) {
          controller.combat = 1
        }
        this.changeState(controller, controller.getState("Combat"))
      }

    }
    catch{
      case e:WrongModeCombat=>throw e
    }
  }

  /** The method that represents the defending of a character.   Allows a transition from wait to combat
   *
   * @param controller The class that has the current information of the game
   * @throws WrongModeCombat Happens when the mode of combat is not the same with method
   * @example
   * {{{
   *   val controller=new Controller
   *   val wait=new Wait
   *   wait.defend(controller)
   * }}}
   */
  override def defend(controller: Controller): Unit = {
    try {
      val playerAttacking = controller.playerCharacters(controller.turn)
      val playerAttacked: Player = controller.playerCharacters(controller.attackTo)
      if (playerAttacked.ModeCombat == 2) {
        throw new WrongModeCombat("The mode combat chosen is evade so the transition is invalid")
      }
      playerAttacking.attack(playerAttacked)
      this.changeState(controller, controller.getState("Combat"))
    }
    catch {
      case e: WrongModeCombat => throw e
    }
  }

}

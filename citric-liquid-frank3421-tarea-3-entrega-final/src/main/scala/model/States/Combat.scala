package cl.uchile.dcc.citric
package model.States
import model.Controller.Controller
import exceptions.States.{CombatNotFinished, InvalidAttack, PlayerDoesntWantAttack}
import model.Units.Player

/**The class where the player could initiate a fight if there are more players in that panel
 *
 * @throws PlayerDoesntWantAttack Happens when the player didnt choose an objective because doesnt want to attack a player
 * @throws InvalidAttack Happens when the player choose a target to attack but that target is invalid
 * @throws CombatNotFinished Happens when a player attack but the player that was attacked has not attacked back
 *
 * @example
 * {{{
 *   val controller= New Controller
 *   val combat=Combat
 *   combat.attack(controller)
 *   combat.endCombat(controller)
 * }}}
 *
 */
class Combat extends BaseState {
  /**The method that allows to player to attack someone if the player choose a valid target
   *
   * @param controller The class that has the current information of the game
   *@throws PlayerDoesntWantAttack Happens when the player didnt choose an objective because doesnt want to attack a player
   *@throws InvalidAttack Happens when a player attack but the player that was attacked has not attacked back
   * @example
   * {{{
   *  val controller= New Controller
   *  val combat=Combat
   *  combat.attack(controller)
   * }}}
   */
  override def attack(controller:Controller):Unit={
    try {
      if (controller.combat==1){
        val playerAttacked = controller.playerCharacters(controller.turn)
        val playerAttacking: Player = controller.playerCharacters(controller.attackTo)
        playerAttacking.attack(playerAttacked)
        controller.combat=2
      }
      else if (controller.attackTo == (-1)) {
        throw new PlayerDoesntWantAttack("The player doesnt want to attack other player")
      }
      else if(controller.attackTo<0 || controller.attackTo>controller.TotalPlayers){
        throw new InvalidAttack("The player doesnt choose a right target")
      }
      else{
        this.changeState(controller, controller.getState("Wait"))
      }
    }
    catch{
      case e: PlayerDoesntWantAttack=>throw e
      case e1:InvalidAttack=>throw e1
    }
  }

  /**This method allows to transition form combat to landing panel.
   *
   * @param controller The class that has the current information of the game
   * @throws CombatNotFinished Happens when a player attack but the player that was attacked has not attacked back
   * @example
   * {{{
   *  val controller= New Controller
   *  val combat=Combat
   *  combat.endCombat(controller)
   * }}}
   */
  override def endCombat(controller: Controller): Unit = {
    try{
      if(controller.combat==0||controller.combat==2){
        this.changeState(controller,controller.getState("LandingPanel"))
        controller.combat=0
      }
      else{
        throw new CombatNotFinished("The player that defended has hp>0 and has to attack")
      }
    }
    catch {
      case e:CombatNotFinished=>throw e
    }
  }
}

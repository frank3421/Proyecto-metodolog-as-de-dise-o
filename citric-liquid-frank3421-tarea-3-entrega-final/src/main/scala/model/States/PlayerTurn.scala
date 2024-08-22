package cl.uchile.dcc.citric
package model.States
import model.Controller.Controller

import scala.util.Random

/**The class that represents the state before the player throws the dice to move
 *
 * @example
 * {{{
 *   val controller=new Controller
 *   val playerTurn=new PlayerTurn
 *   playerTurn.rollDice(controller)
 * }}}
 */
class PlayerTurn extends BaseState {
  /**The method to allows the transition from player turn to moving.  the player throws the dice and in the next state
   * start to move.
   *
   * @param controller The class that has the current information of the game
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   val playerTurn=new PlayerTurn
   *   playerTurn.rollDice(controller)
   * }}}
   */
  override def rollDice(controller: Controller): Unit = {
    val Dice:Int=new Random().nextInt(6)+1
    controller.setMovements(Dice)
    this.changeState(controller,controller.getState("Moving"))
  }
}

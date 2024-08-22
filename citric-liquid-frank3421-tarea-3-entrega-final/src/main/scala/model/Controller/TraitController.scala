package cl.uchile.dcc.citric
package model.Controller

import model.States.TraitState
import model.Units._

/**Its a trait that contains a set of methods that will be defined in the controller
 *
 */
trait TraitController {
  /** Update the current state of the game.
   *
   * @param aState The new state
   */
  def setState(aState: TraitState): Unit
  /** Allows to change the current state to transition from PreGame to Chapter if its possible.
   *
   */
  def startGame(): Unit

  /**Allows to reset the turn and start a new Chapter.
   *
   */
  def newChapter(): Unit

  /** Allows to change the current state from Chapter to EndGame.
   *
   */
  def normaSixReached(): Unit

  /** Allows to change the current state from Chapter to Recovery
   *
   */
  def Ko(): Unit

  /** Allows to change the state from Chapter to PlayerTurn
   *
   */
  def playTurn(): Unit

  /** Allows to change the state from recovery to PlayerTurn or Chapter
   *
   */
  def tryOutRecovery(): Unit

  /** Allows to change the state from PlayerTurn to Moving.
   */
  def rollDice(): Unit

  /** This method allows to change the path and remains in Moving
   *
   */
  def choosePath(): Unit

  /** Allows to change the state from moving to Combat.
   *
   */
  def outOfMovements(): Unit

  /** Allows to change the state from moving to combat
   *
   */
  def stopMovement(): Unit

  /** Allows to change the state from combat to wait.
   *
   */
  def attack(): Unit

  /** Allows to change the state from wait to combat
   *
   */
  def defend(): Unit

  /** Allows to change the state from wait to combat
   *
   */
  def evade(): Unit

  /** Allows to change the state from Chapter to endCombat
   *
   */
  def endCombat(): Unit

  /** Allows to change the state from landingPanel to chapter
   *
   */
  def doEffect(): Unit
}

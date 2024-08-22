package cl.uchile.dcc.citric
package model.States
import model.Controller._

/**The trait that has all the method that a state must to have in the game
 *
 */
trait TraitState {

  /** This method allows to change the current state of a controller
   *
   * @param controller The class that has the current information of a game
   * @param state      The  state of game that wants to set in state of controller
   */
  def changeState(controller: TraitController, state: TraitState): Unit

  /** The method to change the pregame to chapter, will throw a exception
   *
   * @param controller The class that has the current information of the game
   */
  def startGame(controller: Controller): Unit

  /** The method to allows to enter in a new chapter in the game, throw an exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def newChapter(controller: Controller): Unit

  /** The method to change the chapter to endGame, throw an exception by defect
   *
   * @param controller The class that has the current information of the game
   */
  def normaSixReached(controller: Controller): Unit

  /** The method to change the chapter to recovery, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def Ko(controller: Controller): Unit

  /** The method to change the chapter to playerTurn, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def playTurn(controller: Controller): Unit

  /** The method to change the recovery to chapter or player turn, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.tryOutRecovery(controller)
   * }}}
   */
  def tryOutRecovery(controller: Controller): Unit

  /** The method to change the playerTurn to moving, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def rollDice(controller: Controller): Unit

  /** The method to move if the direction was established, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def choosePath(controller: Controller): Unit

  /** The method to change the moving state to combat, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def outOfMovements(controller: Controller): Unit

  /** The method to change the pregame to chapter, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def stopMovement(controller: Controller): Unit

  /** The method to change the combat state to wait, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def attack(controller: Controller): Unit

  /** The method to change the wait state to combat, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def defend(controller: Controller): Unit

  /** The method to change the wait state to combat, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def evade(controller: Controller): Unit

  /** The method to change the combat to landing panel state, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def endCombat(controller: Controller): Unit

  /** The method to change the landing Panel to chapter, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   */
  def doEffect(controller: Controller): Unit
}

package cl.uchile.dcc.citric
package model.States
import model.Controller._

/**The class that is used like a template of other states of the game
 *
 * By default the transitions of this states generate an error
 *
 * @throws invalidTransitionException Happens with all transition methods
 *
 * @example
 * {{{
 *   val controller=new Controller
 *   val base = new Controller
 *   base.startGame(controller)
 *   base.changeState(controller,new Chapter)
 * }}}
 */
class BaseState extends TraitState {
  /**The exceptions that is launched in all transition states by default
   *
   * @param message The message that will be printed
   *
   * @constructor Creates a new Exception with a message
   *
   * @example
   * {{{
   *   val base=new BaseState
   *   val controller=new Controller
   *   base.startGame(controller)
   * }}}
   */
  private class invalidTransitionException(message:String) extends Exception(message)

  /** This method allows to change the current state of a controller
   *
   * @param controller The class that has the current information of a game
   * @param state The  state of game that wants to set in state of controller
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.changeState(controller,new Chapter)
   * }}}
   */
  def changeState(controller: TraitController, state: TraitState): Unit={
    controller.setState(state)
  }

  /**The error that will be throw in the transition methods by defect
   *
   * @example
   * {{{
   *   val base=new BaseState
   *   base.error()
   * }}}
   */
  private def error():Unit={
    throw new invalidTransitionException("Invalid transition")
  }

  /**The method to change the pregame to chapter, will throw a exception
   *
   * @param controller The class that has the current information of the game
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.startGame(controller)
   * }}}
   */
  def startGame(controller: Controller): Unit=error()

  /** The method to allows to enter in a new chapter in the game, throw an exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.newChapter(controller)
   * }}}
   */
  def newChapter(controller: Controller): Unit=error()
  /** The method to change the chapter to endGame, throw an exception by defect
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.normaSixReached(controller)
   * }}}
   */
  def normaSixReached(controller: Controller): Unit=error()
  /** The method to change the chapter to recovery, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.Ko(controller)
   * }}}
   */
  def Ko(controller: Controller): Unit=error()
  /** The method to change the chapter to playerTurn, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.playTurn(controller)
   * }}}
   */
  def playTurn(controller: Controller): Unit=error()
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
  def tryOutRecovery(controller:Controller): Unit=error()
  /** The method to change the playerTurn to moving, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.rollDice(controller)
   * }}}
   */
  def rollDice(controller: Controller): Unit=error()
  /** The method to move if the direction was established, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.choosePath(controller)
   * }}}
   */
  def choosePath(controller: Controller): Unit=error()
  /** The method to change the moving state to combat, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.outOfMovements(controller)
   * }}}
   */
  def outOfMovements(controller: Controller): Unit=error()
  /** The method to change the pregame to chapter, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.stopMovement(controller)
   * }}}
   */
  def stopMovement(controller: Controller): Unit=error()
  /** The method to change the combat state to wait, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.attack(controller)
   * }}}
   */
  def attack(controller: Controller): Unit=error()
  /** The method to change the wait state to combat, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.defend(controller)
   * }}}
   */
  def defend(controller: Controller): Unit=error()
  /** The method to change the wait state to combat, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.evade(controller)
   * }}}
   */
  def evade(controller: Controller): Unit=error()
  /** The method to change the combat to landing panel state, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.endCombat(controller)
   * }}}
   */
  def endCombat(controller: Controller): Unit=error()
  /** The method to change the landing Panel to chapter, will throw a exception by defect in this class
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val base=new BaseState
   *   base.doEffect(controller)
   * }}}
   */
  def doEffect(controller: Controller): Unit=error()
}

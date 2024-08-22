package cl.uchile.dcc.citric
package model.States
import model.Controller._
import exceptions.States._

/**This class represents the initial state of the game when has not yet started
 *
 *
 * @example
 * {{{
 *   val controller=new Controller
 *   val pregame=new PreGame
 *   pregame.startGame(controller)
 * }}}
 */
class PreGame extends BaseState {
  /**Allows to transition to pregame to chapter if the conditions that are required are satisfied
   *
   * @param controller class that contains the actual information of the game
   *
   * @throws ListOfPlayerEmpty If there are not players defined in the list of players
   *
   * @example
   * {{{
   *   val pregame=new PreGame
   *   pregame.startGame
   * }}}
   */
  override def startGame(controller:Controller):Unit={
    try{
      if(controller.playerCharacters.isEmpty) {
        throw new ListOfPlayerEmpty("The game can not start without players")
      }
      controller.increaseChapter()
      this.changeState(controller, controller.getState("Chapter"))
    }
    catch{
      case e:ListOfPlayerEmpty => throw e
    }
  }

}

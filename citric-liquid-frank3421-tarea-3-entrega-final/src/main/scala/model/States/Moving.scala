package cl.uchile.dcc.citric
package model.States
import model.Controller.Controller
import exceptions.States.{ PlayerHasNotMovements, WrongDirection,MovementsRemaining}
import model.Panels.HomePanel
import model.Units.{Player,PlayerCharacter}
import exceptions.States.CannotStop

/**The class that represent the state of the player when the player is moving
 *
 * @throws WrongDirection Happens when the player choose an invalid direction
 * @throws PlayerHasNotMovements Happens when the player wants to move but has not more movements
 * @throws CannotStop Happens when the player has movements remaining and can stop because is not in owner of the panel
 * @throws MovementsRemaining Happens when the player has movements remaining
 *
 * @example
 * {{{
 *   val controller=new Controller
 *   val moving= new Moving
 *   moving.ChoosePath(controller)
 *   moving.StopMovement(controller)
 *   moving.outOfMovements(controller)
 * }}}
 *
 */
class Moving extends BaseState{
  /**The method that allows to move in the direction selected
   *
   * @param controller The class that has the current information of the game
   * @throws WrongDirection Happens when the player choose a invalid direction
   * @throws  PlayerHasNotMovements Happens when the player has not movements
   * @example
   * {{{
   *   val controller=new Controller
   *   val moving= new Moving
   *   moving.ChoosePath(controller)
   * }}}
   */
  override def choosePath(controller: Controller): Unit = {
    try{
      val player: Player = controller.playerCharacters(controller.turn)
      val panel = player.inPanel.get
      val num=panel.nextPanels.size
      if (controller.direction() < 0 || controller.direction() >num) {
        throw new WrongDirection("There are not such direction in this panel")
      }
      else if(controller.movements==0){
        throw new PlayerHasNotMovements("The Player has not more movements")
      }
      else{
        player.setPanel(panel.nextPanels(controller.direction()))
        controller.decreaseMovements()
      }
    }
    catch{
      case e1:WrongDirection=>throw e1
      case e2:PlayerHasNotMovements=>throw e2
    }
  }

  /** The method that allows to stop movements when a player is in a home panel and its the owner
   *
   * @param controller The class that has the current information of the game
   * @throws CannotStop Happens when the player cannot stop because the player is not the owner of the panel
   * @example
   * {{{
   *   val controller=new Controller
   *   val moving= new Moving
   *   moving.stopMovement(controller)
   * }}}
   */
  override def stopMovement(controller:Controller):Unit ={
    try{
      val player: Player = controller.playerCharacters(controller.turn)
      val panel = player.inPanel.get
      if (panel!=player.HomePanel.get){
        throw new CannotStop("The player is in a HomePanel but is not their Home Panel and has movements")
      }
      else{
        controller.setMovements(0)
        this.changeState(controller, controller.getState("Combat"))
      }
    }
    catch{
      case e2:CannotStop=>throw e2
    }
  }

  /**The method that allows to transition from this class to combat in the state of the controller when the player
   * has not more remaining movements.
   *
   * @param controller The class that has the current information of the game
   * @throws MovementsRemaining Happens when the character has moves remaining
   * @example
   * {{{
   *   val controller=new Controller
   *   val moving= new Moving
   *   moving.outMovements(controller)
   * }}}
   */
  override def outOfMovements(controller: Controller): Unit = {
    try{
      if(controller.movements!=0){
        throw new MovementsRemaining("The character has moves remaining")
      }
      this.changeState(controller,controller.getState("Combat"))
    }
    catch{
      case e:MovementsRemaining=>throw e
    }
  }

}

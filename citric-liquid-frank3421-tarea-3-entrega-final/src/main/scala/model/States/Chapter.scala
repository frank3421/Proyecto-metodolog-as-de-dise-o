package cl.uchile.dcc.citric
package model.States
import model.Controller._
import exceptions.States._
import model.Units.Player

/** The class chapter
 *
 * In this class, can reset the turn if the last players turn was execute.   Also in this class the player can win if
 * he reached the norma six, the player can go to recovery state if the player is ko or play their turn.
 *
 * @example
 * {{{
 *   val controller=new Controller
 *   val chapter= new Chapter
 *   chapter.newChapter(controller)
 *   chapter.normaSixReached(controller)
 *   chapter.Ko(controller)
 *   chapter.playTurn(controller)
 * }}}
 *
 * @throws InvalidTransitionException Happens when the turn of the last player it doesnt happen yet
 * @throws NormaIsNot6 Happens when a player wants to win but their norma is not 6
 * @throws PlayerIsKo Happens when the player is ko
 *
 *
 */
class Chapter extends BaseState{
  /** The method that allows to reset the current turn to 0 and start a new chapter
   *
   * @param controller The class that has the current information of the game
   *
   * @throws InvalidTransitionToNewChapter Happens when the turn of the last player it doesnt happen yet
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   controller.newChapter(this)
   * }}}
   */
  override def newChapter(controller: Controller): Unit = {
    try{
      if(controller.turn!=controller.TotalPlayers-1){
        throw new InvalidTransitionToNewChapter("The turn of the last player it doesnt happen yet")
      }
      controller.increaseChapter()
      controller.resetTurn()
    }
    catch{
      case e:InvalidTransitionToNewChapter=>throw e
    }
  }

  /**The method that allows to a player to win the game if norma 6 is reached
   *
   * @param controller The class that has the current information of the game
   * @throws NormaIsNot6 Happens when the norma of the player is not 6
   * @throws PlayerIsKo Happens when the player is Ko
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   controller.normaSixReached(this)
   * }}}
   */
  override def normaSixReached(controller: Controller): Unit = {
    try{
      val player:Player= controller.playerCharacters(controller.turn)
      if (player.norma!=6){
        throw new NormaIsNot6("The norma of the player is not 6 so the player can not win")
      }
      else if(player.ko){
        throw new PlayerIsKo("The player is Ko so the player can not win")
      }
      else {
        this.changeState(controller, controller.getState("EndGame"))
        player.notifyObservers()
      }
    }
    catch{
      case e:NormaIsNot6 => throw e
      case e1:PlayerIsKo => throw e1
    }
  }

  /**The method that allows to a player to enter in recovery state if the player is ko.
   *
   * @param controller The class that has the current information of the game
   *
   * @throws PlayerIsKo Happens when the player is not ko so the player cannot be in recovery state
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   controller.Ko(this)
   * }}}
   */
  override def Ko(controller:Controller): Unit={
    try{
      val player:Player= controller.playerCharacters(controller.turn)
      if(!player.ko){
        throw new PlayerIsKo("The player is not Ko so the player cannot be in recovery state")
      }
      else{
        this.changeState(controller,controller.getState("Recovery"))
      }
    }
    catch{
      case e:PlayerIsKo => throw e
    }
  }

  /** The method that allows to a player to enter in playerTurn state to start their turn of the game
   *
   * @param controller The class that has the current information of the game
   * @throws PlayerIsKo Happens when the player is Ko so the player can not initiate their turn
   * @example
   * {{{
   *   val controller=new Controller
   *   controller.playTurn(this)
   * }}}
   */
  override def playTurn(controller: Controller): Unit = {
    try{
      val player:Player= controller.playerCharacters(controller.turn)
      if(player.ko){
        throw new PlayerIsKo("The player is Ko so the player can not initiate their turn")
      }
      this.changeState(controller,controller.getState("PlayerTurn"))
    }
    catch{
      case e:PlayerIsKo=>throw e
    }
  }
}

package cl.uchile.dcc.citric
package model.States
import model.Controller.Controller
import model.Units

/**The state of the game where the effects of panels activate
 *
 * @example
 * {{{
 *   val controller=new Controller
 *   val landing=new LandingPanel
 *   landing.doEffect(controller)
 * }}}
 */
class LandingPanel extends BaseState {
  /**In this method the effects of landing panel is going to be activate and that effects will be applied in the
   * player that is playing their turn
   *
   * @param controller The class that has the current information of the game
   * @example
   * {{{
   *   val controller=new Controller
   *   val landing=new LandingPanel
   *   landing.doEffect(controller)
   * }}}
   */
  override def doEffect(controller: Controller): Unit = {
    val player=controller.playerCharacters(controller.turn)
    val panel=player.inPanel.get
    panel.apply(player)
    if(controller.turn==controller.TotalPlayers-1){
      controller.resetTurn()
      controller.setAttack(-1)
      this.changeState(controller,controller.getState("Chapter"))
    }
    else{
      controller.setAttack(-1)
      controller.nextTurn()
      this.changeState(controller,controller.getState("Chapter"))
    }
  }
}

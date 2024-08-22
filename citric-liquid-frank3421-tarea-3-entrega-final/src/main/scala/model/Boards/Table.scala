package cl.uchile.dcc.citric
package model.Boards

import model.Controller._
import model.Panels._

/**The class that represent the board where the players will play
 *
 * The players that will play in this board are two.  To create the class we are using singleton pattern
 *
 */
class Table () {
  /**This method is used to create a new board to play
   *
   * @return The panel that will be added to the list of next panels of initial panel of a controller
   */
  def createNewTable(controller:Controller):Panel={
    val panel1 = new EncounterPanel
    val panel2 = new EncounterPanel
    val panel3 = new BonusPanel
    val panel4 = new DropPanel
    val panel5 = new EncounterPanel
    val panel6=new HomePanel(controller.playerCharacters(0))
    val panel7=new HomePanel(controller.playerCharacters(1))
    panel1.addNextPanel(panel2)
    panel2.addNextPanel(panel3)
    panel2.addNextPanel(panel5)
    panel3.addNextPanel(panel4)
    panel5.addNextPanel(panel4)
    panel4.addNextPanel(panel6)
    panel4.addNextPanel(panel7)
    panel7.addNextPanel(panel1)
    panel6.addNextPanel(panel1)
    val player1=controller.playerCharacters(0)
    val player2=controller.playerCharacters(1)
    player1.HomePanel = panel6
    player2.HomePanel = panel7
    panel1
  }
}

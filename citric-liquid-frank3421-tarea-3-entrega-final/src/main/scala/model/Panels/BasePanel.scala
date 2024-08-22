package cl.uchile.dcc.citric
package model.Panels

import model.Units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
/** An abstract class that has the elements and methods that each type of panel must have
 *
 *The abstract class have variables called characters and nextPanels and both of them are represented initially
 * as an empty ArrayBuffer that can be filled with characters objects and panels respectively.  Also the abstract class
 * has four methods that allows to change the ArrayBuffer of characters and nextPanels adding or subtracting characters
 * and panels respectively.
 */
abstract class BasePanel() extends Panel{

  /**The characters in the panel
   *
   * This variable is a ArrayBuffer that could contains PlayerCharacter objects
   */
  val characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer.empty[PlayerCharacter]

  /**The nextPanels of the panel
   *
   * This variable is an ArrayBuffer that could contains Panels objects
   */
  protected var _nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty[Panel]

  /**Return te nextPanels of the Panel
   */
  def nextPanels : ArrayBuffer[Panel]= {
    val copy=_nextPanels.clone()
    copy
  }
  private def nextPanels_=(newNextPanel: ArrayBuffer[Panel]): Unit={
    _nextPanels=newNextPanel
  }
  /**Allows modify the list of characters adding a playerCharacter object
   *
   * @param player The player character to add to this panel.
   * @return The ArrayBuffer with the character inside
   * @example of using with NeutralPanel that inherits this method of this abstract class
   * {{{
   *  character1= new PlayerCharacter(name,maxHp,attack,defense, evasion, randomNumberGenerator)
   *  panel1 = new NeutralPanel()
   *  panel1.addCharacter(character1)
   * }}}
   */
  def addCharacter(player: PlayerCharacter): Unit = {
    if (characters.contains(player)){
    }
    characters+=player
    player.inPanel=Some(this)
  }

  /** Allows modify the list of characters subtracting a playerCharacter object
   *
   * @param player The player character to add to this panel.
   * @return The ArrayBuffer without the character inside
   * @example of using with NeutralPanel that inherits this method of this abstract class
   * {{{
   *   val panel1=new NeutralPanel
   *   val player1=new PlayerCharacter("player",1,1,1,1)
   *   print(s"panel1 don t have player 1 in Characters, $panel1.characters.contains(player1)")
   *   panel1.addCharacter(player1)
   *   print(s"panel1 now have in Characters player1,$panel1.characters.contains(player1)")
   *   panel1.removeCharacter(player1)
   *   print(s"panel1 don t have player 1 in Characters, $panel1.characters.contains(player1)")
   * }}}
   */
  def removeCharacter(player: PlayerCharacter): Unit = {
    if(characters.contains(player)){
      characters-=player
      player.inPanel=None
    }

  }

  /** Allows modify the list of nextPanels adding a Panel object
   *
   * @param panel The panel object to add to nextPanels.
   * @return The ArrayBuffer with the panel inside
   * @example of using with NeutralPanel that inherits this method of this abstract class
   * {{{
   *
   * }}}
   */
  def addNextPanel(newPanel: Panel): Unit ={
    val copy=nextPanels
    copy+=newPanel
    nextPanels=copy
  }

  /** Allows modify the list of nextPanels subtracting a Panel object
   *
   * @param panel The panel object to subtract to nextPanels.
   * @return The ArrayBuffer with the panel inside
   * @example of using with NeutralPanel that inherits this method of this abstract class
   * {{{
   *
   * }}}
   */
  def removeNextPanel(panel: Panel): Unit = {
    if(nextPanels.contains(panel)){
      val copy=nextPanels
      copy-=panel
      nextPanels=copy
    }
  }
}
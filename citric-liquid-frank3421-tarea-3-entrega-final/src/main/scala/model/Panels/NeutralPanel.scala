package cl.uchile.dcc.citric
package model.Panels

import model.Units.Player

/** The class that represents a HomePanel of the game
 *
 * The class inherits the variables and methods of BasePanel and define the methods apply and equals.
 *
 * @constructor Create a new NeutralPanel.
 * @example
 * {{{
 *   val player1=new PlayerCharacter("m",1,1,1,1)
 *   val NeutralPanel1=new NeutralPanel
 *   val NeutralPanel2=new NeutralPanel
 *   println(s"its true that a NeutralPanel1 have the same class of NeutralPanel2 $NeutralPanel1.equals(NeutralPanel2)")
 * }}}
 */
class NeutralPanel extends BasePanel {
  /**This method do nothing
   *
   *
   * @param player The player to whom the panel effects will be applied
   *
   * @example
   * {{{
   *   val neutralPanel=new NeutralPanel
   *   neutralPanel.apply(new character(",",1,1,1,1))
   * }}}
   */
  def apply(player: Player): Unit = {
  }
  /** Compares the NeutralPanel with another object to determine if they have the same class.
   *
   * @param other The object to be compared with.
   *
   * @example
   * {{{.
   * val NeutralPanel= new NeutralPanel
   * println(s"this is true, $NeutralPanel.equals(new NeutralPanel)")
   * }}}
   *
   * @return `true` if this NeutralPanel have the same class with the object, `false` otherwise.
   */
  override def equals(other: Any): Boolean = other.getClass==this.getClass
}

package cl.uchile.dcc.citric
package model.Panels

import model.Units.Player

import scala.util.Random


/** The class that represents a DropPanel of the game
 *
 * The class inherits the variables and methods of BasePanel and define the methods apply and equals.
 *
 * @constructor Create a new DropPanel.
 *
 * @example
 * {{{
 *   val player1=new PlayerCharacter("m",1,1,1,1)
 *   val DropPanel=new DropPanel
 *   DropPanel.apply(player1)
 *   val NeutralPanel=new NeutralPanel()
 *   println(s"its false that a NeutralPanel is equal DropPanel, $DropPanel.equals(NeutralPanel)")
 * }}}
 *
 */
class DropPanel() extends BasePanel{
  /** This method simulate the effect of a DropPanel that are explained in the enunciate
   *
   * @example
   * {{{
   *   val player1=new PlayerCharacter("m",1,1,1,1)
   *   val DropPanel=new DropPanel
   *   DropPanel.apply(player1)
   * }}}
   *
   * @param player The player to whom the panel effects will be applied
   */
  def apply(player: Player): Unit = {
    player.changeStars(-1*(Random.nextInt(6) + 1)*player.norma)
  }

  /** Compares the DropPanel with another object to determine if they have the same class.
   *
   * @param other The object to be compared with.
   *
   * @example
   * {{{
   * val DropPanel= new DropPanel
   * println(s"this is true, $DropPanel.equals(new DropPanel)")
   * }}}
   *
   * @return `true` if this DropPanel have the same class with the object, `false` otherwise.
   */
  override def equals(other: Any): Boolean = other.getClass==this.getClass
}

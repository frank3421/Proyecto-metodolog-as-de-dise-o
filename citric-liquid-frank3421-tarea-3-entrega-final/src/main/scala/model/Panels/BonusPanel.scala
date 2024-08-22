package cl.uchile.dcc.citric
package model.Panels

import model.Units.Player

import scala.util.Random
/** The class that represents a BonusPanel of the game
 *
 * The class inherits the variables and methods of BasePanel and define the methods apply and equals.
 *
 * @constructor Create a new BonusPanel.
 * @example
 * {{{
 *  panel1 = new BonusPanel
 *  panel2 = new NeutralPanel
 *  assert(character1.stars==0)
 *  panel1.apply(character1)
 *  assert(character1.stars!=0)
 *  assert(!panel1.equals(panel2))
 * }}}
 *
 */
class BonusPanel extends BasePanel {
  /** This method simulate the effect of a BonusPanel that are explained in the enunciate
   *
   * @example
   * {{{
   *   val player1=new PlayerCharacter("m",1,1,1,1)
   *   val BonusPanel=new BonusPanel
   *   BonusPanel.apply(player1)
   * }}}
   * @param player The player to whom the panel effects will be applied
   */
  def apply(player: Player): Unit = {
    var Dice = Random.nextInt(6) + 1
    var a1 = Dice * player.norma
    var a2 = Dice * 3
    player.changeStars(a2.min(a1))
  }

  /** Compares the BonusPanel with another object to determine if they have the same class.
   *
   * @param other The object to be compared with.
   * @example
   * {{{
   *  panel1 = new BonusPanel
   *  panel2 = new NeutralPanel
   *  assert(!panel1.equals(panel2))
   * }}}
   * @return `true` if this BonusPanel have the same class with the object, `false` otherwise.
   */
  override def equals(other: Any): Boolean = other.getClass==this.getClass
}

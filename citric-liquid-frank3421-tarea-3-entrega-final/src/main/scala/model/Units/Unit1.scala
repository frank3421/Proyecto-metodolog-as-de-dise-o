package cl.uchile.dcc.citric
package model.Units

import cl.uchile.dcc.citric.model.Panels.Panel
import model.Panels.HomePanel
/**Represents a Unit that could be player or WildUnit
 *
 * Each Unit has their variables.
 * In the context of board game, the units interact with each other and have methods that change variables
 *
 */
trait Unit1 {
  /** The current Hp of the Unit
   */
  var Hp: Int
  /** The current stars of the unit
   */
  var stars: Int
  /**The max Hp that a player could have
   */
  protected val maxHp: Int
  /**The damage that a Unit can do to other Unit
   *
   */
  val Atk: Int
  /**The discount of damage that a Unit can have in defending step
   */
  val Def : Int
  /**The value needed to have a successful evading step
   */
  val Eva: Int
  /** A variable number that represents the mode combat of the player
   * 1 is defense and 2 is evade
   */
  protected var _ModeCombat: Int
  def ModeCombat:Int
  /** The variable that represents if a unit is in a panel or not
   */
  protected var _inPanel: Option[Panel]
  def attack(other: Unit1): Unit
  def defend(other: Player): Unit
  def defend(other: WildUnit): Unit
  def evade(other: WildUnit): Unit
  def evade(other: Player): Unit
  def changeStars(value: Int): Unit
  def changeHp(value: Int): Unit
  def inPanel: Option[Panel]
  def setPanel(panel:Panel): Unit
}

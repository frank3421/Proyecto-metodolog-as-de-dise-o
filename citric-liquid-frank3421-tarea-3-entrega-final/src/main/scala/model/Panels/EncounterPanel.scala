package cl.uchile.dcc.citric
package model.Panels

import model.Units._

import scala.util.Random
/** The class that represents a EncounterPanel of the game
 *
 * The class inherits the variables and methods of BasePanel and define the methods apply, equals and
 * generateWildUnit. The class have a variable called wildUnit that could contains a WildUnit or None-
 * At the starting of this class generateWildUnit() always be executed.
 *
 * @constructor Create a new EncounterPanel.
 *
 * @example
 * {{{
 *   val EncounterPanel=new EncounterPanel
 *   EncounterPanel.apply() //Do nothing
 *   println(s"The actual WildUnit of the panel is $EncounterPanel.wildUnit")
 *   EncounterPanel.generateWildUnit()
 *   println(s"The actual WildUnit of the panel is $EncounterPanel.wildUnit")
 * }}}
 */
class EncounterPanel extends BasePanel{
  /**The WildUnit that could contain the EncounterPanel
   *
   * This variable start being WildChicken by default and activating the method generateWildUnit
   * the variable has now one of the 3 possible objects WildUnit.
   */

  protected var _wildUnit:WildUnit=new WildChicken
  /**return the variable wildUnit
   */
  def wildUnit:WildUnit=_wildUnit
  /**Updates the wildUnit of encounterPanel .
   * @param newWildUnit The new WildUnit that will have the EncounterPanel.
   */
  def wildUnit_=(newWildUnit: WildUnit):Unit=_wildUnit=newWildUnit
  /** The method assigns a new WildUnit to the variable _wildUnit.
   *
   *  This method assigns randomly one of the WildUnits defined in the game
   *
   * @example
   * {{{
   *   val EncounterPanel=new EncounterPanel
   *   println(s"The actual WildUnit of the panel is $EncounterPanel.wildUnit")
   *   EncounterPanel.generateWildUnit()
   *   println(s"The actual WildUnit of the panel is $EncounterPanel.wildUnit")
   * }}}
   */
  def generateWildUnit (): Unit = {
    val number = Random.nextInt(3) + 1
    if (number == 1) {
      val enemy = new WildChicken
      enemy.inPanel = (Some(this))
      wildUnit = enemy
    }
    else if (number == 2) {
      val enemy = new WildRoboBall
      enemy.inPanel = (Some(this))
      wildUnit = enemy
    }
    else {
      val enemy = new WildSeaGull
      enemy.inPanel = (Some(this))
      wildUnit = enemy
    }

  }
  generateWildUnit()

  /** This method do nothing.
   *
   * @param player The player to whom the panel effects will be applied
   * @example
   * {{{
   *   val neutralPanel=new NeutralPanel
   *   neutralPanel.apply(new character(",",1,1,1,1))
   * }}}
   */
  def apply(player: Player): Unit = {
    player.attack(_wildUnit)
    if(wildUnit.Hp>0){
      wildUnit.attack(player)
    }
    else{
      generateWildUnit()
    }
  }
  /** Compares the EncounterPanel with another object to determine if they have the same class.
   *
   * @param other The object to be compared with.
   *
   * @example
   * {{{
   *   val EncounterPanel= new EncounterPanel
   *   println(s"this is true, $EncounterPanel.equals(new EncounterPanel)")
   * }}}
   *
   * @return `true` if this EncounterPanel have the same class with the object, `false` otherwise.
   */
  override def equals(other: Any): Boolean = other.getClass==this.getClass
}

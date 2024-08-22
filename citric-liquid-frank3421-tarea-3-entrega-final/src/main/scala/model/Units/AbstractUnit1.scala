package cl.uchile.dcc.citric
package model.Units

import cl.uchile.dcc.citric.model.Panels.Panel
import cl.uchile.dcc.citric.model.ResultsCombat.Results

import scala.util.Random
import model.Panels.HomePanel

/**This abstract class is used as a base template by players and WildUnits that are considered Units
 *
 * Implements the variables ad methods that both classes have in common.
 */
abstract class AbstractUnit1 extends Unit1{
  /**The variable that represents if a unit is in a panel or not
   */
  protected var _inPanel: Option[Panel] = None

  /**The variable that is randomly created that can be a number between 1 to 6
   */
  val randomNumberGenerator: Random = new Random()
  /** Give a random number between 1 to 6
   * @example
   * {{{
   *   val number=rollDice()
   *   println(number)
   * }}}
   * @return A number between 1 to 6
   */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /**The current Hp of the Unit
   */
  protected var _Hp = maxHp

  /**return the current panel that the unit is on
   */
  def inPanel: Option[Panel] = _inPanel

  /**Allows to update the panel that the unit is on
   * @param newInPanel the new value of inPanel
   */
  def inPanel_=(newInPanel: Option[Panel]): Unit = _inPanel = newInPanel

  /** Allows the player to change the panel they are on
   *
   * @param panel The new Panel where the player will be
   */
  def setPanel(panel:Panel):Unit={
    _inPanel=Some(panel)
  }
  /**Returns the current Hp of the Unit
   */
  def Hp: Int = _Hp

  /**Allows to update the Hp of a Unit
   *
   * @param newHp the new Hp value
   */
  def Hp_=(newHp: Int): Unit = _Hp = newHp

  /**the method adds the given amount to the Hp
   *
   * @param value is the value that will be added to Hp
   *
   * @example using a PlayerCharacter that inherits this method
   *{{{
   *   new player=new PlayerCharacter("n",1,1,1,1)
   *   println(s"currently hp of player,$player.Hp")
   *   player.changeHp(2)
   *   println(s"the currently player hp now is $player.Hp")
   *}}}
   *
   */
  def changeHp(value: Int): Unit = {
    Hp += value
  }
  /**The current stars of the unit
   */
  protected var _stars = 0

  /**Return the stars of the player
   */
  def stars: Int = _stars

  /**updates the stars of the player
   * @param newStars the new stars  value
   */
  def stars_=(newStars: Int): Unit = _stars = newStars
  /** add the value to the variable stars
   *
   * @param value The value that will be plus to the currently victoryStars of the player
   * @example
   * {{{
   *   println(s"The value of stars is $stars")
   *   changeStars(5)
   *   println(s"The new value of stars is $stars")
   * }}}
   */
  def changeStars(value: Int): Unit = {
    this.stars=stars+value
  }

  /**A variable number that represents the mode combat of the player
   *1 is defense and 2 is evade
   */
  protected var _ModeCombat = randomNumberGenerator.nextInt(2) + 1

  /**returns the mode combat of unit
   */
  def ModeCombat: Int = _ModeCombat

  /**updates the modecombat of a player
   * @param newModeCombat The new mode combat that will have this variable
   */
  def ModeCombat_=(newModeCombat: Int): Unit = _ModeCombat = newModeCombat

  /**A method that represents the damage given to other unit in evading mode combat
   *
   * @param other The attacker that could be player or wildUnit
   * @return the damage given to the unit in evading mode
   */
  protected def dmgEvade(other: Unit1): Int = {
    if (rollDice() + this.Eva > rollDice() + other.Atk) {
      return 0
    }
    other.Atk
  }

  /** A method that represents the damage given to other unit in defending mode combat
   *
   * @param other The attacker that could be player or wildUnit
   * @return the damage given to the unit in defending mode
   */
  protected def dmgDefense(other: Unit1): Int = 1.max(rollDice() + other.Atk - this.Def - rollDice())


}

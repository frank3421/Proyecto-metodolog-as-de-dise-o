package cl.uchile.dcc.citric
package model.Units

/** The class that represents the WildChicken of the game
 *
 * @constructor Creates a new WildChicken with their respective stats
 * @example
 * {{{
 *   val WilChicken=new WildChicken
 * }}}
 */
class WildChicken extends AbstractWild {
  /**The maxHp that this unit could have in the game
   */
  /**The damage points that this unit can do to other Unit
   */
  val Atk=(-1)
  /** The discount of damage that a Unit can have in defending step
   */
  val Def =(-1)
  /** The value needed to have a successful evading step
   */
  val Eva=(1)
  stars=3
}


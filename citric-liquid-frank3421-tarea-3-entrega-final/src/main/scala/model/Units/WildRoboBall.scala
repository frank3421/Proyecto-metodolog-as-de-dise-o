package cl.uchile.dcc.citric
package model.Units

/** The class that represents the WildRoboBall of the game
 *
 * @constructor Creates a new WildRoboball with their respective stats
 * @example
 * {{{
 *   val WildRoboball=new WildRoboball
 * }}}
 */
class WildRoboBall extends AbstractWild {
  /** The damage points that this unit can do to other Unit
   */
  val Atk = (-1)
  /** The discount of damage that a Unit can have in defending step
   */
  val Def = (1)
  /** The value needed to have a successful evading step
   */
  val Eva = (-1)
  stars=2
}
package cl.uchile.dcc.citric
package model.Units

/** The class that represents the WildSeaGull of the game
 *
 * @constructor Creates a new WildSeaGull with their respective stats
 * @example
 * {{{
 *   val WildSeaGull=new WildSeaGull
 * }}}
 */
class WildSeaGull extends AbstractWild {
  /** The damage points that this unit can do to other Unit
   */
  val Atk = (1)
  /** The discount of damage that a Unit can have in defending step
   */
  val Def = (-1)
  /** The value needed to have a successful evading step
   */
  val Eva = (-1)
  stars=2
}
package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the player has not more movements.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:PlayerHasNotMovements=>println("Player has not more movements")
 * }}}
 */
class PlayerHasNotMovements(message:String) extends Exception(message)  {

}

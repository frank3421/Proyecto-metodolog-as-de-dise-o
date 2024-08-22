package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the player that defended or evaded has not attacked yet and has hp>0.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:CombatNotFinished=>println("The player that defended has hp>0 and has to attack")
 * }}}
 */
class CombatNotFinished(message:String) extends Exception(message)

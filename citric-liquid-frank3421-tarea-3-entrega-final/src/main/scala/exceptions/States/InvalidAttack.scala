package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the player doesnt choose a right target to attack.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:InvalidAttack=>println("The player doesnt choose a right target")
 * }}}
 */
class InvalidAttack(message:String) extends Exception(message)

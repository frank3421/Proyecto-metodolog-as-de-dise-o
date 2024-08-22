package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the player has movements remaining.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:MovementsRemaining=>println("The character has movements remaining")
 * }}}
 */
class MovementsRemaining(message: String) extends Exception(message)

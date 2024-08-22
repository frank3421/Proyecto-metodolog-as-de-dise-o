package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the player choose a invalid direction.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:WrongDirection=>println("There are not such direction in this panel")
 * }}}
 */
class WrongDirection(message:String) extends Exception(message)

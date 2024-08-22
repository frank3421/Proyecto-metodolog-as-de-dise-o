package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the player is Ko.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:PlayerIsKo=>println("The player is ko")
 * }}}
 */
class PlayerIsKo(message:String) extends Exception(message)

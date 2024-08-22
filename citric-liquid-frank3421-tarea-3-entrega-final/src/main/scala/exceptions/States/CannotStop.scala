package cl.uchile.dcc.citric
package exceptions.States

/**The exceptions that is launched if the player cannot stop.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:CannotStop=>println("The player is in a HomePanel but is not their Home Panel and has movements")
 * }}}
 */
class CannotStop(message:String) extends Exception(message)

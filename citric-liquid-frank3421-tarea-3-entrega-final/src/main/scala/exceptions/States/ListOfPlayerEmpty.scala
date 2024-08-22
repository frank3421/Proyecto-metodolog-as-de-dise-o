package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the game has not players.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:ListOfPlayerEmpty=>println("The game cannot start without players")
 * }}}
 */
class ListOfPlayerEmpty(message:String) extends Exception(message)

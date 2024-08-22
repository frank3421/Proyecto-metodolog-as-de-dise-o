package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the player try to win but has not norma 6.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:NormaIsNot6=>println("The norma of the player is not 6 so the player can not win")
 * }}}
 */
class NormaIsNot6(message:String) extends Exception(message)

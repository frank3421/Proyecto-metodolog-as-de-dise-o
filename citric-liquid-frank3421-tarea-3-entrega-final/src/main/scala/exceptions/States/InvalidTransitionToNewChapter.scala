package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the the last turn of the chapter has not initiated.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:InvalidTransitionToNewChapter=>println("The turn of the last player it doesnt happen yet")
 * }}}
 */
class InvalidTransitionToNewChapter(message:String) extends Exception(message)

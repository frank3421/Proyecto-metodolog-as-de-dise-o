package cl.uchile.dcc.citric
package exceptions.States

/**The exceptions that is launched if the player doesnt want to attack.
 *
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:PlayerDoesntWantAttack=>println("The player doesnt want to attack other player")
 * }}}
 */
class PlayerDoesntWantAttack(message:String) extends Exception(message)

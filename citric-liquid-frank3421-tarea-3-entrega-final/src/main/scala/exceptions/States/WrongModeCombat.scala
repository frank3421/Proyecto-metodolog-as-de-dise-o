package cl.uchile.dcc.citric
package exceptions.States
/**The exceptions that is launched if the player has a wrong mode of combat.
 *
 *Happens when the game is in wait state and the transition is defend when the mode combat is evade or vice-versa
 *
 * @param message The message that will be printed
 *
 * @constructor Creates a new Exception with a message
 *
 * @example
 * {{{
 *   case e:WrongModeCombat=>println("The transition is invalid because the player choose defend")
 *   case e1:WrongModeCombat=>println("The transition is invalid because the player choose evade")
 * }}}
 */
class WrongModeCombat(message:String) extends Exception(message)

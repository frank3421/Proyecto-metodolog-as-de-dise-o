package cl.uchile.dcc.citric
package model.Panels

import model.Units.PlayerCharacter
import model.Units.Player

/** The class that represents a HomePanel of the game
 *
 * The class inherits the variables and methods of BasePanel and define the methods apply and equals.
 *
 * @constructor Create a new HomePanel with an owner defined that can be a Player type
 * @example
 * {{{
 *   val player1=new PlayerCharacter("m",1,1,1,1)
 *   val HomePanel=new HomePanel(player)
 *   HomePanel.apply(player1)
 *   val NeutralPanel=new NeutralPanel()
 *   println(s"its false that a NeutralPanel is equal HomePanel $HomePanel.equals(NeutralPanel)")
 * }}}
 * @param _owner The owner of the HomePanel
 */
class HomePanel(private val _owner:Player) extends BasePanel{
  /** This method simulate the effect of HomePanel in the game.
   *
   * The method not modify directly the parameters of player. Instead the method use methods of PlayerCharacter
   * or Norma to execute the effects using recoverHp, changeTurn() from PlayerCharacter and normaCheck() from norma
   *
   * @throws e1 If its not the turn of the Player
   * @throws Exception If there other error
   * @param player The player to whom the panel effects will be applied
   * @example
   * {{{
   *   val player1=new PlayerCharacter("m",1,1,1,1)
   *   val HomePanel=new HomePanel(player)
   *   HomePanel.apply(player1)
   * }}}
   */
  def apply(player: Player): Unit = {
    class e1 extends Exception()

    try {
      if(!player.turn) {
        throw new e1
      }
      player.recoverHp()
      player.changeTurn()
      player.normaClass.normaCheck()
    }
    catch{
        case e:e1 => println("Its not the turn of the player")
    }
  }

  /**Return a copy of the owner of the HomePanel
   */
  def owner:PlayerCharacter={
    val theOwner=_owner.copy()
    return theOwner
  }
  /** Compares the HomePanel with another object to determine if they have the same class.
   *
   * @param other The object to be compared with.
   * @example
   * {{{
   * val HomePanel= new HomePanel
   * println(s"this is true, $HomePanel.equals(new HomePanel)")
   * }}}
   * @return `true` if this HomePanel have the same class with the object, `false` otherwise.
   */
  override def equals(other: Any): Boolean = other.getClass==this.getClass

}

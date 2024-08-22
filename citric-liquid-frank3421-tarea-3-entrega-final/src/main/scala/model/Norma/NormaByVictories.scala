package cl.uchile.dcc.citric
package model.Norma

import model.Units.PlayerCharacter

/**This class represents the requisites to level up norma if the player choose to level up norma by victories
 * In this class the player need to have an amount of victories points to level up norma that change in each
 * level of norma
 *
 * @param player The player where the effects of normaCheck will be apply.
 * @example
 * {{{
 *   val player=new player("m",1,1,1,1)
 *   val norma=NormaByVictories(player)
 *   norma.normaCheck()
 * }}}
 *
 */
class NormaByVictories(player:PlayerCharacter) extends NormaInitially(player) {
  /** The method that allows to level up norma if the conditions are fulfished.
   *
   * @throws e2 If the conditions to activate norma are not fulfished
   * @example
   * {{{
   *   val player=new player("m",1,1,1,1)
   *   val norma=NormaByVictories(player)
   *   norma.normaCheck()
   * }}}
   */
  override def normaCheck(): Unit = {
    try {
      if (player.norma == 2 && player.victoryPoints >= 3) player.applyEffectsNormaCheck()
      else if (player.norma == 3 && player.victoryPoints >= 6) player.applyEffectsNormaCheck()
      else if (player.norma == 4 && player.victoryPoints >= 10) player.applyEffectsNormaCheck()
      else if (player.norma == 5 && player.victoryPoints >= 14) player.applyEffectsNormaCheck()
      throw new e2
    }
    catch {
      case e: e2 => println("The conditions to activate normaCheck are not met")
    }
  }

  /** This method makes a copy of this object
   *
   * @return the copy of the same object
   * @examples
   * {{{
   *   val player=new PlayerCharacter("n",1,1,1,1)
   *   val norma=normaByVictories(player)
   *   val copy=norma.copy()
   * }}}
   */
  override def copy(): Norma = {
    val copy = new NormaByVictories(player)
    copy
  }
}

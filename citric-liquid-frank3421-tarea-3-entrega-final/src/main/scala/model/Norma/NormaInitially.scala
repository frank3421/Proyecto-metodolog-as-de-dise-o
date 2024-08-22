package cl.uchile.dcc.citric
package model.Norma

import model.Units.PlayerCharacter

/**This class represents the first requisite to level up norma to level 1 to level 2
 * In this class the player need to have an amount of stars or victories to level up norma
 *
 * @param player The player where the effects of normaCheck will be apply.
 * @example
 * {{{
 *   val player=new player("m",1,1,1,1)
 *   val norma=NormaInitially(player)
 *   norma.normaCheck()
 * }}}
 *
 */
class NormaInitially(val player:PlayerCharacter) extends Norma {
  class e2 extends Exception
  /**The method that allows to level up norma if the conditions are fulfished.
   *
   * @throws e2 If the conditions to activate norma are not fulfished
   * @example
   * {{{
   *   val player=new player("m",1,1,1,1)
   *   val norma=NormaInitially(player)
   *   norma.normaCheck()
   * }}}
   */
  def normaCheck(): Unit = {
    try {
      if ((player.norma == 1 && player.stars >= 10) || (player.norma== 1 && player.victoryPoints >= 1)) player.applyEffectsNormaCheck()
      else {
        throw new e2
      }
    }
    catch{
        case e: e2 => println("The conditions to activate normaCheck are not met")
    }
  }

  /**This method makes a copy of this object
   *
   * @return the copy of the same object
   * @example
   * {{{
   *   val character=new PlayerCharacter("n",1,1,1,1)
   *   assert(character.norma==1)
   *   intercept[Throwable] {
   *     character.normaClass.normaCheck()
   *   }
   *   assert(character.norma==1)
   *   assert(character.norma==1)
   *   character.changeStars(100)
   *   character.normaClass.normaCheck()
   *   assert(character.norma==2)
   *   val copy=norma.copy()
   * }}}
   */
  def copy(): Norma={
    val copy=new NormaInitially(player)
    copy
  }
}

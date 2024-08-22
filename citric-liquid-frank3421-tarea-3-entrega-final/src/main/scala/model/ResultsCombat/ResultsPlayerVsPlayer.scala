package cl.uchile.dcc.citric
package model.ResultsCombat
import cl.uchile.dcc.citric.model.Units._
/**Represents the results of a defeat of player versus other player.
 *
 * This class calculates and applies the results of a PvP match, including the transfer of stars and the adjustment of victory points.
 *
 * @param player The player who have 0 health points
 * @param enemy The opposing player that wins.
 * @example
 * {{{
 *   character = new PlayerCharacter("1",1,1,1,1)
 *   character.stars(77)
 *   character1 = new PlayerCharacter("2",1,1,1,1)
 *   ResultsPlayerVsPlayer=new ResultsPlayerVsPlayer(character,character1)
 *   assert(character.stars==77)
 *   assert(character1.stars==0)
 *   assert(character1.victoryPoints==0)
 *   ResultsPlayerVsPlayer.ApplyResults()
 *   assert(character.stars==39)
 *   assert(character1.stars==38)
 *   assert(character1.victoryPoints==2)
 * }}}
 */
class ResultsPlayerVsPlayer(player:PlayerCharacter,enemy:Player) extends Results{
  /**Calculates and applies the results of the battle.
   *
   * This method calculates the outcome of the match, including the transfer of stars from one player to another and the adjustment of victory points.
   * * {{{
   *   val character = new PlayerCharacter("1",1,1,1,1)
   *   character.stars(77)
   *   val character1 = new PlayerCharacter("2",1,1,1,1)
   *   val ResultsPlayerVsPlayer=new ResultsPlayerVsPlayer(character,character1)
   *   assert(character.stars==77)
   *   assert(character1.stars==0)
   *   assert(character1.victoryPoints==0)
   *   ResultsPlayerVsPlayer.ApplyResults()
   *   assert(character.stars==39)
   *   assert(character1.stars==38)
   *   assert(character1.victoryPoints==2)
   * }}}
   */
  def ApplyResults(): Unit={
    val result=player.stars/2
    enemy.changeStars(result)
    player.changeStars(-result)
    enemy.changeVictoryPoints(2)
  }
}

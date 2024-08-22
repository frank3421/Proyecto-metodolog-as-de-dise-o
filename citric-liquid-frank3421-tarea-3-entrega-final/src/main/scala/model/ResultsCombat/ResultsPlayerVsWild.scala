package cl.uchile.dcc.citric
package model.ResultsCombat
import cl.uchile.dcc.citric.model.Units._
/**Represents the results of the defeat of a player versus wild unit.
 *
 * This class calculates and applies the results of a defeated encounter between a player and a wild unit, including the transfer of stars.
 *
 * @param player The player who have their health points in 0.
 * @param enemy The wild unit that the player wins against player.
 * @example
 * {{{
 *   val character=new PlayerCharacter("1",1,1,1,1)
 *   val WildSeaGull=new WildSeaGull
 *   val ResultsPlayerVsWild=new ResultsPlayerVsWild(character,WildSeaGull)
 *   assert(character.stars==77)
 *   assert(WildSeaGull.stars==2)
 *   ResultsPlayerVsWild.ApplyResults()
 *   assert(character.stars==39)
 *   assert(WildSeaGull.stars==40)
 * }}}
 */
class ResultsPlayerVsWild(player:PlayerCharacter,enemy:WildUnit) extends Results {
  /**Calculates and applies the results of the battle.
   *@example
   * {{{
   *   val character=new PlayerCharacter("1",1,1,1,1)
   *   val WildSeaGull=new WildSeaGull
   *   val ResultsPlayerVsWild=new ResultsPlayerVsWild(character,WildSeaGull)
   *   assert(character.stars==77)
   *   assert(WildSeaGull.stars==2)
   *   ResultsPlayerVsWild.ApplyResults()
   *   assert(character.stars==39)
   *   assert(WildSeaGull.stars==40)
   * }}}
   * This method calculates the outcome of the combat, including the transfer of stars from the player to the wild unit.
   */
  def ApplyResults(): Unit = {
    val result=player.stars/2
    enemy.changeStars(result)
    player.changeStars(-result)
  }
}

package cl.uchile.dcc.citric
package model.ResultsCombat
import cl.uchile.dcc.citric.model.Units._
/**
 * Represents the results of defeat of a wild unit against a player.
 *
 * This class calculates and applies the results of a defeat combat between a wild unit and a player, including the transfer of stars and the adjustment of victory points.
 *
 * @param wild The wild unit that is defeated.
 * @param player The player who win the battle.
 * @example
 * {{{
 *   val character=new PlayerCharacter("1",1,1,1,1)
 *   val WildSeaGull=new WildSeaGull
 *   val ResultsWild=new ResultsWild(WildSeaGull,character)
 *   assert(character.stars==77)
 *   assert(character.victoryPoints ==0)
 *   assert(WildSeaGull.stars==2)
 *   ResultsWild.ApplyResults()
 *   assert(character.stars==79)
 *   assert(character.victoryPoints==1)
 * }}}
 */
class ResultsWild(Wild:WildUnit,player:Player) extends Results{
  /**Calculates and applies the results of the combat.
   *
   * This method calculates the outcome of the encounter, including the transfer of stars from the wild unit to the player and the adjustment of victory points.
   * @example
   * {{{
   *   val character=new PlayerCharacter("1",1,1,1,1)
   *   val WildSeaGull=new WildSeaGull
   *   val ResultsWild=new ResultsWild(WildSeaGull,character)
   *   assert(character.stars==77)
   *   assert(character.victoryPoints ==0)
   *   assert(WildSeaGull.stars==2)
   *   ResultsWild.ApplyResults()
   *   assert(character.stars==79)
   *   assert(character.victoryPoints==1)
   * }}}
   */
  def ApplyResults(): Unit = {
    val result=Wild.stars
    player.changeStars(result)
    player.changeVictoryPoints(1)
  }
}

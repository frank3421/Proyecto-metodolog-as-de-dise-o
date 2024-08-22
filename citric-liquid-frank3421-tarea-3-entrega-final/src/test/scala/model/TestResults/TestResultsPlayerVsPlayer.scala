package cl.uchile.dcc.citric
package model.TestResults

import model.ResultsCombat.ResultsPlayerVsPlayer
import model.Units.PlayerCharacter

import munit.FunSuite
class TestResultsPlayerVsPlayer extends FunSuite {
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val maxHp = 1
  private val maxHp1 = 1000
  private val attack = 1
  private val attack1 = 1000
  private val defense = 1
  private val defense1 = 1
  private val evasion = 1
  private val evasion1 = 10000
  private var character: PlayerCharacter = _ // <- x = _ is the same as x = null
  private var character1: PlayerCharacter = _
  private var ResultsPlayerVsPlayer:ResultsPlayerVsPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name1,
      maxHp,
      attack,
      defense,
      evasion
    )
    character.stars=77
    character1 = new PlayerCharacter(
      name2,
      maxHp1,
      attack1,
      defense1,
      evasion1
    )
    ResultsPlayerVsPlayer=new ResultsPlayerVsPlayer(character,character1)
  }
  test("If the class ResultsPlayerVsPlayer is activated, then half stars of a character are transferred to the other character and the other character increases their victory points 2"){
    assert(character.stars==77)
    assert(character1.stars==0)
    assert(character1.victoryPoints==0)
    ResultsPlayerVsPlayer.ApplyResults()
    assert(character.stars==39)
    assert(character1.stars==38)
    assert(character1.victoryPoints==2)
  }
}

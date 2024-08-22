package cl.uchile.dcc.citric
package model.TestResults

import model.ResultsCombat.ResultsWild
import model.Units.{PlayerCharacter, WildSeaGull}

import munit.FunSuite
class TestResultsWild extends FunSuite {
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
  private var ResultsWild:ResultsWild = _
  private var WildSeaGull:WildSeaGull=_

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
    WildSeaGull=new WildSeaGull
    ResultsWild=new ResultsWild(WildSeaGull,character)
  }
  test("If the class ResultsPlayerVsWild is activated, then half stars of a character are transferred to the wildUnit"){
    assert(character.stars==77)
    assert(character.victoryPoints ==0)
    assert(WildSeaGull.stars==2)
    ResultsWild.ApplyResults()
    assert(character.stars==79)
    assert(character.victoryPoints==1)
  }
}

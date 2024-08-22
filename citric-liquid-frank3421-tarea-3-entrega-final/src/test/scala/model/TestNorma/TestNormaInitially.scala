package cl.uchile.dcc.citric
package model.TestNorma

import model.Norma.Norma
import model.Units.PlayerCharacter

import scala.util.Random
class TestNormaInitially extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator = new Random(11)
  private var character: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit={
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )

  }
  test ("The activation of effects of norma check are not possible because player doesnt fulfilled the conditions" ){
    assert(character.norma==1)
    intercept[Throwable] {
      character.normaClass.normaCheck()
    }
    assert(character.norma==1)
  }
  test("If the conditions to activate norma initially are met by stars, then the norma of character level up by one"){
    assert(character.norma==1)
    character.changeStars(100)
    character.normaClass.normaCheck()
    assert(character.norma==2)
  }
  test("If the conditions to activate norma initially are met by victories, then the norma of character level up by one") {
    assert(character.norma == 1)
    character.changeVictoryPoints(100)
    character.normaClass.normaCheck()
    assert(character.norma == 2)
  }
  test("Its possible norma can be copied with a method"){
    val copy=character.normaClass.copy()
    assert(copy.isInstanceOf[Norma])
    assert(copy!=character.normaClass)
  }
}

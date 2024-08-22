package cl.uchile.dcc.citric
package model.TestNorma

import model.Norma.NormaByStars
import model.Units.PlayerCharacter

import scala.util.Random

class TestNormaByStars  extends munit.FunSuite  {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator = new Random(11)
  private var character: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
    character.normaClass=new NormaByStars(character)
  }
  test("If player has norma 2 but doesnt fulfilled the conditions of stars, then normaCheck will not activate") {
    character.norma=2
    assert(character.norma == 2)
    intercept[Throwable] {
      character.normaClass.normaCheck()
    }
    assert(character.norma == 2)
  }
  test("If player has norma 3 but doesnt fulfilled the conditions of stars, then normaCheck will not activate") {
    character.norma=3
    assert(character.norma == 3)
    intercept[Throwable] {
      character.normaClass.normaCheck()
    }
    assert(character.norma == 3)
  }
  test("If player has norma 4 but doesnt fulfilled the conditions of stars, then normaCheck will not activate") {
    character.norma=4
    assert(character.norma == 4)
    intercept[Throwable] {
      character.normaClass.normaCheck()
    }
    assert(character.norma == 4)
  }
  test("If player has norma 5 but doesnt satisfied the conditions of stars, then normaCheck will not activate") {
    character.norma=5
    assert(character.norma == 5)
    intercept[Throwable] {
      character.normaClass.normaCheck()
    }
    assert(character.norma == 5)
  }
  test("If player has norma 2 and has the stars needed to activate normaCheck in that norma, then the effects activate"){
    character.norma=2
    assert(character.norma==2)
    assert(character.stars==0)
    character.changeStars(1000)
    assert(character.stars==1000)
    character.normaClass.normaCheck()
    assert(character.norma==3)
  }
  test("If player has norma 3 and has the stars needed to activate normaCheck in that norma, then the effects activate") {
    character.norma = 3
    assert(character.norma == 3)
    assert(character.stars == 0)
    character.changeStars(1000)
    assert(character.stars == 1000)
    character.normaClass.normaCheck()
    assert(character.norma == 4)
  }
  test("If player has norma 4 and has the stars needed to activate normaCheck in that norma, then the effects activate") {
    character.norma = 4
    assert(character.norma == 4)
    assert(character.stars == 0)
    character.changeStars(1000)
    assert(character.stars == 1000)
    character.normaClass.normaCheck()
    assert(character.norma == 5)
  }
  test("If player has norma 5 and has the stars needed to activate normaCheck in that norma, then the effects activate") {
    character.norma = 5
    assert(character.norma == 5)
    assert(character.stars == 0)
    character.changeStars(1000)
    assert(character.stars == 1000)
    character.normaClass.normaCheck()
    assert(character.norma == 6)
  }

}

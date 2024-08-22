package cl.uchile.dcc.citric
package model.TestUnits

import model.Panels.{NeutralPanel, Panel}
import model.Units.{PlayerCharacter, WildSeaGull}

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val maxHp = 1
  private val maxHp1=1000
  private val attack = 1
  private val attack1=1000
  private val defense = 1
  private val defense1 =1
  private val evasion = 1
  private val evasion1=10000
  private val randomNumberGenerator = new Random(11)
  /* Add any other constants you need here... */

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  private var character1:PlayerCharacter = _
  private var WildSeaGull:WildSeaGull = _
  /* Add any other variables you need here... */

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name1,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
    character1 = new PlayerCharacter(
      name2,
      maxHp1,
      attack1,
      defense1,
      evasion1,
      randomNumberGenerator
    )
    WildSeaGull=new WildSeaGull
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name1)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.Atk, attack)
    assertEquals(character.Def, defense)
    assertEquals(character.Eva, evasion)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  // 2. Set a seed and test the result is always the same.
  // A seed sets a fixed succession of random numbers, so you can know that the next numbers
  // are always the same for the same seed.
  /**test("A character should be able to roll a dice with a fixed seed") {
    val other =
      new PlayerCharacter(name, maxHp, attack, defense, evasion, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(character.rollDice(), other.rollDice())
    }
  }*/
  test("A character start with norma equal 1, stars equal 0,victoryPoints equal 0, turn equal false,ko equal false" +
    "and Hp equal MaxHp") {
    assertEquals(character.norma,1)
    assertEquals(character.stars,0)
    assertEquals(character.victoryPoints,0)
    assertEquals(character.turn,false)
    assertEquals(character.ko,false)
    assertEquals(character.Hp,maxHp)
  }
  test("its possible to plus and minus x stars of a character"){
    var x=10
    character.changeStars(x)
    assertEquals(character.stars,10)
    character.changeStars(-x)
    assertEquals(character.stars,0)
  }
  test("its possible to plus and minus x stars of a character"){
    var x = 10
    character.changeVictoryPoints(x)
    assertEquals(character.victoryPoints, 10)
    character.changeVictoryPoints(-x)
    assertEquals(character.victoryPoints, 0)
  }
  test("its possible to change the status of ko of a character"){
    assertEquals(character.ko,false)
    character.changeKo()
    assertEquals(character.ko,true)
  }
  test("its possible to change the status of turn of a character") {
    assertEquals(character.turn, false)
    character.changeTurn()
    assertEquals(character.turn, true)
  }
  test("its possible to change true to false the ko and false to true"){
    assert(!character.ko)
    character.changeKo()
    assert(character.ko)
    character.changeKo()
    assert(!character.ko)
  }
  test("Its not possible to the character attack against a Unit if character is in ko state"){
    assert(!character.ko)
    character.changeKo()
    intercept[Throwable] {
      character.attack(character1)
    }
  }
  test("Its possible to the character attack other unit if the character is not in ko state") {
    assert(!character.ko)
    character.attack(character1)
  }
  test("If a character is attacked and defeated by other character, then the values of both characters change according of rules of game"){
    character.changeStars(50)
    character.defend(character1)
    assert(character.stars==25)
    assert(character1.stars==25)
    assert(character1.victoryPoints==2)
    assert(character.Hp==0)
    assert(character.ko)
  }
  test("If a characters is attacked by other Player but the characters is ko, then nothing happens"){
    character.changeKo()
    character.changeStars(50)
    assert(character.ko)
    character.defend(character1)
    assert(character.stars != 25)
    assert(character1.stars != 25)
    assert(character1.victoryPoints != 2)
    assert(character.Hp != 0)
  }
  test("its possible to the player defends against a wildUnit if the player is not in ko state"){
    assert(!character.ko)
    character.defend(WildSeaGull)
  }
  test("its not possible to the player defends against a wildUnit if the player is in ko state"){
    character.changeKo()
    assert(character.ko)
    intercept[Throwable] {
      character.defend(WildSeaGull)
    }
  }
  test("Its possible to the character recover 1 of health points") {
    assert(character.Hp == 1)
    character.recoverHp()
    assert(character.Hp == 2)
  }
  test("its possible to the character apply the effects of norma check"){
    assert(character.norma==1)
    character.applyEffectsNormaCheck()
    assert(character.norma==2)
  }
  test("its possible to the character to evade against other player if character is not in ko state"){
    assert(!character.ko)
    character.evade(character1)
  }
  test("Its not possible to the character evade against other player if character is not in ko state"){
    assert(!character.ko)
    character.changeKo()
    assert(character.ko)
    intercept[Throwable] {
      character.evade(character1)
    }
  }
  test("Its possible to the character evade against a wildUnit if character is not in ko state"){
    assert(!character.ko)
    character.evade(WildSeaGull)
  }
  test("its not possible to the character evade against other wildUnit character is in ko state"){
    assert(!character.ko)
    character.changeKo()
    assert(character.ko)
    intercept[Throwable] {
      character.evade(WildSeaGull)
    }
  }
  test("Its possible to create a copy of the character using the method copy"){
    assert(!character.eq(character.copy()))
  }
  test("Its possible to know if the characters is in a panel using a getter"){
    val Panel=character.inPanel
    assert(Panel.isInstanceOf[Option[Panel]])
  }
  test("It is possible to change the panel the players are on"){
    assert(character.inPanel==None)
    val NeutralPanel=new NeutralPanel
    character.inPanel=Some(NeutralPanel)
    assert(character.inPanel==Some(NeutralPanel))
  }
  test("Player's life points may change"){
    assert(character.Hp==1)
    character.changeHp(1)
    assert(character.Hp==2)
  }
  test("Its possible to know the modeCombat of the Unit"){
    val number=character.ModeCombat
    assert(number.isInstanceOf[Int])
  }
  test("Its possible to change the ModeCombat of the Unit"){
    val number=character.ModeCombat
    character.ModeCombat=3
    assert(number!=character.ModeCombat)
  }
  test("Its possible to compare if an object has the same class of PlayerCharacter"){
    assert(character.equals(character1))
  }

}


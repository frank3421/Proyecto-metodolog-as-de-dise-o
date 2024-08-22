package cl.uchile.dcc.citric
package model.TestUnits

import model.Units.{PlayerCharacter, WildChicken, WildSeaGull}

class TestWildChicken extends munit.FunSuite {
  private var WildChicken:WildChicken = _
  private var WildSeaGull:WildSeaGull=_
  private var PlayerCharacter:PlayerCharacter=_

  override def beforeEach(context: BeforeEach): Unit = {
    WildChicken=new WildChicken
    WildSeaGull=new WildSeaGull
    PlayerCharacter=new PlayerCharacter(",",1000,1000,1000,1000)
  }
  test("The WildChickens has initially Hp=3,Atk=-1,Def=-1,Eva=1, stars=3"){
    assert(WildChicken.Hp==3)
    assert(WildChicken.Atk==(-1))
    assert(WildChicken.Def==(-1))
    assert(WildChicken.Eva==(1))
    assert(WildChicken.stars==3)
  }
  test("Its not possible that a wildChicken defends against other WildUnit"){
    intercept[Throwable] {
      WildChicken.defend(WildSeaGull)
    }
  }
  test("Its not possible that a wildChicken evades against other WildUnit"){
    intercept[Throwable] {
      WildChicken.evade(WildSeaGull)
    }
  }
  test("Its possible that a wild chicken die defending against a player and the stars and victories of the player increase"){
    assert(PlayerCharacter.stars==0)
    WildChicken.defend(PlayerCharacter)
    assert(PlayerCharacter.stars==3)
    assert(PlayerCharacter.victoryPoints==1)
  }
  test("Its possible that a wildChicken die evading against a player and the stars and victories of the player increase"){
    assert(PlayerCharacter.stars == 0)
    WildChicken.evade(PlayerCharacter)
    assert(PlayerCharacter.stars == 3)
    assert(PlayerCharacter.victoryPoints == 1)
  }
  test("Its possible that a wildChicken attack against a player"){
    assert(PlayerCharacter.stars==0)
    WildChicken.attack(PlayerCharacter)
    assert(PlayerCharacter.stars==0)
  }
  test("A wild chicken can compare with other objects type with the method equals"){
    assert(!WildChicken.equals(PlayerCharacter))
  }

}
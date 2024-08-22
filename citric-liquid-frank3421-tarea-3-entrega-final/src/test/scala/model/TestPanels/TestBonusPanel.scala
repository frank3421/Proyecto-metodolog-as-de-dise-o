package cl.uchile.dcc.citric
package model.TestPanels

import model.Panels.{BonusPanel, NeutralPanel}
import model.Units.PlayerCharacter

import munit.FunSuite

import scala.util.Random

class TestBonusPanel extends FunSuite {
  var panel1: BonusPanel = _
  var panel2: NeutralPanel = _

  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator = new Random(11)
  private var character1: PlayerCharacter = _

  override def beforeEach(context:BeforeEach): Unit = {
    character1= new PlayerCharacter(name,maxHp,attack,defense, evasion, randomNumberGenerator)
    panel1 = new BonusPanel
    panel2 = new NeutralPanel
  }
  test("Bonus Panel can use the method 'apply' the change stars of a character "){
    assert(character1.stars==0)
    panel1.apply(character1)
    assert(character1.stars!=0)
  }
  test("Bonus Panel have the method equals that allows to compare with other object if the other object has the same class of Bonus Panel"){
    assert(!panel1.equals(panel2))
  }
}

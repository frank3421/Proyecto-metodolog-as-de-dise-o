package cl.uchile.dcc.citric
package model.TestPanels

import model.Panels.{DropPanel, NeutralPanel}
import model.Units.PlayerCharacter

import munit.FunSuite

import scala.util.Random

class TestDropPanel extends FunSuite {
  var panel1: DropPanel = _
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
    panel1 = new DropPanel
    panel2 = new NeutralPanel
  }
  test("Drop Panel can use the method 'apply' to change stars of a character "){
    assert(character1.stars==0)
    character1.changeStars(50)
    assert(character1.stars!=0)
    panel1.apply(character1)
    assert(character1.stars!=50)
  }
  test("Drop Panel have the method equals that allows to compare with other object if the other object has the same class of Drop Panel"){
    assert(!panel1.equals(panel2))
  }
}

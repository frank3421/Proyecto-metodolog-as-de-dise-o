package cl.uchile.dcc.citric
package model.TestPanels

import model.Panels.{EncounterPanel, NeutralPanel}
import model.Units.{PlayerCharacter, WildUnit}

import munit.FunSuite

import scala.util.Random

class TestEncounterPanel extends FunSuite {
  var panel1: EncounterPanel = _
  var panel2: NeutralPanel = _

  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator = new Random(11)
  private var character1: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    character1 = new PlayerCharacter(name, maxHp, attack, defense, evasion, randomNumberGenerator)
    panel1 = new EncounterPanel
    panel2 = new NeutralPanel
  }

  test("Encounter Panel can use the method 'apply' but nothing happens") {
    val copypanel1 = panel1
    val copyCharacter1 = character1
    panel1.apply(character1)
    assertEquals(copypanel1, panel1)
    assertEquals(copyCharacter1, character1)
  }
  test("At the creation of the encounter panel there are a random wildUnit") {
    assert(panel1.wildUnit.isInstanceOf[WildUnit])
  }
  test("There are a method that can be used to generate a random wildUnit") {
    val initialWild = panel1.wildUnit
    panel1.generateWildUnit()
    assert(initialWild != panel1.wildUnit)
  }
  test("Encounter Panel has the method equals that allows to compare with other object if the other object has the same class of encounter Panel") {
    assert(!panel1.equals(panel2))
  }
}
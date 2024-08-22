package cl.uchile.dcc.citric
package model.TestPanels

import model.Panels.NeutralPanel
import model.Units.PlayerCharacter

import munit.FunSuite

import scala.util.Random

class TestNeutralPanel extends FunSuite {
  var panel1: NeutralPanel = _
  var panel2: NeutralPanel = _
  var panel3: NeutralPanel = _

  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator = new Random(11)
  private var character1: PlayerCharacter = _

  override def beforeEach(context:BeforeEach): Unit = {
    character1= new PlayerCharacter(name,maxHp,attack,defense, evasion, randomNumberGenerator)
    panel1 = new NeutralPanel()
    panel2 = new NeutralPanel()
    panel3 = new NeutralPanel()
    panel3.addNextPanel(panel1)
    panel2.characters+=character1
  }
  test("Each neutral panel initially start with 0 players"){
    assertEquals(panel1.characters.isEmpty,true)
  }
  test ("Each neutral panel start with 0 next panels"){
    assertEquals(panel1.nextPanels.isEmpty,true)
  }
  test("Each panel has the capability to add a new character"){
    assert(panel1.characters.isEmpty)
    panel1.addCharacter(character1)
    assert(panel1.characters.contains(character1))
    assertEquals(character1.inPanel,Some(panel1))
  }
  test ( "Each panel has the capability to remove a character of the panel"){
    assert(panel2.characters.contains(character1))
    panel2.removeCharacter(character1)
    assert(panel2.characters.isEmpty)
    assert(character1.inPanel==None)
  }
  test("If a Panel already has a character, then the character its not introduced"){
    val copy=panel2.characters
    panel2.addCharacter(character1)
    assertEquals(copy,panel2.characters)
  }
  test ("Each panel has the capability to add a nextPanel"){
    assert(panel1.nextPanels.isEmpty)
    panel1.addNextPanel(panel2)
    assert(panel1.nextPanels.contains(panel2))
  }
  test("Each panel has the capability to remove a nextPanel form the list"){
    assert(panel3.nextPanels.nonEmpty)
    assert(panel3.nextPanels.contains(panel1))
    panel3.removeNextPanel(panel1)
    assert(!panel3.nextPanels.contains(panel1))
  }
  test("Each NeutralPanel has the method equals to identify if an object has the same type of class"){
    assert(panel1.equals(panel2))
  }
  test("When a NeutralPanel activates the method apply nothing happens") {
    val copypanel1 = panel1
    val copyCharacter1 = character1
    panel1.apply(character1)
    assertEquals(copypanel1, panel1)
    assertEquals(copyCharacter1, character1)
  }



}

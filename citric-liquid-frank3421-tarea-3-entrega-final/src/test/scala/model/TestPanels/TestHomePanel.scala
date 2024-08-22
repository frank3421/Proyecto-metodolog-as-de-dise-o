package cl.uchile.dcc.citric
package model.TestPanels

import model.Panels.{HomePanel, NeutralPanel}
import model.Units.PlayerCharacter

import munit.FunSuite

import scala.util.Random

class TestHomePanel extends FunSuite {
  var panel1: HomePanel = _
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
    panel1 = new HomePanel(character1)
    panel2 = new NeutralPanel
  }
  test("Home Panel can use the method 'apply' to change stars of a character if the turn of the player is true "){
    assert(!character1.turn)
    character1.changeTurn()
    panel1.apply(character1)
  }
  test("if it is not the character's turn, then HomePanel cannot applies the effect of method apply to that character"){
    assert(!character1.turn)
    intercept[Throwable]{
      panel1.apply(character1)
    }
  }
  test("Home Panel have the method equals that allows to compare with other object if the other object has the same class of Home Panel"){
    assert(!panel1.equals(panel2))
  }
  test("Its possible to know the owner with a getter"){
    val player:PlayerCharacter=panel1.owner
    assert(player.isInstanceOf[PlayerCharacter])
  }
  test("Its possible to know the owner of the homePanel using a getter"){
    assert(panel1.owner.isInstanceOf[PlayerCharacter])
  }
}

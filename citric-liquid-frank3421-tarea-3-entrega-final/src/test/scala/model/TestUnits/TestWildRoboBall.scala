package cl.uchile.dcc.citric
package model.TestUnits

import model.Units.WildRoboBall

import munit.FunSuite

class TestWildRoboBall extends FunSuite {
  private var WildRoboBall:WildRoboBall = _

  override def beforeEach(context: BeforeEach): Unit = {
    WildRoboBall=new WildRoboBall
  }
  test("The WildChickens has Hp=3,Atk=-1,Def=-1,Eva=1, stars=3"){
    assert(WildRoboBall.Hp==3)
    assert(WildRoboBall.Atk==(-1))
    assert(WildRoboBall.Def==(1))
    assert(WildRoboBall.Eva==(-1))
    assert(WildRoboBall.stars==2)
  }

}


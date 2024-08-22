package cl.uchile.dcc.citric
package model.TestUnits

import model.Units.WildSeaGull

import munit.FunSuite

class TestWildSeaGull extends FunSuite {
  private var WildSeaGull:WildSeaGull = _

  override def beforeEach(context: BeforeEach): Unit = {
    WildSeaGull=new WildSeaGull
  }
  test("The WildChickens has Hp=3,Atk=-1,Def=-1,Eva=1, stars=3"){
    assert(WildSeaGull.Hp==3)
    assert(WildSeaGull.Atk==(1))
    assert(WildSeaGull.Def==(-1))
    assert(WildSeaGull.Eva==(-1))
    assert(WildSeaGull.stars==2)
  }

}

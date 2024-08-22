package cl.uchile.dcc.citric
package model.Units
import cl.uchile.dcc.citric.model.ResultsCombat.{Results,ResultsWild}

/**This abstract class is used to apply the methods that WildUnits have in common
 * In this case, attack, defend and evade are methods that can be implemented in the same way among wildunits
 */
abstract class AbstractWild extends AbstractUnit1 with WildUnit{
  /** This method allow to a PlayerCharacter to attack other Unit
   *
   * The method attack use double dispatch and depending of the type of other the effects of the attack could
   * variate.  If the attacker is ko then the attack will not
   * consummate.   This method only call other function.
   *
   * @param other Other is an Unit that will receive the attack if the player can attack
   * @example
   * {{{
   *   val WildUnit=new WildUnit
   *   val Unit: Unit1=new player("no",1,1,1,1)
   *   WildUnit.attack(Unit)
   * }}}
   *
   */
  val maxHp = 3
  Hp = maxHp

  /** This method allow to a WildUnit to attack other Unit
   *
   * The method attack use double dispatch and depending of the type of other the effects of the attack could
   * variate.  This method only call other function. The defend mode of the other unit is decided randomly.
   *
   * @param other Other is an Unit that will receive the attack if the player can attack
   * @throws e1 If the player is already ko then cannot do the attack
   * @example
   * {{{
   *   val WildUnit=new WildChicken
   *   val Unit: Unit1=new player("no",1,1,1,1)
   *   WildUnit.attack(Unit)
   * }}}
   *
   */
  def attack(other: Unit1): Unit = {
    val election = other.ModeCombat
    if (election == 1) {
      other.defend(this)
    }
    else if(election==2) {
      other.evade(this)
    }
  }
  /** This method simulate the effects of a WildUnit in defending mode that is attacked by a Player
   * @param other The player that is attacking
   * @example using a WildChicken that inherits this method
   * {{{
   *   new WildUnit=new WildChicken
   *   new player1:Player=PlayerCharacter("n1",1,1,1,1)
   *   WildUnit.defend(player1)
   * }}}
   */
  def defend(other: Player): Unit = {
    this.Hp-=this.dmgDefense(other)
    if (this.Hp <= 0) {
      new ResultsWild(this,other).ApplyResults()

      /** this.inPanel.asInstanceOf[EncounterPanel].generateWildUnit()
       * its not a good form to resolve te problem using asInstanceOf so its commented and not implemented */
    }
  }

  /**Ths method represents what happened if a wildUnit defends against other WildUnit.  In this case the
   * method print a message "its not possible in the game that a WildUnit fight against other WildUnit"
   *
   * @param other The WildUnit that is attacking
   *
   * @example using a WildChicken that inherits this method
   * {{{
   *   val wildunit1=new WildChicken
   *   val wildunit2=new WildChicken
   *   println("wildunit1.defend(wildunit2)")
   * }}}
   */
  def defend(other: WildUnit): Unit = {
    try{
      throw new Throwable()
    }
    catch{
      case e:Throwable=>"its not possible in the game that a WildUnit fight against other WildUnit"
    }
  }
  /** This method simulate the effects of a WildUnit in evading mode that is attacked by a Player
   *
   * @param other The player that is attacking
   * @example using a WildChicken that inherits this method
   * {{{
   *   new WildUnit=new WildChicken
   *   new player1:Player=PlayerCharacter("n1",1,1,1,1)
   *   WildUnit.evade(player1)
   * }}}
   */
  def evade(other: Player): Unit = {
    this.Hp-=this.dmgEvade(other)
    if (this.Hp <= 0) {
      new ResultsWild(this,other).ApplyResults()
    }

  }

  /** Ths method represents what happened if a wildUnit evades against other WildUnit.  In this case the
   * method print a message "its not possible in the game that a WildUnit fight against other WildUnit"
   *
   * @param other The WildUnit that is attacking
   * @example using a WildChicken that inherits this method
   * {{{
   *   val wildunit1=new WildChicken
   *   val wildunit2=new WildChicken
   *   println("wildunit1.evade(wildunit2)")
   * }}}
   */
  def evade(other: WildUnit): Unit = {
    try {
      throw new Throwable()
    }
    catch {
      case e: Throwable => "its not possible in the game that a WildUnit fight against other WildUnit"
    }
  }

  /**Compares this object with another to determine if they are of the same type.
   * @param other The object to compare with.
   * @return @return `true` if this object is of the same type as the `other` object, `false` otherwise.
   */
  override def equals(other:Any): Boolean=other.getClass==this.getClass
}

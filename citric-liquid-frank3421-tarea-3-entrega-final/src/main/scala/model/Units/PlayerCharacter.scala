package cl.uchile.dcc.citric
package model.Units

import model._
import cl.uchile.dcc.citric.model.ResultsCombat.{Results,ResultsPlayerVsPlayer,ResultsPlayerVsWild}
import cl.uchile.dcc.citric.model.Norma.{Norma, NormaInitially}

import scala.util.Random
import model.Controller._
import model.Panels.HomePanel
/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
 * Also players has a turn and can be ko or not and a player can be in a panel or not at the beginning of the
 * game.   The player inherits other faculties because the class extends of abstractUnit1 so Player has
 * the variables and methods that are described in the documentation of that abstract class.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
 *
 * - Have the capability to attack other Players or WildUnits
 *
 * - Increase their number of VictoryPoints
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param Atk The player's capability to deal damage to opponents.
  * @param Def The player's capability to resist or mitigate damage from opponents.
  * @param Eva The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/~frank3421~/ ~Franco Navarro B.~]]
  */

class PlayerCharacter(val name: String,
                      val maxHp: Int,
                      val Atk: Int,
                      val Def: Int,
                      val Eva: Int,
                      override val randomNumberGenerator: Random = new Random()) extends AbstractUnit1 with Player  {
  /**The list of observers
   *
   * In this list there are the players that will be notify when someone reached norma 6
   */
  private var observers: List[Observer]=List.empty

  /** This method is used to add a observer in this subject that will be notify
   *
   * @param observer The observer that will be notified
   */
  def addObserver(observer:Observer): Unit ={
    observers=observer :: observers
  }
  /**This method is used to notify the observers that are in the list of observers
   *
   */
  def notifyObservers(): Unit = {
    for (observer<-observers){
      observer.update(this)
    }
  }
  /**The norma of the Player
   *
   * This variable specifies the level that has the player.  With this level the player can win the game
   */
  protected var _norma = 1
  /**The victory Points of Player.
   *
   * This variable contains the  points that the player win when defeats other players or wildUnits.
   * Needed to level up Norma.
   */
  protected var _victoryPoints = 0
  /**
   * represents whether it is the player's turn.
   *
   * The turn could be true or false.
   */
  protected var _turn = false
  /** Represents if the player is in ko or not.
   *
   * The ko could be true or false.
   */
  protected var _ko = false
  /** The objective to level up norma
   *
   * Initially the norma can not be choosed by player but after completed the first level up of norma then
   * the player can choose between level up norma by stars or norma by victories.  This variable is a class
   * type norma.
   */
  protected var _normaClass: Norma = new NormaInitially(this)

  /** The getter of norma
   */
  def norma: Int = _norma
  /** The setter of norma */
  def norma_=(newNorma: Int): Unit = _norma = newNorma
/** The getter of victoryPoints*/
  def victoryPoints: Int = _victoryPoints

  /**The setter of victoryPoints
   */
  def victoryPoints_=(newVictoryPoints: Int): Unit = _victoryPoints = newVictoryPoints

  /**The getter of turn
   */
  def turn: Boolean = _turn

  /** The setter of turn
   */
  def turn_=(newTurn: Boolean): Unit = _turn = newTurn
  /** The getter of ko
   */
  def ko: Boolean = _ko

  /**The setter of ko
   */
  def ko_=(newKo: Boolean): Unit = _ko = newKo

  /**The getter of normaClass
   */
  def normaClass: Norma = _normaClass.copy()

  /**The setter of normaClass
   */
  def normaClass_=(newNormaClass: Norma): Unit = _normaClass = newNormaClass

  /** add the value to the variable victoryPoints
   *
   * @param value The value that will be plus to the currently victoryPoints of the player
   * @example
   * {{{
   *   val player=new player("m",1,1,1,1)
   *   println(s"The value of victoryPoints is $player.victoryPoints")
   *   player.changeVictoryPoints(5)
   *   println(s"The new value of victoryPoints is $player.victoryPoints")
   * }}}
   */
  def changeVictoryPoints(value: Int): Unit = {
    victoryPoints += value
  }
  /** Turn is false when the variable turn its true and true when its false
   *
   * @example
   * {{{
   *   val player = new player("m",1,1,1,1)
   *   println(s"The turn of the player is $player.turn")
   *   player.changeTurn()
   *   println(s"The turn of the player now is $player.turn")
   * }}}
   */
  def changeTurn(): Unit = {
    turn = !turn
  }

  /** ko is false when the variable ko its true and true when its false
   *
   * @example
   * {{{
   *   val player= new player("m",1,1,1,1)
   *   println(s"The ko of the player is $player.ko")
   *   player.changeTurn()
   *   println(s"The ko of the player now is $player.ko")
   * }}}
   */
  def changeKo(): Unit = {
    ko = !ko
  }
  /**def activateNormaCheck(newNorma: Norma): Unit = {
    class e1 extends Exception
    try {
      if (inPanel.isEmpty) {
        throw new Throwable()
      }
      if (normaClass.normaCheck()){
        norma+=1
        normaClass = newNorma
      }
      throw new e1
    }
    catch {
      case e:Throwable => println("Player is not in a Panel")
      case e:e1 => println("The conditions for activating normacheck are not met")
    }
  }*/
  /**Add one point of life
   *
   * This function can only be activated using the method apply of an object called HomePanel
   *
   * @example
   * {{{
   *   val player = new player("m",1,1,1,1)
   *   println(s"The actual Hp of player is $player.Hp")
   *   player.recoverHp()
   *   println(s"The new Hp of player is $player.Hp")
   * }}}
   */
  protected [model] def recoverHp(): Unit={
    Hp+=1
  }

  /**The function level up norma
   *
   * The function can only be activated using the method normaCheck of an object that extends from the trait Norma
   *
   * @example
   * {{{
   *   new player("m",1,1,1,1)
   *   println(s"The current norma of player is $player.norma ")
   *   player.recoverHp()
   *   println(s"The current norma now of player is $player.norma ")
   * }}}
   */
  def applyEffectsNormaCheck(): Unit = {
    norma+=1
  }

  /** This method allow to a PlayerCharacter to attack other Unit
   *
   * The method attack use double dispatch and depending of the type of other the effects of the attack could
   * variate.   This verifies if the attacker is ko or not.  If the attacker is ko then the attack will not
   * consummate.   This method only call other function.  The defend mode of the other unit is decided randomly.
   *
   * @param other Other is an Unit that will receive the attack if the player can attack
   *
   * @throws e1 If the player is already ko then cannot do the attack
   *
   * @example
   * {{{
   *   val player=new player("qw",1,1,1,1)
   *   val Unit: Unit1=new player("no",1,1,1,1)
   *   player.attack(Unit)
   * }}}
   *
   */
  def attack(other: Unit1): Unit = {
    class e1 extends Exception
    try{
      if (this.ko) {
        throw new e1
      }
      /**its a provisional solution because the player cannot choose with an input*/
      val election=other.ModeCombat
      if(election==1){
        other.defend(this)
      }
      else if(election==2){
        other.evade(this)
      }
    }
    catch{
      case e:e1=>println("The character is ko so the attack cannot be consummate")
    }
  }

  /** This method simulate the effects of a Player in defending mode that is attacked by other Player
   *
   * @example
   * {{{
   *   new player=PlayerCharacter("n",1,1,1,1)
   *   new player1:Player=PlayerCharacter("n1",1,1,1,1)
   *   player.defend(player1)
   * }}}
   * @param other The player that is attacking
   */
  def defend(other:Player):Unit={
    class e1 extends Exception
    try {
      if (this.ko){throw new e1}
      this.Hp -= this.dmgDefense(other)
      if(this.Hp<=0){
        this.changeKo()
        this.Hp = 0
        new ResultsPlayerVsPlayer(this,other).ApplyResults()
      }
    }
    catch{
      case e:e1=>println("The attacker cannot consummate the attack because the defender is ko")
    }
  }

  /** This method simulate the effects of a Player in defending mode that is attacked by a WildUnit
   *
   * @example
   * {{{
   *   new player=PlayerCharacter("n",1,1,1,1)
   *   new savage:WildUnit=new WildChicken
   *   player.defend(savage)
   * }}}
   * @param other The WildUnit that is attacking
   */
  def defend(other:WildUnit): Unit= {
    class e1 extends Exception
    try {
      if (this.ko) {throw new e1}
      this.Hp -= this.dmgDefense(other)
      if (this.Hp <= 0) {
        this.changeKo()
        this.Hp = 0
        new ResultsPlayerVsWild(this,other).ApplyResults()
      }
    }
    catch{
      case e:e1=>println("The attacker cannot consummate the attack because the defender is ko")
    }
  }

  /** This method simulate the effects of a Player in evading mode that is attacked by a Player
   *
   * @example
   * {{{
   *   new player=PlayerCharacter("n",1,1,1,1)
   *   new player1:Player=PlayerCharacter("n1",1,1,1,1)
   *   player.evade(player1)
   * }}}
   * @param other The Player that is attacking
   */
  def evade(other:Player): Unit={
    try {
      if (this.ko) {
        throw new Throwable()
      }
      this.Hp -= this.dmgEvade(other)
      if (this.Hp <= 0) {
        this.changeKo()
        this.Hp = 0
        new ResultsPlayerVsPlayer(this,other).ApplyResults()
      }
    }
    catch{
      case e: Throwable=>println("The attacker cannot consummate the attack because the defender is ko")
    }
  }


  /** This method simulate the effects of a Player in evading mode that is attacked by a WildUnit
   *
   * @example
   * {{{
   *   new player=PlayerCharacter("n",1,1,1,1)
   *   new savage:WildUnit=new WildChicken
   *   player.evade(savage)
   * }}}
   * @param other The WildUnit that is attacking
   */
  def evade(other:WildUnit): Unit={
    try {
      if (this.ko) {
        throw new Throwable()
      }
      this.Hp -= this.dmgEvade(other)
      if (this.Hp <= 0) {
        this.changeKo()
        this.Hp = 0
        new ResultsPlayerVsWild(this,other).ApplyResults()
      }
    }
    catch{
      case e:Throwable=>println("The attacker cannot consummate the attack because the defender is ko")
    }
  }

  /** This method is used to generate a copy of PlayerCharacter
   *
   * @return A PlayerCharacter that have the same attributes and values that the original but their name is copy
   * @example
   * {{{
   *   val character=new PlayerCharacter("n",1,1,1,1)
   *   val copy=character.copy()
   *   assert(copy.isInstanceOf[PlayerCharacter])
   *   assert(copy!=character)
   * }}}
   */
  def copy(): PlayerCharacter={
    val copy=new PlayerCharacter(s"copy${this.name}",this.maxHp,this.Atk,this.Def,this.Eva)
    copy.norma=this.norma
    copy.stars=this.stars
    copy.victoryPoints=this.victoryPoints
    copy.Hp=this.Hp
    copy.ko=this.ko
    copy.turn=this.turn
    copy.normaClass=this.normaClass
    copy
  }
  /**Compares this object with another to determine if they are of the same type.
   * @param other The object to compare with.
   * @return `true` if this object is of the same type as the `other` object, `false` otherwise.
   */
  override def equals(other:Any): Boolean=other.getClass==this.getClass
  /**Represents the home panel that the player owns.
   *
   */
  protected var _HomePanel: Option[HomePanel] = None

  /**The method that returns the home panel that the player owns
   *
   * @return The home panel that the player owns
   */
  def HomePanel: Option[HomePanel] = _HomePanel
  /**This method allows to modifies the home panel that the player owns
   *
   * @param newHomePanel The new home panel of the player
   */
  def HomePanel_=(newHomePanel: HomePanel): Unit = _HomePanel = Some(newHomePanel)
}



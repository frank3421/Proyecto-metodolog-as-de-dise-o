package cl.uchile.dcc.citric
package model.Controller
import model.States._
import model.Units._
import model.Panels._
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import model.Boards.Table
/**
 * Controller class that manages the game state, player characters, turns, and game events.
 * Extends TraitController for trait-based functionality and implements Observer for observing game events.
 *
 * @example
 * {{{
 *   val controller = new Controller
 *   controller.addPlayerCharacter("kkk", 1, 1, 1, 1)
 * }}}
 */
class Controller extends TraitController with Observer {

  /** Current state of the game.
   *
   * The state represents the phase of the game
   */
  private var _state: TraitState = new PreGame

  /**Return the current state of the controller
   *
   */
   def state:TraitState=_state

  /**Allows to set a new state
   *
   */
  def state_=(newState:TraitState):Unit=_state=newState

  /** List of player characters in the game.
   *
   */
  private var _playerCharacters: List[Player] = List.empty[Player]

  /** Current chapter in the game.
   *
   */
  private var _chapter: Int = 0

  /** Map of possible game states.
   *
   * This map saves the possible phases of the game because the states will be used constantly
   */
  private val states: Map[String, TraitState] = Map(
    "PreGame"->new PreGame,
    "Chapter" -> new Chapter,
    "EndGame" -> new EndGame,
    "Recovery" -> new Recovery,
    "PlayerTurn" -> new PlayerTurn,
    "Moving" -> new Moving,
    "Combat" -> new Combat,
    "Wait" -> new Wait,
    "LandingPanel" -> new LandingPanel
  )

  /** Total number of players in the game.
   *
   */
  private var _TotalPlayers: Int = 0

  /** Current turn in the game.
   *
   */
  private var _turn: Int = 0

  /** Initial game panel where the players start.
   *
   */
  val InitialPanel = new NeutralPanel

  /** List to save recovery values for players.
   *
   */
  private var recovery = ListBuffer.empty[Int]

  /** Current direction chosen by player in their turn to move.
   *
   */
  private var _direction = 0

  /** Current movements of the player in their turn.
   *
   */
  private var _movements = 0

  /** Player to be attacked in the game.
   *
   */
  private var _attackTo = (-1)
  var combat=0
  def createTableAndPlayersConfig1():Unit={
    configListPlayers1()
    configCreateBoard1()
  }
  private def configCreateBoard1():Unit={
    val panel = new Table
    InitialPanel.addNextPanel(panel.createNewTable(this))
  }
  private def configListPlayers1(): Unit = {
    addPlayerCharacter("fran",10,10,10,10)
    addPlayerCharacter("nava",1,1,1,1)
  }

  /** Getter for the player that is chosen to be attacked
   *
   */
  def attackTo: Int = _attackTo

  /** Setter to choose the player that will be attacked
   *
   * @param player The number that represents the player on the list
   * @example
   * {{{
   *   val controller = new Controller
   *   var objective=controller.attackTo
   * }}}
   */
  def setAttack(player: Int): Unit = _attackTo = player

  /** The current direction chosen by player
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   controller.setAttack=2
   * }}}
   */
  def direction(): Int = _direction

  /** Updates the current election of direction chosen by the player.
   *
   * @param newDirection The new direction chosen to move in
   * @example
   * {{{
   *   val controller = new Controller
   *   val value=controller.direction
   * }}}
   */
  def setDirection(direction:Int):Unit ={_direction=direction}

  /** Returns the current movements remaining of the player.
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   setDirection=2
   * }}}
   */
  def movements(): Int = _movements

  /** Return the current movements remaining of the player.
   *
   * @param newMovements The movements that will be set
   * @example
   * {{{
   *   val controller = new Controller
   *   val value=controller.movements
   * }}}
   */
  def setMovements(newMovements: Int): Unit = _movements = newMovements

  /** Decreases the current movements of the player by 1.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.decreaseMovements()
   * }}}
   */
  def decreaseMovements(): Unit = {
    _movements -= 1
  }

  /** Gets the recovery value of the current player.
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   val value = controller.getRecoveryOfPlayer()
   * }}}
   */
  def getRecoveryOfPlayer: Int = {
    recovery(_turn)
  }
  def setRecovery(newRecovery:Int):Unit=recovery(_turn)=newRecovery

  /** Resets the recovery value for the current player.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.resetRecoveryPlayer()
   * }}}
   */
  def resetRecoveryPlayer(): Unit = {
    recovery(_turn) = 6
  }

  /** Decreases the recovery value for the current player.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.decreaseRecovery()
   * }}}
   */
  def decreaseRecovery(): Unit = {
    recovery(_turn) -= 1
  }

  /**
   * When it's activated the function prints a message of endgame because someone already wins.
   *
   * @param observable The subject being observed (player).
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   val player=new PlayerCharacter("kkk",1,1,1,1)
   *   controller.update(player)
   * }}}
   */
  def update(observable: Subject): Unit = {
    val player: Player = _playerCharacters(_turn)
    val name = player.name
    println(s"The player called $name wins the game due to the player already reached norma 6")
  }

  /** Return the total number of players.
   *
   * @example
   * {{{
   *   val controller = new controller
   *   val value=controller.TotalPlayers
   * }}}
   */
  def TotalPlayers: Int = _TotalPlayers

  /** Return the current turn.
   *
   * @example
   * {{{
   *   val controller=New Controller
   *   val value = controller.turn
   * }}}
   */
  def turn: Int = _turn
  def turn_=(newTurn:Int):Unit=_turn=newTurn
  /** Resets the current turn to 0.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.resetTurn()
   * }}}
   */
  def resetTurn(): Unit = {
    _turn = 0
  }

  /** Increments the current turn in 1.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.nextTurn()
   * }}}
   */
  def nextTurn(): Unit = {
    _turn += 1
  }

  /** Return the list of player characters.
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   val value=controller.playerCharacters
   * }}}
   */
  def playerCharacters: List[Player] = _playerCharacters

  /**
   * Return the state from the list of states
   *
   * @param state The name of the state that wants to be returned .
   *
   * @return The corresponding state.
   * @example
   * {{{
   *   val controller = new Controller
   *   val currentState = controller.getState("Chapter")
   * }}}
   */
  def getState(state: String): TraitState = {
    val value: TraitState = states(state)
    value
  }

  /** Return the current chapter of the game.
   *
   * @example
   * {{{
   *   val controller=new Controller
   *   val value=controller.chapter
   * }}}
   */
  def chapter: Int = _chapter

  /** Increments the current chapter of the game by 1.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.increaseChapter()
   * }}}
   */
  def increaseChapter(): Unit = {
    _chapter += 1
  }

  /** Update the current state of the game.
   *
   * @param aState The new state
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.setState(new Chapter)
   * }}}
   */
  def setState(aState: TraitState): Unit = {
    state = aState
  }

  /**
   * Adds a new player character to the game.
   *
   * @param name The name of the player character.
   * @param maxHp The maximum health points of the player character.
   * @param Atk The attack stat of the player character.
   * @param Def The defense stat of the player character.
   * @param Eva The evasion stat of the player character.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.addPlayerCharacter("kkkk", 1, 1, 1, 1)
   * }}}
   */
  def addPlayerCharacter(name: String, maxHp: Int, Atk: Int, Def: Int, Eva: Int): Unit = {
    _TotalPlayers += 1
    val player = new PlayerCharacter(name, maxHp, Atk, Def, Eva)
    player.addObserver(this)
    _playerCharacters = player :: _playerCharacters
    player.inPanel = Some(InitialPanel)
    recovery += 6
  }

  /** Starts the game by initiating the initial game state transitioning from PreGame to Chapter.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.startGame(this)
   * }}}
   */
  def startGame(): Unit = {
    state.startGame(this)
  }

  /** Allows to reset the turn and start a new Chapter.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.newChapter(this)
   * }}}
   */
  def newChapter(): Unit = state.newChapter(this)

  /** Allows to change the current state from Chapter to EndGame.
   *
   * When a player reach norma 6 and the game its in the Chapter state then can do a valid transitio form chapter
   * to endgame winning the game.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.normaSixReached(this)
   * }}}
   */
  def normaSixReached(): Unit = state.normaSixReached(this)

  /** Allows to change the current state from Chapter to Recovery
   *
   * Its a valid transition when the player is Ko
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.Ko(this)
   * }}}
   */
  def Ko(): Unit = state.Ko(this)

  /** Allows to change the state from Chapter to PlayerTurn
   *
   * Its a valid transition when the player is not Ko.
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.playTurn(this)
   * }}}
   */
  def playTurn(): Unit = state.playTurn(this)

  /** Allows to change the state from recovery to PlayerTurn or Chapter
   *
   * The player throw a Dice and verify if the value of Dice is higher than recovery time
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.tryOutRecovery(this)
   * }}}
   */
  def tryOutRecovery(): Unit = state.tryOutRecovery(this)

  /** Allows to change the state from PlayerTurn to Moving.
   *
   * The player roll a Dice, verifies the number and that number is used to do movements in the next state
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.rollDice(this)
   * }}}
   */
  def rollDice(): Unit = state.rollDice(this)

  /** This method allows to change the path and remains in Moving
   *
   * This method allows to the character choose a path to move and move to the next panel
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.choosePath(this)
   * }}}
   */
  def choosePath(): Unit = state.choosePath(this)

  /** Allows to change the state from moving to Combat.
   *
   * If the player has not more movements then do a valid transition to te state combat
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.outOfMovements(this)
   * }}}
   */
  def outOfMovements(): Unit = state.outOfMovements(this)

  /** Allows to change the state from moving to combat
   *
   * The player stop movement if the panel is a home panel and the player its the owner
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.stopMovement(this)
   * }}}
   */
  def stopMovement(): Unit = state.stopMovement(this)

  /** Allows to change the state from combat to wait.
   *
   * If the player select a player to attack then the player attack that player
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.attack(this)
   * }}}
   */
  def attack(): Unit = state.attack(this)

  /** Allows to change the state from wait to combat
   *
   * If the mode of combat of the player is defend then the player defend against attacker
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.defend(this)
   * }}}
   */
  def defend(): Unit = state.defend(this)

  /** Allows to change the state from wait to combat
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.evade(this)
   * }}}
   */
  def evade(): Unit = state.evade(this)

  /** Allows to change the state from Chapter to endCombat
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.endCombat(this)
   * }}}
   */
  def endCombat(): Unit = state.endCombat(this)

  /** Allows to change the state from landingPanel to chapter
   *
   * @example
   * {{{
   *   val controller = new Controller
   *   controller.doEffect(this)
   * }}}
   */
  def doEffect(): Unit = state.doEffect(this)
}

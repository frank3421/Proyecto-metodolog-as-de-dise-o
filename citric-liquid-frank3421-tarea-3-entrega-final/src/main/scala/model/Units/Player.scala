package cl.uchile.dcc.citric
package model.Units
import cl.uchile.dcc.citric.model.ResultsCombat.{Results, ResultsPlayerVsPlayer, ResultsPlayerVsWild}
import cl.uchile.dcc.citric.model.Norma.Norma
import cl.uchile.dcc.citric.model.Panels.HomePanel

/** Represents a character that is manage by a player.
 *
 * Each character has their variables that can be modify
 * In the context of the board game, a character is managed by a human that allows stars, victories and other atributes.
 * the character can fight with other monsters and characters
 * Panels can also be connected to other panels, allowing for the formation of complex board
 * structures.*/
trait Player extends Unit1 with Subject {
  /**
   * the name of player
   */
  val name:String
  /** the norma of the player
   *
   * The norma is required to win the game
   */
  protected var _norma: Int
  /**The victory points of the player
   *
   * This points are required to level up norma
   */
  protected var _victoryPoints: Int
  /**Represents whether it is the player's turn
   *
   * Could change depending of the state of the game
   */
  protected var _turn: Boolean
  /** Represents if the player is recovering of a defeat or not
   *
   * Can be changed with the results of defending or evading
   */
  protected var _ko: Boolean
  /**Its a class that allows to level up norma if the requirements are fulfilled or not
   *
   */
  protected var _normaClass: Norma

  /** updates the modeCombat of a player
   *
   * @param newModeCombat The new mode combat that will have this variable
   */
  def ModeCombat_=(newModeCombat: Int): Unit
  def norma_=(newNorma: Int): Unit
  def rollDice(): Int
  def changeVictoryPoints(Points: Int): Unit
  def changeTurn(): Unit
  def changeKo(): Unit
  protected [model] def recoverHp(): Unit
  def applyEffectsNormaCheck(): Unit
  def copy(): PlayerCharacter
  def norma: Int
  def ko:Boolean
  protected var _HomePanel: Option[HomePanel]
  def HomePanel: Option[HomePanel]
  def HomePanel_=(newHomePanel: HomePanel): Unit
  def turn:Boolean
  def normaClass:Norma
}

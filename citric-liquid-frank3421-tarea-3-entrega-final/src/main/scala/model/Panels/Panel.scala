package cl.uchile.dcc.citric
package model.Panels

import model.Units.{Player, PlayerCharacter, WildUnit}

import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/YOUR-USERNAME YOUR NAME]]
  */
trait Panel {

  /** Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   */
  val characters: ArrayBuffer[PlayerCharacter]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  protected var _nextPanels: ArrayBuffer[Panel]
  /** Return te nextPanels of the Panel
   */
  def nextPanels : ArrayBuffer[Panel]

  /** Adds a character to the list of characters currently on this panel.
   *
   * This might be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from the list of characters currently on this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */
  def removeCharacter(player: PlayerCharacter): Unit

  /** Add a panel from the list of nextPanels currently on this panel
   *
   * This might be invoked someone whats to initialize a panel in the game
   *
   *@param panel The panel to remove from the list nextPanels
   */
  def addNextPanel(panel: Panel): Unit

  /** Removes a panel from the list of nextPanels currently on this panel
   *
   * This might be invoked someone whats to initialize a panel in the game
   *
   * @param panel The panel to remove from the list nextPanels
   */
  def removeNextPanel(panel: Panel): Unit

  /** The purpose of this method is to activate the effect that each type of Panel could have
   *
   * The application of this method is defined in each Panel
   *
   * @param player The player to whom the panel effects will be applied
   */
  def apply(player:Player): Unit

  /**Compares this Panel with another object to determine if they ave the same class
   *
   * @param other The Panel to be compared with.
   * @return `true` if this Panel have the same class of the object, `false` otherwise.
   */
  def equals(other:Any):Boolean

}








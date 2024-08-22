package cl.uchile.dcc.citric
package model.ResultsCombat
import cl.uchile.dcc.citric.model.Units.Unit1
/**
 * A trait representing the results of a combat where one opponent lose.
 *
 * This trait defines a common interface for classes that represent the results of defeats. Classes implementing this trait are expected to provide an `ApplyResults` method to calculate and apply the specific outcomes of the encounter.
 */
trait Results {
  /**
   * Calculates and applies the results of a defeat.
   *
   * This method should be implemented by classes that extend this trait to define the specific outcomes of a defeat.
   */
  def ApplyResults(): Unit
}

package cl.uchile.dcc.citric
package model.Units
import model.Controller._

/** The trait that represent the methods that a subject must to has
 *
 */
trait Subject {
  /**This method is used to add a observer in this subject that will be notify
   *
   * @param observer The observer that will be notified
   */
  def addObserver(observer: Observer): Unit

  /**This method is used to notify the observers that are in the list of observers
   *
   */
  def notifyObservers(): Unit

}

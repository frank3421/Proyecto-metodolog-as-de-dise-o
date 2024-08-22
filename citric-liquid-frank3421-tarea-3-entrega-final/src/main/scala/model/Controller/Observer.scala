package cl.uchile.dcc.citric
package model.Controller
import model.Units._

/**The trait of an observer that allows to do updates
 */
trait Observer {
  /**This method allows to an observer to do an update
   *
   * @param observable Its the subject that is being observed
   */
  def update(observable:Subject): Unit
}

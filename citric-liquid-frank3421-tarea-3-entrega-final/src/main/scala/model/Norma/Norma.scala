package cl.uchile.dcc.citric
package model.Norma

/**Represents requisites that are needed to level up the norma of a player.
 * The method normaCheck could use stars or victories and need to know norma.
 */
trait Norma {
  def normaCheck(): Unit
  def copy(): Norma
}





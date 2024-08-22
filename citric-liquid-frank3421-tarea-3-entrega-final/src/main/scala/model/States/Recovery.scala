package cl.uchile.dcc.citric
package model.States
import model.Controller._
import model.Units.Player
import scala.util.Random
class Recovery extends BaseState{
  override def tryOutRecovery(controller:Controller):Unit={
    val Dice: Int = new Random().nextInt(6)+1
    if (controller.getRecoveryOfPlayer <= Dice) {
      controller.resetRecoveryPlayer()
      val actualPlayer=controller.playerCharacters(controller.turn)
      actualPlayer.changeKo()
      this.changeState(controller,controller.getState("PlayerTurn"))
    }
    else{
      controller.decreaseRecovery()
      if(controller.turn==controller.TotalPlayers-1){
        controller.resetTurn()
        this.changeState(controller,controller.getState("Chapter"))
      }
      else{
        controller.nextTurn()
        this.changeState(controller, controller.getState("Chapter"))
      }
    }
  }
}

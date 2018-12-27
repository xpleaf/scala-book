package cn.xpleaf.scala.c13

/**
  * @author xpleaf 
  * @date 2018/12/27 11:55 PM
  */
class Rocket {
    import Rocket.fuel
    private def canGoHomeAgain: Boolean = fuel > 20
}

object Rocket {
    private def fuel = 10
    def chooseStrategy(rocket: Rocket): Unit = {
        if (rocket.canGoHomeAgain)
            goHome()
        else
            pickAStar()
    }
    def goHome(): Unit = {}
    def pickAStar(): Unit = {}
}

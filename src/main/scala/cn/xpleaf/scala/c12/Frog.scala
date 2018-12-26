package cn.xpleaf.scala.c12

/**
  * @author xpleaf 
  * @date 2018/12/25 10:25 PM
  */
class Frog extends Philosophical {
    override def toString: String = "green"
}

class Animal
class Frog2 extends Animal with Philosophical {
    override def toString: String = "green"

    override def philosophize(): Unit = {
        println("It ain't easy being " + toString + "!")
    }
}
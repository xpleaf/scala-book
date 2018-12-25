package cn.xpleaf.scala.c10

/**
  * @author xpleaf 
  * @date 2018/12/22 10:41 AM
  */
class ArrayElement(override val contents: Array[String]) extends Element {
    // override val contents: Array[String] = conts
    override def demo(): Unit = {
        println("ArrayElement's implementation invoked")
    }
}

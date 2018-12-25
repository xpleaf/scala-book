package cn.xpleaf.scala.c10

/**
  * @author xpleaf 
  * @date 2018/12/23 7:53 PM
  */
class LineElement(s :String) extends Element {
    def contents: Array[String] = Array(s)
    override def width: Int = s.length
    override def height: Int = 1
    override def demo(): Unit = {
        println("LineElement's implementation invoked")
    }
}

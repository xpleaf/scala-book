package cn.xpleaf.scala.c10

/**
  * @author xpleaf 
  * @date 2018/12/23 8:17 PM
  */
class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
    private val line = ch.toString * width
    override def contents: Array[String] = Array.fill(height)(line)
}

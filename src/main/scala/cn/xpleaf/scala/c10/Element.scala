package cn.xpleaf.scala.c10

/**
  * @author xpleaf 
  * @date 2018/12/22 10:04 AM
  */
import Element.elem
abstract class Element {
    def contents: Array[String]

    // 定义高度，其实就是数组的大小，意味着数组元素是垂直放置的
    def height: Int = contents.length

    // 定义宽度，其实就是数组元素的长度
    def width: Int = if (height == 0) 0 else contents(0).length

    /**
      * above就是将两个数组合并，其会改变数组的大小
      * Array("1", "2") above Array("a", "b")
      * --->
      * Array("1", "2", "a", "b")
      */
    def above(that: Element): Element = {
        val this1 = this widen that.width
        val that1 = that widen this.width
        elem(this1.contents ++ that1.contents)
        // elem(this.contents ++ that.contents)
    }

    /**
      * beside就是将两个数组的相对应元素合并，组成一个新的数组，其元素为两个数组中同索引的元素相加，其会改变数组元素的大小
      * Array("1", "2") beside Array("a", "b")
      * --->
      * Array("1a", "2b")
      */
    def beside(that: Element): Element = {
        val this1 = this heighten that.height
        val that1 = that heighten this.height
        elem(
            for ((line1, line2) <- this1.contents zip that1.contents)
            yield line1 + line2)
    }

    /**
      * 将元素设置为等宽，主要是用空格在数组元素前后填充
      * 填充的条件为，当前元素的宽度比另外一个元素的宽度要小
      */
    def widen(w: Int): Element =
        // eg. w = 4, width = 3
        if (w <= width) this
        else {
            // 元素左边需要增加的宽度，先取一半
            val left = elem(' ', (w - width) / 2, height)
            // 元素右边需要增加的宽度，剩下的放到右边
            val right = elem(' ', w - width - left.width, height)
            // 改变数组元素本身的宽度，使用beside操作
            left beside this beside right
        }

    /**
      * 将元素设置为等高，主要是用空格在数组首尾进行填充
      * 填充的条件为，当前元素的高度比另外一个元素的高度要小
      */
    def heighten(h: Int): Element =
        // eg. h = 4, height = 3
        if (h <= height) this
        else {
            // 数组首部需要增加的高度，先取一半
            val top = elem(' ', width, (h - height) / 2)
            // 数组尾部需要增加的高度，剩下的放到尾部
            val bot = elem(' ', width, h - height - top.height)
            // 改变数组的大小，使用above操作
            top above this above bot
        }

    override def toString: String = contents mkString "\n"

    def demo(): Unit = {
        println("Element's implementation invoked")
    }
}

// Element的伴生对象，主要是作为工厂对象来使用
object Element {

    private class ArrayElement(override val contents: Array[String]) extends Element {
        // override val contents: Array[String] = conts
        override def demo(): Unit = {
            println("ArrayElement's implementation invoked")
        }
    }

    private class LineElement(s :String) extends Element {
        def contents: Array[String] = Array(s)
        override def width: Int = s.length
        override def height: Int = 1
        override def demo(): Unit = {
            println("LineElement's implementation invoked")
        }
    }

    private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
        private val line = ch.toString * width
        override def contents: Array[String] = Array.fill(height)(line)
    }

    // 构建ArrayElement对象
    def elem(contents: Array[String]): Element =
        new ArrayElement(contents)

    // 构建LineElement对象
    def elem(line: String): Element =
        new LineElement(line)

    // 构建UniformElement对象
    def elem(chr: Char, width: Int, height: Int): Element =
        new UniformElement(chr, width, height)

}
package cn.xpleaf.scala.c8

import scala.io.Source

/**
  * @author xpleaf 
  * @date 2018/12/18 11:06 PM
  */
object LongLines {

    def processFile(filename: String, width: Int): Unit = {
        val source = Source.fromFile(filename)
        for (line <- source.getLines())
            processLine(filename, width, line)
    }

    private def processLine(filename: String, width: Int, line: String): Unit = {
        if (line.length > width)
            println(filename + ": " + line.trim)
    }

    // 使用函数嵌套方式
    def processFile2(filename: String, width: Int): Unit = {
        def processLine(line: String): Unit = {
            if (line.length > width)
                println(filename + ": " + line.trim)
        }

        val source = Source.fromFile(filename)
        for (line <- source.getLines())
            processLine(line)
    }

}

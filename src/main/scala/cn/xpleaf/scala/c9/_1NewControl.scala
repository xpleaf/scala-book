package cn.xpleaf.scala.c9

import java.io.{File, PrintWriter}

/**
  * @author xpleaf 
  * @date 2018/12/20 11:44 PM
  */
object _1NewControl extends App {

    def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
        val writer = new PrintWriter(file)
        try {
            op(writer)
        } finally {
            writer.close()
        }
    }

    withPrintWriter(
        new File("date.txt"),
        // writer => writer.println(new java.util.Date)
        _.println(new java.util.Date)
    )

    // 柯里化
    def withPrintWriter2(file: File)(op: PrintWriter => Unit): Unit = {
        val writer = new PrintWriter(file)
        try {
            op(writer)
        } finally {
            writer.close()
        }
    }

    // 看起来更像控制对象的调用
    withPrintWriter2(new File("date.txt")) { writer =>
        writer.println(new java.util.Date)
    }

}

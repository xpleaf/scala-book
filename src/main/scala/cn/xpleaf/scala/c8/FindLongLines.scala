package cn.xpleaf.scala.c8

/**
  * @author xpleaf 
  * @date 2018/12/18 11:15 PM
  */
object FindLongLines {

    def main(args: Array[String]): Unit = {
        val width = args(0).toInt
        for (arg <- args.drop(1)) {
            LongLines.processFile(arg, width)
        }
    }

}

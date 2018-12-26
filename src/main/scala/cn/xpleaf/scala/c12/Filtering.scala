package cn.xpleaf.scala.c12

/**
  * @author xpleaf 
  * @date 2018/12/26 10:50 PM
  */
trait Filtering extends IntQueue {
    abstract override def put(x: Int): Unit = {
        if (x >= 0) super.put(x)
    }
}

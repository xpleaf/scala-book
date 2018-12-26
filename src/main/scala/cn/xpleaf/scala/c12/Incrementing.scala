package cn.xpleaf.scala.c12

/**
  * @author xpleaf 
  * @date 2018/12/26 10:48 PM
  */
trait Incrementing extends IntQueue {
    abstract override def put(x: Int): Unit = { super.put(x + 1) }
}

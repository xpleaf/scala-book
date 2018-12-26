package cn.xpleaf.scala.c12

/**
  * @author xpleaf 
  * @date 2018/12/26 10:39 PM
  */
trait Doubling extends IntQueue {
    abstract override def put(x: Int): Unit = { super.put(2 * x) }
}

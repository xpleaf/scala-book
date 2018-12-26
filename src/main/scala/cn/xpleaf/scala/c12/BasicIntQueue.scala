package cn.xpleaf.scala.c12

import scala.collection.mutable.ArrayBuffer

/**
  * @author xpleaf 
  * @date 2018/12/26 10:28 PM
  */
class BasicIntQueue extends IntQueue {

    private val buf = new ArrayBuffer[Int]

    override def get(): Int = buf.remove(0)

    override def put(x: Int): Unit = { buf += x }
}

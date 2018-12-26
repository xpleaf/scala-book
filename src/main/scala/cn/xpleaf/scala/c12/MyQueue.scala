package cn.xpleaf.scala.c12

/**
  * @author xpleaf 
  * @date 2018/12/26 10:42 PM
  */
class MyQueue extends BasicIntQueue with Doubling

object MyQueue {
    val queue = new BasicIntQueue with Doubling
}
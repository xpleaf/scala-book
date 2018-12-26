package cn.xpleaf.scala.c12

/**
  * @author xpleaf 
  * @date 2018/12/26 10:18 AM
  */
trait Rectangular {

    def topLeft: Point
    def bottomRight: Point

    def left: Int = topLeft.x
    def right: Int = bottomRight.x
    def width:Int = right - left
}

package cn.xpleaf.scala.c10

/**
  * @author xpleaf 
  * @date 2018/12/22 11:09 AM
  */
class Tiger2(param1: Boolean, param2: Int) extends Cat {
    override val dangerous: Boolean = param1
    private var age = param2
}

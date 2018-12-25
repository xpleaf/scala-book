package cn.xpleaf.scala.c11

/**
  * @author xpleaf 
  * @date 2018/12/25 9:52 PM
  */
// 自定义值类
class Dollars(val amount: Int) extends AnyVal {
    override def toString: String = "$" + amount
}

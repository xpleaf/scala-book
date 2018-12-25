package cn.xpleaf.scala.c9

/**
  * @author xpleaf 
  * @date 2018/12/21 12:00 AM
  */
object _2ByNameParam extends App {

    var assertionsEnabled = true

    def myAssert(predicate: () => Boolean): Unit =
        if (assertionsEnabled && !predicate())
            throw new AssertionError()

    myAssert(() => 5 > 3)
    // myAssert(5 > 3)  // it does's work

    // 使用传名参数
    def byNameAssert(predicate: => Boolean): Unit =
        if (assertionsEnabled && !predicate)
            throw new AssertionError

    byNameAssert(5 > 3)

    // bool
    def boolAssert(predicate: Boolean): Unit =
        if (assertionsEnabled && !predicate)
            throw new AssertionError()

    val x = 5
    boolAssert(x / 5 == 0)      // assertionsEnabled为false时，会抛出异常

    byNameAssert(x / 5 == 0)    // assertionsEnabled为false时，并不会抛出异常

    // 所以区别是，boolAssert的参数为一个表达式，先求值，再进入函数调用
    // 而byNameAssert的参数是一个函数值，是否调用该函数取决于assertionsEnabled是否为true
}

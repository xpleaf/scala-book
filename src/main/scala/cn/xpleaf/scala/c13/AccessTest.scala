package cn.xpleaf.scala.c13

/**
  * @author xpleaf 
  * @date 2018/12/27 10:24 PM
  */
class AccessTest {

}

class Super {
    protected def f(): Unit = { println("f") }
}

class Sub extends Super {
    f()
}

class Other {
    // (new Super).f()  // 无法访问
}

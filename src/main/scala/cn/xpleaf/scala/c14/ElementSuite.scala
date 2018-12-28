package cn.xpleaf.scala.c14

import org.scalatest.{Assertions, FunSuite}
import cn.xpleaf.scala.c10.Element.elem

import scala.runtime.Nothing$

/**
  * @author xpleaf 
  * @date 2018/12/28 8:46 PM
  */
class ElementSuite extends FunSuite {
    test("elem result should have passed width") {
        val ele = elem('x', 2, 3)
        assert(ele.width == 2)
    }

    override def newAssertionFailedException(option: Option[AnyRef], option1: Option[Throwable], i: Int): Throwable = ???

    override def assert(b: Boolean): Unit = ???

    override def assert(b: Boolean, o: Any): Unit = ???

    override def assert(option: Option[String], o: Any): Unit = ???

    override def assert(option: Option[String]): Unit = ???

    override def fail(): Nothing$ = ???

    override def fail(s: String): Nothing$ = ???

    override def fail(s: String, throwable: Throwable): Nothing$ = ???

    override def fail(throwable: Throwable): Nothing$ = ???

    override def expect(o: Any, o1: Any, o2: Any): Unit = ???

    override def expect(o: Any, o1: Any): Unit = ???

    override def convertToEqualizer(o: Any): Assertions#Equalizer = ???

    override def intercept[T](function0: () => AnyRef, manifest: Manifest[T]): T = ???
}

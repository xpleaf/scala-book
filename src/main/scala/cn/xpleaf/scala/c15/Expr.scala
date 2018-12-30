package cn.xpleaf.scala.c15

/**
  * @author xpleaf 
  * @date 2018/12/28 9:46 PM
  */
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Expr {
    // 简单例子
    def simplifyTop(expr: Expr): Expr = expr match {
        case UnOp("-", UnOp("-", e)) => e
        case BinOp("+", e, Number(0)) => e
        case BinOp("*", e, Number(1)) => e
        case _ => expr  // 处理默认case
    }

    // 通配模式
    def simplifyTop2(expr: Expr): Unit = expr match {
        case BinOp(_, _, _) => println(expr + " is a binary operation")
        case _ => println("It's something else")
    }

    // 常量模式
    def describe(x: Any): String = x match {
        case 5 => "five"
        case true => "truth"
        case "hello" => "hi!"
        case Nil => "the empty list"
        case _ => "something else"
    }

    // 变量模式
    def variable(x: Any): Any = x match {
        case 0 => "zero"
        case somethingElse => "not zero: " + somethingElse
    }

    // 构造方法模式
    def construct(expr: Expr): Unit = expr match {
        case BinOp("+", e, Number(0)) => println("a deep match")
        case _ =>   // do nothing
    }

    // 序列模式
    def seq(x: List[Any]): Unit = x match {
        // 固定长度
        case List(0, _, _) => println("found it")
        // 任意长度，这里是匹配任意长度的以0开始的列表
        case List(0, _*) => println("found it2")
        case _ =>
    }

    // 元组匹配
    def tupleDemo(expr: Any): Unit = expr match {
        case (a, b, c) => println("matched " + a + b + c)
        case _ =>
    }

    // 带类型的模式
    def generalSize(x: Any): Int = x match {
        case s: String => s.length
        case m: Map[_, _] => m.size
        case _ => -1
    }

    // 使用类型测试和转换重写generalSize方法
    def generalSize2(x: Any): Int = {
        if (x.isInstanceOf[String]) {
            val s = x.asInstanceOf[String]
            s.length
        } else if (x.isInstanceOf[Map]) {
            val m = x.asInstanceOf[Map]
            m.size
        } else {
            -1
        }
    }

    // 类型擦除，Map中的Int编译之后是没有保存的
    def isIntIntMap(x: Any): Boolean = x match {
        case m: Map[Int, Int] => true
        case _ => false
    }

    // 数组的元素类型是跟数组一起保存的
    def isStringArray(x: Any): String = x match {
        case a: Array[String] => "yes"
        case _ => "no"
    }

    // 变量绑定，如果整个匹配成功了，UnOp("abs", _)就会被赋值给变量e
    def valueAssign(expr: Expr): Expr = expr match {
        case UnOp("abs", e @ UnOp("abs", _)) => e
        case _ => expr
    }
    // scala> valueAssign(UnOp("abs", UnOp("abs", Number(-1))))
    // res244: Expr = UnOp(abs,Number(-1.0))

    // 带有模式守卫的match表达式，其实就是模式后面的if操作
    def simplifyAdd(e: Expr): Expr = e match {
        // 两个相同数相加等价于其乘以2
        case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
        case _ => e
    }

    // 模式重叠，下面的例子（simplifyTop的加强版），匹配所有的case需要放在最后面，因为模式会按照代码中的顺序逐个被尝试
    def simplifyAll(expr: Expr): Expr = expr match {
        case UnOp("-", UnOp("-", e)) => simplifyAll(e)      // -是自己的取反
        case BinOp("+", e, Number(0)) => simplifyAll(e)     // 0是+的中性元素
        case BinOp("*", e, Number(1)) => simplifyAll(e)     // 1是*的中性元素
        case UnOp(op, e) => UnOp(op, simplifyAll(e))
        case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
        case _ => expr
    }

    // 漏掉了某些可能case的模式匹配，但是带上unchecked注解后可以让编译器忽略这些检查
    def describe(e: Expr): String = (e: @unchecked) match {
        case Number(_) => "a number"
        case Var(_) => "a variable"
    }

    // Option的模式匹配
    def show(x: Option[String]): String = x match {
        case Some(s) => s
        case None => "?"
    }

    // 到处都是模式--变量定义中的模式
    def allMode(): Unit = {
        // demo1
        val myTuple = (123, "abc")
        val (number, string) = myTuple

        // demo2
        val exp = new BinOp("*", Number(5), Number(1))
        val BinOp(op, left, right) = exp
    }

    // 到处都是模式--作为偏函数的case序列
    def caseSeq(): Unit = {
        val withDefault: Option[Int] => Int = {
            case Some(x) => x
            case None => 0
        }

        val second: List[Int] => Int = {
            case x :: y :: _ => y
        }

        val second2: PartialFunction[List[Int], Int] = {
            case x :: y :: _ => y
        }
    }

    // 到处都是模式--for表达式中的模式
    def forMode(): Unit = {
        // 对偶模式demo
        val capitals: Map[String, String] = Map("France" -> "Paris", "Japan" -> "Tokyo")
        for ((country, city) <- capitals)
            println(s"The capital of $country is $city")

        // 生成的值当中那些不能匹配给定模式的值会被直接丢弃，如下下面的None值
        val results = List(Some("apple"), None, Some("orange"))
        for (Some(fruit) <- results)
            println(fruit)
    }
}

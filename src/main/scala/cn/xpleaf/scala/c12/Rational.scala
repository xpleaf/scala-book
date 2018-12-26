package cn.xpleaf.scala.c12

/**
  * @author xpleaf 
  * @date 2018/12/26 10:07 PM
  */
class Rational(n: Int, d: Int) extends Ordered[Rational] {

    // 前置检查
    require(d != 0)

    // 分子和分母的最大公约数
    private val g: Int = gcd(n, d)

    val numer: Int = n / g  // 分子
    val denom: Int = d / g  // 分母

    // 辅助构造器
    def this(n: Int) = this(n, 1)

    override def toString: String = numer + "/" + denom

    // 加法
    def + (that: Rational): Rational =
        new Rational(
            numer * that.denom + that.numer * d,
            denom * that.denom
        )
    def + (i: Int): Rational =
        new Rational(numer + i * denom, denom)

    // 减法
    def - (that: Rational): Rational =
        new Rational(
            numer * that.denom - that.numer * denom,
            denom * that.denom
        )
    def - (i: Int): Rational =
        new Rational(numer - i * denom, denom)

    // 乘法
    def * (that: Rational): Rational =
        new Rational(numer * that.numer, denom * that.denom)
    def * (i: Int): Rational =
        new Rational(numer * i, denom)

    // 除法
    def / (that: Rational): Rational =
        new Rational(numer * that.denom, denom * that.numer)
    def / (i: Int): Rational =
        new Rational(numer, denom * i)

    // 求两个数的最大公约数
    private def gcd(a: Int, b: Int): Int =
        if(b == 0) a else gcd(b, a % b)

    // 判断当前有理数是否小于另外一个有理数
    def lessThan(that: Rational): Boolean =
        this.numer * that.denom < that.numer * this.denom

    // 取当前有理数与比较的有理数的最大值
    def max(that: Rational): Rational =
        if(lessThan(that)) that else this

    override def compare(that: Rational): Int =
        this.numer * that.denom - that.numer * this.numer
}
// 不支持 整数 * Rational，不过可以添加隐式转换以支持该操作：implicit def intToRational(x: Int) = new Rational(x)
object Rational {
    implicit def intToRational(x: Int): Rational = new Rational(x)
}

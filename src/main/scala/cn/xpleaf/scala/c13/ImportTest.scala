package cn.xpleaf.scala.c13

/**
  * @author xpleaf 
  * @date 2018/12/27 11:07 AM
  */
class ImportTest {

    abstract class Fruit(val name: String, val color: String)

    object Fruits {
        object Apple extends Fruit("apple", "red")
        object Orange extends Fruit("orange", "orange")
        object Pear extends Fruit("pear", "yellowish")

        val menu = List(Apple, Orange, Pear)
    }

    def showFruit(fruit: Fruit): Unit = {
        import fruit._
        println(name + "s are " + color)
    }

}

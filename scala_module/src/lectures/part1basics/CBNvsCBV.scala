package lectures.part1basics

/**
  * Created by Daniel on 07-May-18.
  */
object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + 1257387745764245L) //instead of x
    println("by value: " + 1257387745764245L) //instead of x
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + System.nanoTime())  //instead of x reevaluating the value
    println("by name: " + System.nanoTime())  //instead of x like reevaluating the parameter
  }

  calledByValue(1257387745764245L)
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //  printFirst(infinite(), 34)
  printFirst(34, infinite())
}
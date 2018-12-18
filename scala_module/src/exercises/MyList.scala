package exercises


abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B>:A](element:B): MyList[B]
  override def toString: String
}

object Empty extends MyList[Nothing]{

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B>:Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def toString() : String = "empty"

}

class Cons[+A](h:A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B>:A](element: B): MyList[B] = new Cons(element,this)

  override def toString() : String = if (t.isEmpty) ""+h else h + tail.toString()

}

object ListTest extends App {
  val listOfIntegers : MyList[Int] = new Cons(1, new Cons(2,new Cons(3,Empty)))
  val listOfString : MyList[String] = new Cons("hello", new Cons("world",new Cons("Scala",Empty)))
  private val value: MyList[Object] = listOfString.add(AnyRef)
  println(listOfIntegers.toString)
  println(listOfString.toString)

}
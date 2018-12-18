package exercises

trait MyPredicate[-T] {
  def test(test: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  override def toString: String

  def map[B](myTransformer: MyTransformer[A, B]): MyList[B]

  def filter(myPredicate: MyPredicate[A]): MyList[A]

  def flatMap[B] (myTransformer: MyTransformer[A,MyList[B]]) : MyList[B]

  def ++ [B>: A](list: MyList[B]): MyList[B]
}

object Empty extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def toString(): String = "empty"

  override def map[B](myTransformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def filter(myPredicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def flatMap[B](myTransformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def toString(): String = if (t.isEmpty) "" + h else h + tail.toString()

  override def map[B](myTransformer: MyTransformer[A, B]): Cons[B] = {
    new Cons[B](myTransformer.transform(head), t.map(myTransformer))
  }

  override def filter(myPredicate: MyPredicate[A]): MyList[A] = {
    if(myPredicate.test(h)) new Cons(h,t.filter(myPredicate)) else t.filter(myPredicate)
  }

  /*
      [1,2] .flatMap(n => [n,n+1]
      = 1,2 ++  2.flatMap(n => [n,n+1]
      = 1,2 ++ 2,3 ++ Empty.flatMap
   */

  override def flatMap[B](myTransformer: MyTransformer[A, MyList[B]]): MyList[B] =
    myTransformer.transform(head) ++ t.flatMap(myTransformer)

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list) // works because of the empty list on the end
}


object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(4, Empty)))
  val listOfString: MyList[String] = new Cons("hello", new Cons("world", new Cons("Scala", Empty)))
  private val value: MyList[Object] = listOfString.add(AnyRef)
  println(listOfIntegers.toString)
  println(listOfString.toString)

  println(listOfIntegers.filter((test: Int) => test % 2 == 0))

  println(listOfIntegers.map((a: Int) => a * 2))

  println(listOfIntegers.flatMap(new MyTransformer[Int,MyList[Int]] {
    override def transform(a: Int): MyList[Int] = new Cons[Int](a,new Cons[Int](a+1,Empty))
  }))
}
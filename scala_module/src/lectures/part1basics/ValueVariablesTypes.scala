package lectures.part1basics

object ValueVariablesTypes extends App {

  val x: Int = 42

  println(x)

  //vals cannot be reassigned . they are immutable

  val y = 24

  println(y)

  //types of vals are optional. compiler can infer types

  val aString: String = "" ; val anotherString = " goodbye" // on same line you need ;

  val aBoolean : Boolean = false

  val aChar : Char = 'a'

  val anInt : Int = x

  val aShort : Short = 1234

  val aLong : Long = 1234332432432423L

  val aFloat : Float = 12.3F

  val aDouble : Double = 3.13

  //variables

  var aVariable : Int  = 4;
  aVariable = 5 // side effects



}

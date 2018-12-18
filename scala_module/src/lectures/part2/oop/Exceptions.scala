package lectures.part2.oop

object Exceptions extends App {

  val x: String = null

  // println(x.length)
  //this will crash with NPE

  //1 . throwing and catching exceptions

  //  val aWieldValue: String = throw new NullPointerException

  //throwable classes extend the Throwable class
  //exception and error are the major Throwable subtypes


  //2. catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("not int for you")
    else 1


  val tryCatch = try {
    getInt(false)
  } catch {
    case e: RuntimeException => println("caught a runtimeException")
  } finally {
    //code executed no matter what except system.exit in try
    println("finally")
  }

  //3. define own exceptions

  class MyException extends Exception

  val exception = new MyException

  //throw exception

  //OOM
   //val array = Array.ofDim(Int.MaxValue)

  //Stack overflow
  def infinite : Int = 1 + infinite
  //call it
}


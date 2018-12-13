package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + "   " + b
  }

  println(aFunction("Hello", 4))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)


  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hek", 3))

  //when you need loops , use recursion

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1);
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUtil(t: Int): Boolean =
      if( t<= 1 ) true
      else n% t != 0 && isPrimeUtil(t-1)

    isPrimeUtil(n / 2)
  }

}

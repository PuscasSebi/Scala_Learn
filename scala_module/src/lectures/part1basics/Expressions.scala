package lectures.part1basics

object Expressions extends App{
    val x = 1 + 2 // expression
    println(x)

    println(2 + 4 * 2)
    // + - * / & | ^ << >> >>> )right shift with zero extension

    println(!(3==x))

  var aVariable = 2
  aVariable += 3 //-=  *= /=  side effects

  // Instructions (DOes something)  vs Expressions (has a Value)

  // IF Expression

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // if expression not if instruction
  println(5)
  println(if(aCondition) 4 else 2)

  var i = 0;
  val aWhile :Unit = while( i < 10) {
    println(i)
    i += 1
  }

  // ITERATE using other stuff , not such imperative approach , like java..

  val aWeirdValue = (aVariable == 3) // Unit === void
  println(aWeirdValue)


  //a code block
  val aCodeBlock = {
    //everything declared here will not be visible outside.
    val y = 2;
    val z = y+1
    if(z>2) "Hello" else "goodBye"
  }

  //expression vs instructions
  // give me the value of something vs do something
    //think more in terms of expressions

}

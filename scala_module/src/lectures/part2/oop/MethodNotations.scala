package lectures.part2.oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String){
    def likes(movie: String) : Boolean = movie  == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging of with ${person.name}"

    def unary_! : String = s"$name what the heck"

    def isAlive : Boolean = true

    def apply() : String =s"Hi , my name is $name and I like $favoriteMovie"
  }


  val mary = new Person("mary", "inception")
  println(mary.likes("inception"))

  println(mary likes "inception")
  //1. infix notation = operator notation (syntactic sugar)

  // "operators"

  val tom = new Person("Tom", " Fight Club ")
  //operator like , you can rename it to '+' for example
  println(mary hangOutWith tom)

  println( 1+ 2)
  println( 1.+(2))

  //ALL operators are methods
  //Akka actors have ! ?

  //2. prefix notation

  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  //unary_ prefix only works with - + ~ !
  println(!mary)
  println(tom.unary_!)


  //3. postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //4. apply

  println(mary.apply())
  println(mary())


}

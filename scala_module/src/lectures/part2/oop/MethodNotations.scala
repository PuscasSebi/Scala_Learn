package lectures.part2.oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String,val age: Int = 0){
    def likes(movie: String) : Boolean = movie  == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging of with ${person.name}"

    def unary_! : String = s"$name what the heck"
    def unary_+ : Person =  new Person (name,favoriteMovie,age+1)
    def isAlive : Boolean = true

    def apply() : String =s"Hi, my name is $name and I like $favoriteMovie"
    def apply(times: Int) : String =s"$name watched $favoriteMovie $times times"

    def +(nickname: String) :Person = new Person(s"$name ($nickname)",favoriteMovie)



    def learns(entity: String) : String = s"$name learns $entity"

    def learnsScala = learns("Scala")
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

  //execises


  /*
  1. Overload + operator
  mary + "rock start" -> new Mary with new favorite movies
  2. Add age to person class
   add unary + operator incrementing age + 1

  3. add a "learns" method in the person class  Mary learns Scala
     add a learnsScala method , calls  learns method with "Scala"
     Use it in postfix notation

   4. Overload the apply method
      mary.apply(2) => " mary watched Inception 2 times"
   */
//1
  println( (mary +  "rockstart")())
  //2
  println((+mary).age)
  //3
  println( mary learns "math")
  println( mary learnsScala )
  //4
  println(mary.apply(2))
}

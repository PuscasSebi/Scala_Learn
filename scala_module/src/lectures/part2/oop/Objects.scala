package lectures.part2.oop

object Objects  {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  //equivalent for static is theose objects example:

  object Person{
    //static/class level funcitonality
    val N_EYES = 2
    def canFly : Boolean = false


    //factory method
    def apply (mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person (val name:String){
    // instance level functionality

  }

  //Scala applications == scala object with
  //def main (args: Array[String]): Unit

  def main( args: Array[String]): Unit = {

    //combining those two is called COMPANIONS

    println(Person.N_EYES)



    //Scala object is singleton instance by definition without any code

    var mary = Person
    var john = Person

    println(mary == john) // true


    var mary1 = new Person("mary")
    var john1 = new Person("john")

    println(mary1 == john1) // false

    val bobby = Person(mary1,john1)

    println(bobby.name)
  }

}

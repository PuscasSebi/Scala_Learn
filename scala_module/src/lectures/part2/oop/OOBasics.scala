package lectures.part2.oop

object OOBasics extends App {
  val person = new Person("John", 23)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

}

// constructor
class Person(name: String, val age: Int = 0) {
  //evaluate whole body on any instantiation of Person
  //body
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  //overload
  def greet(): Unit = println(s"hi , I am $name")

  //multiple constructors

  def this(name: String) = this(name, 0) //or use default params

  def this() = this("John Doe") //an alternative constructor can call just other constructor

}

//class params are NOT FIELDS  , they are fields if you write val before one


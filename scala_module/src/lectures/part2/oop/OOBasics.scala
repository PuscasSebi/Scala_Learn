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

/*
  Novel and a writer

 */

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = firstName + surname


}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge = yearOfRelease - author.year


  def isWrittenBy(author: Writer): Boolean = {
    return author.equals(this.author)
  }

  def copy(newyear: Int): Novel = {
     new Novel(this.name, newyear, this.author)
  }
}

class Counter(count: Int) {
  def currentCount(): Int = count // or val in constructor

  def increment(): Counter =  new Counter(this.count + 1)

  def increment(value: Int): Counter =  new Counter(this.count + value)

  def decrement(): Counter =  new Counter(this.count - 1)

  def decrement(value: Int): Counter =  new Counter(this.count - value)

  def incrementByOneManyXTimes(x: Int) :Counter = {
    if (x == 0) this
    else increment.incrementByOneManyXTimes(x-1)
  }
}
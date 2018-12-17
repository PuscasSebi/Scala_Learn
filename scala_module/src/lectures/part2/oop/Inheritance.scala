package lectures.part2.oop

object Inheritance extends App {


  class Animal {
    val creatureType = "whild"

    def eat = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name) //much specify directly constructors

  //overriding

  class Dog extends Animal {
    override val creatureType: String = "domestic"

    override def eat = {
      super.eat
      println("chunchChruns dog")
    }
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  class Tiger(override val creatureType: String) extends Animal {

    override def eat = println("tiger eat")
  }

  val tiger = new Tiger("wild and zoo like");
  tiger.eat

  //type substitution

  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat

  //overRiding vs overLoading

  //super

  // preventing overrides
      // 1. use final keyword before method
      // 2. use final on the entire class
      // 3. seal the class = extend the class in this file only and prevent extension on other files

}

package lectures.part2.oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine" //need override here

     override def eat: Unit = println("crunch crunch") // not really need override here
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal):Unit
    val preferredMeal : String = "fresh meat"
  }
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  var dog = new Dog
  val croc = new Crocodile()
  croc eat dog

  //traits vs abstract classes
  // 1 - traits do no have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits over abstract class if we speak about behaviours
        // abstract class over trait if we speak more about entities

  //Scala's type Hierarchy image in this package called  TYPE HIERARCHY


}

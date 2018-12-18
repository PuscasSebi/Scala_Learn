package lectures.part2.oop

object Generics extends App {

  class MyList[+A]{
    //use the type A inside class def
    def add[B>:A](element: B): MyList[B] = ??? //if I add a super type of A to the list than transform the list to match supertype
    /*
    A = CAT
    B = DOG

     */
  }

  // val myList : MyList[Animal] = new MyList[Animal] // odes not work without + before A
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[Key,Value]

  //generic methods

  object MyList {
    def empty[A] :MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  //todo important lesson here
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  //does a List[Cat] extends List[Animal] COVARIANCE ?

  class CovariantList[+A]
  val animal: Animal = new Cat
  //yes
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) can be used ?? USUALLY  NO but here we return a list of animals ! the supertype of both of them

  // 2. No you cannot add like this so you need INVARIANCE LIST
  class InvariantList[A]
  val invariantAnimalList : InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no ! Contravariance classes
  class ContravariantList[-A]
  val contravariantList : ContravariantList[Cat] = new ContravariantList[Animal]
  //not intuitive for list but for next example it is useful

  class Trainer[-A]
  val trainer : Trainer[Cat] = new Trainer[Animal]

  //bounded types

  class Cage[A <: Animal](animal: A) // accepts just class that extends Animal
  class Cage2[A >: Animal](animal: A) //accepts just a super class of Animal
 //generic types news proper bound
 // val cage = new Cage(new Dog)

  class Car

  // val newCage = new Cage(new Car) //invalid


}

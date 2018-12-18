package lectures.part2.oop

object AnonymousClasses extends App {

  abstract class Animal{
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("haha");
  }


  println(funnyAnimal.getClass) // anonymous class instantiation


  class Person (name: String){
    def sayHi : Unit = println(s"hi my name is $name")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = super.sayHi
  }
  jim.sayHi

  /*
  1. generic trait MyPredicate[T] with a test method => boolean
  2. generic trait MyTransformer[A,B] with method transform (A) = > B
  3. myList:
      -map (transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B] => myList[B]

     class EvenPredicate extends MyPredicate[Int]
     class StringToIntTransformer extends myTransformer[String,Int]

     [1, 2, 3].map(n*2) => 2,4,6
     1,2,3 .filter (n%2==0) => 2
     [1,2,3].flapMap(n => [n, n+1]) => [1,2, 2,3 ,3,4]
   */
}

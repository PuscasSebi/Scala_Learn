package lectures.part2.oop

 object CaseClasses extends App {

  /*
  equals hashCode , toString
   */
  case class Person(name: String, age:Int)

  //1.class params are promoted to fields using 'case' keyword
  val jim = Person("name",12);
  println(jim.name)

  //2. sensible toString

  println(jim)

  //3. equals and hashcode implemented OOTB
  val jim2 = new Person("name", 12);
  println(jim2 == jim)

  // 4. case classes have handy copy methods
  val jim3 = jim.copy(age = 45)

  // 5. case classes have companion objects
  val thePerson = Person

  val mary = Person("Mary",24)

  //6. CCs are serializable
  //Akka sending serializable messages throgth

  //7. CCS have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
   execise myList- use case classes and case objects
   */
}

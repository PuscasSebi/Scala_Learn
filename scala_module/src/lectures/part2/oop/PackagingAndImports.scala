package lectures.part2.oop

import java.sql

import playground.{Cinderella, PrinceCharming}
//or
import playground.{Cinderella, PrinceCharming => Princess}
//or
import playground._

import java.util.Date
import java.sql.{Date => SqlDate}


object PackagingAndImports extends App {

  val princess = new Cinderella
  val princess2 = new Princess

  //classes import as in java

  //package object oop

  // imports
//use fully qualified name
  //use aliasing rename imports
  val prince = new PrinceCharming

  val date = new Date

}

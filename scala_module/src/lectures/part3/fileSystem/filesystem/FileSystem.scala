package lectures.part3.fileSystem.filesystem

import java.util.Scanner

import lectures.part3.fileSystem.commands.Command
import lectures.part3.fileSystem.files.Directory

object FileSystem extends App {

  val root = Directory.ROOT
  //at the end will show how to change var with val  , doing some functional programmingmkdi
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while (true) {
    state show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)

  }

}

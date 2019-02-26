package lectures.part3.fileSystem.commands

import lectures.part3.fileSystem.files.{DirEntry, Directory}
import lectures.part3.fileSystem.filesystem.State

import scala.annotation.tailrec

class Cd(dir: String) extends Command {

  override def apply(state: State): State = {
    /*
    cd /something/s/d
    cd a/b/c = relative path to curent working directory

    future
    cd ..
    cd .
    cd a/./../a
     */
    //1 find root

    val root = state.root
    val wd = state.wd

    //2 find the absolute path

    val absolutePath = if (dir.startsWith(Directory.SEPARATOR)) dir else if (wd.isRoot) wd.path + dir
    else wd.path + Directory.SEPARATOR + dir


    //3 find the directory to cd to

    val destinationDirectory = doFindEntry(root, absolutePath)

    //4 change the state of the new directory
    if (destinationDirectory == null || !destinationDirectory.isDirectory) {
      state.setMessage(dir + ": no such directory")
    } else {
      State(root, destinationDirectory.asDirectory, "")
    }
  }


  def doFindEntry(root: Directory, path: String): DirEntry = {

    @tailrec
    def findEntryHelper(currentDir: Directory, path: List[String]): DirEntry = {
      if (path.isEmpty || path.head.isEmpty) currentDir
      else if (path.tail.isEmpty) currentDir.findEntry(path.head)
      else {
        val nextDir = currentDir.findEntry(path.head)
        if (nextDir == null || nextDir.isFile) null
        else findEntryHelper(nextDir.asDirectory, path.tail)
      }

    }

    // 1.tokens
    val tokens: List[String] = path.substring(1).split(Directory.SEPARATOR).toList

    // 2. navigate to the correct entry

    findEntryHelper(root, tokens);
  }
}

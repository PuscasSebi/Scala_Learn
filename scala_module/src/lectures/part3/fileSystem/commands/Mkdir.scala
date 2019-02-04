package lectures.part3.fileSystem.commands

import lectures.part3.fileSystem.files.{DirEntry, Directory}
import lectures.part3.fileSystem.filesystem.State

class Mkdir(name: String) extends Command {


  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists")
    } else if (name.contains(Directory.SEPARATOR)) {
      //no not allow mkdir something/something
      state.setMessage(name + " must not contain separators")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ":illegal entry name")
    } else {
      doMkdir(state, name)
    }
  }

  def checkIllegal(str: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, name: String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      /*
      someDir
        /a
        /b
         (new) /d
      => new someDir
            /a
            /b
            /d
       */
      if(path.isEmpty){
        currentDirectory.addEntry(newEntry)
      }else{
        // /a/b
        //   /c
        //   /d
        //   (new entry)
        /*current directory = /a
        path =["b"]
        */
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name,updateStructure(oldEntry,path.tail,newEntry))

        /*
          /a/b
              (contents)
              (new entry) /e

          updateStructure(root, ["a","b], /e)
              -> path.isEmpty
              -> oldEntry = /a
              root.replaceEntry("a", updateStructure(/a,["b"],/e)
              -> path.isEmpty
              -> oldEntry = /b
               /a.replaceEntry("b", updateStructure(/b,[], /e)
               -> path.isEmpty -> /b.add(/e)
         */


      }
    }

    val wd = state.wd

    val fullPath = wd.path

    //1. get all the directories in the fullPath
    val allDirsInPath = wd.getAllFoldersInPath

    //2. update new structure with new directory entry in the wd
    val newDirectory = Directory.empty(wd.path, name)

    //3. update the whole directory structure starting from the root
    // the directory structure is IMMUTABLE
    val newRoot = updateStructure(state.root, allDirsInPath, newDirectory)

    //4. find new working directory INSTANCE given wd's full path, in the NEW directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)

  }

}

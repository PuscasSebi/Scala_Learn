package lectures.part3.fileSystem.commands

import lectures.part3.fileSystem.files.Directory
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
    }else{
      doMkdir(state,name)
    }
  }

  def checkIllegal(str: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, name: String): State = ???

}

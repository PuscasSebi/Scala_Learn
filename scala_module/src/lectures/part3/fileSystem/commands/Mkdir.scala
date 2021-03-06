package lectures.part3.fileSystem.commands
import lectures.part3.fileSystem.files.{DirEntry, Directory}
import lectures.part3.fileSystem.filesystem.State

class Mkdir(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry = {
    Directory.empty(state.wd.path,name)
  }

}

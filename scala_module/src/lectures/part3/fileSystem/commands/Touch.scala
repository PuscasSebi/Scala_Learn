package lectures.part3.fileSystem.commands

import lectures.part3.fileSystem.files.{DirEntry, File}
import lectures.part3.fileSystem.filesystem.State

class Touch(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry = {
    File.empty(state.wd.path, name)
  }

}

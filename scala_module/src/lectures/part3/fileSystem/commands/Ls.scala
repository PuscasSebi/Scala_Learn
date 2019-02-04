package lectures.part3.fileSystem.commands

import lectures.part3.fileSystem.files.DirEntry
import lectures.part3.fileSystem.filesystem.State

class Ls extends Command {

  override def apply(state: State): State = {
    val wdContents = state.wd.contents
    val niceOutput = createNiceOutput(wdContents);
    state.setMessage(niceOutput)
  }


  def createNiceOutput(wdContents: List[DirEntry]): String = {
    if (wdContents.isEmpty) ""
    else {
      val entry = wdContents.head
      entry.name + "[" + entry.getType + "]" + "\n" + createNiceOutput(wdContents.tail)
    }
  }

}

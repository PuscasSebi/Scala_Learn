package lectures.part3.fileSystem.commands
import lectures.part3.fileSystem.filesystem.State

class Pwd extends Command {
  override def apply(state: State): State = {
    state.setMessage(state.wd.path)
  }
}

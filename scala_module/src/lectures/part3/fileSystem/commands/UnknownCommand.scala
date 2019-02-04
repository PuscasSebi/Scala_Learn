package lectures.part3.fileSystem.commands

import lectures.part3.fileSystem.filesystem.State

class UnknownCommand extends Command {
  override def apply(state: State): State = {
    state.setMessage("Command not found")
  }
}

package lectures.part3.fileSystem.commands
import lectures.part3.fileSystem.filesystem.State
trait Command {
  def apply(state: State) : State

}


object Command {
  def from(input: String): Command =
    new UnknownCommand
}
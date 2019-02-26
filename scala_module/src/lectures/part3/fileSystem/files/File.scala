package lectures.part3.fileSystem.files

import lectures.part3.fileSystem.filesystem.FilesystemException

class File(override val parentPath: String, override val name: String, contents: String) extends DirEntry(parentPath, name) {
  override def path: String = super.path

  override def asDirectory: Directory = throw new FilesystemException("A file cannot be converted to a directory")

  override def getType: String = "File"

  override def asFile: File = this
}

object File {

  def empty(parentPath: String, name: String): File =
    new File(parentPath, name, "")
}
package lectures.part3.fileSystem.files

abstract class DirEntry(val parentPath: String, val name: String) {
  def path: String = {
    var separatorIfnecessary = if (Directory.SEPARATOR.equals(parentPath)) ""
    else Directory.SEPARATOR

    parentPath + separatorIfnecessary + name
  }

  def asDirectory: Directory

  def asFile: File

  def getType: String

  def isDirectory: Boolean

  def isFile: Boolean
}

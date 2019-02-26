package lectures.part3.fileSystem.files

import lectures.part3.fileSystem.filesystem.FilesystemException

import scala.annotation.tailrec

class Directory(override val parentPath: String, override val name: String, val contents: List[DirEntry])
  extends DirEntry(parentPath, name) {
  def replaceEntry(entryName: String, newEntry: DirEntry): Directory = new Directory(parentPath, name, contents.filter(e => {
    !e.name.equals(entryName)
  }) :+ newEntry)

  def findEntry(entryName: String): DirEntry = {
    @tailrec
    def findEntryHelper(name: String, contentList: List[DirEntry]): DirEntry = {
      if (contentList.isEmpty) null
      else if (contentList.head.name.equals(name)) contentList.head
      else findEntryHelper(name, contentList.tail)
    }

    findEntryHelper(entryName, contents)
  }

  def isRoot : Boolean = parentPath.isEmpty

  def addEntry(newEntry: DirEntry): Directory = new Directory(parentPath, name, contents :+ newEntry)

  def hasEntry(name: String): Boolean = findEntry(name) != null

  def findDescendant(path: List[String]): Directory = {
    if (path.isEmpty) this
    else findEntry(path.head).asDirectory.findDescendant(path.tail)
  }

  def getAllFoldersInPath: List[String] = {
    // /a/b/d -> List["a","b","c"]
    path.substring(1).split(Directory.SEPARATOR).toList.filter(e => !e.isEmpty)
  }

  override def asDirectory: Directory = this

  override def getType: String = "Directory"

  override def asFile: File = throw new FilesystemException("cannot convert directory to file")

  override def isDirectory: Boolean = true

  override def isFile: Boolean = false
}

object Directory {
  val SEPARATOR = "/"
  val ROOT_PATH = "/"

  def ROOT: Directory = Directory.empty("", "")

  def empty(parentPath: String, name: String): Directory =
    new Directory(parentPath, name, List())


}
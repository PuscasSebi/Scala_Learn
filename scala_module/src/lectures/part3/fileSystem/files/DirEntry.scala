package lectures.part3.fileSystem.files

abstract class DirEntry(val parentPath:String, val name: String) {
      def path: String = parentPath + Directory.SEPARATOR + name

      def asDirectory : Directory

      def asFile : File

      def getType : String
}

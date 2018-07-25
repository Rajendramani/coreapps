import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class FileVisitor extends SimpleFileVisitor<Path> {
   public FileVisitResult visitFile(Path path, BasicFileAttributes 
                                    attributes) throws IOException {
      System.out.println(path);
      return FileVisitResult.CONTINUE;
   }
}

public class ShowDirTree {
   public static void main(String[] args) {
      String dir = args[0];
      System.out.println("Starting directory: " + dir + ": ");
      try {
         Files.walkFileTree(Paths.get(dir), new FileVisitor());
      }
      catch (IOException e) {
         System.out.println("Error walking directory tree.");
      }
   }
}
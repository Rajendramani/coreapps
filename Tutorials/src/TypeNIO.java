import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class TypeNIO {
   public static void main(String[] args) throws IOException {
      int count;
      File sourceFile = new File(args[0]);
      FileChannel sourceChannel = new FileInputStream(sourceFile).
                                     getChannel();
      try {
         ByteBuffer buffer = ByteBuffer.allocate(1024);
         do {
            count = sourceChannel.read(buffer);
            if (count != -1) {
               buffer.rewind();
               for (int i = 0; i < count; ++i) {
                  System.out.print((char)buffer.get());
               }
            }
         } while (count != -1);
      }
      catch (IOException e) {
         System.out.println("Error reading file.");
      }
   }
}
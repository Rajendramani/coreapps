import java.io.*;
import java.util.*;

public class Type {
   public static void main(String[] args) {
      String file = args[0];
      String line = "";
      try {
         BufferedReader inFile = new BufferedReader(new FileReader(file));
         while ((line = inFile.readLine()) != null) {
            System.out.println(line);
         }
      }
      catch (FileNotFoundException e) {
         System.out.print("File not found. Try again.");
      }
      catch (IOException e) {
         System.out.print("Problem reading file.");
      }  
      finally {
         if (inFile != null) {
            try {
               inFile.close();
            }
            catch (IOException e) {
               System.out.println("Problem with file.");
            }
         }
      }
   }
}
import java.io.*;
import java.util.*;

public class StringConcat {
   public static void main(String[] args) {
      BufferedReader input;
      String word, words;
      word = words = "";
      String file = "c:\\data\\animals1.txt";
      long startTime, stopTime, duration;
      startTime = stopTime = duration = 0;
      try {
         input = new BufferedReader(new FileReader(file));
         startTime = System.nanoTime();
         while ((word = input.readLine()) != null) {
            words += word + ",";
         }
         stopTime = System.nanoTime();
         duration = stopTime - startTime;
      }
      catch (IOException e) {
         System.out.println(e.toString());
      }
      System.out.println("Time to concatenate: " + duration);
      startTime = stopTime = duration = 0;
      StringBuilder sbWords = new StringBuilder();
      try {
         input = new BufferedReader(new FileReader(file));
         startTime = System.nanoTime();
         while ((word = input.readLine()) != null) {
            sbWords.append(word + ",");
         }
         stopTime = System.nanoTime();
         duration = stopTime - startTime;
      }
      catch (IOException e) {
         System.out.println(e.toString());
      }
      System.out.println("Time to append: " + duration);
   }
}
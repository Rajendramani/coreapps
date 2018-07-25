// metacharacters - \w \d \s
import java.util.regex.*;

public class RegEx2 {
   public static void main(String[] args) {
      String words = "90 percent effort 100 percent of the time";
      // String patt = "\\w+";
      //String patt = "\\d+";
      String patt = "\\s";
      Pattern pattern = Pattern.compile(patt);
      Matcher match = pattern.matcher(words);
      System.out.println(words);
      /*while (match.find()) {
         System.out.println("Found " + patt + " at: " + match.start());
         System.out.println("Match: " + match.group());
      }*/
      int count = 0;
      while (match.find()) {
         ++count;
      }
      System.out.println("Total spaces = " + count);
   }
}
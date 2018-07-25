import java.util.regex.*;

public class RegEx3 {
   public static void main(String[] args) {
      String names = "Mike McMillian Terri McMillen Allison McMillin ";
      String patt = "McM.*? ";
      Pattern pattern = Pattern.compile(patt);
      Matcher match = pattern.matcher(names);
      System.out.println(names);
      names = match.replaceAll("McMillan ");
      System.out.println(names);
   }
}
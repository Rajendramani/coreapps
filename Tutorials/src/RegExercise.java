import java.util.regex.*;
import java.util.*;

public class RegExercise {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a date: ");
      String number = input.next();
      //String patt = "^\\d{3}$";
      // 999-999-9999
      //String patt = "^[2-9]\\d{2}-\\d{3}-\\d{4}$";
      String patt = 
         "^(0[1-9]|1[012])/(0[1-9]|[1-2][0-9]|3[01])/(19|20)\\d\\d$";
      Pattern pattern = Pattern.compile(patt);
      Matcher match = pattern.matcher(number);
      if (match.find()) {
         System.out.println("Date is in legal format.");
      } else {
         System.out.println("Date is not in legal format.");
      }
   }
}
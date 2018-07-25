import java.util.HashMap;

public class Grades {
   public static void main(String[] args) {
      HashMap<String,Integer> grades = new HashMap<String,Integer>();
      grades.put("Smith", 88);
      grades.put("Brown", 100);
      grades.put("Jones", 77);
      grades.put("Green", 90);
      System.out.println("Smith's grade: " + grades.get("Smith"));
      System.out.println("Size of grades: " + grades.size());
      if (grades.containsKey("Brown")) {
         grades.remove("Brown");
         System.out.println("Record successfully removed.");
      }
      System.out.println("Size of grades: " + grades.size());
   }
}
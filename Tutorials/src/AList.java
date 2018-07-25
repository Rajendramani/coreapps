import java.util.ArrayList;

public class AList {
   public static void main(String[] args) {
      ArrayList<Integer> grades =  new ArrayList<Integer>();
      grades.add(100);
      grades.add(90);
      grades.add(80);
      grades.add(70);
      grades.add(60);
      int total = 0;
      /*for(int i = 0; i < grades.size(); ++i) {
         total += grades.get(i);
      }*/
      for (Integer grade : grades) {
         total += grade;
      }
      double average = total / grades.size();
      System.out.println("Size of grades: " + grades.size());
      System.out.println("Average: " + average);
      grades.remove(4);
      System.out.println("New size: " + grades.size());
      grades.add(60);
      grades.add(50);
      System.out.println("Newer size: " + grades.size());
   }
}
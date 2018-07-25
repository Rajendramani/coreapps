import java.util.*;

public class Grammar {
   public static void main(String[] args) {
      String[] dets = new String[]{"A","The","An","Some"};
      String[] adjs = new String[]{"green","ugly","small","huge"};
      String[] nouns = new String[]{"frog","monster","king","alien"};
      String[] verbs = new String[]{"sings","sits","stands","dances"};
      StringBuilder sentence = new StringBuilder();
      Random randNum = new Random();
      for (int i = 0; i < 4; ++i) {
         int rnum = randNum.nextInt(3)+1;
         sentence.append(dets[rnum] + " ");
         rnum = randNum.nextInt(3)+1;
         sentence.append(adjs[rnum] + " ");
         rnum = randNum.nextInt(3)+1;
         sentence.append(nouns[rnum] + " ");
         rnum = randNum.nextInt(3)+1;
         sentence.append(verbs[rnum] + " ");
         System.out.println(sentence.toString());
         sentence = new StringBuilder();
      }
   }
}
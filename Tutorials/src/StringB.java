public class StringB {
   public static void main(String[] args) {
      //StringBuilder sentence = new StringBuilder();
      StringBuilder sentence = new StringBuilder("now the time");
      System.out.println(sentence.toString());
      sentence.insert(4,"is ");
      System.out.println(sentence.toString());
      System.out.println("the is found at pos: " + 
         sentence.indexOf("the"));
      sentence.delete(4,6);
      System.out.println(sentence.toString());
      sentence.deleteCharAt(3);
      System.out.println(sentence.toString());
      sentence.reverse();
      System.out.println(sentence.toString());
   }
}
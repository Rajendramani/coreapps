public class Square {
   static double guess = 1;
   
   static double square(double x) {
      return x * x;
   }

   static double average(double x, double y) {
      return (x + y) / 2;
   }

   static double improve(double guess, double x) {
      return (average(guess, x/guess));
   }

   static boolean goodEnough(double guess, double x, double precision) {
      return (Math.abs(square(guess) - x) < precision);
   }

   static double sqrt(double x, double precision) {
      if (!(goodEnough(guess, x, precision))) {
         guess = improve(guess, x);
         sqrt(x, precision);
      }
      return guess;
   }

   public static void main(String[] args) {
      int num = 9;
      System.out.println(sqrt(num, .001));
   }
}
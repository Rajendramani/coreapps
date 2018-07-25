public class BubbleSort {

   public static void bubbleSort(int[] arr) {
      int size = arr.length;
      for (int pass = 1; pass < size; pass++) {
         for (int i = 0; i < size-pass; i++) {
            if (arr[i] > arr[i+1]) {
               int temp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = temp;
            }
         }
      }
   }
            
   public static void main(String[] args) {
      int size = 10;
      int[] data = new int[size];
      for(int i = 0; i < size; ++i) {
         data[i] = (int)(Math.random() * 100);
      }
      System.out.println("Before sorting: ");
      for(int i = 0; i < size; ++i) {
         System.out.println(data[i]);
      }
      /*
      for(int i = 0; i < size; ++i) {
         for(int j = i; j > 0; --j) {
            if (data[j-1] > data[j]) {
               int temp = data[j];
               data[j] = data[j-1];
               data[j-1] = temp;
            }
         }
      }
      */
      bubbleSort(data);
      System.out.println();
      System.out.println("After sorting: ");
      for(int i = 0; i < size; ++i) {
         System.out.println(data[i]);
      }
   }
}
class Market {
   int n;
   synchronized int get() {
      System.out.println("Got: " + n);
      return n;
   }

   synchronized void put(int n) {
      this.n = n;
      System.out.println("Put: " + n);
   }
}

class Producer implements Runnable {
   Market m;
   
   public Producer(Market m) {
      this.m = m;
      new Thread(this, "Producer").start();
   }

   public void run() {
      int i = 0;
      while (true) {
         m.put(i++);
      }
   }
}

class Consumer implements Runnable {
   Market m;

   public Consumer(Market m) {
      this.m = m;
      new Thread(this,"Consumer").start();
   }

   public void run() {
      while (true) {
         m.get();
      }
   }
}

class PandC {
   public static void main(String[] args) {
      Market m = new Market();
      new Producer(m);
      new Consumer(m);
      System.out.println("Stop by pressing Ctrl-C");
   }
}
      
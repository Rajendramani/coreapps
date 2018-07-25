import javax.swing.*;

public class SwingExample {
   SwingExample() {
      JFrame frame = new JFrame("Hello, World! Application");
      frame.setSize(350,150);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabel label = new JLabel("Hello, world!");
      frame.add(label);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new SwingExample();
         }
      });
   }
}
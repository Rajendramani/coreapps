import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons {
   JLabel label;
   JTextField textField;
   JButton button;

   public Buttons() {
      label = new JLabel("");
      textField = new JTextField("Type text here");
      button = new JButton("Put text in label");
      JFrame frame = new JFrame("Using TextFields");
      frame.setLayout(new FlowLayout());
      frame.setSize(200,150);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            label.setText(textField.getText());
         }
      });
      textField.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            label.setText(textField.getText());
         }
      }); 
      frame.add(textField);
      frame.add(button);
      frame.add(label);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new Buttons();
         }
      });
   }
}  
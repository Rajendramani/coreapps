import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SPanes {
   JLabel label;
   JList list;
   JScrollPane spane;
   String[] nycsites;
   
   public SPanes() {
      label = new JLabel("");
      nycsites = new String[]{"Empire State Building", "Ground Zero",
                              "Statue of Liberty", "Wall Street",
                              "Central Park", "Times Square"};
      list = new JList(nycsites);
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      list.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent le) {
            int index = list.getSelectedIndex();
            if (index != -1) {
               label.setText("Site to visit: " + nycsites[index]);
            }
         }
      });
      spane = new JScrollPane(list);
      spane.setPreferredSize(new Dimension(120,90));
      JFrame frame = new JFrame("Using Lists");
      frame.setLayout(new FlowLayout());
      frame.setSize(500,250);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.add(list);
      frame.add(spane); // adds list to frame
      frame.add(label);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new SPanes();
         }
      });
   }
}
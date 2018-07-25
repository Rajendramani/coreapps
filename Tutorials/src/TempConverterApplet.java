import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="TempConverterApplet" width=300 height=200>
</applet>
*/

public class TempConverterApplet extends Applet {
   JLabel tempLabel, outLabel;
   JTextField textField;
   JButton button;
   String[] temps;
   JList list;
   int tempIndex;

   static double convert(int temp, String scale) {
      if (scale.equals("Celsius")) {
         return (temp - 32.0) * (5.0 / 9.0);
      }
      else {
         return temp * (9.0 / 5.0) + 32.0;
      }
   }

   public void init() {
      tempLabel = new JLabel("Temperature: ");
      outLabel = new JLabel("");
      textField = new JTextField(5);
      button = new JButton("Convert");
      temps = new String[]{"Celsius", "Fahrenheit"};
      list = new JList(temps);
      setLayout(new GridLayout(3,2));

      list.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent le) {
            tempIndex = list.getSelectedIndex();
         }
       });

      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            int temp = Integer.parseInt(textField.getText());
            String scale = temps[tempIndex];
            outLabel.setText(Double.toString(convert(temp, scale)));
         }
      });

      add(tempLabel);
      add(textField);
      add(list);
      add(button);
      add(outLabel);
      setVisible(true);
   }
}
   

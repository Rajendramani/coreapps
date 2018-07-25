import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;


public class GUIProgram 
{
	public static final int width = 640;
	public static final int height = 480;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					JFrameExample jfe = new JFrameExample();

					JPanelExample jpe = new JPanelExample();
					jfe.getContentPane().add(jpe);

					String name = JOptionPane.showInputDialog("Please enter your name: ");
					JOptionPane.showMessageDialog(null, "You entered the name: " + name);
					jpe.setTextFieldName(name);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
}

import java.awt.EventQueue;

import javax.swing.JFrame;


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
					/*
					JFrame jf = new JFrame();
					jf.setLocation(250,250);
					jf.setSize(GUIProgram.width + 20, GUIProgram.height + 60);
					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.setTitle("My JFrame");
					jf.setBounds(0, 0, GUIProgram.width + 20, GUIProgram.height + 60);
					jf.setVisible(true);
					*/
					
					JFrameExample jfe = new JFrameExample();
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
}

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BorderLayoutExample extends JFrame
{

	public BorderLayoutExample()
	{
		//create a panel
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JButton n = new JButton("Top");
		JButton e = new JButton("Right");
		JButton s = new JButton("Bottom");
		JButton w = new JButton("Left");
		JButton c = new JButton("Center");
		
		jp.add(n, BorderLayout.NORTH);
		jp.add(e, BorderLayout.EAST);
		jp.add(s, BorderLayout.SOUTH);
		jp.add(w, BorderLayout.WEST);
		jp.add(c, BorderLayout.CENTER);
		
		this.getContentPane().add(jp);

		this.setLocation(250,250);
    	this.setSize(GUIProgram.width+20,GUIProgram.height+60);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setTitle("Border Layout");
    	this.setBounds(0, 0, GUIProgram.width+20,GUIProgram.height+60);
    	this.setVisible(true);
		
	}
}

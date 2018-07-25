import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FlowLayoutExample extends JFrame
{
	public FlowLayoutExample()
	{
		//create a panel
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		JButton n = new JButton("Top");
		JButton e = new JButton("Right");
		JButton s = new JButton("Bottom");
		JButton w = new JButton("Left");
		JButton c = new JButton("Center");
		
		jp.add(n);
		jp.add(e);
		jp.add(s);
		jp.add(w);
		jp.add(c);
		
		this.getContentPane().add(jp);
		this.setLocation(250,250);
		this.setSize(GUIProgram.width+20,GUIProgram.height+60);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Flow Layout");
		this.setBounds(0, 0, GUIProgram.width+20,GUIProgram.height+60);
		this.setVisible(true);
	}
}

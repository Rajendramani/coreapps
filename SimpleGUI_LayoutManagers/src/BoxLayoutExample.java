import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BoxLayoutExample extends JFrame
{
	public BoxLayoutExample()
	{
		//create a panel
		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		JButton n = new JButton("One");
		n.setAlignmentX(Component.LEFT_ALIGNMENT);
		JButton e = new JButton("Two");
		e.setAlignmentX(Component.RIGHT_ALIGNMENT);
		JButton s = new JButton("Three");
		s.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton w = new JButton("Four");
		w.setAlignmentX(Component.TOP_ALIGNMENT);
		JButton c = new JButton("Five");
		c.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		
		jp.add(n);
		jp.add(e);
		jp.add(s);
		jp.add(w);
		jp.add(c);
		
		this.getContentPane().add(jp);
	
		this.setLocation(250,250);
		this.setSize(GUIProgram.width+20,GUIProgram.height+60);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Box Layout");
		this.setBounds(0, 0, GUIProgram.width+20,GUIProgram.height+60);
		this.setVisible(true);
	}
}

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GridLayoutExample extends JFrame
{
	public GridLayoutExample()
	{
		//create a panel
		JPanel jp = new JPanel();
		GridLayout gl = new GridLayout(3,3);
		jp.setLayout(gl);
		JButton one = new JButton("1");
		JButton two = new JButton("2");
		JButton three = new JButton("3");
		JButton four = new JButton("4");
		JButton five = new JButton("5");
		JButton six = new JButton("6");
		JButton seven = new JButton("7");
		JButton eight = new JButton("8");
		JButton nine = new JButton("9");
		jp.add(one);
		jp.add(two);
		jp.add(three);
		jp.add(four);
		jp.add(five);
		jp.add(six);
		jp.add(seven);
		jp.add(eight);
		jp.add(nine);
		
		
		this.getContentPane().add(jp);
		this.setLocation(250,250);
		this.setSize(GUIProgram.width+20,GUIProgram.height+60);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Grid Layout");
		this.setBounds(0, 0, GUIProgram.width+20,GUIProgram.height+60);
		this.setVisible(true);
	}
}

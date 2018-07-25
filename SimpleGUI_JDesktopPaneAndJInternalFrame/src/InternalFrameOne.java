import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class InternalFrameOne extends JInternalFrame
{
	public InternalFrameOne()
	{
		SetupForm();
		
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
	}
	
	private void SetupForm()
    {
        setBackground(Color.WHITE);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        
        //pack and show:
        pack();
        setVisible(true);
    }
}

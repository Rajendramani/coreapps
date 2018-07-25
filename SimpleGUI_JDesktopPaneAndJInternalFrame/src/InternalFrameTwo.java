import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class InternalFrameTwo extends JInternalFrame
{

	public InternalFrameTwo()
	{
		SetupForm();
		
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

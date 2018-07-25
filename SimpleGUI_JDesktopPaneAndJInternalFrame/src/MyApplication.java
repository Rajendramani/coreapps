import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class MyApplication extends JFrame
{

	private JDesktopPane dp;
	private JInternalFrame jif1;
	private JInternalFrame jif2;
	
	public MyApplication()
	{
		dp = new JDesktopPane();
		this.getContentPane().add(dp);
		
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		
		JMenu mnuFile = new JMenu("File");
		jmb.add(mnuFile);
		
		//add an exit item with no frame
		JMenuItem mnuItemExit = new JMenuItem("Exit");
		mnuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //exit
                int close = JOptionPane.showConfirmDialog(null
                                , "Are you sure you want to exit?"
                                , "End Application?"
                                , JOptionPane.YES_NO_OPTION
                                , JOptionPane.INFORMATION_MESSAGE);
                if (close == 1) return;
                System.exit(0);
            }
        });
		mnuFile.add(mnuItemExit);
		
		JMenu mnitemIFs = new JMenu("Internal Frames");
        jmb.add(mnitemIFs);
        
        //add the two menu items
        JMenuItem mnuJIFOne = new JMenuItem("Frame One");
        mnuJIFOne.addActionListener(new ActionListener()
        {

			public void actionPerformed(ActionEvent arg0) {
				jif1 = new InternalFrameOne();
				jif1.setBounds(0, 0, GUIProgram.width, GUIProgram.height);
				dp.add(jif1);
			}
        	
        });
        mnitemIFs.add(mnuJIFOne);
        
        JMenuItem mnuJIFTwo = new JMenuItem("Frame Two");
        mnuJIFTwo.addActionListener(new ActionListener()
        {

			public void actionPerformed(ActionEvent arg0) {
				jif2 = new InternalFrameTwo();
				jif2.setBounds(0, 0, GUIProgram.width, GUIProgram.height);
				dp.add(jif2);
			}
        	
        });
        mnitemIFs.add(mnuJIFTwo);
	}
}

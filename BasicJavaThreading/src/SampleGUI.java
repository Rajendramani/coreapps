import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SampleGUI extends JFrame
{
	private JPanel contentPane;
	private SimpleThreadingSample simpleThreadingSample;
	
	public SampleGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 23, 644, 479);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
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
		menu.add(menuItem);
		
		JMenu mnSamples = new JMenu("Samples");
		menuBar.add(mnSamples);
		
		JMenuItem mntmSimpleThreadingSample = new JMenuItem("Simple Threading Sample");
		mntmSimpleThreadingSample.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//show the form to add A Racer
				simpleThreadingSample = new SimpleThreadingSample();
				desktopPane.add(simpleThreadingSample);
			}
		});
		mnSamples.add(mntmSimpleThreadingSample);
	}
}

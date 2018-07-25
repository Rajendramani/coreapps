import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ProcessCounterGUI extends JFrame {
	private static JTextField txtExecutionCount;
	private static JTextArea txtMessages;
	private JScrollPane messageBlock;
	private DataServer ds = null;
	private ProcessOnOldEquipment pOld;
	private ProcessOnNewEquipment pNew;
	
	public ProcessCounterGUI() {
		getContentPane().setLayout(null);

		txtMessages = new JTextArea(10,35);
		txtMessages.setEditable(false);
		txtMessages.setLineWrap(true);
		messageBlock = new JScrollPane(txtMessages);
		messageBlock.setBounds(40, 83, 389, 222);
		messageBlock.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(messageBlock);
		
		JLabel lblMessages = new JLabel("Messages");
		lblMessages.setBounds(36, 58, 90, 14);
		getContentPane().add(lblMessages);
		
		JLabel lblCurrentExecutionCount = new JLabel("Current Execution Count:");
		lblCurrentExecutionCount.setBounds(36, 23, 170, 14);
		getContentPane().add(lblCurrentExecutionCount);
		
		txtExecutionCount = new JTextField();
		txtExecutionCount.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExecutionCount.setText("0");
		txtExecutionCount.setEditable(false);
		txtExecutionCount.setBounds(207, 20, 86, 20);
		getContentPane().add(txtExecutionCount);
		txtExecutionCount.setColumns(10);
		
		JButton btnNewButton = new JButton("Unsynchronized");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runUnSynchronizedDataServer();
			}
		});
		btnNewButton.setBounds(60, 341, 120, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnSynchronized = new JButton("Synchronized");
		btnSynchronized.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runSynchronizedDataServer();
			}
		});
		btnSynchronized.setBounds(287, 341, 120, 23);
		getContentPane().add(btnSynchronized);
	}
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					ProcessCounterGUI frame = new ProcessCounterGUI();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100,100,500,450);
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	private void runSynchronizedDataServer()
	{
		clearForm();
		ds = new SynchronizedDataServer();
		pOld = new ProcessOnOldEquipment(ds);
		pNew = new ProcessOnNewEquipment(ds);
		//whichever thread goes first is greedy
		//start new second to see it lose to old every time
		pNew.start();
		Thread t = new Thread(pOld);
		t.start();
		//pNew.start();
	}
	
	private void runUnSynchronizedDataServer()
	{
		clearForm();
		ds = new NonSynchronizedDataServer();
		pOld = new ProcessOnOldEquipment(ds);
		pNew = new ProcessOnNewEquipment(ds);
		Thread t = new Thread(pOld);
		t.start();
		pNew.start();
	}
	
	public static void setExecutionText(String count)
	{
		txtExecutionCount.setText(count);
	}
	
	public static void addMessage(String msg)
	{
		txtMessages.append(msg + "\n");
	}
	
	private static void clearForm()
	{
		txtExecutionCount.setText("0");
		txtMessages.setText("");
	}
}

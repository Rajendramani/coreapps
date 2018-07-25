import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SimpleThreadingSample extends BaseInternalFrame {
	private JButton btnRunWithoutThread;
	private JButton btnRunWithThread;
	private JButton btnShowTheNext;
	private JTextArea txtWithoutThread;
	public static JTextArea txtWithThread;
	private int currentMessageIndex;
	private static ArrayList<String> messages;
	private JTextArea txtMessageDisplay;
	
	public SimpleThreadingSample() {
		super();
		setBounds(10, 10, 498, 471);
		getContentPane().setLayout(null);
		messages = new ArrayList<String>();
		populateMessages();
		
		btnRunWithoutThread = new JButton("Run Without Thread");
		btnRunWithoutThread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GregorianCalendar gc = new GregorianCalendar();
					txtWithoutThread.setText("Button Pressed at: " + "\n" + getCalendarToString(gc));
					
					Thread.sleep(5000);
					
					gc = new GregorianCalendar();
					txtWithoutThread.setText("Button Action Completed at: " + "\n"  + getCalendarToString(gc));
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnRunWithoutThread.setBounds(254, 26, 204, 23);
		getContentPane().add(btnRunWithoutThread);
		
		btnRunWithThread = new JButton("Run With Thread");
		btnRunWithThread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportantProcess myIP = new ImportantProcess();
		        Thread t = new Thread(myIP);
		        t.start();
			}
		});
		btnRunWithThread.setBounds(254, 105, 204, 23);
		getContentPane().add(btnRunWithThread);
		
		btnShowTheNext = new JButton("Show the Next Message");
		btnShowTheNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = messages.get(currentMessageIndex);
				currentMessageIndex++;
				if (currentMessageIndex == 5) currentMessageIndex = 0;
				txtMessageDisplay.setText(message);
			}
		});
		btnShowTheNext.setBounds(254, 396, 204, 23);
		getContentPane().add(btnShowTheNext);
		
		txtWithoutThread = new JTextArea();
		txtWithoutThread.setLineWrap(true);
		txtWithoutThread.setColumns(35);
		txtWithoutThread.setRows(5);
		txtWithoutThread.setBounds(24, 25, 220, 66);
		getContentPane().add(txtWithoutThread);
		
		txtWithThread = new JTextArea();
		txtWithThread.setLineWrap(true);
		txtWithThread.setColumns(35);
		txtWithThread.setRows(5);
		txtWithThread.setBounds(24, 104, 220, 66);
		getContentPane().add(txtWithThread);
		
		txtMessageDisplay = new JTextArea();
		txtMessageDisplay.setLineWrap(true);
		txtMessageDisplay.setBounds(24, 214, 434, 171);
		getContentPane().add(txtMessageDisplay);
	}
	
	public static String getCalendarToString(GregorianCalendar gc)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(gc.get(Calendar.YEAR));
		sb.append("/");
		sb.append(gc.get(Calendar.MONTH) + 1);
		sb.append("/");
		sb.append(gc.get(Calendar.DAY_OF_MONTH));
		sb.append(" ");
		sb.append(gc.get(Calendar.HOUR));
		sb.append(":");
		sb.append(gc.get(Calendar.MINUTE)); 
		sb.append(":");
		sb.append(gc.get(Calendar.SECOND));
		sb.append(":"); 
		sb.append(gc.get(Calendar.MILLISECOND));
		return sb.toString();
	}
	
	private static void populateMessages()
	{
		messages.add("This is message one");
		messages.add("This is message two");
		messages.add("This is message three");
		messages.add("This is message four");
		messages.add("This is message five");
	}
}

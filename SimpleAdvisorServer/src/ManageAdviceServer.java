import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ManageAdviceServer extends JFrame
{
	public static JTextArea serverLogs;
	private JScrollPane messageScroller;
	AdviceServer s;
	Thread processThread;
	private JTextField txtPort;
	
	public ManageAdviceServer() 
	{
		getContentPane().setLayout(null);
		
		serverLogs = new JTextArea(10,35);
		serverLogs.setEditable(false);
		serverLogs.setLineWrap(true);
		
		messageScroller = new JScrollPane(serverLogs);
		messageScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		messageScroller.setBounds(23, 85, 422, 189);
		getContentPane().add(messageScroller);
		
		JLabel lblServerActions = new JLabel("Server Actions");
		lblServerActions.setBounds(25, 60, 158, 14);
		getContentPane().add(lblServerActions);
		
		JButton btnStartServer = new JButton("Start");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					startServer();
				} catch (IOException e) {
					serverLogs.append("ERROR: " + e.toString());
				}
			}
		});
		btnStartServer.setBounds(369, 374, 89, 23);
		getContentPane().add(btnStartServer);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearMessages();
			}
		});
		btnClear.setBounds(20, 374, 89, 23);
		getContentPane().add(btnClear);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopServer();
			}
		});
		btnStop.setBounds(247, 374, 89, 23);
		getContentPane().add(btnStop);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(23, 11, 158, 14);
		getContentPane().add(lblPort);
		
		txtPort = new JTextField();
		txtPort.setText("8080");
		txtPort.setBounds(23, 29, 86, 20);
		getContentPane().add(txtPort);
		txtPort.setColumns(10);
	}
	
	private void startServer() throws IOException
	{
		serverLogs.setText("Starting Server...\n");
		AdviceServer s = new AdviceServer(Integer.parseInt(txtPort.getText()));
		processThread = new Thread(s);
		processThread.start();
		serverLogs.append("Server thread is running...\n");
	}
	
	private void stopServer()
	{
		//just quit the program
		System.exit(0);
	}
	
	private void clearMessages()
	{
		//clear log
		serverLogs.setText("");
		serverLogs.append("Server thread is running...\n");
	}
}
	

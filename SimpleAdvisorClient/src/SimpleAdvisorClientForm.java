import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleAdvisorClientForm extends JFrame
{
	private JTextField txtServer;
	private JTextField txtPort;
	private JTextField txtClientMessage;
	private JTextArea txtServerMessages;
	private JTextArea txtLogs;
	private JScrollPane messageScroller;
	private JScrollPane messageScroller1;
	private BufferedReader in;
	private PrintWriter out;
	
	public SimpleAdvisorClientForm() {
		getContentPane().setLayout(null);
		
		txtServer = new JTextField();
		txtServer.setText("localhost");
		txtServer.setBounds(23, 32, 200, 20);
		getContentPane().add(txtServer);
		txtServer.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Server");
		lblNewLabel.setBounds(23, 11, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtPort = new JTextField();
		txtPort.setText("8080");
		txtPort.setColumns(10);
		txtPort.setBounds(233, 32, 103, 20);
		getContentPane().add(txtPort);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(233, 11, 46, 14);
		getContentPane().add(lblPort);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					connectToServer();
				} catch (IOException e) {
					txtLogs.append(e.toString() + "\n");
					e.printStackTrace();
				}
			}
		});
		btnConnect.setBounds(349, 32, 116, 20);
		getContentPane().add(btnConnect);
		
		txtServerMessages = new JTextArea(10,35);
		txtServerMessages.setLineWrap(true);
		txtServerMessages.setEditable(false);
		messageScroller = new JScrollPane(txtServerMessages);
		messageScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		messageScroller.setBounds(23, 79, 442, 140);
		getContentPane().add(messageScroller);
		
		
		JLabel lblMessages = new JLabel("Server Messages");
		lblMessages.setBounds(23, 63, 200, 14);
		getContentPane().add(lblMessages);
		
		txtLogs = new JTextArea(10,35);
		txtLogs.setLineWrap(true);
		txtLogs.setEditable(false);
		messageScroller1 = new JScrollPane(txtLogs);
		messageScroller1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		messageScroller1.setBounds(23, 323, 442, 52);
		getContentPane().add(messageScroller1);
		
		JLabel lblLogs = new JLabel("Logs");
		lblLogs.setBounds(23, 304, 68, 14);
		getContentPane().add(lblLogs);
		
		txtClientMessage = new JTextField();
		txtClientMessage.setBounds(22, 253, 289, 25);
		getContentPane().add(txtClientMessage);
		txtClientMessage.setColumns(10);
		
		JButton btnTransmit = new JButton("Transmit");
		btnTransmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					transmitMessage();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnTransmit.setBounds(349, 255, 116, 20);
		getContentPane().add(btnTransmit);
		
		JButton btnClearMessages = new JButton("Clear Messages");
		btnClearMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtServerMessages.setText("");
			}
		});
		btnClearMessages.setBounds(349, 230, 116, 20);
		getContentPane().add(btnClearMessages);
		
		JButton btnClearLogs = new JButton("Clear Logs");
		btnClearLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLogs.setText("");
			}
		});
		btnClearLogs.setBounds(349, 386, 116, 20);
		getContentPane().add(btnClearLogs);
		
		JLabel lblClientMessageTo = new JLabel("Client Message To Server:");
		lblClientMessageTo.setBounds(23, 233, 140, 14);
		getContentPane().add(lblClientMessageTo);
	}
	
	private void connectToServer() throws IOException
	{
		int port = Integer.parseInt(txtPort.getText());
		String server = txtServer.getText();
		
		Socket s = new Socket(server, port);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
        String answer = in.readLine();
        txtServerMessages.append(answer + "\n");
	}
	
	private void transmitMessage() throws IOException
	{
		String data = txtClientMessage.getText();
		out.println(data);
		String response;
		try
		{
			response = in.readLine();
		}
		catch (Exception e)
		{
			response = "ERROR: " + e.toString();
		}
		txtServerMessages.append(response + "\n");
	}
}

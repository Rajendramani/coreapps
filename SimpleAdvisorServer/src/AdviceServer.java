import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;


public class AdviceServer implements Runnable 
{
	private ServerSocket listener;
	private int countClientConnections;
	private int port;
	
	public AdviceServer(int p)
	{
		port = p;
	}
	
	@Override
	public void run() {
		try {
			countClientConnections = 1;
			startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void startServer() throws IOException
	{
		listener = new ServerSocket(port);
		try {
            while (true) {
                SomeServerImplementation ssi = new SomeServerImplementation(listener.accept(), countClientConnections++);
                ManageAdviceServer.serverLogs.append("New Client: " + (countClientConnections - 1) + " connected...\n");
				Thread thread = new Thread(ssi);
		        thread.start();
            }
        }
        finally {
            listener.close();
        }
	}
	

	/**
	 * Make a thread-enabled implementation to do stuff...
	 * @author Brian
	 */
	private class SomeServerImplementation implements Runnable
	{
		private Socket s;
		int counter;
		private BufferedReader in;
		private PrintWriter out;
		
		public SomeServerImplementation(Socket socket, int executions)
		{
			s = socket;
			counter = executions;
		}
		
		@Override
		public void run() 
		{
			try 
			{
				out = new PrintWriter(s.getOutputStream(), true);
                out.println("Execution Count: " + counter + " executions");
                counter++;
            
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				while (true)
				{
	                String input = in.readLine();
	                if (input == null || input.length() == 0 || input.equalsIgnoreCase("quit"))
	                {
	                	break;
	                }
	                ManageAdviceServer.serverLogs.append("Input Received: " + input + "\n");
	                if (input.equalsIgnoreCase("What is the answer to life, the universe, and everything?"))
	                {
	                	out.println("42");
	                }
	                else
	                {
	                    out.println(GetAnswer(input));
	    			}
	            }
            } 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
                try 
                {
					s.close();
				} 
                catch (Exception e) 
                {
					e.printStackTrace();
				}
            }
		}
		
		/**
		 * Get an answer from the server
		 * @param t the String Question
		 * @return the response
		 */
		private String GetAnswer(String t)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("The answer to your question: " + t + " is:  ");
			Random r = new Random();
			int choice = r.nextInt(8);
			switch(choice)
			{
				case 0:
					sb.append("Absolutely!");
					break;
				case 1:
					sb.append("Not at this time");
					break;
				case 2:
					sb.append("When pigs fly!");
					break;
				case 3:
					sb.append("It will be as you wish");
					break;
				case 4:
					sb.append("You already know the answer to this question");
					break;
				case 5:
					sb.append("Never");
					break;
				default:
					sb.append("Unable to be determined. Please try again later\n");
			}
			return sb.toString();
		}
	}
}

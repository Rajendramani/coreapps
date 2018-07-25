import java.net.*;
import java.io.*;

public class EchoServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverSock = null;
      try {
         serverSock = new ServerSocket(10007);
      }
      catch (IOException ie) {
         System.out.println("Can't listen on 10007");
         System.exit(1);
      }
      Socket clientSock = null;
      System.out.println("Listening for connection....");
      try {
         clientSock = serverSock.accept();
      }
      catch (IOException ie) {
         System.out.println("Accept failed.");
         System.exit(1);
      }
      System.out.println("Connection successful.");
      System.out.println("Listening for input....");
      PrintWriter output = new PrintWriter(clientSock.getOutputStream(),
                                           true);
      BufferedReader input = new BufferedReader(new InputStreamReader(
                                clientSock.getInputStream()));
      String inputLine;
      while ((inputLine = input.readLine()) != null) {
         System.out.println("Server: " + inputLine);
         output.println(inputLine);
         if (inputLine.equals("Bye")) {
            break;
         }
      }
      output.close();
      input.close();
      clientSock.close();
      serverSock.close();
   }
}
      
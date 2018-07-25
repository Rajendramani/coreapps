import java.io.*;
import java.net.*;

public class EchoClient {
   public static void main(String[] args) throws IOException {
      Socket sock = null;
      PrintWriter output = null;
      BufferedReader input = null;

      try {
         sock = new Socket("127.0.0.1", 10007);
         output = new PrintWriter(sock.getOutputStream(), true);
         input = new BufferedReader(new InputStreamReader(
                                       sock.getInputStream()));
      }
      catch (UnknownHostException e) {
         System.out.println("Unknown host");
         System.exit(1);
      }
      catch (IOException ie) {
         System.out.println("Cannot connect to host");
         System.exit(1);
      }

      BufferedReader stdIn = new BufferedReader(
                                new InputStreamReader(System.in));
      String userInput;
      while ((userInput = stdIn.readLine()) != null) {
         output.println(userInput);
         System.out.println("echo: " + input.readLine());
      }
      output.close();
      input.close();
      stdIn.close();
      sock.close();
   }
}
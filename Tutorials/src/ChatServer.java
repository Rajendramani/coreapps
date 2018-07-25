import java.net.*;
import java.io.*;

public class ChatServer {
   public static void main(String[] args) throws Exception {
      ServerSocket server = new ServerSocket(10007);
      Socket sock = server.accept();
      BufferedReader input = new BufferedReader(
         new InputStreamReader(sock.getInputStream()));
      PrintStream output = new PrintStream(sock.getOutputStream());
      BufferedReader serverInput = new BufferedReader(
         new InputStreamReader(System.in));
      String line;
      while (true) {
         line = input.readLine();
         if (line.equals("bye")) {
            break;
         }
         System.out.println("Client: " + line);
         System.out.print("Server: ");
         line = serverInput.readLine();
         output.println(line);
      }
      server.close();
      sock.close();
      input.close();
      output.close();
      serverInput.close();
   }
}
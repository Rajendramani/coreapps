import java.net.*;
import java.io.*;

public class ChatClient {
   public static void main(String[] args) throws Exception {
      Socket client = new Socket("127.0.0.1", 10007);
      BufferedReader input = new BufferedReader(
         new InputStreamReader(client.getInputStream()));
      PrintStream output = new PrintStream(client.getOutputStream());
      BufferedReader clientInput = new BufferedReader(
         new InputStreamReader(System.in));
      String line;
      while (true) {
         System.out.print("Client: ");
         line = clientInput.readLine();
         output.println(line);
         line = input.readLine();
         System.out.print("Server: " + line + "\n");
         if (line.equals("bye")) {
            break;
         }
      }
      client.close();
      input.close();
      clientInput.close();
      output.close();
   }
}
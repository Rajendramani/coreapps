import java.net.*;
import java.io.*;

public class UrlProg {
   public static void main(String[] args) throws Exception {
      URL theURL = new URL("http://www.infiniteskills.com");
      System.out.println("Basic information: ");
      System.out.println();
      System.out.println("Protocol: " + theURL.getProtocol());
      System.out.println("Port: " + theURL.getPort());
      System.out.println("Host: " + theURL.getHost());
      URLConnection theConn = theURL.openConnection();
      //check to see if there is content
      int contentLen = theConn.getContentLength();
      int c;
      if (contentLen != 0) {
         System.out.println("Content: ");
         System.out.println();
         InputStream urlInput = theConn.getInputStream();
         while (((c = urlInput.read()) != -1)) {
            System.out.print((char) c);
         }
         urlInput.close();
      }
      else {
         System.out.println("Sorry, no content.");
      }
   }
}
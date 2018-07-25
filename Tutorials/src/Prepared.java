import java.sql.*;
import java.io.*;

public class Prepared {
   public static void main(String[] args) {
      Connection conn = null;
      BufferedReader input = null;
      try {
         String userName = "mmcmillan";
         String password = null;
         String url = "jdbc:mysql://localhost/test";
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection(url, userName, password);
         Statement stmt = conn.createStatement();
         input = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("Enter record to update (isbn): ");
         String isbn = input.readLine();
         System.out.print("Enter data: ");
         String data = input.readLine();
         PreparedStatement ptst = null;
         String ps = "update books set title = ? where isbn = ?";
         ptst = conn.prepareStatement(ps);
         ptst.setString(1,data);
         ptst.setString(2,isbn);
         ptst.executeUpdate();
         conn.close();
         System.out.println("Record updated.");
      }
      catch (Exception e) {
         System.out.print("Error updating record.");
      }
   }
}
import java.sql.*;

public class CreateTable {
   public static void main(String[] args) {
      Connection conn = null;
      try {
         String userName = "mmcmillan";
         String password = null;
         String url = "jdbc:mysql://localhost/test";
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection(url, userName, password);
         Statement stmt = conn.createStatement();
         stmt.executeUpdate("drop table if exists books");
         stmt.executeUpdate(
            "create table books (" +
            "isbn char(10), title char(50)," +
            "author char(50), publisher char(50))");
         conn.close();
         System.out.println("Table created.");
      }
      catch (Exception e) {
         System.out.print("Error creating table.");
      }
   }
}
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RetrieveFieldsServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, 
                     HttpServletResponse response) 
                     throws IOException, ServletException {
      response.setContentType("text/html");
      PrintWriter writer = response.getWriter();
      String fullname = request.getParameter("fullname");
      String address = request.getParameter("address");
      String city = request.getParameter("city");
      String state = request.getParameter("state");
      String zip = request.getParameter("zip");
      writer.println("Full name: " + fullname);
      writer.println("Address: " + address);
      writer.println("City: " + city);
      writer.println("State: " + state);
      writer.println("Zip code: " + zip);
      writer.close();
   }
}
      
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PostSelServlet extends HttpServlet {
   public void doPost(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
      response.setContentType("text/html");
      PrintWriter writer = response.getWriter();
      String language = request.getParameter("lang");
      writer.println("You selected " + language + " as your favorite.");
      writer.close();
   }
}
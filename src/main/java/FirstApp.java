import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstApp extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();
    writer.println("<html>");
    writer.println("<head>");
    writer.println("<title>HelloWorld</title>");
    writer.println("</head>");
    writer.println("<body>");
    writer.println("<h1>SUPPPP CUNT</h1>");
    writer.println("</body>");
    writer.println("</html>");
  }

}

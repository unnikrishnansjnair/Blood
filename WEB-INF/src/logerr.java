
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class logerr extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			PrintWriter out=res.getWriter();

			res.setContentType("text/html");


			out.println("<html>");
			out.println("<head><title>Sorry</title></head>");

			out.println("<body>");
			out.println("<h1>Welcome to Blood Donation</h1>");

			out.println("<br><br><h2>You should Login to visit our site </h2>");
			out.println("<br><br>");
			
			
			out.println("<br><a href='login1'><input type='button' value='LogIn'></a>");
			out.println("<br><br><br><a href='reg'><input type='button' value='Register'></a>");
			out.println("</body>");
			out.println("</html>");

		}catch(Exception ae){}
	}
}
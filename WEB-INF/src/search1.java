
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class search1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			PrintWriter out=res.getWriter();

			res.setContentType("text/html");


			out.println("<html>");
			out.println("<head><title>Welcome</title></head>");

			HttpSession hs=req.getSession(true);
			String uid=(String)hs.getValue("username");
			if(uid==null || uid.length()==0)
				res.sendRedirect("logerr");
			
			out.println("<body>");
			out.println("<h1>Welcome to Blood Donation</h1>");
			
			out.println("<form name='f1' method='POST' action='search2'>");
			out.println("<br><table border='1' cellpadding='5' cellspacing='5' width='80%' align='center'>");
			
			out.println("<tr>");
			out.println("<td width=50%><input type='text' name='t1' placeholder='Enter Blood Group'></td>");
			
			out.println("<td><input type=submit value='Search'></td>");
			
			out.println("</tr>");
			out.println("<br><br>");
			out.println("</table>");
			out.println("</form>");
			
			out.println("<br><a href='show'><input type='button' value='Show Donors'></a>");
			out.println("<br><br><br><a href='login3'><input type='button' value='Home'></a>");
			out.println("<br><br><br><a href='login1'><input type='button' value='Log Out'></a>");
			out.println("</body>");
			out.println("</html>");

		}catch(Exception ae){}
	}
}
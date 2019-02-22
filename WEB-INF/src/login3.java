
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class login3 extends HttpServlet
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
				res.sendRedirect("login1");
			out.println("<body>");
			out.println("<h1>Welcome to Blood Donation</h1>");

			out.println("<br><br><h2>Welcome ! " +  uid +"</h2>");
			out.println("<br><br>");
			
			
			out.println("<br><a href='search1'><input type='button' value='Search Blood Group'></a>");
			out.println("<br><br>");
			
			out.println("<br><a href='show'><input type='button' value='Show Donors'></a>");
			out.println("<br><a href='edit1?username="+uid+"'><input type='button' value='Edit'></a>");
			out.println("<br><br><br><a href='login1'><input type='button' value='Log Out'></a>");
			out.println("</body>");
			out.println("</html>");

		}catch(Exception ae){}
	}
}
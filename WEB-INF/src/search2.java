
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class search2 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			
			String bgrp=req.getParameter("t1");
			
			PrintWriter out=res.getWriter();

			res.setContentType("text/html");
			
	
			out.println("<html>");
			out.println("<head><title>Donars</title></head>");
			
			
			HttpSession hs=req.getSession(true);
			String uid=(String)hs.getValue("username");
			if(uid==null || uid.length()==0)
				res.sendRedirect("logerr");

			out.println("<body>");
			out.println("<h1>Donars Details</h1>");
			out.println("<h3>Searching for "+bgrp+"</h3>");
			out.println("<br>");

			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery("select * from bld where bldgrp="+"'"+bgrp+"'");

			out.println("<table width='80%' cellpadding='10' cellspacing='10' border='1'>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Location</th>");
			out.println("<th>Blood Group</th>");
			out.println("<th>Contact</th>");
			out.println("</tr>");

			while(rs.next())
			{
				out.println("<tr>");
				out.println("<th>"+rs.getString(3)+"</th>");
				out.println("<th>"+rs.getString(6)+"</th>");
				out.println("<th>"+rs.getString(7)+"</th>");
				out.println("<th>"+rs.getString(8)+"</th>");
				out.println("</tr>");
			}
			out.println("</table>");
				

			out.println("<br><br><br><a href='login3'><input type='button' value='Home'></a>");
			out.println("<br><br><br><a href='login1'><input type='button' value='Log Out'></a>");
			out.println("</body>");
			out.println("</html>");

		}catch(Exception ae){}
	}
}
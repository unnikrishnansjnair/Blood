
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class view extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			PrintWriter out=res.getWriter();

			res.setContentType("text/html");

			
			String id=req.getParameter("id");
	
			out.println("<html>");
			out.println("<head><title>Donars</title></head>");
			
			
			HttpSession hs=req.getSession(true);
			String uid=(String)hs.getValue("username");
			if(uid==null || uid.length()==0)
				res.sendRedirect("logerr");


			out.println("<body>");
			out.println("<h1>Donars Details</h1>");
			out.println("<br>");

			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery("select * from bld where id="+id);
			rs.next();
		
			out.println("<table width='80%' cellpadding='10' cellspacing='10' border='1'>");
						
			out.println("<tr>");
			out.println("<td>Donar's Name</td>");
			out.println("<td>"+ rs.getString(3) + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Donar's Location</td>");
			out.println("<td>"+ rs.getString(6) + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Blood group</td>");
			out.println("<td>"+ rs.getString(7) + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Donar's Contact</td>");
			out.println("<td>"+ rs.getString(8) + "</td>");
			out.println("</tr>");
			


			out.println("</table>");
				
			out.println("<br><br>");
			out.println("<a href='show'>Back</a>");

			out.println("<br><br><br><a href='login3'><input type='button' value='Home'></a>");
			out.println("<br><br><br><a href='login1'><input type='button' value='Log Out'></a>");
			
			out.println("</body>");
			out.println("</html>");

		}catch(Exception ae){System.out.println(ae);}
	}
}
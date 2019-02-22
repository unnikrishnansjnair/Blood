
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class reg extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			PrintWriter out=res.getWriter();

			res.setContentType("text/html");


			out.println("<html>");
			out.println("<head><title>New User</title></head>");

			out.println("<body>");
			out.println("<h1>New User Registration</h1>");
			out.println("<form name='f1' method='POST' action='reg1'>");
			out.println("<br><table border='1' cellpadding='10' cellspacing='10' width='80%' align='center'>");
			
			out.println("<tr>");
			out.println("<td width='50%'>User Name </td>");
			out.println("<td><input type='text' name='t1' placeholder='Enter User Name'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'>Password </td>");
			out.println("<td><input type='password' name='t2' placeholder='Enter Password'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'>Name </td>");
			out.println("<td><input type='text' name='t3' placeholder='Enter Name'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'>Age </td>");
			out.println("<td><input type='number' name='t4' placeholder='Enter Age'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'>Gender </td>");
			out.println("<td><input type='text' name='t5' placeholder='Enter Gender'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'>Location </td>");
			out.println("<td><input type='text' name='t6' placeholder='Enter Location'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'>Blood Group </td>");
			out.println("<td><input type='text' name='t7' placeholder='Enter Blood Group'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'>Contact </td>");
			out.println("<td><input type='number' name='t8' placeholder='Enter Contact Number'></td>");
			out.println("</tr>");

			Cookie c1[]=req.getCookies();
			String errmsg="";
			if(c1!=null)
			{
				for(int i=0;i<c1.length;i++)
				{
					if(c1[i].getName().equals("rerr"))
						errmsg=c1[i].getValue();
				}
			}
			out.println("<tr>");
			out.println("<td colspan='2'>&nbsp;"+ errmsg + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'><input type=submit value='Register'></td>");
			out.println("<td><a href='login1'><input type='button' value='Already Registered'></a></td>");

			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}catch(Exception ae){System.out.println(ae);}
	}
}
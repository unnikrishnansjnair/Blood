
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class login1 extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			HttpSession hs=req.getSession(true);
			hs.putValue("username","");
			PrintWriter out=res.getWriter();

			res.setContentType("text/html");


			out.println("<html>");
			out.println("<head><title>Login</title></head>");

			out.println("<body>");
			out.println("<h1>Login</h1>");
			out.println("<form name='f1' method='POST' action='login2'>");
			out.println("<br><table border='1' cellpadding='10' cellspacing='10' width='80%' align='center'>");
			
			out.println("<tr>");
			out.println("<td width='50%'>User Name </td>");
			out.println("<td><input type='text' name='t1' placeholder='Enter User Name'></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'>Password </td>");
			out.println("<td><input type='password' name='t2' placeholder='Enter Password'></td>");
			out.println("</tr>");

			Cookie c1[]=req.getCookies();
			String errmsg="";
			if(c1!=null){
			for(int i=0;i<c1.length;i++)
			{
				if(c1[i].getName().equals("lerr"))
					errmsg=c1[i].getValue();
			}
			}
			out.println("<tr>");
			out.println("<td colspan='2'>&nbsp;"+ errmsg + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td width='50%'><input type=submit value='SignIn'></td>");
			out.println("<td><a href='reg'><input type='button' value='New User'></a></td>");

			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}catch(Exception ae){System.out.println(ae);}
	}
}
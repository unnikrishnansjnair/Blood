
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class login2 extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			
			String uid=req.getParameter("t1");
			String pwd=req.getParameter("t2");
	
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery("select count(*) from bld where username=" + "'" + uid + "'" + " and password=" + "'" + pwd + "'");
			rs.next();

			if(rs.getInt(1) == 0)
			{

				Cookie c1=new Cookie("lerr","Invalid UserId / Password");
				res.addCookie(c1);
				res.sendRedirect("login1");
			}
			else
			{

				HttpSession hs=req.getSession(true);
				hs.putValue("username",uid);
				res.sendRedirect("login3");
			}

		}catch(Exception ae){System.out.println(ae);}
	}
}
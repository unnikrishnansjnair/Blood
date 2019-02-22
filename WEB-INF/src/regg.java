
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class regg extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			
			String uid=req.getParameter("t1");
			String pwd=req.getParameter("t2");
			String na=req.getParameter("t3");
			int age=Integer.parseInt(req.getParameter("t4"));
			String gen=req.getParameter("t5");
			String loc=req.getParameter("t6");
			String bgrp=req.getParameter("t7");
			int con=Integer.parseInt(req.getParameter("t8"));
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery("select count(*) from bld where username=" + "'" + uid + "'");
			rs.next();

			if(rs.getInt(1) == 0)
			{

				st.executeUpdate("insert into bld values("+" '" + uid + " '"+"," + "'" + pwd + "'" + "," + "'" + na + "'" + ","   + age + "  , " + "'" + gen + "'" + "," + "'" + loc + "'" + "," + "'" + bgrp + "'" + "," + con + ")");
				Cookie c1=new Cookie("rerr","Successfully Registered");
				res.addCookie(c1);
			}
			else
			{

				Cookie c1=new Cookie("rerr","Userid/Password Already Exists");
				res.addCookie(c1);
			}

			res.sendRedirect("register.html");
		}catch(Exception ae){System.out.println(ae);}
	}
}
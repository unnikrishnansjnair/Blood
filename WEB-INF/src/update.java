
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class update extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		try
		{
			
			String na=req.getParameter("t1");
			String gen=req.getParameter("t2");
			String loc=req.getParameter("t3");
			String bgrp=req.getParameter("t4");
			double con=Double.parseDouble(req.getParameter("t5"));
			
			HttpSession hs=req.getSession(true);
			String uid=(String)hs.getValue("username");
			if(uid==null || uid.length()==0)
				res.sendRedirect("logerr");
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery("select * from bld where username=" + "'" + uid + "'");
			rs.next();

			System.out.println(uid);
			int id=rs.getInt(9);
			st.executeUpdate("update bld set name='" + na + "', gender= '" + gen + "', location= '" + loc + "', bldgrp= '" + bgrp + "', contact= " + con + " where id= "+id);
			
			System.out.println(uid);
			
			res.sendRedirect("update1");
		
		}catch(Exception ae){System.out.println(ae);}
	}
}
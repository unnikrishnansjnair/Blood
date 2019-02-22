<%@ page language="java" import="java.sql.*"%>

<%
	String uid=request.getParameter("t1");
	String pwd=request.getParameter("t2");
	String na=request.getParameter("t3");
	int age=Integer.parseInt(request.getParameter("t4"));
	String gen=request.getParameter("gender");
	String loc=request.getParameter("t6");
	String bgrp=request.getParameter("t7");
	double con=Double.parseDouble(request.getParameter("t8"));
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

	Statement st=cn.createStatement();

	ResultSet rs=st.executeQuery("select count(*) from bld where username=" + "'" + uid + "'");
	rs.next();

	if(rs.getInt(1) == 0)
	{
		st.executeUpdate("insert into bld values("+" '" + uid + " '"+"," + "'" + pwd + "'" + "," + "'" + na + "'" + ","   + age + "  , " + "'" + gen + "'" + "," + "'" + loc + "'" + "," + "'" + bgrp + "'" + "," + con + ","+" null)");
		
		response.sendRedirect("login.jsp");
	}
	else
	{
		response.sendRedirect("register.jsp");
	}
%>

<html>
	<body>
	</body>
</html>
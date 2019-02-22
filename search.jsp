<%@ page language="java" import="java.sql.*,javax.servlet.*,javax.servlet.http.*"%>

<%
	String bgrp=request.getParameter("t1");
%>

<html>
	<head>
		<title>Search</title>
	</head>
	
	<%
		HttpSession hs=request.getSession(true);
		String uid=(String)hs.getValue("username");
		if(uid==null || uid.length()==0)
			response.sendRedirect("logerr.jsp");
	%>
	
	<body>
		<h1>Donars Details</h1>
		<br><br>
		<%
			out.println("<h4>Results for "+bgrp+"</h4>");
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery("select * from bld where bldgrp="+"'"+bgrp+"'");
			
		%>
		
		<table border="1" align="center" width="80%" cellpadding="10" cellspacing="1">
			<tr>
				<th>Name</th>
				<th>Location</th>
				<th>Blood Group</th>
				<th>Contact</th>
			</tr>
			
			<%
			
				while(rs.next())
				{
					out.println("<tr>");
					out.println("<th>"+rs.getString(3)+"</th>");
					out.println("<th>"+rs.getString(6)+"</th>");
					out.println("<th>"+rs.getString(7)+"</th>");
					out.println("<th>"+rs.getString(8)+"</th>");
					out.println("</tr>");
				}
			
			%>
		</table>
		
		<br>
		<br>
		<a href='show.jsp'>Show All</a>
		<br>
		<br>
		<a href='home.jsp'>Home</a>
		<br>
		<br>
		<a href='login.jsp'>Logout</a>
	</body>
</html>
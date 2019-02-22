<%@ page language="java" import="java.sql.*,javax.servlet.*,javax.servlet.http.*"%>

	<html>
	<head>
		<title>Details</title>
	</head>
	
	<%
	
		
			HttpSession hs=request.getSession(true);
			String uid=(String)hs.getValue("username");
			if(uid==null || uid.length()==0)
				response.sendRedirect("logerr.jsp");
	%>
	
	<body>
		<h1 align="center">Details</h1> 
		<br>
		<br>
		
		<table border="1" align="center" width="80%" cellpadding="10" cellspacing="1">
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Location</th>
				<th>Blood Group</th>
				<th>Contact</th>
				<th>Action</th>
			</tr>
			<%
				
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

				Statement st=cn.createStatement();

				ResultSet rs=st.executeQuery("select * from bld");
							
				while(rs.next())
				{
					int id=rs.getInt(9);
					out.println("<tr>");
					out.println("<td>"+rs.getString(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getString(5)+"</td>");
					out.println("<td>"+rs.getString(6)+"</td>");
					out.println("<td>"+rs.getString(7)+"</td>");
					out.println("<td>"+rs.getString(8)+"</td>");
					out.println("<td><a href='view.jsp?id=" + id + "'><input type=button value=view></a></td>");
					out.println("</tr>");
				}
				cn.close();

			%>
		<table>
		
		<br>
		<br>
		<a href='home.jsp'>Home</a>
		<br>
		<br>
		<%
			out.println("<a href='login.jsp'>Logout ("+uid+")</a> ");
		%>
	</body>
	
</html>

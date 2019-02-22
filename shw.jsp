<%@ page language="java" import="java.sql.*"%>

<html>
	<head>
		<title>Details</title>
	</head>
	
	<body>
		<h1 align="center">Details</h1>
		<br>
		<br>
		
		<table border="1" align="center" width="805" cellpadding="10" cellspacing="10">
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Name</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Location</th>
				<th>Blood Group</th>
				<th>Contact</th>
			</tr>
			<%
							
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

				Statement st=cn.createStatement();
				
				ResultSet rs=st.executeQuery("select * from bld");
				
				while(rs.next())
				{
					
					out.println("<tr>");
					out.println("<td>"+rs.getString(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getString(5)+"</td>");
					out.println("<td>"+rs.getString(6)+"</td>");
					out.println("<td>"+rs.getString(7)+"</td>");
					out.println("<td>"+rs.getString(8)+"</td>");
					out.println("</tr>");
				}
				cn.close();

			%>
		<table>
		
	</body>
	
</html>
<%@ page language="java" import="java.sql.*,javax.servlet.*,javax.servlet.http.*"%>

<%
	String id=request.getParameter("id");
%>

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
		<h1>Donar's Details</h1>
		<br>
		<%
				
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery("select * from bld where id="+id);
			rs.next();
		
		%>
		
		<table border="1" align="center" width="80%" cellpadding="10" cellspacing="1">
			<tr>
				<td width=50%>Donar's Name</td>
				<% out.println("<td>"+ rs.getString(3) + "</td>"); %>
			</tr>
			
			<tr>
				<td>Donar's Location</td>
				<% out.println("<td>"+ rs.getString(6) + "</td>"); %>
			</tr>
			
			<tr>
				<td>Blood group</td>
				<% out.println("<td>"+ rs.getString(7) + "</td>"); %>
			</tr>
			
			<tr>
				<td>Donar's Contact</td>
				<% out.println("<td>"+ rs.getString(8) + "</td>"); %>
			</tr>
		</table>
		<br>
		<br>
		<a href='show.jsp'>Back</a>
		<br>
		<br>
		<a href='home.jsp'>Home</a>
		<%
			out.println("<a href='login.jsp'>Logout ("+uid+")</a> ");
		%>
	</body>
	
</html>
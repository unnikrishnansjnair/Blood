<%@ page language="java" import="java.sql.*,javax.servlet.*,javax.servlet.http.*" %>

<html>
	<head>
		<title>Home</title>
	</head>
	
	<%
	
		HttpSession hs=request.getSession(true);
		String uid=(String)hs.getValue("username");
		if(uid==null || uid.length()==0)
			response.sendRedirect("logerr.jsp");
		
	%>
	
	<body bgcolor="#f5f5f5">
		<h1 align='center'>Home | Blood Donation<h1>
		
		<%
			out.println("<br><h2>Welcome ! " +  uid +"</h2>");
		%>
		<form name='f1' method='POST' action='search.jsp'>
		<div>
			<div>
				<input type='text' name='t1' placeholder='Enter Blood Group'>
			</div>
			<div>
				<input type=submit value='Search'>
			</div>
		</div>
		<form>
		<br><a href='show.jsp'><input type='button' value='Show Donors'></a>
		<br><br><a href='logout.jsp'><input type='button' value='Log Out'></a>
	</body>
</html>
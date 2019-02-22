<%@ page language="java" import="java.sql.*,javax.servlet.*"%>


<html>
	<head>
		<title>Register</title>
	</head>
	<body>
		<h1 align="center"> Register </h1>
			<form name="f1" method="POST" action="reg1.jsp">
				<br>
				<table border='1' bordercolor="#FFFFFF" cellpadding='10'  cellspacing='1' width='30%' align='center'>
				
					<tr>
						<td width=30%>Username</td>
						<td><input type="text" name="t1" placeholder="Enter User Name"></td>
					</tr>
					
					<tr>
						<td width=30%>Password</td>
						<td><input type="text" name="t2" placeholder="Enter Password "></td>
					</tr>
				
					<tr>
						<td width=30%>Name</td>
						<td><input type="text" name="t3" placeholder="Enter Your Name"></td>
					</tr>
									
					<tr>
						<td width=30%>Age</td>
						<td><input type="number" name="t4" placeholder="Enter Your Age "></td>
					</tr>
				
					<tr>
						<td width=30%>Gender</td>
						<td><input type="radio" name="gender" value="Male">Male
						<input type="radio" name="gender" value="female">Female</td>
					</tr>
				
					<tr>
						<td width=30%>Location</td>
						<td><input type="text" name="t6" placeholder="Enter Location"></td>
					</tr>
				
					<tr>
						<td width=30%>Blood Group</td>
						<td><input type="text" name="t7" placeholder="Enter Your Blood Group"></td>
					</tr>
				
					<tr>
						<td width=30%>Contact</td>
						<td><input type="number" name="t8" placeholder="Enter Your Contact Number"></td>
					</tr>
					<tr>
						<td colspan=''><input type="submit" value="Register"><td>
					</tr>

				</table>
				<br>
				<br>
				<br>
				<br>
				
				Already Registered <a href='login.jsp'>Click here</a>
			</form>
	</body>
</html>
<%@ page language="java" import="java.sql.*"%>

<html>
	<head><title>Login</title></head>

		<body bgcolor="#f5f5f5">
		<h1 align="center" >Login</h1>
		<form name='f1' method='POST' action='login1.jsp'>
		<br><table border='0' bordercolor="#FFFFFF" cellpadding='10' cellspacing='' width='40%' align='center'>
			
		<tr>
		<td width='50%'>User Name</td>
		<td><input type='text' name='t1' placeholder='Enter User Name'></td>
		</tr>

		<tr>
		<td width='50%'>Password </td>
		<td><input type='password' name='t2' placeholder='Enter Password'></td>
		</tr>
		
		<%
			
			Cookie c1[]=request.getCookies();
			String errmsg="";
			if(c1!=null)
			{
				for(int i=0;i<c1.length;i++)
				{
					if(c1[i].getName().equals("lerr"))
						errmsg=c1[i].getValue();
					
				}
			}
			
			
			out.println("<tr>");
			out.println("<td colspan='2'>&nbsp;"+ errmsg + "</td>");
			out.println("</tr>");
		%>

		<tr>
		<td width='50%'><input type=submit value='SignIn'></td>
		<td><a href='register.jsp'><input type='button' value='New User'></a></td>

		</table>
		</form>
		</body>
</html>
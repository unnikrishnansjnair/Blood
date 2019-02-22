<%@ page language="java" import="java.sql.*"%>

<%

	String uid=request.getParameter("t1");
	String pwd=request.getParameter("t2");
	
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/blood","root","");

	Statement st=cn.createStatement();

	ResultSet rs=st.executeQuery("select count(*) from bld where username=" + "'" + uid + "'" + " and password=" + "'" + pwd + "'");
	rs.next();

	if(rs.getInt(1) == 0)
	{
		Cookie c1=new Cookie("lerr","Invalid Username/ Password");
		response.addCookie(c1);
		response.sendRedirect("login.jsp");
	}
	else
	{
		HttpSession hs=request.getSession(true);
		hs.putValue("username",uid);
		response.sendRedirect("home.jsp");
	}


%>
<html>
<body>
</body>
</html>
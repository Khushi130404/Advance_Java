<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String sub = request.getParameter("sub");

if(sub!=null)
{
	if(sub.equals("LOGIN"))
	{
		String mail = request.getParameter("tma");
		String pass = request.getParameter("tpa");
				
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1","root","khushi");
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from user where mail='"+mail+"' and pass='"+pass+"'");
			
			if(rs.next())
			{
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}
			else
			{
				out.print("Fail");
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.print("\n ERROR : "+e.getMessage());
		}
	}
	else
	{
		out.println("\n REGISTER THAI GAYU ");		
	}
}
else
{
%>
	<h1> LOGIN PAGE </h1>

	<form name="f1" action="LoginServlet">

	MAIL : <input type="text" name="tma"> <br><br>
	PASSWORD : <input type="password" name="tpa"> <br><br>

	<input type="submit" name="sub" value="LOGIN"> 
	<input type="reset" name="sub" value="CANCEL">

	</form>
<%
}
%>
	
</body>
</html>
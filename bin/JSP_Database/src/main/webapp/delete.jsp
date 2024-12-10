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
	String sub = request.getParameter("sub_del");
	if(sub!=null)
	{
		String mail = request.getParameter("mail");

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1","root","khushi");
			Statement st = con.createStatement();
			st.executeUpdate("delete from user where mail = '"+mail+"'");
			System.out.println("Data Delete");
			out.print("<br> User Deleted Successfully");
			request.getRequestDispatcher("success.jsp").include(request, response);
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
%>
	<h1>Delete User</h1>
	    <form action="DeleteUser">
	        E-mail : <input type="text" name="mail"><br>
	        <br><br>
	        <input type="submit" value="Submit" name="sub_del">
	        <input type="reset" value="Cancel" name="sub_del">
	    </form>
<%
	}
%>
</body>
</html>
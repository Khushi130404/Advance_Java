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
	String sub = request.getParameter("sub_add");
	if(sub!=null)
	{	
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String mobile = request.getParameter("mobile");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db24?characterEncoding=latin1","root","khushi");
			Statement st = con.createStatement();
			st.executeUpdate("insert into user value ('"+mail+"','"+pass+"','"+name+"',"+age+",'"+mobile+"')");
			System.out.println("Data inserted");
			out.print("<br> User Inserted Successfully");
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
	<h1>Add User</h1><br>
	<form action="AddUser">
	        E-mail : <input type="text" name="mail"><br>
	        Password : <input type="password" name="pass"><br>
	        Name : <input type="text" name="name"><br>
	        Age : <input type="number" name="age"><br>
	        Mobile : <input type="text" name="mobile"><br>
	        <br><br>
	        <input type="submit" value="Submit" name="sub_add">
	        <input type="reset" value="Cancel" name="sub_add">
	 </form>
<%
	}
%>
</body>
</html>
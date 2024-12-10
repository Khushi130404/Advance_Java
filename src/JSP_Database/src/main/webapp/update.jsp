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
	String sub = request.getParameter("sub_up");
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
			st.executeUpdate("update user set pass = '"+pass+"',name='"+name+"',age="+age+",mobile='"+mobile+"' where mail='"+mail+"'");
			System.out.println("Data Updated");
			out.print("<br> User Update Successfully");
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
	<h1>Update User</h1><br>
	    <form action="UpdateUser">
	        E-mail : <input type="text" name="mail"><br>
	        Password : <input type="password" name="pass"><br>
	        Name : <input type="text" name="name"><br>
	        Age : <input type="number" name="age"><br>
	        Mobile : <input type="text" name="mobile"><br>
	        <br><br>
	        <input type="submit" value="Submit" name="sub_up">
	        <input type="reset" value="Cancel" name="sub_up">
	    </form>
<%
	}
%>
</body>
</html>
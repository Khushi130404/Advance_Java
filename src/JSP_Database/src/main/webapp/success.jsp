<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	String sub = request.getParameter("sub_success");
	if(sub!=null)
	{
		out.print("Hello");
		if(sub.equals("add"))
		{
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
		else if(sub.equals("delete"))
		{
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("update.jsp").forward(request, response);	
		}
	}
	else
	{		
%>
	<h1 style="color: cadetblue;">	Welcome User...!</h1>
	<h1 style="color: cadetblue;">	MSU Na levay</h1>

	<form action="UserService">
	      <button name="sub_success" value="add">Add</button>
	      <button name="sub_success" value="delete">Delete</button>
	      <button name="sub_success" value="update">Update</button>
	 </form>
<%
	}
%>
</body>
</html>
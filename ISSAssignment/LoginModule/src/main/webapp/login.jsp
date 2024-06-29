<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<form action="login" method="post" style="position:center">
			<div>
			<label for="username">Username</label>
			<input type="text" id="username" name="username"></input>
			</div>
			<div>
			<label for="password">Password</label>
			<input type="password" id="password" name="password"></input>
			</div>
			<input type="submit" value="submit form">
			
			<% if(session.getAttribute("message")!=null) { %>
					<h1 style="color:red"><%=session.getAttribute("message")%></h1>
			<%} %>
			<a href="register.jsp" style="display: inline-block;text-decoration:none;border-radius: 3px;background-color:rgb(192, 192, 192);padding: 10px 15px;margin-top:10px;margin-left:70px">New to the website? Register here</a>
			</form>
			
			
</body>
</html>
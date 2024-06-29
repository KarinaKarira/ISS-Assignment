<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style2.css">
</head>
<body>
		<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); %>
		<form action="register" method="post">
			<label for="username">Username:</label>
			<input type="text" id="username" name="username">
			
			<label for="password">Password:</label>
			<input type="password" id="password" name="password">
			
			<label for="mobile_no">Mobile number:</label>
			<input type="text" id="mobile_no" name="mobile_no">
			
			<label for="email">Email:</label>
			<input type="email" id="email" name="email">
			
			<input type="submit" value="submit">
		</form>
</body>
</html>
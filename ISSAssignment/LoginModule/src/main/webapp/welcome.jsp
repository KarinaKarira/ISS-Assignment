<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
    
</head>
<body>
	<%
		//to prevent caching of this page
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		//to add seurity to the page that means,we all this page to open only if the user is logged in
		
		if(session.getAttribute("uname")==null)
			response.sendRedirect("login.jsp");
	%>
	<div style="display:flex">
			<p style="display:inline-block;margin:30px;font-family:cursive;font-weight:bold;font-size:20px">Hello <%=session.getAttribute("uname") %>
			</p>
			<form action="logout" style="margin-left:auto">
				<input type="submit" value="logout" class="btn btn-secondary m-3">
			</form>
	</div>
	
	

	<p style="margin-top:15%;margin-left:40%;font-family:cursive;font-weight:bold;font-size:20px">Welcome to the page</p>
    
</body>
</html>

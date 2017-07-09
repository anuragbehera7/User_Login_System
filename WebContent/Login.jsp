<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body style="text-align: center;">
<h1>Login Page</h1>
<form action="Login.do" method="post">
Email Id :<input type="text" name="emailid"> <br> <br>
Password :<input type="password" name="password"> <br><br><br>
<input type="submit" value="Login">
<h4 style="color: red"> ${msg}</h4> <br>
<h3>
<a href="Register.jsp">Register Here</a> <br><br>
<a href="Forgot.jsp">Forgot Password</a>
</h3>
</form>
</body>
</html>
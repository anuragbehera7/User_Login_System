<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1>Registration Page</h1>

	<form action="register.do" method="post">
		<pre>
		User Name       :<input type="text" name="name"> <br>
		Emali ID        :<input type="text" name="emailId"><br>
		Phone Number    :<input type="number" name="phoneNum"> <br>
		Password        :<input type="password" name="password"><br>
		Confirm Password:<input type="password" name="confirmPwd"><br>
		Country         : <select name="country"><br>
		<option value="India">India</option>
		<option value="England">England</option>
		<option value="USA">USA</option>
		</select><br>
		<input type="submit" value="Register">
		</pre>
	</form>

</body>
</html>
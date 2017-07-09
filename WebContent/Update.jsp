<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body style="text-align: center;">
<h1>Update Profile</h1>

	<form action="update.do" method="post">
		<pre>
		User Name       :<input type="text" name="name" value="${dto.name}" > <br>
		Emali ID        :<input type="text" name="emailId" value="${dto.emailId}"><br>
		Phone Number    :<input type="number" name="phoneNum" value="${dto.phoneNum}"> <br>
		Password        :<input type="password" name="password" value="${dto.password}"><br>
		Confirm Password:<input type="password" name="confirmPwd" value="${dto.confirmPwd}"><br>
		Country         : <select name="country" value="${dto.country}"><br>
		<option value="Select">--select--</option>
		<option value="India">India</option>
		<option value="England">England</option>
		<option value="USA">USA</option>
		</select><br>
		<input type="submit" value="Update">
		</pre>
	</form>

</body>
</html>
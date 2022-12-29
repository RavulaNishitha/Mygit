<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form </title>
</head>
<body>
<h3> Register page </h3>
<h4>${err}</h4>
<form action = "register" method ="post">
<input type="text"     placeholder="User Name" name ="username" value ="${param.username}"><br> <br>
<input type="password" placeholder="Password" name = "password"><br> <br>
<input type="text"     placeholder="Full Name" name ="fullname" value ="${param.fullname}"><br> <br>
<input type="email"    placeholder="EmailId" name = "email" value ="${param.email} "><br> <br>
<input type="tel"      placeholder="Contact No" value ="${param.mobile}"name = "mobile"><br> <br>
<input type="submit" value="Submit" ><br>
</form><br>
<a href="login">Sign in </a>
</body>
</html>
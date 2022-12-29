<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Additem</title>
</head>
<body>
<form  method ="post" action="uploadFolder"   enctype="multipart/form-data" >
<input type="text"     placeholder="Id" name ="id" value ="${param.id}"><br> <br>
<input type="text"     placeholder="Name" name ="name" value ="${param.name}"><br> <br>
<input type="text"     placeholder="Price" name ="price" value ="${param.price}"><br> <br>
<input type="file"    placeholder="Photo" name = "photo" value ="${param.photo} " ><br> <br>
<input type="submit" value="Submit" ><br>
</form><br>
</body>
</html>
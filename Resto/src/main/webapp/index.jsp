<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body >
<br>

<a href ="account">My Profile</a><br><br>
<a href ="myorders"> My Orders </a>
Welcome to My Resto<a href="viewcart" > <c:out value="${cart.size()}"> </c:out> </a> Item(s)
<c:if test="${empty uid}">
 <a href ="register?c=index">Signin</a> 
 </c:if>
  <c:if test="${not empty uid}">
 Hello <c:out value="${uid}"> </c:out> <a href ="logout">Sign out</a>
  </c:if><br>
   <center>
<c:forEach var="pr" items="${prs}"><br><br>
<c:out value ="${pr.name}"> </c:out> 
<c:out value ="${pr.price}"> </c:out>
<img src="data:image/jpg;base64,${pr.base64Image}" width="340" height="300"/>  
 <%--<img src="uploads/{$pr.id}/${pr.fileName}" width="340" height="300"/> --%>
<a href="addcart?id=${pr.id}">Add to Cart</a>
</c:forEach>
</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>
 <c:forEach var="ord" items="${ords}">
 <c:out value="${ord.orderid}"></c:out>&nbsp;
 <c:out value="${ord.customerId}"></c:out>&nbsp;
  <c:out value="${ord.totalamount}"></c:out>&nbsp;
  <br><br>
  <c:forEach var="orderItems" items="${ord.orderItems}">																																																												
 <c:out value="${orderItems.id}"></c:out>&nbsp;
 <c:out value="${orderItems.name}"></c:out>&nbsp;
  <c:out value="${orderItems.price}"></c:out>&nbsp;
  <br><br>
 </c:forEach>
 <br><br>
 </c:forEach><br>
 
</body>
</html>
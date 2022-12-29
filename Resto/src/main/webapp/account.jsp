<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Account </title>
</head>
<body>
<c:if test="${not empty uid}">

<c:out value="${uid}"></c:out>&nbsp;
<c:out value ="${profile.userName}"> </c:out> &nbsp;
<c:out value ="${profile.emailId}"></c:out> &nbsp;
<c:out value ="${profile.mobile}"> </c:out> &nbsp;
  </c:if>
</body>
</html>
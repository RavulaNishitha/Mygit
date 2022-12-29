<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
</head>
<body>


<table class="table">
 <thead>
    <tr>
      <th scope="col">Sno</th>
      <th scope="col">UserName</th>
      <th scope="col">EmailId</th>
      <th scope="col">Mobile</th>
    </tr>
  </thead>
 <c:forEach var="profile" items="${users}">
  <tbody>
    <tr>
      <th scope="row">1&nbsp;</th>
      <td><c:out value ="${profile.userName}"> </c:out>&nbsp;</td>
      <td><c:out value ="${profile.emailId}"></c:out>&nbsp;</td>
      <td><c:out value ="${profile.mobile}"> </c:out>&nbsp;</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
<style>
table,th,td{
border:1px solid black;
}
</style>
</head>
<body>
<h1> ${message} !!! </h1>

<table style="width:100%">
<tr> 
<th>Topic </th>
<th>Date</th>
<th>Price</th>

</tr>
  <c:forEach items="${events}" var="event">
    <tr>
      <td><c:out value="${event.topic}" /></td>
      <td><c:out value="${event.eventDate}" /></td>
      <td><c:out value="${event.price}" /></td>
    </tr>
  </c:forEach>
</table>

	<a href="logout.jsp">logout</a>

</body>
</html>
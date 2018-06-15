<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add events</title>
</head>
<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null){
	response.sendRedirect("login.html");
}else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>
<br>
User=<%=user %>
<br>
<a href="logout.jsp">logout</a>

<form name="addform" action="AdminController" method="post" onsubmit="" >
	<br>
		
	
	Event topic: <input type="text" name="title" id="title"><br>
	Type: <input type="text" name="type" id="type"><br>
	Date: <input type="date" pattern="yyyy/MM/dd" name="date" id="date"><br>
	Location: <input type="text" name="loc" id="loc"><br>
	Price: <input type="text" name="price" id="price"><br>
	EventTime: <input type="text" name="time" id="time"><br>
	Description: <input type="text" name="desc" id="desc"><br>
	
	<input type="submit" name="submit" value="add_event"><br>
	
	
</form>

</body>
</html>
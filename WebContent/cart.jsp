<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta charset="utf-8">
    <meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- bootstrap general -->

	<!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> -->
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap/css/shop-homepage.css" rel="stylesheet">

<script>
var type = document.getElementByName('type');
alert(type.value);
</script>
</head>


<body>
 <!-- Navigation -->
 
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">${message}</a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="<c:url value="LoginController">
              <c:param name="mode" value="fetch"/>
        				</c:url>">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="MyReservationController"><c:param name="mode" value="fetch"/></c:url>">My Reservations</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="CartController">
              <c:param name="mode" value="fetch"/>
        				</c:url>">Cart</a>
            </li>
            <li class="nav-item">
              	<a class="nav-link" href="logout.jsp">logout</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
    <h4>${cannotBeAdded}</h4>
  

	<c:forEach items="${eventsInCart}" var="event" varStatus = "loop">
	<table >

				<tr>
					<td name = "eventsInCart" id = "eventsInCart${loop.index+1}" ><c:out value="${event.topic}" /></td>
					<td><c:out value="${event.price}" /></td>
					<td id = "delete${loop.index+1}"><a href="<c:url value="CartController">
            			<c:param name="eventToBeDeleted" value="${event.eventId}"/>
            			<c:param name="mode" value="delete"/>
        				</c:url>">Delete</a></td>
				</tr>
		</table>
	</c:forEach>
	
	<table>
	<tr>
	<td> Order Total:</td>
	<td>${orderTotal}</td>
	</tr>
	</table>

	<form name="checkoutEvents" action="CartController" method="post" onSubmit="">
		 <input id= "checkout" type="submit" value="Checkout" name="mode">
	</form>



	<!-- Footer -->
	<footer class="py-5 bg-dark fixed-bottom">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Group:5</p>
	</div>
	<!-- /.container --> </footer>

	<!-- Bootstrap core JavaScript -->
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
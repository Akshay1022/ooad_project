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
<title>Details Page</title>

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
        <a class = "navbar-brand" href="#">${message}</a>
        
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
    
    <div class="col-md-4">
	<h3 class="my-3">${selectedEventId.topic}</h3>
	<p>${selectedEventId.description}</p>
	<p>DATE AND TIME <br>${selectedEventId.eventDate} <br>${selectedEventId.eventTime}</p>
	<p>LOCATION<br>${selectedEventId.location}</p>
	<p>PRICE<br>${selectedEventId.price}</p>
    
	<form name="selectedEvent" action="CartController" method="post" onSubmit="">

	<input type="hidden" name="eventId" value="${selectedEventId.eventId}">
	<input type="hidden" id = "event-topic" name="topic" value="${selectedEventId.topic}">
	<input type="hidden" name="eventType" value="${selectedEventId.eventType}">
	<input type="hidden" name="eventDate" value="${selectedEventId.eventDate}">
	<input type="hidden" name="location" value="${selectedEventId.location}">
	<input type="hidden" name="price" value="${selectedEventId.price}">
	<input type="hidden" name="eventTime" value="${selectedEventId.eventTime}">
	<input type="hidden" name="description" value="${selectedEventId.description}">
	<input type="submit" value="Add to cart" name="mode">
	</form>


	<!-- Footer -->
    <footer class="py-5 bg-dark fixed-bottom">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Group:5</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>  


</body>
</html>


<!-- <table>
			<thead>
				<tr>
					<th>EventId</th>
					<th>Topic</th>
					<th>EventType</th>
					<th>EventDate</th>
					<th>Location</th>
					<th>Price</th>
					<th>EventTime</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${eventDetails.eventId}</td>
				</tr>
				<tr>
					<td>${eventDetails.topic}</td>
				</tr>
				<tr>
					<td>${eventDetails.eventType}</td>
				</tr>
				<tr>
					<td>${eventDetails.eventDate}</td>
				</tr>
				<tr>
					<td>${eventDetails.location}</td>
				</tr>
				<tr>
					<td>${eventDetails.price}</td>
				</tr>
				<tr>
					<td>${eventDetails.eventTime}</td>
				</tr>
				<tr>
					<td>${eventDetails.description}</td>
				</tr>
			</tbody>
		</table> -->
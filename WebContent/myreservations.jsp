<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Reservations Page</title>

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

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
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

	<h4>Exisiting Reservations</h4><br>
	<c:forEach items="${pastEvents}" var="item" varStatus="loop">
	
	<table cellpading="10"cellspacing="10">
	<col width="500">
	<col width="200">

    <tr>
    <td id= "topic${loop.index+1 }" name="topic">${item.topic}
    </td>
    <td>
    <a id= "cancel${loop.index+1 }" href="<c:url value="MyReservationController">
        <c:param name="eventToBeCancelled" value="${item.eventId}"/>
        <c:param name="mode" value="cancel"/>
        </c:url>">Cancel</a>
    </td></tr>
    </table>
	</c:forEach>




	<!-- Footer -->
	<footer class="py-2 bg-dark fixed-bottom">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Group:5</p>
	</div>
	<!-- /.container --> </footer>

	<!-- Bootstrap core JavaScript -->
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
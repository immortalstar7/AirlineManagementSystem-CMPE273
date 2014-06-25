<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html 5.0>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book a Flight</title>
<style type="text/css">
table tr td { padding:10px;margin:10px; }
.color { color:green; }
</style>
<script type="text/javascript">
function validate(){
	var noOfSeats = document.getElementById('numSeats').value;
	if(noOfSeats==0) alert("Invalid number of seats");
	else if(noOfSeats>5)	
		alert("You can book upto 5 seats only.");
}
</script>
</head>
<body>
<center>
<h1>Book Flight</h1>
<% if(request!=null && request.getAttribute("status")!=null) { %>
	<h3><span class="color"><%=request.getAttribute("status").toString() %></span></h3>
<% } %>
<form action="bookflight" method="post" onsubmit="validate();">
<table>
	<tr>
		<td>Flight Number:</td>
		<td><input type="text" name="flightNumber" required="required" pattern="[A-Za-z]{3}[0-9]{5}"/></td>
	</tr>
	<tr>
		<td>Flying Date:</td>
		<td><input type="text" name="flyingDate" required="required" pattern="[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}"/></td>
	</tr>
	<tr>
		<td>Number of Seats:</td>
		<td><input type="text" name="numSeats" id="numSeats" required="required" pattern="[0-9]{1,2}"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Book Flight" style="width:140px;"/></td>
	</tr>
</table>
</form>
</center>
</body>
</html>
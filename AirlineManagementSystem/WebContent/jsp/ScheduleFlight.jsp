<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html 5.0>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Flight</title>
<style>
table tr td { padding:10px; }
.color { color:blue; }
</style>
</head>
<body>
<center>
<h1>Schedule Flight</h1>
<% if(request!=null && request.getAttribute("schedulestatus")!=null) { %>
	<h3><span class="color"><%=request.getAttribute("schedulestatus").toString() %></span></h3>
<% } %>
<h3>Enter the following information</h3>
<form action="scheduleFlight" method="post">
<table>
	<tr>
		<td>Flight Number: </td>
		<td><input type="text" name="flightNo" pattern="[A-Za-z]{3}[0-9]{5}" required="required"></td>
	</tr>
	<tr>
		<td>Flight date: </td>
		<td><input type="text" name="flightdate" required="required"></td>
	</tr>
	<tr>
		<td>Source: </td>
		<td><input type="text" name="source" required="required" pattern="[A-Za-z ]{2,30}"></td>
	</tr>
	<tr>
		<td>Destination: </td>
		<td><input type="text" name="dest" required="required" pattern="[A-Za-z\ ]{2,30}"></td>
	</tr>
	<tr>
		<td>Available Seats: </td>
		<td><input type="text" name="seats" required="required" pattern="[0-9]{1,3}"></td>
	</tr>
	<tr>
		<td colspan="2"><b>Enter Crew Names: </b></td>
	</tr>
	<tr>
		<td>Staff 1:</td>
		<td><input type="text" name="staff1" required="required" pattern="[A-Za-z0-9@.]{2,30}"/></td>
	</tr>
	<tr>
		<td>Staff 2:</td>
		<td><input type="text" name="staff2" required="required" pattern="[A-Za-z0-9@.]{2,30}"/></td>
	</tr>
	<tr>
		<td>Staff 3:</td>
		<td><input type="text" name="staff3" required="required" pattern="[A-Za-z0-9@.]{2,30}"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Schedule Flight"/></td>
	</tr>
</table>
</form>
</center>
</body>
</html>
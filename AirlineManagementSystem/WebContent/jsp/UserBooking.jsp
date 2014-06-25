<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get User Booking</title>
<style type="text/css">
table tr td{ padding:10px;margin:10px;border:1px solid grey; }
table { border:1px solid grey; }
</style>
</head>
<body>
<form action="getUserBookings" method="post">
<input type="submit" value="Get Bookings"/>
</form>
<% if(request!=null && request.getAttribute("result")!=null) { %>
	<% String result = request.getAttribute("result").toString();
		if(result.equals("No booking")) { %>
			<h3><span class="color">You do not have any bookings </span></h3>
		<% } else {  %>
		<table>
		<tr>
			<td><b>Flight Name</b></td>
			<td><b>Flight Date</b></td>
			<td><b>Number Of Seats</b></td>
			<td><b>Source</b></td>
			<td><b>Destination</b></td>
		</tr>
		<% String[] bookings = result.split("\\$"); %>
		
		<% for(int i=0;i<bookings.length;i++) {
			String[] info = bookings[i].split("%"); %>
			<tr>
				<td><%= info[0] %></td>
				<td><%= info[1] %></td>
				<td><%= info[2] %></td>
				<td><%= info[3] %></td>
				<td><%= info[4] %></td>
			</tr>
			<% } %>
		</table>
		
	<% } } %>
</body>
</html>
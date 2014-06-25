<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html 5.0">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Flight</title>
<style type="text/css">
table tr td { padding:10px;margin:10px; }
.color { color:green; }
</style>
</head>
<body>
<center>
<h1>Update Flight</h1>
<% if(request!=null && request.getAttribute("updatestatus")!=null) { %>
	<h3><span class="color"><%=request.getAttribute("updatestatus").toString() %></span></h3>
<% } %>
<form action="updateflight" method="post" onsubmit="validate();">
<table>
	<tr>
		<td>Flight Number:</td>
		<td><input type="text" name="updateflightNumber" required="required" pattern="[A-Za-z]{3}[0-9]{5}"/></td>
	</tr>
	<tr>
		<td>Current Scheduled Date:</td>
		<td><input type="text" name="currentflyingDate" required="required"/> <!-- pattern="[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}" --></td>
	</tr>
	<tr>
		<td>New Date Schedule:</td>
		<td><input type="text" name="updateflyingDate" /><!-- pattern="[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}" --></td>
	</tr>
	<tr>
		<td>Source:</td>
		<td><input type="text" name="updatesource" pattern="[A-Za-z ]{2,30}"></td>
	</tr>
	<tr>
		<td>Destination:</td>
		<td><input type="text" name="updatedest" pattern="[A-Za-z\ ]{2,30}"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update Flight" style="width:140px;"/></td>
	</tr>
</table>
</form>
</center>
</body>
</html>
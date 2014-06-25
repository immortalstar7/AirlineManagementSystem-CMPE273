<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Airline Management System</title>

<link href="css/redmond/jquery-ui-1.10.3.custom.css" rel="stylesheet">
	<script src="js/jquery-1.9.1.js"></script>
	<script src="js/jquery-ui-1.10.3.custom.js"></script>
<script>
	$(function() {
		
			
		$( "#tabs" ).tabs();
	});
	</script>
</head>
<body>
<div id="tabs" align="right">
	<ul>
		<li><a href="./Login.jsp">Login</a></li>
		<li><a href="./CustomerRegistrationForm.jsp">Customer Registration</a></li>
		<li><a href="./StaffRegistrationForm.jsp">Staff registration</a></li>
	</ul>
	
</div>
	
        
</body>
</html>
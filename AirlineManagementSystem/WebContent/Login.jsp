<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="resources/css/Server1.css" rel="stylesheet" type="text/css"/>
</head>
<body class="login">
<form method="POST" action=LoginServlet>
            <table border=1 align="center">
                <tr>
                    <th colspan="2">Login Form</th>
                </tr>
                <tr>
                    <td>Enter your UserId:</td>
                    <td><input type=text name=userName></td>
                </tr>
                <tr>
                    <td>Enter your Password:</td>
                    <td><input type=password name=password></td>
                </tr>
                <tr>
                    <td><input type=submit value=submit></td>
                    <td><input type=reset value=refresh></td>
                </tr>
                <tr>
                    <td><input type=button value=SignUp  ></td>
                   
                </tr>
                
            </table>
        </form>
</body>
</html>
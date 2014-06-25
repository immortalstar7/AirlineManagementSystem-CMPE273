<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
<table width="75%" border="1">
  <tr> 
    <td>
    <form name="modelDetail" method="POST" action="CustomerDetailsServlet">
 		<table border="1">
			<tbody>
				<c:forEach items="${customerList}" var="cust"> 
				 	 <tr>
					    <td>${cust.user_id}</td>
					    <td>${cust.f_name}</td>
					    <td>${cust.l_name}</td>
					    <td>${cust.passport_no}</td>
				    </tr>
							
		            </c:forEach>
			</tbody>
		</table>
	</form>     
   </td>
  </tr>

</table>
</body>
</html>
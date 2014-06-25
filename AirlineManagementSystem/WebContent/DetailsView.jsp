<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<title>Details Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- StyleSheet -->
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" href="css/signin.css" />
<link rel="stylesheet" href="css/datepicker.css" />
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
 <style type="text/css">
  /* GLOBAL STYLES
    -------------------------------------------------- */
    /* Padding below the footer and lighter body text */

    body {
      padding-top: 80px;
      padding-bottom: 40px;
       padding-left: 0px;
        margin-left:0px;
      color: #5a5a5a;
    }

    /* CUSTOMIZE THE NAVBAR
    -------------------------------------------------- */

    /* Special class on .container surrounding .navbar, used for positioning it into place. */
    .navbar-wrapper {
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      z-index: 10;
      margin-top: 20px;
      margin-bottom: -90px; /* Negative margin to pull up carousel. 90px is roughly margins and height of navbar. */
    }
    .navbar-wrapper .navbar {

    }

    /* Remove border and change up box shadow for more contrast */
    .navbar .navbar-inner {
      border: 0;
      -webkit-box-shadow: 0 2px 10px rgba(0,0,0,.25);
         -moz-box-shadow: 0 2px 10px rgba(0,0,0,.25);
              box-shadow: 0 2px 10px rgba(0,0,0,.25);
    }

    /* Downsize the brand/project name a bit */
    .navbar .brand {
      padding: 14px 20px 16px; /* Increase vertical padding to match navbar links */
      font-size: 16px;
      font-weight: bold;
      text-shadow: 0 -1px 0 rgba(0,0,0,.5);
    }

    /* Navbar links: increase padding for taller navbar */
    .navbar .nav > li > a {
      padding: 15px 20px;
    }

    /* Offset the responsive button for proper vertical alignment */
    .navbar .btn-navbar {
      margin-top: 10px;
    }


</style>
<style type="text/css">
.scrollspyTable {
  display: block;
  overflow: scroll;
  width: 300px;
  height: 200px;
}
</style>
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

  <script>
  $(function() {
    $( "#depart_date" ).datepicker();
  });
  $(function() {
	$( "#return_date" ).datepicker();
  });
  </script>
<script>

var errorMsg = "";
window.onload = function() {
	//alert("onload");
	 
	 document.getElementById("firstName").focus();
};

function onClickSubmit(){
	alert("inside onClickSubmit");
	
	if(validateForm()){
		var form = getForm();
		form.action = "RegistrationServlet";
        form.submit();
	}else{
		alert(errorMsg);
		errorMsg = "";
	}
}
function validateForm()
{
	
	//alert("inside validate form");
	var result = true;	
	//validate first Name 
	var f_name=document.getElementById("firstName").value.trim();	
	//alert("f_name:: "+f_name);
	if(f_name==null || f_name=="")
	{
	 // alert("First name must be filled out");
	  errorMsg += "First Name must be filled out"+"\n";	
	  result = false;
	}else{
		if(!allLetter(f_name)){
			errorMsg += "Please input alphabet characters only for First Name"+"\n";	
			result = false;
		}
	}
	var l_name=document.getElementById("lastName").value.trim();	
	if(l_name==null || l_name=="")
	{
	 
	  errorMsg += "Last Name must be filled out"+"\n";	
	  result = false;
	}else{
		if(!allLetter(l_name)){
			errorMsg += "Please input alphabet characters only for Last Name"+"\n";	
			  result = false;
		}
	}
	var email=document.forms["frmRegistration"]["email"].value;
	var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
	{
		errorMsg += "Not a valid e-mail address "+"\n";
		result = false;
	 }
	var userName=document.getElementById("userName").value.trim();	
	if(userName==null || userName=="")
	{
	 
	  errorMsg += "User Name must be filled out"+"\n";	
	  result = false;
	}
	var password=document.getElementById("password").value.trim();	
	if(password==null || password=="")
	{
	 
	  errorMsg += "Password must be filled out"+"\n";	
	  result = false;
	}
	//alert("result:: "+result);
	if(!result){
		alert(errorMsg);
		errorMsg = "";
	}
	
	return result;
}

function allLetter(inputtxt)
{ 
	//alert("inside allLetter"+inputtxt);
	var letters = /^[A-Za-z]+$/;
	if(inputtxt.match(letters))
	{
		return true;
	}
	else
	{
		return false;
	}
}  
function checkdate(input){
    var validformat=/^\d{2}\/\d{2}\/\d{4}$/;//Basic check for format validity
    var returnval=false;
    if (!validformat.test(input.value))
        alert("Invalid Date Format. Please correct and submit again.");
    else{ //Detailed check for valid date ranges
        var monthfield=input.value.split("/")[0];
        var dayfield=input.value.split("/")[1];
        var yearfield=input.value.split("/")[2];
        var dayobj = new Date(yearfield, monthfield-1, dayfield);
        if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield))
            alert("Invalid Day, Month, or Year range detected. Please correct and submit again.");
        else
            returnval=true;
    }
    if (returnval==false) input.select();
        return returnval;
}

</script>
<script>
<script>
$(function () {
  $('#myTab a:last').tab('show');
})
</script>
</head>
<body >

<p><font color="#ff0000"><c:out value="${userMsg}"/></font></p>

<!-- Navigation Bar -->

 <!-- NAVBAR
================================================== -->
	<div class="navbar-wrapper" >
      <div class="container">
        <div class="navbar navbar-inverse navbar-fixed-top"" role="navigation">
          <div class="container">      
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>             
              <a class="navbar-brand" href="./Home.jsp">Airline Management System</a>   
               <%if(session.getAttribute("type").toString().equalsIgnoreCase("admin")){ %>          
               		  <a class="navbar-brand" href="CustomerDetailsServlet">View Details</a>   
               		  <a class="navbar-brand" href="./StaffRegistrationForm.jsp">Staff Registration</a>
               		 <ul class="nav navbar-nav ">
               		  		 <li class="dropdown">
			                  <a href="#" class="navbar-brand" data-toggle="dropdown">Manage Flight <b class="caret"></b></a>
			                  <ul class="dropdown-menu">
			                    <li><a href="./AddFlight.jsp">Add Flight</a></li>
			                    <li><a href="./ScheduleFlight.jsp">Schedule Flight</a></li>
			                   <li><a href="./UpdateFlight.jsp">Update Flight</a></li>                   
			                  </ul>
               				 </li>
               				 <li class="dropdown">
			                  <a href="#" class="navbar-brand" data-toggle="dropdown">Search <b class="caret"></b></a>
			                  <ul class="dropdown-menu">
			                    <li><a href="./SearchCustomer.jsp"">Customer</a></li>
			                    <li><a href="./SearchEmployee.jsp">Employee</a></li>
			                    <li><a href="./SearchFlight.jsp">Flight</a></li>        
			                     <li><a href="./SearchBooking.jsp">Booking</a></li>                  
			                  </ul>
               				 </li>
                </ul>
               		  
               <%} %>  
               <%if(session.getAttribute("type").toString().equalsIgnoreCase("customer")){ %>          
               		  <a class="navbar-brand" href="getUserBookings">My Bookings</a>   
               		  <a class="navbar-brand" href="CustomerManagementServlet">My Account</a>
               		    <a class="navbar-brand" href="./BookFlight.jsp">Book Flights</a>
               <%} %>  
                <%if(session.getAttribute("type").toString().equalsIgnoreCase("staff")){ %>          
               		  
               		  <a class="navbar-brand" href="StaffManagementServlet">My Account</a>
               		  
               <%} %> 
            </div>
            <ul class="nav pull-right">                      
           
            <li><h3><span class="label label-primary"><%= session.getAttribute("msg") %></span></h3></li>  
             <li> <a class="navbar-brand" href="./test.jsp">Logout</a></li>            
           </ul>
          </div>
        </div>

      </div>
    </div>
<!-- Navigation Ends -->
<!--  View Detials -->
 <ul class="nav nav-tabs">
  <li><a href="#customer" data-toggle="tab">Customer</a></li>
  <li><a href="#staff" data-toggle="tab">Staff</a></li>
  <li><a href="#flight" data-toggle="tab">Flights</a></li>
  <li><a href="#bookings" data-toggle="tab">Bookings</a></li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
  <div class="tab-pane active" id="customer">
  	 <form  method="post" action=CustomerManagementServlet >
		  <div class="panel panel-default">
		  <div class="panel-heading">Customer Details</div>
		  	<table border="1">
					<tbody>
					<tr>
							<td></td>
							<td><b>First Name</b></td>
							<td><b>Last Name</b></td>
							<td><b>Address</b></td>
							<td><b>City</b></td>	
							<td><b>State</b></td>			
							<td><b>Zipcode</b></td>
							<td><b>Date of Birth</b></td>	
							<td><b>Email</b></td>
							<td><b>Customer SSN</b></td>	
							<td><b>Passport Number</b></td>	
							<td><b>Nationality</b></td>
							
						</tr>
						<c:forEach items="${customerList}" var="cust"> 
						 	 <tr>
							    <td><input type="checkbox" id="CustomerCheckbox" name="CustomerCheckbox" value="${cust.user_id}"></td>
							    <td>${cust.f_name}</td>
							    <td>${cust.l_name}</td>
							    <td>${cust.address}</td>
							    <td>${cust.city}</td>
							    <td>${cust.state}</td>
							    <td>${cust.zipcode}</td>
							    <td>${cust.dob}</td>
							    <td>${cust.email}</td>
							    <td>${cust.customer_ssn}</td>
							    <td>${cust.passport_no}</td>
							    <td>${cust.nationality}</td>
						    </tr>
									
				            </c:forEach>
				            
					</tbody>
				</table>
				<div>
					 <button style="margin-left: 1050px; width: 60px" class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
				</div>
			</div>
			 <input type="hidden" name="operation" value="Delete_Customer">
		</form>
	</div>
  <div class="tab-pane" id="staff">
   <form  method="post" action=StaffManagementServlet >
	 <div class="panel panel-default">
	  <div class="panel-heading">Staff Details</div>
  		<table border="1">
			<tbody>
				<tr>
					<td></td>
					<td><b>First Name</b></td>
					<td><b>Last Name</b></td>
					<td><b>Address</b></td>
					<td><b>City</b></td>	
					<td><b>State</b></td>			
					<td><b>Zipcode</b></td>
					<td><b>Date of Birth</b></td>	
					<td><b>Email</b></td>
					<td><b>Work Description</b></td>	
					<td><b>Position</b></td>
					<td><b>Staff SSN</b></td>	
					<td><b>Hire Date</b></td>	
					
				</tr>
				<c:forEach items="${staffList}" var="staffvar"> 
				 	 <tr>
				 		 <td><input type="checkbox" id="StaffCheckbox" name="StaffCheckbox" value="${staffvar.user_id}"></td>				 	 
					    <td>${staffvar.f_name}</td>
					    <td>${staffvar.l_name}</td>
					    <td>${staffvar.address}</td>
					    <td>${staffvar.city}</td>
					    <td>${staffvar.state}</td>
					    <td>${staffvar.zipcode}</td>
					    <td>${staffvar.dob}</td>
					    <td>${staffvar.email}</td>
					    <td>${staffvar.work_desc}</td>
					    <td>${staffvar.position}</td>
					    <td>${staffvar.staff_ssn}</td>
					    <td>${staffvar.hire_date}</td>
				    </tr>
				    							
		        </c:forEach>
			</tbody>
		</table>
		<div>
		 <button style="margin-left: 1050px; width: 60px" class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
		</div>	
	</div>
	
	<input type="hidden" name="staff_operation" value="Delete_Staff">
	</form>
	
  </div>
  <div class="tab-pane" id="flight">
  <div class="panel panel-default">
  <div class="panel-heading">Flight Details</div>
  		<table border="1">
    		
			<tbody>
			<tr>
					
					<td><b>Flight Number</b></td>
					<td><b>Flight Name</b></td>
					<td><b>Number of Seats </b></td>
					<td><b>Flight Date</b></td>
					<td><b>Flight Source</b></td>
					<td><b>Flight Destination</b></td>
					<td><b>Available Seats</b></td>
					<td><b>Crew Id</b></td>
			</tr>
				<c:forEach items="${flightList}" var="flight"> 
				 	 <tr>
				 	 	<td>${flight.flight_no}</td>
				 	    <td>${flight.flight_name}</td>
					    <td>${flight.no_of_seats}</td>
					    <td>${flight.flight_date}</td>
					    <td>${flight.source}</td>
					    <td>${flight.destination}</td>
					    <td>${flight.avail_seats}</td>
					    <td>${flight.crew_id}</td>
				    </tr>
				    							
		        </c:forEach>
			</tbody>
		</table>
		</div>
  </div>
  <div class="tab-pane" id="bookings">
  <div class="panel panel-default">
  <div class="panel-heading">Booking Details</div>
  		
  		<table border="1">
			<tbody>
			<tr>
				  <td><b>Flight Number</b></td>
				  <td><b>Flight Date</b></td>
				  <td><b>No of Booked Seats</b></td>
				  <td><b>Source</b></td>
				  <td><b>Destination</b></td>
			</tr>
				<c:forEach items="${bookingList}" var="booking"> 
				 	 <tr>
				 	 	<td>${booking.flight_no}</td>
				 	    <td>${booking.flight_date}</td>
					    <td>${booking.no_of_seats}</td>
					    <td>${booking.source}</td>
					    <td>${booking.destination}</td>
				    </tr>
				    							
		        </c:forEach>
			</tbody>
		</table>
		</div>
  </div>
</div>
<!--  View Detials Ends -->
 <!-- JavaScript -->


     <!-- Placed at the end of the document so the pages load faster -->
     <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/holder.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>
    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/c"></script>
    <script src="js/bootstrap-typeahead.js"></script>
</body>
</html>
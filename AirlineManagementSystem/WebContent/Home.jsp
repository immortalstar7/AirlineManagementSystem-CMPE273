<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<title>Welcome to Airline Management System</title>
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
               		     <a class="navbar-brand" href="./CancelBooking.jsp">Cancel Booking</a>
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
<!--  Trip Planner Form -->
 <div align="left" class="container">
      <form   method="post" action=SearchServlet >
      <table>
      <tr>
      	<td>
	        <h3 >Plan a Trip</h3>
	        <div align="left" class="control-group">
			  	<div align="left" class="controls">
			  	<span>
				 	 <label class="control-label" for="source">From</label>				   
       				  <input type="text" id="source" name="source" class="form-control" placeholder="Source" required pattern="[A-Za-z]+" title="Please Enter characters only"/>
				   	 
				</span>
				<span>
				  	 <label class="control-label" for="destination">To</label>
				     	<input type="text" id="destination" name="destination" class="form-control" placeholder="Destination" required autofocus pattern="[A-Za-z]+" title="Please Enter characters only" />
				     <br>
				</span>				     
				     <br> 
			<!-- 	<span>
			    	<label>  
			     		 <input type="radio" name="radios-0" id="radios-0" value="One Way" checked="checked">
			     		 One Way
			     	</label> 
			     	</span><span>
			     	</span><span>
			     	</span><span>
			   		<label>  
			      		<input type="radio" name="radios-0" id="radios-0" value="Round Trip" >
			      		Round Trip
			  	 	</label>
			    </span> -->
			    <br><br>
		 		<label class="control-label" for="depart_date">Departure Date</label>
		    	<input id="depart_date" name="depart_date" type="text" placeholder="Departure Date" class="input-large" required><br>
		   		
		       
		  		<br><br>
		  		   <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
			</div>	
	         </div>
     		</td>
     		<td>
	   
     		</td>
     		</tr>
		</table>
		 <input type="hidden" name="search_type" value="flight_home">
      </form>

    </div>
    <div align="center" >
    	<form method="post" >
 		 <div class="panel panel-default">
		  <div class="panel-heading">Flights</div>
		  	<table >
				<tbody>
					<tr>
						<td><b>First Number</b></td>
						<td><b>Flight Name</b></td>
						<td><b>Available Seat</b></td>
						
						
					</tr>
					<c:forEach items="${flightList}" var="flight" varStatus="i"> 
						 	 <tr>
						 	 	<td>${flight.flight_no}</td>
							    <td>${flight.flight_name}</td>
							    <td>${flight.no_of_seats}</td>
							  
							    
						    </tr>
									
				    </c:forEach>
				</tbody>
			</table>
			
		  </div>
					
</form>
    
    </div>
<!--  Trip Planner Ends -->
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
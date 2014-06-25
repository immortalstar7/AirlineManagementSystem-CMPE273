<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html 5.0>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<title>Search Staff</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" href="css/search.css" />
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<style type="text/css">
  /* GLOBAL STYLES
    -------------------------------------------------- */
    /* Padding below the footer and lighter body text */

    body {
      padding-top: 220px;
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
  
  $(function(){
	    $('#dob').datepicker({
	        //startDate: '-0m'
	        endDate: '-0m'
	    }).on('changeDate', function(ev){
	        $('#sDate1').text($('#dob').data('date'));
	        $('#dob').datepicker('hide');
	    });

	});
  </script>
<script type="text/javascript">
function validateInput(){
	var noOfSeats = document.getElementById('numberOfSeats').value;
	if(noOfSeats<=0)	
		alert("Number of seats cannot be 0 or less");
}
</script>
</head>
<body>
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

 <div class="container">
  <form class="form-signin" method="post" action=SearchServlet>
  		
   		<br><br>
        <span  style="font-size: 25px; margin-left:50px;" class="label label-primary">Search Staff</span>
        <table>
        	<tr>
        		<td><input type="text" id="firstName" name="firstName" class="form-control" placeholder="First Name"  autofocus pattern="[A-Za-z]+" title="Please Enter characters only" /></td>
        		<td> <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Last Name"  pattern="[A-Za-z]+" title="Please Enter characters only"/></td>
        		<td> <input type="email" id="email" name="email" class="form-control" placeholder="Email address"  /></td>
        	</tr>
        	<tr>
        		<td>  <input type="text" id="dob" name="dob" class="form-control" id="dob" placeholder="Date of Birth"  /></td>
        		<td> <input type="text" id="address" name="address" class="form-control" placeholder="Address"  /></td>
        		<td> <input type="text" id="city" name="city" class="form-control" placeholder="City"  pattern="[A-Z\sa-z]+" title="Please Enter characters only" /></td>
        	</tr>
        	<tr>
        		<td> <input type="text" id="state" name="state" class="form-control" placeholder="State"  pattern="[A-Za-z]+" title="Please Enter characters only"/></td>
        		<td> <input type="text" id="zipcode" name="zipcode" class="form-control" placeholder="Zipcode"  pattern="[0-9]{5}?([-][0-9]{4})?" title="Please Enter in eg. 12345 or 12345-6789 foramt only" /></td>
        		<td> <input type="text" id="work_desc" name="work_desc" class="form-control" placeholder="Work Description"  pattern="[A-Za-z]+" title="Please Enter characters only" /></td>
        	</tr>
        	<tr>
        	<td> <input type="text" id="position" name="position" class="form-control" placeholder="Position"  pattern="[A-Za-z]+" title="Please Enter characters only" /></td>
        	<td>  <input type="text" id="hire_date" name="hire_date" class="form-control" id="hire_date" placeholder="Hire Date"  /></td>
        	
        	</tr>
        </table>
       
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>    
         <input type="hidden" name="search_type" value="staff">
 </form>
 <form>
 		 <div class="panel panel-default">
		  <div class="panel-heading">Staff</div>
		  	<table >
				<tbody>
					<tr>
						<td><b>First Name</b></td>
						<td><b>Last Name</b></td>
						<td><b>Email</b></td>
						<td><b>Date Of Birth</b></td>
						<td><b>Address</b></td>
						<td><b>City</b></td>
						<td><b>State</b></td>
						<td><b>Zipcode</b></td>
						<td><b>Work Description</b></td>
						<td><b>Position</b></td>
						<td><b>Hire Date</b></td>
						<td><b>Staff SSN</b></td>
					</tr>
					<c:forEach items="${staffList}" var="staff"> 
						  <tr>
						 	 	<td>${staff.f_name}</td>
							    <td>${staff.l_name}</td>
							  	<td>${staff.email}</td>
							  	<td>${staff.dob}</td>
							  	<td>${staff.address}</td>
							  	<td>${staff.city}</td>
							  	<td>${staff.state}</td>		
							  	<td>${staff.zipcode}</td>
							  	<td>${staff.work_desc}</td>	
							  	<td>${staff.position}</td>	
							  	<td>${staff.hire_date}</td>
							  	<td>${staff.staff_ssn}</td>								  	 	 	 					   
						 </tr>
									
				    </c:forEach>
				</tbody>
			</table>
			
		  </div>
					
</form>     
 		<br><br>
 		

</div>
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
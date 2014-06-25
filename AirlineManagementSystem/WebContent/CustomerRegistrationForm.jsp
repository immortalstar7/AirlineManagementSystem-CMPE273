<!DOCTYPE HTML 5.0><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<title>Customer Registration Form</title>
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
      padding-top: 20px;
      padding-bottom: 40px;
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
              <a class="navbar-brand" href="./test.jsp">Airline Management System</a>               
            </div>
           <!--  <ul class="nav pull-right">
               <li> <a class="navbar-brand" href="./test.jsp">Logout</a></li>              
           </ul> -->
          </div>
        </div>

      </div>
    </div>
<!-- Navigation Ends -->
<!--  Customer Registration Form -->
 <div class="container">
      <form name="frmRegistration" class="form-signin" method="post" action=RegistrationServlet >
        <h2 class="form-signin-heading">Customer Registration</h2>
         <input type="text" id="firstName" name="firstName" class="form-control" placeholder="First Name" required autofocus pattern="[A-Za-z]+" title="Please Enter characters only" />
         <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Last Name" required pattern="[A-Za-z]+" title="Please Enter characters only"/>
        <input type="email" id="email" name="email" class="form-control" placeholder="Email address"  />
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required/>
        <input type="text" id="dob" name="dob" class="form-control" id="dob" placeholder="Date of Birth" required />
        <input type="text" id="address" name="address" class="form-control" placeholder="Address" required />
        <input type="text" id="city" name="city" class="form-control" placeholder="City" required pattern="[A-Z\sa-z]+" title="Please Enter characters only" />
        <input type="text" id="state" name="state" class="form-control" placeholder="State" required pattern="[A-Za-z]+" title="Please Enter characters only"/>
        <input type="text" id="zipcode" name="zipcode" class="form-control" placeholder="Zipcode" required pattern="[0-9]{5}?([-][0-9]{4})?" title="Please Enter in eg. 12345 or 12345-6789 foramt only" />
        <input type="text" id="customer_ssn" name="customer_ssn" class="form-control" placeholder="SSN" required pattern="[0-9]{9}" title="Please enter valid 9 digit SSN Number"/>
        <input type="text" id="nationality" name="nationality" class="form-control" placeholder="Nationality" required pattern="[A-Za-z]+" title="Please Enter only characters"/>
        <input type="text" id="passport_no" name="passport_no" class="form-control" placeholder="Passport No" required pattern="[A-Za-z0-9]+" title="Please Enter characters or numbers only"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        <input type="hidden" name="type" value="customer">
      </form>

    </div>
<!-- Customer Registration Ends -->
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
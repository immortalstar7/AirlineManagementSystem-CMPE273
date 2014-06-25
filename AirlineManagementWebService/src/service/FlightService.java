package service;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.CustomerMessageBean;
import model.Flight;
import model.FlightDetails;
import model.Staff;
import model.Utility;

public class FlightService {
	private static final String RETRIEVE_ALL_FLIGHT_QUERY = "Select f.flight_no, f.flight_name, f.no_of_seats, sf.flight_date, sf.source, sf.destination, sf.avail_seat, sf.crew_id from airline_management.flight f, airline_management.schedule_flight sf where f.flight_no = sf.flight_no";
	DBOperation dbOperation;
	Utility utility = new Utility();
	private static final String ADD_NEW_FLIGHT = "Insert into airline_management.flight values('";
	public FlightService() {
		// TODO Auto-generated constructor stub
		dbOperation = new DBOperation();
	}
	public static List<FlightDetails> getFlightDetails() {
		
		List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();
			try {
				//insert into User Table
				//System.out.println("@@@@@@@@@@@@@@@@@@@@ 1");
				String flightdetailsQuery = RETRIEVE_ALL_FLIGHT_QUERY;
				//System.out.println("@@@@@@@@@@@@@@@@@@@@ 2");
				flightDetailsList = executeflightdetailsQuery(flightdetailsQuery);
				//System.out.println("@@@@@@@@@@@@@@@@@@@@ 3");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//customeressageBean.setMessage("Error in adding New Customer!! ");
			e.printStackTrace();
		}
		
		return flightDetailsList;
			
		}
		
	public static List<FlightDetails> executeflightdetailsQuery(String querystr) throws Exception{
			
			Connection conn = null;
			Statement stmt= null;
			ResultSet rs;
			List<FlightDetails> flightDetailsList = new ArrayList<FlightDetails>();
			try{
				conn = DBOperation.getConnection();
				stmt = conn.createStatement();
				//System.out.println("before execute");
				rs = stmt.executeQuery(querystr);
				//System.out.println("after execute");
				//stmt  = conn.createStatement();
				//rs.absolute(2);
				while(rs.next())
		        {
					System.out.println("before query");
		            FlightDetails flightDetails = new FlightDetails();
					flightDetails.setFlight_no(rs.getString("flight_no"));
					//System.out.println("after query"+rs.getInt("user_id"));
					flightDetails.setFlight_name(rs.getString("flight_name"));
					flightDetails.setNo_of_seats(rs.getInt("no_of_seats")); 
		            flightDetails.setFlight_date(rs.getString("flight_date"));
		            flightDetails.setSource(rs.getString("source"));
		            flightDetails.setDestination(rs.getString("destination"));
		            flightDetails.setAvail_seats(rs.getString("avail_seat"));
		            flightDetails.setCrew_id(rs.getInt("crew_id"));
		            flightDetailsList.add(flightDetails);
				}
			}catch (Exception e){
				
				System.out.println("unable to execute customer details query" + querystr);
			}
			System.out.println("List length:: "+flightDetailsList.size());
			return flightDetailsList;
		}


	public String addFlights(Flight flight){
		String status = "";
		String flightNumber = "";
		String flightName = flight.getFlight_name();
		int numberOfSeats = flight.getNo_of_seats();
		
		try {			
			//Generate unique flight number
			Connection conn = DBOperation.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs; 
			System.out.println(flightName+", "+ numberOfSeats);
			//Add new flight into the flight system
			if( flightName==null  || flightName.isEmpty() || !(Pattern.matches("[0-9A-Za-z-\\ ]{2,40}", flightName)) || numberOfSeats<=0 || numberOfSeats>9999 ){
				status = "Flight not added to the system";
			} else {
				rs = stmt.executeQuery("Select flight_no from airline_management.flight where flight_name='"+flightName+"'");
                if(rs.next()){
                    return "Flight with this name already exists.Flight not added.";
                }
				rs = stmt.executeQuery("Select flight_no from airline_management.flight order by flight_no");
				if(rs.last()){
					String flightNum = rs.getString(1);				
					flightNumber = "AMS" + (Integer.parseInt(flightNum.substring(3))+1);
				} else {
					flightNumber = "AMS" + 10001;
				}
				DBOperation.executeQuery(ADD_NEW_FLIGHT+flightNumber+"','"+flightName+"','"+numberOfSeats+"')");
				status = "Flight is added successfully. Flight Number is "+ flightNumber; 
			}
			
		} catch(MySQLIntegrityConstraintViolationException e){
			status = "Flight name already exists. Please enter a different name";
		}   catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public String scheduleNewFlight(String flightNo, String date, String source, String dest, int seats,double fare, String[] staff) {
		String status="";
		Date flightDate = utility.convertStringToDate(date);
		Connection conn = DBOperation.getConnection();
		Statement stmt;
		ResultSet rs;
		
		//Server side validations
		if( flightNo.isEmpty() || flightNo==null) return "Invalid Flight Number";
		if( !(Pattern.matches("[A-Za-z]{3}[0-9]{5}", flightNo))) { return "Invalid flight Number";  }
		if(!source.isEmpty()) {
			if(!(Pattern.matches("[A-Za-z ]{2,30}", source))) return "Invalid Source string";
		}
		if(!dest.isEmpty()) {
			if(!(Pattern.matches("[A-Za-z ]{2,30}", dest))) return "Invalid Destination string";
		}
		if(seats<=0) return "Number of seats must be greater than 0";
		if(fare == 0) return "Invalid Fare";
		if(staff==null) return "Enter Staff members";		
		if(staff.length!=3) return "Invalid number of staff members";
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select flight_no from airline_management.flight where flight_no='"+flightNo+"'");
			if(!rs.next()){
				return status="Invalid Flight Number";
			}
			rs = stmt.executeQuery("select flight_no from airline_management.schedule_flight where flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
			if(rs.next()){
				return status="This flight has been scheduled already for this date.";
			}
			rs = stmt.executeQuery("select no_of_seats from airline_management.flight where flight_no='"+flightNo+"'");
			if(rs.next()){
				int noOfSeats = rs.getInt(1);
				if( seats>noOfSeats )
				return status="Available seats are less than the seats scheduled";
			}
			for (String s : staff) {
				rs = stmt.executeQuery("select user_id from airline_management.user where email='"+s+"'");
				if(!rs.next()){
					status+="Staff "+s+" does not exist.\n";
				} else {
					int userid = rs.getInt(1);
					rs = stmt.executeQuery("select * from airline_management.staff where user_id='"+userid+"'");
					if(!rs.next()){
						status += s+" is not a staff.\n";
					}
				}
				if(status!="")	return status;
				rs = stmt.executeQuery("select staff_name from airline_management.crew_details c, airline_management.schedule_flight s" +
						" where c.crew_id = s.crew_id and s.flight_date='"+flightDate+"'");
				if(rs.next()){
					for( String staffname:staff ){
						if(rs.getString(1).equals(staffname)) return "Staff member "+staffname+" is scheduled already for another flight";
					}
				}
			}
			
			if(status!="")	return status;
			int crewid = 0;
			rs = stmt.executeQuery("select crew_id from airline_management.schedule_flight order by crew_id");
			if(rs.last()){ crewid = rs.getInt(1); }
			crewid = crewid+1;
			stmt.executeUpdate("Insert into airline_management.schedule_flight values('"+flightNo+"','"+flightDate+"','"+source+"','"+dest+"','"+seats+"','"+crewid+"','"+fare+"')");
			for( String s:staff ){
				stmt.executeUpdate("insert into airline_management.crew_details values('"+crewid+"','"+s+"')");
			}
			status = "Flight scheduled successfully";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;		
	}
	
	public String payment(int userid, String flightNo, String date, int noOfSeats){

		
		Connection conn = DBOperation.getConnection();
		Date flightDate = utility.convertStringToDate(date);
		Statement stmt;
		ResultSet rs;
		try{
			stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from airline_management.booking where user_id='"+userid+"' and flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
		if(rs.next()){	
			
				stmt.executeUpdate("update airline_management.booking set no_of_seats=no_of_seats+"+noOfSeats+" where user_id='"+userid+"' and flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
				stmt.executeUpdate("update airline_management.schedule_flight set avail_seat=avail_seat-"+noOfSeats+" where flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
			
		} else {
			if(noOfSeats>0){
				stmt.executeUpdate("insert into airline_management.booking values('"+userid+"','"+flightNo+"','"+flightDate+"','"+noOfSeats+"')");
				stmt.executeUpdate("update airline_management.schedule_flight set avail_seat=avail_seat-"+noOfSeats+" where flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
			}
		}
		rs= stmt.executeQuery("select f.flight_name, f.flight_no, sf.avail_seat,sf.source, sf.destination from airline_management.flight f, airline_management.schedule_flight sf where f.flight_no=sf.flight_no and sf.flight_no='"+flightNo+"' and sf.flight_date='"+flightDate+"'");
		if(rs.next()){
			Flight flight = new Flight();
			flight.setFlight_name(rs.getString(1));
			flight.setFlight_no(rs.getString(2));
			flight.setNo_of_seats(rs.getInt(3));
			List<Flight> forCacheFlightList = new ArrayList<Flight>(); 
			forCacheFlightList.add(flight);
			new CachingService().updateCache(rs.getString(4), rs.getString(5), date, forCacheFlightList);
		}
			
		}catch (Exception e) {
			// TODO: handle exception
			
			return "Payment failure";
		}
		return "Payment Successful";
	}
	
	public String bookFlights(int userid, String flightNo, String date, int noOfSeats){
		Date flightDate = utility.convertStringToDate(date);
		System.out.println(flightDate);
		Connection conn = DBOperation.getConnection();
		Statement stmt;
		ResultSet rs;
		Double fare = null;
		//server side validations
		if(userid==0) return "Missing user id";
		if( flightNo.isEmpty() || flightNo==null) return "Invalid Flight Number";
		if( !(Pattern.matches("[A-Za-z]{3}[0-9]{5}", flightNo))) { return "Invalid flight Number";  }
		if(noOfSeats<=0) return "Number of seats must be greater than 0";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select flight_no from airline_management.flight where flight_no='"+flightNo+"'");
			if(!rs.next()){
				return "Invalid Flight Number";
			}
			rs = stmt.executeQuery("select flight_date from airline_management.schedule_flight where flight_no='"+flightNo+"'");
			boolean isValidDate = false;
			while(rs.next()){
				Date fdate = rs.getDate(1);
				if(fdate.equals(flightDate))  isValidDate = true;
			}
			if(!isValidDate) return "The flight has not been scheduled for the requested date";
			rs = stmt.executeQuery("select avail_seat ,fare from airline_management.schedule_flight where flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
			if(rs.next()){				
				if(rs.getInt(1)<noOfSeats)
					return "The requested number of seats are not available";
				fare = rs.getDouble(2);
			}
			rs = stmt.executeQuery("select * from airline_management.booking where user_id='"+userid+"' and flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
			if(rs.next()){	
				int numseats = rs.getInt(4);
				if((noOfSeats+numseats) > 5)
					return "You have already booked "+ numseats+ " seats for this date." + " You can book maximum of 5 seats only.";
				/*else { 
					stmt.executeUpdate("update airline_management.booking set no_of_seats=no_of_seats+"+noOfSeats+" where user_id='"+userid+"' and flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
					stmt.executeUpdate("update airline_management.schedule_flight set avail_seat=avail_seat-"+noOfSeats+" where flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
				}*/
			} /*else {
				if(noOfSeats>0){
					stmt.executeUpdate("insert into airline_management.booking values('"+userid+"','"+flightNo+"','"+flightDate+"','"+noOfSeats+"')");
					stmt.executeUpdate("update airline_management.schedule_flight set avail_seat=avail_seat-"+noOfSeats+" where flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
				}
			}*/
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success#"+fare.toString();
	}
	
	public String cancelBooking( int userId, String flightNo, String date, int noOfSeats ){
		Date flightDate = utility.convertStringToDate(date);
		Connection conn = DBOperation.getConnection();
		Statement stmt;
		ResultSet rs;
		//server side validations
		if(userId==0) return "Missing user id";
		if( flightNo.isEmpty() || flightNo==null) return "Invalid Flight Number";
		if( !(Pattern.matches("[A-Za-z]{3}[0-9]{5}", flightNo))) { return "Invalid flight Number";  }
		if(noOfSeats<=0) return "Number of seats must be greater than 0";
				
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select flight_no from airline_management.flight where flight_no='"+flightNo+"'");
			if(!rs.next()){
				return "Invalid Flight Number";
			}
			rs = stmt.executeQuery("select * from airline_management.booking where flight_no='"+flightNo+"' and user_id='"+userId+"' and flight_date='"+flightDate+"'");
			if(!rs.next()){
				return "You do not have a booking for this date";
			} else {
				int numSeats = rs.getInt(4);
				if(noOfSeats>numSeats){
					return "You are requesting to cancel more seats than what you have booked";
				} else if(noOfSeats==numSeats) {
					stmt.executeUpdate("update airline_management.schedule_flight set avail_seat=avail_seat+"+noOfSeats+" where flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
					stmt.executeUpdate("delete from airline_management.booking where user_id='"+userId+"' and flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
				} else {
					stmt.executeUpdate("update airline_management.schedule_flight set avail_seat=avail_seat+"+noOfSeats+" where flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
					stmt.executeUpdate("update airline_management.booking set no_of_seats=no_of_seats-"+noOfSeats+" where user_id='"+userId+"' and flight_no='"+flightNo+"' and flight_date='"+flightDate+"'");
				}
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Cancellation Successfull";
	}
	
	public String getUserBookingDetails(int userId){
		Connection conn = DBOperation.getConnection();
		Statement stmt;
		ResultSet rs;
		String result = "";
		String delimiter = "";
		
		//server side validations
		if(userId==0) return "Missing user id";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select b.flight_no,b.flight_date,b.no_of_seats,f.source,f.destination "
					+ "from airline_management.booking b, airline_management.schedule_flight f where f.flight_no = b.flight_no "
					+ "and f.flight_date = b.flight_date and user_id='"+userId+"'");
			if(!rs.next()){
				return "No booking";
			} else {
				do{
					result+=delimiter+rs.getString(1)+"%"+rs.getString(2)+"%"+rs.getInt(3)+"%"+rs.getString(4)+"%"+rs.getString(5);
					delimiter = "$";
				} while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String updateFlight( String flightNo, String currDate, String updatedate, String source, String dest ){
		System.out.println("In Service before conversion current flight date: "+currDate);
		System.out.println("In Service before conversion new flight date: "+updatedate);
		Date updateDate = utility.convertStringToDate(updatedate);
		Date currentDate = utility.convertStringToDate(currDate);
		System.out.println("In Service after conversion current flight date: "+currentDate);
		System.out.println("In Service after conversion new flight date: "+updateDate);
		Connection conn = DBOperation.getConnection();
		Statement stmt;
		ResultSet rs;
		String existingsource;
		String existingdestination;
		
		//server side validation
		if(flightNo.isEmpty() || flightNo==null){ return "Please specify flight number"; }
		if( !(Pattern.matches("[A-Za-z]{3}[0-9]{5}", flightNo))) { return "Invalid flight Number";  }
		if( currentDate==null ) return "Current date must be specified";
		if(!source.isEmpty()) {
			if(!(Pattern.matches("[A-Za-z ]{2,30}", source))) return "Invalid Source string";
		}
		if(!dest.isEmpty()) {
			if(!(Pattern.matches("[A-Za-z ]{2,30}", dest))) return "Invalid Destination string";
		}
		System.out.println("Source:"+source+":");
		System.out.println("Dest:"+dest+":");
		if(!source.isEmpty() && !dest.isEmpty() && (source.equals(dest))){ 
			return "From server Source should not be the same as destination";
		}
		
		//Code starts here
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select flight_no from airline_management.flight where flight_no='"+flightNo+"'");
			if(!rs.next()) {
				return "Invalid Flight Number";
			}
			rs = stmt.executeQuery("select * from airline_management.schedule_flight where flight_no='"+flightNo+"'");
			if(!rs.next()) {	
				return "This flight is not scheduled";
			}
			rs = stmt.executeQuery("select * from airline_management.schedule_flight where flight_no='"+flightNo+"' and flight_date='"+currentDate+"'");
			if(!rs.next()) {	
				return "This flight is not scheduled for the given date";
			} else {
				existingsource = rs.getString(3);
				existingdestination = rs.getString(4);
			}	
			
			rs = stmt.executeQuery("select * from airline_management.schedule_flight where flight_no='"+flightNo+"' "
					+ "and flight_date='"+updateDate+"' and source='"+source+"' and destination ='"+dest+"'");
			if(rs.next()){
				return "The flight is already scheduled for the same date, source and destination";
			} 
						
			rs = stmt.executeQuery("select * from airline_management.booking where flight_no='"+flightNo+"' and flight_date='"+currentDate+"'");
			if(rs.next()){
				if( (!source.isEmpty() && !source.equals(existingsource)) || (!dest.isEmpty() && !dest.equals(existingdestination))){
					return "User booking exists for this date. Cannot change source and destination. Can only change date";
				} else if ((source.isEmpty() || source.equals(existingsource)) && (dest.isEmpty() || dest.equals(existingdestination)) && updateDate!=null){
					String updateScheduleFlightTableQuery = "update airline_management.schedule_flight set flight_date='"+updateDate+"' where flight_no='"+flightNo+"' and flight_date='"+currentDate+"'";
					System.out.println("updateScheduleFlightTableQuery :: "+updateScheduleFlightTableQuery);
					String updateBookingTableQuery ="update airline_management.booking set flight_date='"+updateDate+"' where flight_no='"+flightNo+"' and flight_date='"+currentDate+"'";
					System.out.println("updateBookingTableQuery:: "+updateBookingTableQuery);
					stmt.executeUpdate(updateScheduleFlightTableQuery);
					stmt.executeUpdate(updateBookingTableQuery);
				}
			} else {
				//if no booking then we can update source, destination and date
				if(source.isEmpty() ) source = existingsource;
				if(dest.isEmpty()) dest = existingdestination;
				if(updatedate.isEmpty()) updateDate = currentDate;
				String updateScheduleFlightTableQuery ="update airline_management.schedule_flight set flight_date='"+updateDate+"' , source='"+source+"' , destination='"+dest+"' where flight_no='"+flightNo+"' and flight_date='"+currentDate+"'";
				System.out.println("Else part updateScheduleFlightTableQuery:: "+updateScheduleFlightTableQuery);
				stmt.executeUpdate(updateScheduleFlightTableQuery);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Updated Successfully!!";
	}
	


}


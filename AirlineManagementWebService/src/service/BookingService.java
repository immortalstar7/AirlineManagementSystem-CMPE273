package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Booking;

public class BookingService {
	DBOperation dbOperation;
	private static final String RETRIEVE_ALL_BOOKINGS_QUERY = "select b.user_id,b.flight_no,b.flight_date,b.no_of_seats,f.source,f.destination from airline_management.booking b," +
			" airline_management.schedule_flight f where f.flight_no = b.flight_no and f.flight_date = b.flight_date";
	
	
	public BookingService() {
		// TODO Auto-generated constructor stub
		dbOperation = new DBOperation();
	}
	
	public List<Booking> getBookingDetails() {
		// TODO Auto-generated method stub
		List<Booking> bookingList = new ArrayList<Booking>();
		try {
			//insert into User Table
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 1");
			String bookingdetailsQuery = RETRIEVE_ALL_BOOKINGS_QUERY;
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 2");
			bookingList = executebookingdetailsQuery(bookingdetailsQuery);
			//System.out.println("@@@@@@@@@@@@@@@@@@@@ 3");
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//customeressageBean.setMessage("Error in adding New Customer!! ");
		e.printStackTrace();
	}
	
	return bookingList;
		
	}
	
public static List<Booking> executebookingdetailsQuery(String querystr) throws Exception{
		
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs;
		List<Booking> bookingList = new ArrayList<Booking>();
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
	            Booking booking = new Booking();
				booking.setFlight_no(rs.getString("flight_no"));
				booking.setNo_of_seats(rs.getInt("no_of_seats"));
				booking.setFlight_date(rs.getString("flight_date")); 
				booking.setSource(rs.getString("source"));
				booking.setDestination(rs.getString("destination"));
	            booking.setUser_id(rs.getInt("user_id"));
	            bookingList.add(booking);
			}
		}catch (Exception e){
			System.out.println("unable to execute customer details query" + querystr);
		}
		System.out.println("List length:: "+bookingList.size());
		return bookingList;
	}
}

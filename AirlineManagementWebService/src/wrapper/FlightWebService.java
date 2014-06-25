package wrapper;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.Flight;
import service.FlightService;

@WebService(serviceName="FlightWebService")
public class FlightWebService {
	private FlightService flightService;
	public FlightWebService(){
		flightService = new FlightService(); 
	}
	/**
	 * To allow the users to book flight tickets
	 * @param flight
	 * @return
	 */
	@WebMethod(operationName="bookFlights")
	public String bookFlights(int userId, String flightNum, String flyingDate, int noOfSeats ){
		return flightService.bookFlights(userId, flightNum, flyingDate, noOfSeats);
		
	}
	/**
	 * Returns the list of bookings made by the user
	 * @param user_id
	 * @return
	 */
	@WebMethod(operationName="getUserBookingDetails")
	public String getUserBookingDetails(@WebParam(name="user_id")int user_id) {
		return flightService.getUserBookingDetails(user_id);
		
	}
	/**
	 * Allows the user to cancel a booking
	 * @param user_id
	 * @return
	 */
	@WebMethod(operationName="cancelUserBooking")
	public String cancelUserBooking( int userId, String flightNum, String flyingDate, int noOfSeats ){
		return flightService.cancelBooking(userId, flightNum, flyingDate, noOfSeats);
	}
	/**
	 * Allows the administrator to add new flights
	 * @param flight
	 * @return
	 */
	@WebMethod(operationName="addFlights")
	public String  addFlights(@WebParam(name="flight")Flight flight){
		return flightService.addFlights(flight);	
	}
	/**
	 * Allows the administrator to schedule a new flight
	 * @param flight
	 * @return
	 */
	@WebMethod(operationName="scheduleNewFlight")
	public String scheduleNewFlight(String flightNo, String flightdate, String source, String dest, int seats,double fare, String[] staff) {
		return flightService.scheduleNewFlight(flightNo, flightdate, source, dest, seats,fare, staff);
	}
	@WebMethod(operationName="updateFlight")
    public String updateFlight(String flightNo, String currDate, String flightdate, String source, String dest) {
        return flightService.updateFlight(flightNo, currDate, flightdate, source, dest);
    }
	/**
	 * To allow the users to buy flight tickets
	 * @param flight
	 * @return
	 */
	@WebMethod(operationName="payment")
	public String payment(int userid, String flightNo, String date, int noOfSeats){
		return flightService.payment(userid, flightNo, date, noOfSeats);
		
	}
}

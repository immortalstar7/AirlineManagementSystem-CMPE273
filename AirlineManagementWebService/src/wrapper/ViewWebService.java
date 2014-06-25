package wrapper;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import service.BookingService;
import service.CustomerService;
import service.FlightService;
import service.StaffService;

import model.Customer;
import model.CustomerMessageBean;
import model.FlightDetails;
import model.Staff;
import model.Booking;

@WebService(serviceName="ViewWebService")
public class ViewWebService {
	FlightService flightService = new FlightService();
	CustomerService customerService = new CustomerService();
	StaffService staffService = new StaffService();
	BookingService bookingService = new BookingService();

	
	@WebMethod(operationName="getStaffDetails")
	public Staff[] getStaffDetails(){

		System.out.println("in getStaffDetails");
		System.out.println("##################### 3");
		List<Staff> staffList = staffService.getStaffDetails();
		System.out.println("##################### 4");
		Staff[] staffArray = new Staff[staffList.size()];
		System.out.println("##################### 5");
		for(int i =0;i<staffList.size();i++){
			staffArray[i] = staffList.get(i);
		}
		return staffArray;
		
	}
	
	@WebMethod(operationName="getCustomerDetails")
	public Customer[] getCustomerDetails(){
		System.out.println("in getCustomerDetails");
		System.out.println("##################### 3");
		List<Customer> customerList = customerService.getCustomerDetails();
		System.out.println("##################### 4");
		Customer[] customerArray = new Customer[customerList.size()];
		System.out.println("##################### 5");
		for(int i =0;i<customerList.size();i++){
			customerArray[i] = customerList.get(i);
		}
		
		System.out.println("##################### 6");
		return customerArray;
		
		
	}
	
	@WebMethod(operationName="getFlightDetails")
	public FlightDetails[] getFlightDetails(){

		System.out.println("in getFlightrDetails");
		List<FlightDetails> flightDetailsList = flightService.getFlightDetails();
		FlightDetails[] flightDetailsArray = new FlightDetails[flightDetailsList.size()];
		for(int i =0;i<flightDetailsList.size();i++){
			flightDetailsArray[i] = flightDetailsList.get(i);
		}
		
		return flightDetailsArray;
		
	}
	
	@WebMethod(operationName="getBookingDetails")
	public Booking[]  getBookingDetails(){
		//System.out.println("in getFlightrDetails");
		List<Booking> BookingList = bookingService.getBookingDetails();
		Booking[] bookingArray = new Booking[BookingList.size()];
		for(int i =0;i<BookingList.size();i++){
			bookingArray[i] = BookingList.get(i);
		}
		
		return bookingArray;
		
	}
}

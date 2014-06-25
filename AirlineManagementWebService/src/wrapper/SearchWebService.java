package wrapper;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import service.SearchService;

import model.Customer;
import model.Staff;
import model.Flight;



@WebService(serviceName="SearchWebService")
public class SearchWebService {

	Connection con=null;
	ResultSet rs;
	Statement stmt=null;
	SearchService searchwebservice = new SearchService();

	
	
	@WebMethod(operationName="searchStaff")
	public Staff[] searchStaff(@WebParam(name="customer")Staff staff){
		List<Staff> staffList = searchwebservice.searchStaff(staff);
		Staff[] staffArray= new Staff[staffList.size()];
		for(int i=0;i<staffList.size();i++){
			staffArray[i] = staffList.get(i);
		}
		return staffArray;
	}
	
	@WebMethod(operationName="searchCustomers")
	public Customer[] searchCustomers(@WebParam(name="customer")Customer customer){
		
		List<Customer> customerList = searchwebservice.searchCustomer(customer);
		Customer[] customerArray= new Customer[customerList.size()];
		for(int i=0;i<customerList.size();i++){
			customerArray[i] = customerList.get(i);
		}
		return customerArray;
		
	}
	
	@WebMethod(operationName="searchFlights")
	public Flight[] searchFlights(@WebParam(name="source")String source, @WebParam(name="destination")String destination, @WebParam(name="flight_date")String flight_date) {
		
		List<Flight> flightList = searchwebservice.searchFlight(source, destination, flight_date);
		Flight[] flightArray= new Flight[flightList.size()];
		for(int i=0;i<flightList.size();i++){
			flightArray[i] = flightList.get(i);
		}
		return flightArray;
		
		
	}
}




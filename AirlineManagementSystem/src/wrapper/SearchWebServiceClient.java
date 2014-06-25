package wrapper;

import java.rmi.RemoteException;
import java.util.Date;
import model.Customer;
import model.Staff;
import model.Flight;

public class SearchWebServiceClient {
	SearchWebServiceProxy searchProxy = new SearchWebServiceProxy();
	
	public SearchWebServiceClient(){
		searchProxy.setEndpoint("http://localhost:8083/AirlineManagementWebService/services/SearchWebService");
	}
	public Staff[] searchStaff(Staff staff){
		
		Staff[] staffArray=null;
		try {
			staffArray = searchProxy.searchStaff(staff);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staffArray;
	}
	
	
	public Customer[] searchCustomers(Customer customer){
		Customer[] customerArray = null;
		try {
			customerArray = searchProxy.searchCustomers(customer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerArray;
		
	}
	
	
	public Flight[] searchFlights(String source,String destination,String flight_date) {
		Flight[] flightArray = null;
		try {
			flightArray = searchProxy.searchFlights(source, destination, flight_date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightArray;
		
	}
}

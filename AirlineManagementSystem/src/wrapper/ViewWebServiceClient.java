package wrapper;

import java.rmi.RemoteException;

import model.Booking;
import model.Customer;
import model.FlightDetails;
import model.Staff;

public class ViewWebServiceClient {
	ViewWebServiceProxy viewWebServiceProxy = new ViewWebServiceProxy();
	public ViewWebServiceClient() {
		// TODO Auto-generated constructor stub
		viewWebServiceProxy.setEndpoint("http://localhost:8083/AirlineManagementWebService/services/ViewWebService");
	}
	
	public Customer[] getCustomerDetails(){
		Customer[] customersBean = null;
		try {
			//System.out.println("##################### 2");
			customersBean = viewWebServiceProxy.getCustomerDetails();
			//System.out.println("##################### After client");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customersBean;
	}
	
	public Staff[] getStaffDetails(){
		Staff[] staffBean = null;
		try {
			//System.out.println("##################### 2");
			staffBean = viewWebServiceProxy.getStaffDetails();
			//System.out.println("##################### After client");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staffBean;
	}
	
	public Booking[] getBookingDetails(){
		Booking[] bookingBean = null;
		try {
			//System.out.println("##################### 2");
			bookingBean = viewWebServiceProxy.getBookingDetails();
			//System.out.println("##################### After client");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookingBean;
	}
	
	public FlightDetails[] getFlightDetails(){
		FlightDetails[] flightDetailBean = null;
		try {
			//System.out.println("##################### 2");
			flightDetailBean = viewWebServiceProxy.getFlightDetails();
			//System.out.println("##################### After client");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightDetailBean;
	}
	
	
}

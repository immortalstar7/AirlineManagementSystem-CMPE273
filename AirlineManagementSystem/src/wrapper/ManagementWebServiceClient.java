package wrapper;

import java.rmi.RemoteException;
import model.Customer;
import model.Flight;
import model.FlightCustomerBean;
import model.FlightDetails;
import model.Staff;

public class ManagementWebServiceClient {
	
	ManagementWebServiceProxy managementWebServiceProxy = new ManagementWebServiceProxy();
	
	public ManagementWebServiceClient() {
		// TODO Auto-generated constructor stub
		managementWebServiceProxy.setEndpoint("http://localhost:8083/AirlineManagementWebService/services/ManagementWebService");
	}
	
	
	public String updateCustomerInfo( Customer customer ) 
	{
		String result=null;
		try {
			result = managementWebServiceProxy.updateCustomerInfo(customer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String deleteCustomer( int cust_Id )
	{
		String result=null;
		try {
			result = managementWebServiceProxy.deleteCustomer(cust_Id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	public Customer getCustomerInfo(int user_id )
	{
		Customer customer = null;
		try {
			customer = managementWebServiceProxy.getCustomerInfo(user_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
		
	}
	

	public String updateFlightInfo(Flight flight ) 
	{
		String result=null;
		try {
			result = managementWebServiceProxy.updateFlightInfo(flight);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String deleteFlight(String flight_Num )
	{
		String result = null;
		try {
			result = managementWebServiceProxy.deleteFlight(flight_Num);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public FlightDetails getFlightInfo(String flight_Num )
	{
		FlightDetails flightDetails = null;
		try {
			flightDetails = managementWebServiceProxy.getFlightInfo(flight_Num);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightDetails;
	}
	
	
	public String updateStaffInfo(Staff staff)
	{
		String result=null;
		try {
			result = managementWebServiceProxy.updateStaffInfo(staff);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public String deleteStaff(int staff_Id )
	{
		String result = null;
		try {
			result = managementWebServiceProxy.deleteStaff(staff_Id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public Staff getStaffInfo(int staff_Id ) 
	{
		Staff staff = null;;
		try {
			staff = managementWebServiceProxy.getStaffInfo(staff_Id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
		
	}
	
	public FlightCustomerBean[]  listFlightAndCustomer(String flight_Num )
	{
		FlightCustomerBean[] flightCustomerBean = null;
		try {
			flightCustomerBean = managementWebServiceProxy.listFlightAndCustomer(flight_Num);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightCustomerBean;
		
	}
}

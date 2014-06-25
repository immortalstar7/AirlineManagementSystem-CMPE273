package wrapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.Customer;
import model.Flight;
import model.FlightCustomerBean;
import model.FlightDetails;
import model.Staff;
import service.ManagementService;

@WebService(serviceName="ManagementWebService")
public class ManagementWebService {
	Connection con=null;
	ResultSet rs;
	Statement stmt=null;
	ManagementService managementService = new ManagementService();
	
	
	
	@WebMethod(operationName="updateCustomerInfo")
	public String updateCustomerInfo(@WebParam(name="customer") Customer customer ) 
	{
		String result = managementService.updateCustomerInfo(customer);
		return result;
	}
	
	@WebMethod(operationName="deleteCustomer")
	public String deleteCustomer(@WebParam(name="cust_Id") int cust_Id )
	{
		String result = managementService.deleteCustomer(cust_Id);
		return result;
	}
	
	@WebMethod(operationName="getCustomerInfo")
	public Customer getCustomerInfo( @WebParam(name="user_id")int user_id )
	{
		Customer customer = managementService.getCustomerInfo(user_id);
		return customer;
		
	}
	
	@WebMethod(operationName="updateFlightInfo")
	public String updateFlightInfo( @WebParam(name="flight")Flight flight ) 
	{
		String result = managementService.updateFlightInfo(flight);
		return result;
	}
	
	@WebMethod(operationName="deleteFlight")
	public String deleteFlight(@WebParam(name="flight_Num") String flight_Num )
	{
		String result = managementService.deleteFlight(flight_Num);
		return result;
		
	}
	
	@WebMethod(operationName="getFlightInfo")
	public FlightDetails getFlightInfo(@WebParam(name="flight_Num") String flight_Num )
	{
		FlightDetails flightDetails = managementService.getFlightInfo(flight_Num);
		return flightDetails;
	}
	
	@WebMethod(operationName="updateStaffInfo")
	public String updateStaffInfo(@WebParam(name="staff")Staff staff)
	{
		String result = managementService.updateStaffInfo(staff);
		return result;
		
	}
	
	@WebMethod(operationName="deleteStaff")
	public String deleteStaff( @WebParam(name="staff_Id")int staff_Id )
	{
		String result = managementService.deleteStaff(staff_Id);
		return result;
		
	}
	
	@WebMethod(operationName="getStaffInfo")
	public Staff getStaffInfo(@WebParam(name="staff_Id") int staff_Id ) 
	{
		Staff staff = managementService.getStaffInfo(staff_Id);
		return staff;
		
	}
	
	@WebMethod(operationName="listFlightAndCustomer")
	public FlightCustomerBean[]  listFlightAndCustomer(@WebParam(name="flight_Num") String flight_Num )
	{
		List<FlightCustomerBean> list =	managementService.listFlightAndCustomer(flight_Num);
		FlightCustomerBean[] flightCustomerBeansArray = new FlightCustomerBean[list.size()];
		for(int i=0;i<flightCustomerBeansArray.length;i++){
			flightCustomerBeansArray[i] = list.get(i);
		}
		return flightCustomerBeansArray;
		
	}
}

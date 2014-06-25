package wrapper;

import java.rmi.RemoteException;

import model.Customer;
import model.CustomerMessageBean;
import model.Staff;
import model.StaffMessageBean;
import model.UserMessageBean;

public class LoginWebServiceClient {

	LoginWebServiceProxy loginWebServiceProxy = new LoginWebServiceProxy();
	public LoginWebServiceClient() {
		// TODO Auto-generated constructor stub
		loginWebServiceProxy.setEndpoint("http://localhost:8083/AirlineManagementWebService/services/LoginWebService");
		
	}
	
	public CustomerMessageBean customerRegistration(Customer customer){
		CustomerMessageBean customerMessageBean = null;
		try {
			customerMessageBean = loginWebServiceProxy.customerRegistration(customer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerMessageBean;
	}
	
	public StaffMessageBean staffRegistration(Staff staff){
		StaffMessageBean staffMessageBean = null;
		try {
			staffMessageBean = loginWebServiceProxy.staffRegistration(staff);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staffMessageBean;
	}
	
	public UserMessageBean userValidation(String email,String password,String type){
		UserMessageBean userMessageBean = null;
		try {
			userMessageBean = loginWebServiceProxy.userValidation(email, password,type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userMessageBean;
	}
}

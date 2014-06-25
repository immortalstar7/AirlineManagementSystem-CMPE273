package wrapper;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import service.CustomerService;
import service.LoginService;
import service.StaffService;
import model.Customer;
import model.CustomerMessageBean;
import model.Staff;
import model.StaffMessageBean;
import model.UserMessageBean;

@WebService(serviceName="LoginWebService")
public class LoginWebService {
	CustomerService customerService = new CustomerService();
	StaffService staffService = new StaffService(); 
	LoginService loginService = new LoginService();
	
	@WebMethod(operationName="customerRegistration")
	public CustomerMessageBean customerRegistration(@WebParam(name="customer")Customer customer) {
		CustomerMessageBean customerMessageBean = new CustomerMessageBean();
		customerMessageBean =customerService.addCustomer(customer);
		return customerMessageBean;
		
	}

	@WebMethod(operationName="staffRegistration")
	public StaffMessageBean staffRegistration(@WebParam(name="staff")Staff staff) {
		StaffMessageBean staffMessageBean = new StaffMessageBean();
		staffMessageBean =staffService.addStaff(staff);
		return staffMessageBean;
		
	}
	@WebMethod(operationName="userValidation")
	public UserMessageBean userValidation(@WebParam(name="email")String email, @WebParam(name="password")String password, @WebParam(name="type")String type) {
		UserMessageBean userMessageBean = loginService.validateUser(email, password,type);
		return userMessageBean;
	}
}

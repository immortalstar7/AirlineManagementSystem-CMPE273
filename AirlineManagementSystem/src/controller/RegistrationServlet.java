package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wrapper.LoginWebServiceClient;

import model.Customer;
import model.CustomerMessageBean;
import model.Staff;
import model.StaffMessageBean;


/**
 * Servlet implementation class Registration
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CUSTOMER_REGISTRATION_PAGE = "/CustomerRegistrationForm.jsp";
	private static final String STAFF_REGISTRATION_PAGE = "/StaffRegistrationForm.jsp";
	private static final String HOME_PAGE = "/Home.jsp";	
	LoginWebServiceClient loginWebServiceClient = new LoginWebServiceClient();
	CustomerMessageBean customerMessageBean = null;
	StaffMessageBean staffMessageBean = null;	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		
		String strUserMsg = null;
		HttpSession session = request.getSession();
		RequestDispatcher reqDisp = null;
		String type = request.getParameter("type");
		session.setAttribute("type", request.getParameter("type"));
		System.out.println("type is: "+type);
		try {
			if(type.equalsIgnoreCase("customer")){
				reqDisp =  request.getRequestDispatcher(CUSTOMER_REGISTRATION_PAGE);
				customerMessageBean = loginWebServiceClient.customerRegistration(createCustomerFromRequest(request));
				System.out.println("2");
				if(customerMessageBean.getCustomer() != null){
					System.out.println("3");
					session.setAttribute("user_id",customerMessageBean.getCustomer().getUser_id());						
					strUserMsg = customerMessageBean.getMessage();
					session.setAttribute("msg", strUserMsg);
					request.setAttribute("userMsg", strUserMsg);
				}
			}else if(type.equalsIgnoreCase("staff")){
				System.out.println("Inside Staff");
				reqDisp =  request.getRequestDispatcher(STAFF_REGISTRATION_PAGE);
				staffMessageBean = loginWebServiceClient.staffRegistration(createStaffFromRequest(request));
				if(staffMessageBean.getStaff() != null){
					session.setAttribute("user_id",staffMessageBean.getStaff().getUser_id());						
					strUserMsg = staffMessageBean.getMessage();
					session.setAttribute("msg", strUserMsg);
					request.setAttribute("userMsg", strUserMsg);
				}
			}
			
				
				response.sendRedirect(getServletContext().getContextPath()+HOME_PAGE);
			
			
		}catch(Exception e) {//If it goes into Exception other than SQLException
			System.out.println("Unable to register user: "+e.getMessage());
			strUserMsg = "Unable to register user "+request.getParameter("userName")
			+". Please try again later.";
			setRequestAttributes(request);
			request.setAttribute("userMsg", strUserMsg);
			reqDisp.forward(request, response);

		}
	}
	/**
	 * Fancy way of looking through all the request parameters and setting in request Attributes.
	 * @param request
	 */
	private void setRequestAttributes(HttpServletRequest request) {
		Enumeration<String>  enumKeys =  request.getParameterNames();
		while(enumKeys.hasMoreElements()) {
			String key  = enumKeys.nextElement();
			request.setAttribute(key, request.getParameter(key))  ;
		}
	}
	
	public Customer createCustomerFromRequest(HttpServletRequest request){
		System.out.println("Inside create");
		Customer customer = new Customer();
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");	
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		System.out.println("jjjj");
		String zipcode = request.getParameter("zipcode");
		String dob = request.getParameter("dob");
		int customer_ssn = Integer.parseInt(request.getParameter("customer_ssn"));
		String nationality = request.getParameter("nationality");
		String passport_no = request.getParameter("passport_no");
		System.out.println("444");
		customer.setF_name(firstName);
		customer.setL_name(lastName);
		customer.setPassword(password);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setZipcode(zipcode);
		customer.setDob(dob);
		customer.setNationality(nationality);
		customer.setCustomer_ssn(customer_ssn);
		customer.setPassport_no(passport_no);
		customer.setType("customer");
		return customer;
	}
	public Staff createStaffFromRequest(HttpServletRequest request){
		System.out.println("Inside create");
		Staff staff = new Staff();
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");	
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		System.out.println("jjjj");
		String zipcode = request.getParameter("zipcode");
		String dob = request.getParameter("dob");
		int staff_ssn = Integer.parseInt(request.getParameter("staff_ssn"));
		String work_desc = request.getParameter("work_desc");
		String position = request.getParameter("position");
		String hire_date = request.getParameter("hire_date");
		System.out.println("444");
		staff.setF_name(firstName);
		staff.setL_name(lastName);
		staff.setPassword(password);
		staff.setEmail(email);
		staff.setAddress(address);
		staff.setCity(city);
		staff.setState(state);
		staff.setZipcode(zipcode);
		staff.setDob(dob);
		staff.setStaff_ssn(staff_ssn);
		staff.setWork_desc(work_desc);
		staff.setPosition(position);
		staff.setHire_date(hire_date);
		staff.setType("staff");
		return staff;
	}

}

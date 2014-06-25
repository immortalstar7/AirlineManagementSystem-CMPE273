package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Flight;
import model.FlightCustomerBean;
import model.Staff;

import wrapper.ManagementWebServiceClient;
import wrapper.SearchWebServiceClient;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ManagementWebServiceClient managementWebServiceClient = new ManagementWebServiceClient();
	 SearchWebServiceClient searchWebServiceClient = new SearchWebServiceClient();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search_type = request.getParameter("search_type");
		
		if(search_type.equals("booking")){
			FlightCustomerBean[] bookingList = null;
			String flight_Num = request.getParameter("flightNumber");
			System.out.println("Inside Servlet");
			bookingList = managementWebServiceClient.listFlightAndCustomer(flight_Num);
			request.setAttribute("bookingList",bookingList);
			RequestDispatcher reqDisp = request.getRequestDispatcher("/SearchBooking.jsp");
		     reqDisp.forward(request, response);
		}
		if(search_type.equals("flight")|| search_type.equals("flight_home")){
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String depart_date = request.getParameter("depart_date");
			System.out.println("Source: "+source);
			System.out.println("Destination:: "+destination);
			System.out.println("Date:: "+depart_date);
			Flight[] flightList = searchWebServiceClient.searchFlights(source, destination, depart_date);
			request.setAttribute("flightList",flightList);
			if(search_type.equals("flight_home")){
				RequestDispatcher reqDisp = request.getRequestDispatcher("/Home.jsp");
				reqDisp.forward(request, response);
			}else{
			RequestDispatcher reqDisp = request.getRequestDispatcher("/SearchFlight.jsp");
		     reqDisp.forward(request, response);
			}
		}
		if(search_type.equals("customer")){
			Customer customer = createCustomerFromRequest(request);
			Customer customerList[] = searchWebServiceClient.searchCustomers(customer);
			request.setAttribute("customerList",customerList);
			RequestDispatcher reqDisp = request.getRequestDispatcher("/SearchCustomer.jsp");
		    reqDisp.forward(request, response);
		}
		if(search_type.equals("staff") ){
			Staff staff = createStaffFromRequest(request);
			Staff staffList[] = searchWebServiceClient.searchStaff(staff);
			request.setAttribute("staffList",staffList);			
			RequestDispatcher reqDisp = request.getRequestDispatcher("/SearchEmployee.jsp");
			reqDisp.forward(request, response);
			
			
		    
		}
		
	}
	
	public Customer createCustomerFromRequest(HttpServletRequest request){
		Customer customer = new Customer();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");	
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String dob = request.getParameter("dob");
		String nationality = request.getParameter("nationality");
		String passport_no = request.getParameter("passport_no");
		
		customer.setF_name(firstName);
		customer.setL_name(lastName);
		
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setZipcode(zipcode);
		customer.setDob(dob);
		customer.setNationality(nationality);
		customer.setPassport_no(passport_no);
		customer.setType("customer");
		return customer;
	}
	public Staff createStaffFromRequest(HttpServletRequest request){
		
		Staff staff = new Staff();
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");	
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String dob = request.getParameter("dob");
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
		staff.setWork_desc(work_desc);
		staff.setPosition(position);
		staff.setHire_date(hire_date);
		staff.setType("staff");
		return staff;
	}

}

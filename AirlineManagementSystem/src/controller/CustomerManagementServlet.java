package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wrapper.ManagementWebServiceClient;
import model.Customer;

/**
 * Servlet implementation class CustomerManagementServlet
 */
public class CustomerManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ManagementWebServiceClient managementWebServiceClient = new ManagementWebServiceClient();
    Customer customer = new Customer();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In get of CustomerManagementServlet");
	    HttpSession session = request.getSession();	  
		int user_id = (Integer) session.getAttribute("user_id");
		this.customer = managementWebServiceClient.getCustomerInfo(user_id);
		System.out.println("Email::: "+this.customer.getEmail());
		Customer [] customerArray = new Customer[1];
		customerArray[0] = this.customer;
		request.setAttribute("customerArray",customerArray);
		RequestDispatcher reqDisp = request.getRequestDispatcher("/CustomerUpdateForm.jsp");
	     reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		String operation = request.getParameter("operation");
		String result = null;
		if(operation.equals("Update_Customer")){
			Customer updatedCustomer = new Customer();
			HttpSession session = request.getSession();	  
			int user_id = (Integer) session.getAttribute("user_id");
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
			
			if(!customer.getF_name().equalsIgnoreCase(firstName)){
				updatedCustomer.setF_name(firstName);
			}
			if(!customer.getL_name().equalsIgnoreCase(lastName)){
				updatedCustomer.setL_name(lastName);
			}
			if(!customer.getEmail().equalsIgnoreCase(email)){
				updatedCustomer.setEmail(email);
			}
			if(!customer.getAddress().equalsIgnoreCase(address)){
				updatedCustomer.setAddress(address);
			}
			if(!customer.getCity().equalsIgnoreCase(city)){
				updatedCustomer.setCity(city);
			}
			if(!customer.getState().equalsIgnoreCase(state)){
				updatedCustomer.setState(state);
			}
			
			if(customer.getZipcode() != zipcode){
				updatedCustomer.setZipcode(zipcode);
			}
			if(!customer.getDob().equalsIgnoreCase(dob)){
				updatedCustomer.setDob(dob);
			}
			if(!customer.getNationality().equalsIgnoreCase(nationality)){
				updatedCustomer.setNationality(nationality);
			}
			if(!customer.getPassport_no().equalsIgnoreCase(passport_no)){
				updatedCustomer.setPassport_no(passport_no);
			}
			updatedCustomer.setUser_id(user_id);
			result = managementWebServiceClient.updateCustomerInfo(updatedCustomer);
			System.out.println("Result of updataion:: "+result);
			RequestDispatcher reqDisp = request.getRequestDispatcher("/CustomerUpdateForm.jsp");
		     reqDisp.forward(request, response);
		}else if(operation.equals("Delete_Customer")){
			String[] checkboxvalues=request.getParameterValues("CustomerCheckbox");
			  for(int i=0;i<checkboxvalues.length;i++)
			  {
				  System.out.println("Customer Id is:: "+checkboxvalues[i]);
				  int user_id = Integer.parseInt(checkboxvalues[i]);				 
				  result = managementWebServiceClient.deleteCustomer(user_id);
				  
			  }
			  System.out.println("Result of Deletion:: "+result);
			
			  RequestDispatcher reqDisp = request.getRequestDispatcher("/DetailsView.jsp");
			     reqDisp.forward(request, response);
		}
		
	/*	
	     */
	}

}

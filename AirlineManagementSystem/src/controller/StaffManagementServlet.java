package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wrapper.ManagementWebServiceClient;
import model.Staff;

/**
 * Servlet implementation class CustomerManagementServlet
 */
public class StaffManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ManagementWebServiceClient managementWebServiceClient = new ManagementWebServiceClient();
    Staff staff = new Staff();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In get of StaffManagementServlet");
	    HttpSession session = request.getSession();	  
		int user_id = (Integer) session.getAttribute("user_id");
		this.staff = managementWebServiceClient.getStaffInfo(user_id);
		System.out.println("Email::: "+this.staff.getEmail());
		Staff [] staffArray = new Staff[1];
		staffArray[0] = this.staff;
		request.setAttribute("staffArray",staffArray);
		RequestDispatcher reqDisp = request.getRequestDispatcher("/StaffUpdateForm.jsp");
	     reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("Inside Staff");
		String staff_operation = request.getParameter("staff_operation");
		String result = null;
		if(staff_operation.equals("Update_Staff")){
			Staff updatedStaff = new Staff();
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
			String work_desc = request.getParameter("work_desc");
			String position = request.getParameter("position");
			String hire_date = request.getParameter("hire_date");
			
			if(!staff.getF_name().equalsIgnoreCase(firstName)){
				updatedStaff.setF_name(firstName);
			}
			if(!staff.getL_name().equalsIgnoreCase(lastName)){
				updatedStaff.setL_name(lastName);
			}
			if(!staff.getEmail().equalsIgnoreCase(email)){
				updatedStaff.setEmail(email);
			}
			if(!staff.getAddress().equalsIgnoreCase(address)){
				updatedStaff.setAddress(address);
			}
			if(!staff.getCity().equalsIgnoreCase(city)){
				updatedStaff.setCity(city);
			}
			if(!staff.getState().equalsIgnoreCase(state)){
				updatedStaff.setState(state);
			}
			
			if(staff.getZipcode() != zipcode){
				updatedStaff.setZipcode(zipcode);
			}
			if(!staff.getDob().equalsIgnoreCase(dob)){
				updatedStaff.setDob(dob);
			}
			if(!staff.getWork_desc().equalsIgnoreCase(work_desc)){
				updatedStaff.setWork_desc(work_desc);
			}
			if(!staff.getPosition().equalsIgnoreCase(position)){
				updatedStaff.setPosition(position);
			}
			if(!staff.getHire_date().equalsIgnoreCase(hire_date)){
				updatedStaff.setHire_date(hire_date);
			}
			updatedStaff.setUser_id(user_id);
			result = managementWebServiceClient.updateStaffInfo(updatedStaff);
			System.out.println("Result of updataion:: "+result);
			RequestDispatcher reqDisp = request.getRequestDispatcher("/StaffUpdateForm.jsp");
		     reqDisp.forward(request, response);
		}else if(staff_operation.equals("Delete_Staff")){
			System.out.println("Inside staff delete");
			String[] checkboxvalues=request.getParameterValues("StaffCheckbox");
			  for(int i=0;i<checkboxvalues.length;i++)
			  {
				  System.out.println("Staff Id is:: "+checkboxvalues[i]);
				  int user_id = Integer.parseInt(checkboxvalues[i]);				 
				  result = managementWebServiceClient.deleteStaff(user_id);
				  
			  }
			  System.out.println("Result of Deletion:: "+result);
			
			  RequestDispatcher reqDisp = request.getRequestDispatcher("/DetailsView.jsp");
			     reqDisp.forward(request, response);
		}
		
	/*	
	     */
	}

}

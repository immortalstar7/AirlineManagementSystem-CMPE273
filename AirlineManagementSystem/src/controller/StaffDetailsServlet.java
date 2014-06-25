package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Staff;

import wrapper.ViewWebServiceClient;

/**
 * Servlet implementation class StaffDetailsServlet
 */
public class StaffDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ViewWebServiceClient viewWebServiceClient = new ViewWebServiceClient(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Get staff");
		Staff [] staff = viewWebServiceClient.getStaffDetails();
		//System.out.println("##################### Finish");
		//System.out.println("User Id Retrieved:: "+cust[0].getUser_id());
		request.setAttribute("staffList", staff);
		//response.sendRedirect("DetailsView.jsp"); 
		 RequestDispatcher reqDisp = request.getRequestDispatcher("/DetailsView.jsp");
	     reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in post");
	}

}

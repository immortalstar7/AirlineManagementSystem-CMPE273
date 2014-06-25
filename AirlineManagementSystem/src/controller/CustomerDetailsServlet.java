package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Booking;
import model.Customer;
import model.FlightDetails;
import model.Staff;

import wrapper.LoginWebServiceClient;
import wrapper.ViewWebServiceClient;

/**
 * Servlet implementation class CustomerDetailsServlet
 */
public class CustomerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//DefaultNamespace.MarketplaceProxy proxy = new DefaultNamespace.MarketplaceProxy();
	
	ViewWebServiceClient viewWebServiceClient = new ViewWebServiceClient();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Get customer");
		Customer [] cust = viewWebServiceClient.getCustomerDetails();
		//System.out.println("##################### Finish");
		//System.out.println("User Id Retrieved:: "+cust[0].getUser_id());
		request.setAttribute("customerList", cust);
		Staff [] staff = viewWebServiceClient.getStaffDetails();
		request.setAttribute("staffList", staff);
		FlightDetails [] flights = viewWebServiceClient.getFlightDetails();
		request.setAttribute("flightList", flights);
		Booking [] booking = viewWebServiceClient.getBookingDetails();
		request.setAttribute("bookingList", booking);
		//response.sendRedirect("DetailsView.jsp"); 
		 RequestDispatcher reqDisp = request.getRequestDispatcher("/DetailsView.jsp");
	     reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("in post servlet");
		//System.out.println("##################### 1");
		System.out.println("In Post customer");
		Customer [] cust = viewWebServiceClient.getCustomerDetails();
		//System.out.println("##################### Finish");
		//System.out.println("User Id Retrieved:: "+cust[0].getUser_id());
		request.setAttribute("customerList", cust);
		//response.sendRedirect("DetailsView.jsp"); 
		 RequestDispatcher reqDisp = request.getRequestDispatcher("/DetailsView.jsp");
	     reqDisp.forward(request, response);
	}

}

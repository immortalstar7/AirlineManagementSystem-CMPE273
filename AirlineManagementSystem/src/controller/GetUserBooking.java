package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wrapper.FlightWebServiceProxy;

/**
 * Servlet implementation class GetUserBooking
 */
public class GetUserBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FlightWebServiceProxy proxy = new FlightWebServiceProxy();
		HttpSession session = request.getSession();	  
		int user_id = (Integer) session.getAttribute("user_id");
		String userBookingDetails = proxy.getUserBookingDetails(user_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserBooking.jsp");
		request.setAttribute("userBookingDetails", userBookingDetails);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

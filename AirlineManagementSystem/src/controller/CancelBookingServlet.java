package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wrapper.FlightWebServiceProxy;

/**
 * Servlet implementation class CancelBookingServlet
 */
public class CancelBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBookingServlet() {
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
		String status = "";
		int user_id = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		String flightNo = request.getParameter("flightNumber");
		String flightDate = request.getParameter("flyingDate");
		int numSeats = Integer.parseInt(request.getParameter("numSeats").toString());
		if(numSeats>0 && numSeats<=5){
			FlightWebServiceProxy proxy = new FlightWebServiceProxy();
			status = proxy.cancelUserBooking(user_id, flightNo, flightDate, numSeats);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("CancelBooking.jsp");
		request.setAttribute("status", status);
		dispatcher.forward(request, response);
	}
}

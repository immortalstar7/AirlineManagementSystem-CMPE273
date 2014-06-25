package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wrapper.FlightWebServiceProxy;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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
		int userid = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		String flightNo = request.getParameter("flightNo");
		String flightDate = request.getParameter("flightDate");
		int numSeats = Integer.parseInt(request.getParameter("noofseats").toString());
		double total_cost = Double.parseDouble(request.getParameter("total_cost"));
		FlightWebServiceProxy flightWebServiceProxy = new FlightWebServiceProxy();
		String status = flightWebServiceProxy.payment(userid, flightNo, flightDate, numSeats);		
		request.setAttribute("flightNo", flightNo);
		request.setAttribute("flightDate", flightDate);
		request.setAttribute("noofseats", numSeats);
		request.setAttribute("total_cost",total_cost);
		request.setAttribute("status", status);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Ticket.jsp");
		
		dispatcher.forward(request, response);
		
	}

}

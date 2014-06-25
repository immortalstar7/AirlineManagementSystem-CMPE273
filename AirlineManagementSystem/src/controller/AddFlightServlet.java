package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Flight;
import wrapper.FlightWebServiceProxy;

/**
 * Servlet implementation class FlightServlet
 */
public class AddFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlightServlet() {
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
		FlightWebServiceProxy proxy = new FlightWebServiceProxy();
		Flight flight = new Flight();
		if(request!=null) {
			if(request.getParameter("flightName")!=null && request.getParameter("flightName")!="")
				flight.setFlight_name(request.getParameter("flightName"));
			if(request.getParameter("numberOfSeats")!=null && request.getParameter("numberOfSeats")!="")
				flight.setNo_of_seats(Integer.parseInt(request.getParameter("numberOfSeats")));
		}			
		String status = proxy.addFlights(flight);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddFlight.jsp");
		request.setAttribute("status", status);
		dispatcher.forward(request, response);
	}

}

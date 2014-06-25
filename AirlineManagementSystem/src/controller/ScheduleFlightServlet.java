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
 * Servlet implementation class ScheduleFlightServlet
 */
public class ScheduleFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleFlightServlet() {
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
		String flightNo = request.getParameter("flightNo");
		String flightdate = request.getParameter("flightdate");
		String source = request.getParameter("source");
		String dest = request.getParameter("dest");
		int seats = Integer.parseInt(request.getParameter("seats"));		
		double fare = Double.parseDouble(request.getParameter("fare"));	
		String[] staff = new String[3];
		staff[0] = request.getParameter("staff1");
		staff[1] = request.getParameter("staff2");
		staff[2] = request.getParameter("staff3");
		String status = proxy.scheduleNewFlight(flightNo, flightdate, source, dest, seats,fare, staff);
		System.out.println(status);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ScheduleFlight.jsp");
		request.setAttribute("schedulestatus", status);
		dispatcher.forward(request, response);
	}

}

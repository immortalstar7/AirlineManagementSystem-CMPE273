package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wrapper.FlightWebServiceProxy;

/**
 * Servlet implementation class UpdateFlightServlet
 */
public class UpdateFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlightServlet() {
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
		String flightNum = request.getParameter("updateflightNumber");
		String currDate = request.getParameter("currentflyingDate");
		String flightDate = request.getParameter("updateflyingDate");
		String source = request.getParameter("updatesource");
		String dest = request.getParameter("updatedest");
		String status;
		System.out.println("Source: "+source+" Dest: "+dest);
		System.out.println("Inservlet current flight date: "+currDate);
		System.out.println("Inservlet new flight date: "+flightDate);
		if(source != "" && dest != "" && (source.equals(dest))){
			status = "Source should not be the same as destination";
		} else {
			FlightWebServiceProxy proxy = new FlightWebServiceProxy();
			status = proxy.updateFlight(flightNum,currDate, flightDate, source, dest);
		}	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateFlight.jsp");
		request.setAttribute("updatestatus", status);
		dispatcher.forward(request, response);
	}

}

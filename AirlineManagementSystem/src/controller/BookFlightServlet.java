package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wrapper.FlightWebServiceProxy;

/**
 * Servlet implementation class BookFlightServlet
 */
public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFlightServlet() {
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
		int userid = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		String flightNo = request.getParameter("flightNumber");
		String flightDate = request.getParameter("flyingDate");
		int numSeats = Integer.parseInt(request.getParameter("numSeats").toString());
		if(numSeats>0 && numSeats<=5){
			FlightWebServiceProxy proxy = new FlightWebServiceProxy();
			status = proxy.bookFlights(userid, flightNo, flightDate, numSeats);
		}else{
			status = "Invalid No of Seat";
		}
		
		String [] str = status.split("#");
		System.out.println("str: "+str[0]);
		if(str[0].equals("success")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("Payment.jsp");
			request.setAttribute("flightNo", flightNo);
			request.setAttribute("flightDate", flightDate);
			request.setAttribute("noofseats", numSeats);
			request.setAttribute("total_cost", (Double.parseDouble(str[1])* numSeats));
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("BookFlight.jsp");
			request.setAttribute("status", status);
			dispatcher.forward(request, response);
		}
	}

}

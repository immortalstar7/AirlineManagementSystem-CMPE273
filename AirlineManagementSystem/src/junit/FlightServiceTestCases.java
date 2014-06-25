package junit;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import junit.framework.Assert;
import model.Flight;

import org.junit.Test;

import wrapper.FlightWebServiceProxy;

public class FlightServiceTestCases {
	FlightWebServiceProxy flightProxy = new FlightWebServiceProxy();
	
	//Add Flights
	@Test
	public void testEmptyFlightName() {
		Flight flight = new Flight();
		flight.setFlight_name("");
		flight.setNo_of_seats(4);
		try {
			String result = flightProxy.addFlights(flight);
			assertEquals("Flight not added to the system", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInvalidFlightName() {
		Flight flight = new Flight();
		flight.setFlight_name("@#$%");
		flight.setNo_of_seats(3);
		try {
			String result = flightProxy.addFlights(flight);
			assertEquals("Flight not added to the system", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSeatsEqualZero() {
		Flight flight = new Flight();
		flight.setFlight_name("AirBus");
		flight.setNo_of_seats(0);
		try {
			String result = flightProxy.addFlights(flight);
			assertEquals("Flight not added to the system", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSeatsMore() {
		Flight flight = new Flight();
		flight.setFlight_name("AirBus");
		flight.setNo_of_seats(10000);
		try {
			String result = flightProxy.addFlights(flight);
			assertEquals("Flight not added to the system", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExistingFlightName() {
		Flight flight = new Flight();
		flight.setFlight_name("Airline 420");
		flight.setNo_of_seats(100);
		try {
			String result = flightProxy.addFlights(flight);
			assertEquals("Flight with this name already exists.Flight not added.", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddFlight() {
		Flight flight = new Flight();
		flight.setFlight_name("AirIndia");
		flight.setNo_of_seats(200);
		try {
			String result = flightProxy.addFlights(flight);
			assertTrue(result.startsWith("Flight is added successfully."));;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Schedule New Flights
	@Test
	public void testInvalidSource() {
		String[] staff = new String[3];
		staff[0] = "Jim Carry";
		staff[1] = "John Smith";
		staff[2] = "James Albert";
		try {
			String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/12", "^&%$", "Bangalore", 4, 500.0, staff);
			assertEquals("Invalid Source string", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInvalidDestination() {
		String[] staff = new String[3];
		staff[0] = "Jim Carry";
		staff[1] = "John Smith";
		staff[2] = "James Albert";
		try {
			String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/12", "Bangalore", "^&%$", 4, 500.0, staff);
			assertEquals("Invalid Destination string", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSeatslessZero() {
		String[] staff = new String[3];
		staff[0] = "Jim Carry";
		staff[1] = "John Smith";
		staff[2] = "James Albert";
		try {
			String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/12", "Bangalore", "San Francisco", -5, 500.0, staff);
			assertEquals("Number of seats must be greater than 0", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		@Test
		public void testInvalidFare() {
			String[] staff = new String[3];
			staff[0] = "Jim Carry";
			staff[1] = "John Smith";
			staff[2] = "James Albert";
			try {
				String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/12", "Bangalore", "San Francisco", 5, 0, staff);
				assertEquals("Invalid Fare", result);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			@Test
			public void testInadequateStaff() {
				String[] staff = new String[3];
				staff[0] = "Jim Carry";
				staff[1] = "John Smith";
				try {
					String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/12", "Bangalore", "San Francisco", 5, 100.0, staff);
					assertEquals("Invalid number of staff members", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testScheduledAlready() {
				String[] staff = new String[3];
				staff[0] = "Jim Carry";
				staff[1] = "John Smith";
				staff[2] = "James Albert";

				try {
					String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/31", "SJC", "PHX", 5, 100.0, staff);
					assertEquals("This flight has been scheduled already for this date.", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testMoreScheduledSeats() {
				String[] staff = new String[3];
				staff[0] = "Jim Carry";
				staff[1] = "John Smith";
				staff[2] = "James Albert";

				try {
					String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/03", "SJC", "PHX", 400, 100.0, staff);
					assertEquals("Available seats are less than the seats scheduled", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testInvalidStaff() {
				String[] staff = new String[3];
				staff[0] = "Jim Carry";
				staff[1] = "Mr abc";
				staff[2] = "James Albert";

				try {
					String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/30", "SJC", "PHX", 300, 100.0, staff);
					assertEquals("Staff Mr abc does not exist.", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testScheduleStaff() {
				String[] staff = new String[3];
				staff[0] = "Jim Carry";
				staff[1] = "John Smith";
				staff[2] = "James Albert";

				try {
					String result = flightProxy.scheduleNewFlight("AMS10001", "2013/12/30", "SJC", "PHX", 300, 100.0, staff);
					assertEquals("Flight scheduled successfully", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Book Flights
			@Test
			public void testFlightNotScheduled() {
				
				try {
					String result = flightProxy.bookFlights(15, "AMS10001", "2013/01/01", 4);
					assertEquals("The flight has not been scheduled for the requested date", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testUnavailableSeats() {				
				try {
					String result = flightProxy.bookFlights(15, "AMS10001", "2013/12/31", 400);
					assertEquals("The requested number of seats are not available", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
			@Test
			public void testMaxSeatsExceeded() {				
				try {
					String result = flightProxy.bookFlights(4003, "AMS10001", "2013/12/31", 4);
					assertEquals("You have already booked 3 seats for this date. You can book maximum of 5 seats only.", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testSeatsAvailable() {				
				try {
					String result = flightProxy.bookFlights(4003, "AMS10001", "2013/12/31", 2);
					assertEquals("success#1000", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//cancel booking
			@Test
			public void testCancelNoBooking() {				
				try {
					String result = flightProxy.bookFlights(4003, "AMS10001", "2013/12/03", 2);
					assertEquals("You do not have a booking for this date", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testCancelMoreBooking() {				
				try {
					String result = flightProxy.bookFlights(4003, "AMS10001", "2013/12/31", 4);
					assertEquals("You are requesting to cancel more seats than what you have booked", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testCancelSuccess() {				
				try {
					String result = flightProxy.bookFlights(4003, "AMS10001", "2013/12/31", 2);
					assertEquals("Cancellation Successfull", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//update flight
			@Test
			public void testSourceSameDest() {				
				try {
					String result = flightProxy.updateFlight("AMS10001", "2013/12/31", "2013/12/03", "San Jose", "San Jose");
					assertEquals("From server Source should not be the same as destination", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testNoSchedule() {				
				try {
					String result = flightProxy.updateFlight("AMS99999", "2013/12/31", "2013/12/03", "San Jose", "San Jose");
					assertEquals("This flight is not scheduled", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testNoScheduleForDate() {				
				try {
					String result = flightProxy.updateFlight("AMS10001", "2013/12/06", "2013/12/03", "San Jose", "San Jose");
					assertEquals("This flight is not scheduled for the given date", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testScheduledSameDate() {				
				try {
					String result = flightProxy.updateFlight("AMS10001", "2013/12/31", "2013/12/31", "SJC", "PHX");
					assertEquals("The flight is already scheduled for the same date, source and destination", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testChgSrcDest() {				
				try {
					String result = flightProxy.updateFlight("AMS10001", "2013/12/31", "2013/12/31", "PHX", "SJC");
					assertEquals("User booking exists for this date. Cannot change source and destination. Can only change date", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Test
			public void testUpdateSuccess() {				
				try {
					String result = flightProxy.updateFlight("AMS10006", "2013/12/26", "2013/12/31", "PHX", "SJC");
					assertEquals("Updated Successfully!!", result);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}

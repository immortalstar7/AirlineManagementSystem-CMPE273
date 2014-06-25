/**
 * FlightWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface FlightWebService extends java.rmi.Remote {
    public java.lang.String getUserBookingDetails(int user_id) throws java.rmi.RemoteException;
    public java.lang.String cancelUserBooking(int userId, java.lang.String flightNum, java.lang.String flyingDate, int noOfSeats) throws java.rmi.RemoteException;
    public java.lang.String scheduleNewFlight(java.lang.String flightNo, java.lang.String flightdate, java.lang.String source, java.lang.String dest, int seats, double fare, java.lang.String[] staff) throws java.rmi.RemoteException;
    public java.lang.String bookFlights(int userId, java.lang.String flightNum, java.lang.String flyingDate, int noOfSeats) throws java.rmi.RemoteException;
    public java.lang.String addFlights(model.Flight flight) throws java.rmi.RemoteException;
    public java.lang.String updateFlight(java.lang.String flightNo, java.lang.String currDate, java.lang.String flightdate, java.lang.String source, java.lang.String dest) throws java.rmi.RemoteException;
    public java.lang.String payment(int userid, java.lang.String flightNo, java.lang.String date, int noOfSeats) throws java.rmi.RemoteException;
}

package wrapper;

public class FlightWebServiceProxy implements wrapper.FlightWebService {
  private String _endpoint = null;
  private wrapper.FlightWebService flightWebService = null;
  
  public FlightWebServiceProxy() {
    _initFlightWebServiceProxy();
  }
  
  public FlightWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFlightWebServiceProxy();
  }
  
  private void _initFlightWebServiceProxy() {
    try {
      flightWebService = (new wrapper.FlightWebServiceServiceLocator()).getFlightWebService();
      if (flightWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)flightWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)flightWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (flightWebService != null)
      ((javax.xml.rpc.Stub)flightWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wrapper.FlightWebService getFlightWebService() {
    if (flightWebService == null)
      _initFlightWebServiceProxy();
    return flightWebService;
  }
  
  public java.lang.String getUserBookingDetails(int user_id) throws java.rmi.RemoteException{
    if (flightWebService == null)
      _initFlightWebServiceProxy();
    return flightWebService.getUserBookingDetails(user_id);
  }
  
  public java.lang.String cancelUserBooking(int userId, java.lang.String flightNum, java.lang.String flyingDate, int noOfSeats) throws java.rmi.RemoteException{
    if (flightWebService == null)
      _initFlightWebServiceProxy();
    return flightWebService.cancelUserBooking(userId, flightNum, flyingDate, noOfSeats);
  }
  
  public java.lang.String scheduleNewFlight(java.lang.String flightNo, java.lang.String flightdate, java.lang.String source, java.lang.String dest, int seats, double fare, java.lang.String[] staff) throws java.rmi.RemoteException{
    if (flightWebService == null)
      _initFlightWebServiceProxy();
    return flightWebService.scheduleNewFlight(flightNo, flightdate, source, dest, seats, fare, staff);
  }
  
  public java.lang.String bookFlights(int userId, java.lang.String flightNum, java.lang.String flyingDate, int noOfSeats) throws java.rmi.RemoteException{
    if (flightWebService == null)
      _initFlightWebServiceProxy();
    return flightWebService.bookFlights(userId, flightNum, flyingDate, noOfSeats);
  }
  
  public java.lang.String addFlights(model.Flight flight) throws java.rmi.RemoteException{
    if (flightWebService == null)
      _initFlightWebServiceProxy();
    return flightWebService.addFlights(flight);
  }
  
  public java.lang.String updateFlight(java.lang.String flightNo, java.lang.String currDate, java.lang.String flightdate, java.lang.String source, java.lang.String dest) throws java.rmi.RemoteException{
    if (flightWebService == null)
      _initFlightWebServiceProxy();
    return flightWebService.updateFlight(flightNo, currDate, flightdate, source, dest);
  }
  
  public java.lang.String payment(int userid, java.lang.String flightNo, java.lang.String date, int noOfSeats) throws java.rmi.RemoteException{
    if (flightWebService == null)
      _initFlightWebServiceProxy();
    return flightWebService.payment(userid, flightNo, date, noOfSeats);
  }
  
  
}
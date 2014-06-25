package wrapper;

public class ViewWebServiceProxy implements wrapper.ViewWebService {
  private String _endpoint = null;
  private wrapper.ViewWebService viewWebService = null;
  
  public ViewWebServiceProxy() {
    _initViewWebServiceProxy();
  }
  
  public ViewWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initViewWebServiceProxy();
  }
  
  private void _initViewWebServiceProxy() {
    try {
      viewWebService = (new wrapper.ViewWebServiceServiceLocator()).getViewWebService();
      if (viewWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)viewWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)viewWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (viewWebService != null)
      ((javax.xml.rpc.Stub)viewWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wrapper.ViewWebService getViewWebService() {
    if (viewWebService == null)
      _initViewWebServiceProxy();
    return viewWebService;
  }
  
  public model.Customer[] getCustomerDetails() throws java.rmi.RemoteException{
    if (viewWebService == null)
      _initViewWebServiceProxy();
    return viewWebService.getCustomerDetails();
  }
  
  public model.FlightDetails[] getFlightDetails() throws java.rmi.RemoteException{
    if (viewWebService == null)
      _initViewWebServiceProxy();
    return viewWebService.getFlightDetails();
  }
  
  public model.Staff[] getStaffDetails() throws java.rmi.RemoteException{
    if (viewWebService == null)
      _initViewWebServiceProxy();
    return viewWebService.getStaffDetails();
  }
  
  public model.Booking[] getBookingDetails() throws java.rmi.RemoteException{
    if (viewWebService == null)
      _initViewWebServiceProxy();
    return viewWebService.getBookingDetails();
  }
  
  
}
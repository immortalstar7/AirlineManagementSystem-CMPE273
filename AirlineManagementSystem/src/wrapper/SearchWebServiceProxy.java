package wrapper;

public class SearchWebServiceProxy implements wrapper.SearchWebService {
  private String _endpoint = null;
  private wrapper.SearchWebService searchWebService = null;
  
  public SearchWebServiceProxy() {
    _initSearchWebServiceProxy();
  }
  
  public SearchWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSearchWebServiceProxy();
  }
  
  private void _initSearchWebServiceProxy() {
    try {
      searchWebService = (new wrapper.SearchWebServiceServiceLocator()).getSearchWebService();
      if (searchWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)searchWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)searchWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (searchWebService != null)
      ((javax.xml.rpc.Stub)searchWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wrapper.SearchWebService getSearchWebService() {
    if (searchWebService == null)
      _initSearchWebServiceProxy();
    return searchWebService;
  }
  
  public model.Staff[] searchStaff(model.Staff staff) throws java.rmi.RemoteException{
    if (searchWebService == null)
      _initSearchWebServiceProxy();
    return searchWebService.searchStaff(staff);
  }
  
  public model.Flight[] searchFlights(java.lang.String source, java.lang.String destination, java.lang.String flight_date) throws java.rmi.RemoteException{
    if (searchWebService == null)
      _initSearchWebServiceProxy();
    return searchWebService.searchFlights(source, destination, flight_date);
  }
  
  public model.Customer[] searchCustomers(model.Customer customer) throws java.rmi.RemoteException{
    if (searchWebService == null)
      _initSearchWebServiceProxy();
    return searchWebService.searchCustomers(customer);
  }
  
  
}
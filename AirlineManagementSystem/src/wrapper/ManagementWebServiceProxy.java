package wrapper;

public class ManagementWebServiceProxy implements wrapper.ManagementWebService {
  private String _endpoint = null;
  private wrapper.ManagementWebService managementWebService = null;
  
  public ManagementWebServiceProxy() {
    _initManagementWebServiceProxy();
  }
  
  public ManagementWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initManagementWebServiceProxy();
  }
  
  private void _initManagementWebServiceProxy() {
    try {
      managementWebService = (new wrapper.ManagementWebServiceServiceLocator()).getManagementWebService();
      if (managementWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)managementWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)managementWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (managementWebService != null)
      ((javax.xml.rpc.Stub)managementWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wrapper.ManagementWebService getManagementWebService() {
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService;
  }
  
  public java.lang.String updateCustomerInfo(model.Customer customer) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.updateCustomerInfo(customer);
  }
  
  public java.lang.String deleteCustomer(int cust_Id) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.deleteCustomer(cust_Id);
  }
  
  public model.Staff getStaffInfo(int staff_Id) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.getStaffInfo(staff_Id);
  }
  
  public java.lang.String deleteStaff(int staff_Id) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.deleteStaff(staff_Id);
  }
  
  public model.FlightDetails getFlightInfo(java.lang.String flight_Num) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.getFlightInfo(flight_Num);
  }
  
  public java.lang.String deleteFlight(java.lang.String flight_Num) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.deleteFlight(flight_Num);
  }
  
  public model.Customer getCustomerInfo(int user_id) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.getCustomerInfo(user_id);
  }
  
  public model.FlightCustomerBean[] listFlightAndCustomer(java.lang.String flight_Num) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.listFlightAndCustomer(flight_Num);
  }
  
  public java.lang.String updateFlightInfo(model.Flight flight) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.updateFlightInfo(flight);
  }
  
  public java.lang.String updateStaffInfo(model.Staff staff) throws java.rmi.RemoteException{
    if (managementWebService == null)
      _initManagementWebServiceProxy();
    return managementWebService.updateStaffInfo(staff);
  }
  
  
}
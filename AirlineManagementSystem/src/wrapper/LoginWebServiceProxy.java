package wrapper;

public class LoginWebServiceProxy implements wrapper.LoginWebService {
  private String _endpoint = null;
  private wrapper.LoginWebService loginWebService = null;
  
  public LoginWebServiceProxy() {
    _initLoginWebServiceProxy();
  }
  
  public LoginWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initLoginWebServiceProxy();
  }
  
  private void _initLoginWebServiceProxy() {
    try {
      loginWebService = (new wrapper.LoginWebServiceServiceLocator()).getLoginWebService();
      if (loginWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)loginWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)loginWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (loginWebService != null)
      ((javax.xml.rpc.Stub)loginWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wrapper.LoginWebService getLoginWebService() {
    if (loginWebService == null)
      _initLoginWebServiceProxy();
    return loginWebService;
  }
  
  public model.CustomerMessageBean customerRegistration(model.Customer customer) throws java.rmi.RemoteException{
    if (loginWebService == null)
      _initLoginWebServiceProxy();
    return loginWebService.customerRegistration(customer);
  }
  
  public model.UserMessageBean userValidation(java.lang.String email, java.lang.String password, java.lang.String type) throws java.rmi.RemoteException{
    if (loginWebService == null)
      _initLoginWebServiceProxy();
    return loginWebService.userValidation(email, password, type);
  }
  
  public model.StaffMessageBean staffRegistration(model.Staff staff) throws java.rmi.RemoteException{
    if (loginWebService == null)
      _initLoginWebServiceProxy();
    return loginWebService.staffRegistration(staff);
  }
  
  
}
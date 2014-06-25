/**
 * LoginWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public class LoginWebServiceServiceLocator extends org.apache.axis.client.Service implements wrapper.LoginWebServiceService {

    public LoginWebServiceServiceLocator() {
    }


    public LoginWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LoginWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LoginWebService
    private java.lang.String LoginWebService_address = "http://localhost:8083/AirlineManagementWebService/services/LoginWebService";

    public java.lang.String getLoginWebServiceAddress() {
        return LoginWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LoginWebServiceWSDDServiceName = "LoginWebService";

    public java.lang.String getLoginWebServiceWSDDServiceName() {
        return LoginWebServiceWSDDServiceName;
    }

    public void setLoginWebServiceWSDDServiceName(java.lang.String name) {
        LoginWebServiceWSDDServiceName = name;
    }

    public wrapper.LoginWebService getLoginWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LoginWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLoginWebService(endpoint);
    }

    public wrapper.LoginWebService getLoginWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wrapper.LoginWebServiceSoapBindingStub _stub = new wrapper.LoginWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getLoginWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLoginWebServiceEndpointAddress(java.lang.String address) {
        LoginWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wrapper.LoginWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                wrapper.LoginWebServiceSoapBindingStub _stub = new wrapper.LoginWebServiceSoapBindingStub(new java.net.URL(LoginWebService_address), this);
                _stub.setPortName(getLoginWebServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LoginWebService".equals(inputPortName)) {
            return getLoginWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wrapper", "LoginWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wrapper", "LoginWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LoginWebService".equals(portName)) {
            setLoginWebServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

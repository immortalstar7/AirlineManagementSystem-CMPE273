/**
 * SearchWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public class SearchWebServiceServiceLocator extends org.apache.axis.client.Service implements wrapper.SearchWebServiceService {

    public SearchWebServiceServiceLocator() {
    }


    public SearchWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SearchWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SearchWebService
    private java.lang.String SearchWebService_address = "http://localhost:8083/AirlineManagementWebService/services/SearchWebService";

    public java.lang.String getSearchWebServiceAddress() {
        return SearchWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SearchWebServiceWSDDServiceName = "SearchWebService";

    public java.lang.String getSearchWebServiceWSDDServiceName() {
        return SearchWebServiceWSDDServiceName;
    }

    public void setSearchWebServiceWSDDServiceName(java.lang.String name) {
        SearchWebServiceWSDDServiceName = name;
    }

    public wrapper.SearchWebService getSearchWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SearchWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSearchWebService(endpoint);
    }

    public wrapper.SearchWebService getSearchWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wrapper.SearchWebServiceSoapBindingStub _stub = new wrapper.SearchWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSearchWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSearchWebServiceEndpointAddress(java.lang.String address) {
        SearchWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wrapper.SearchWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                wrapper.SearchWebServiceSoapBindingStub _stub = new wrapper.SearchWebServiceSoapBindingStub(new java.net.URL(SearchWebService_address), this);
                _stub.setPortName(getSearchWebServiceWSDDServiceName());
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
        if ("SearchWebService".equals(inputPortName)) {
            return getSearchWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wrapper", "SearchWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wrapper", "SearchWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SearchWebService".equals(portName)) {
            setSearchWebServiceEndpointAddress(address);
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

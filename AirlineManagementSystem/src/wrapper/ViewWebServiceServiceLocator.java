/**
 * ViewWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public class ViewWebServiceServiceLocator extends org.apache.axis.client.Service implements wrapper.ViewWebServiceService {

    public ViewWebServiceServiceLocator() {
    }


    public ViewWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ViewWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ViewWebService
    private java.lang.String ViewWebService_address = "http://localhost:8083/AirlineManagementWebService/services/ViewWebService";

    public java.lang.String getViewWebServiceAddress() {
        return ViewWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ViewWebServiceWSDDServiceName = "ViewWebService";

    public java.lang.String getViewWebServiceWSDDServiceName() {
        return ViewWebServiceWSDDServiceName;
    }

    public void setViewWebServiceWSDDServiceName(java.lang.String name) {
        ViewWebServiceWSDDServiceName = name;
    }

    public wrapper.ViewWebService getViewWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ViewWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getViewWebService(endpoint);
    }

    public wrapper.ViewWebService getViewWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wrapper.ViewWebServiceSoapBindingStub _stub = new wrapper.ViewWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getViewWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setViewWebServiceEndpointAddress(java.lang.String address) {
        ViewWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wrapper.ViewWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                wrapper.ViewWebServiceSoapBindingStub _stub = new wrapper.ViewWebServiceSoapBindingStub(new java.net.URL(ViewWebService_address), this);
                _stub.setPortName(getViewWebServiceWSDDServiceName());
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
        if ("ViewWebService".equals(inputPortName)) {
            return getViewWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wrapper", "ViewWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wrapper", "ViewWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ViewWebService".equals(portName)) {
            setViewWebServiceEndpointAddress(address);
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

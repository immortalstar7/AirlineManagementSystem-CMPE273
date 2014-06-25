/**
 * ManagementWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public class ManagementWebServiceServiceLocator extends org.apache.axis.client.Service implements wrapper.ManagementWebServiceService {

    public ManagementWebServiceServiceLocator() {
    }


    public ManagementWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ManagementWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ManagementWebService
    private java.lang.String ManagementWebService_address = "http://localhost:8083/AirlineManagementWebService/services/ManagementWebService";

    public java.lang.String getManagementWebServiceAddress() {
        return ManagementWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ManagementWebServiceWSDDServiceName = "ManagementWebService";

    public java.lang.String getManagementWebServiceWSDDServiceName() {
        return ManagementWebServiceWSDDServiceName;
    }

    public void setManagementWebServiceWSDDServiceName(java.lang.String name) {
        ManagementWebServiceWSDDServiceName = name;
    }

    public wrapper.ManagementWebService getManagementWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ManagementWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getManagementWebService(endpoint);
    }

    public wrapper.ManagementWebService getManagementWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            wrapper.ManagementWebServiceSoapBindingStub _stub = new wrapper.ManagementWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getManagementWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setManagementWebServiceEndpointAddress(java.lang.String address) {
        ManagementWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wrapper.ManagementWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                wrapper.ManagementWebServiceSoapBindingStub _stub = new wrapper.ManagementWebServiceSoapBindingStub(new java.net.URL(ManagementWebService_address), this);
                _stub.setPortName(getManagementWebServiceWSDDServiceName());
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
        if ("ManagementWebService".equals(inputPortName)) {
            return getManagementWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wrapper", "ManagementWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wrapper", "ManagementWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ManagementWebService".equals(portName)) {
            setManagementWebServiceEndpointAddress(address);
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

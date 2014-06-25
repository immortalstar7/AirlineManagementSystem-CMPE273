/**
 * FlightWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface FlightWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getFlightWebServiceAddress();

    public wrapper.FlightWebService getFlightWebService() throws javax.xml.rpc.ServiceException;

    public wrapper.FlightWebService getFlightWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

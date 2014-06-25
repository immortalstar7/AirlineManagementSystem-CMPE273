/**
 * ViewWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface ViewWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getViewWebServiceAddress();

    public wrapper.ViewWebService getViewWebService() throws javax.xml.rpc.ServiceException;

    public wrapper.ViewWebService getViewWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

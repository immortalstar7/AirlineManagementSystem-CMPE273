/**
 * SearchWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface SearchWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getSearchWebServiceAddress();

    public wrapper.SearchWebService getSearchWebService() throws javax.xml.rpc.ServiceException;

    public wrapper.SearchWebService getSearchWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

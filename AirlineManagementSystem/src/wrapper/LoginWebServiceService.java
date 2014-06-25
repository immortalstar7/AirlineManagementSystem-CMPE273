/**
 * LoginWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface LoginWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getLoginWebServiceAddress();

    public wrapper.LoginWebService getLoginWebService() throws javax.xml.rpc.ServiceException;

    public wrapper.LoginWebService getLoginWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

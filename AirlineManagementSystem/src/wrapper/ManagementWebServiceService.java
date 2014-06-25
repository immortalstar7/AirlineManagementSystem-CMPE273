/**
 * ManagementWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface ManagementWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getManagementWebServiceAddress();

    public wrapper.ManagementWebService getManagementWebService() throws javax.xml.rpc.ServiceException;

    public wrapper.ManagementWebService getManagementWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

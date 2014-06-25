/**
 * LoginWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface LoginWebService extends java.rmi.Remote {
    public model.CustomerMessageBean customerRegistration(model.Customer customer) throws java.rmi.RemoteException;
    public model.UserMessageBean userValidation(java.lang.String email, java.lang.String password, java.lang.String type) throws java.rmi.RemoteException;
    public model.StaffMessageBean staffRegistration(model.Staff staff) throws java.rmi.RemoteException;
}

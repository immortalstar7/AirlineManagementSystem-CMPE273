/**
 * SearchWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface SearchWebService extends java.rmi.Remote {
    public model.Staff[] searchStaff(model.Staff staff) throws java.rmi.RemoteException;
    public model.Flight[] searchFlights(java.lang.String source, java.lang.String destination, java.lang.String flight_date) throws java.rmi.RemoteException;
    public model.Customer[] searchCustomers(model.Customer customer) throws java.rmi.RemoteException;
}

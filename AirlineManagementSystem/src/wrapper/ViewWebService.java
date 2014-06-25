/**
 * ViewWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface ViewWebService extends java.rmi.Remote {
    public model.Customer[] getCustomerDetails() throws java.rmi.RemoteException;
    public model.FlightDetails[] getFlightDetails() throws java.rmi.RemoteException;
    public model.Staff[] getStaffDetails() throws java.rmi.RemoteException;
    public model.Booking[] getBookingDetails() throws java.rmi.RemoteException;
}

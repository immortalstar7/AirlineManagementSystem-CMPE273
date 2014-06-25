/**
 * ManagementWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wrapper;

public interface ManagementWebService extends java.rmi.Remote {
    public java.lang.String updateCustomerInfo(model.Customer customer) throws java.rmi.RemoteException;
    public java.lang.String deleteCustomer(int cust_Id) throws java.rmi.RemoteException;
    public model.Staff getStaffInfo(int staff_Id) throws java.rmi.RemoteException;
    public java.lang.String deleteStaff(int staff_Id) throws java.rmi.RemoteException;
    public model.FlightDetails getFlightInfo(java.lang.String flight_Num) throws java.rmi.RemoteException;
    public java.lang.String deleteFlight(java.lang.String flight_Num) throws java.rmi.RemoteException;
    public model.Customer getCustomerInfo(int user_id) throws java.rmi.RemoteException;
    public model.FlightCustomerBean[] listFlightAndCustomer(java.lang.String flight_Num) throws java.rmi.RemoteException;
    public java.lang.String updateFlightInfo(model.Flight flight) throws java.rmi.RemoteException;
    public java.lang.String updateStaffInfo(model.Staff staff) throws java.rmi.RemoteException;
}

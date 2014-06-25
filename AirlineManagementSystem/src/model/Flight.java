/**
 * Flight.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

public class Flight  implements java.io.Serializable {
    private java.lang.String flight_name;

    private java.lang.String flight_no;

    private int no_of_seats;

    public Flight() {
    }

    public Flight(
           java.lang.String flight_name,
           java.lang.String flight_no,
           int no_of_seats) {
           this.flight_name = flight_name;
           this.flight_no = flight_no;
           this.no_of_seats = no_of_seats;
    }


    /**
     * Gets the flight_name value for this Flight.
     * 
     * @return flight_name
     */
    public java.lang.String getFlight_name() {
        return flight_name;
    }


    /**
     * Sets the flight_name value for this Flight.
     * 
     * @param flight_name
     */
    public void setFlight_name(java.lang.String flight_name) {
        this.flight_name = flight_name;
    }


    /**
     * Gets the flight_no value for this Flight.
     * 
     * @return flight_no
     */
    public java.lang.String getFlight_no() {
        return flight_no;
    }


    /**
     * Sets the flight_no value for this Flight.
     * 
     * @param flight_no
     */
    public void setFlight_no(java.lang.String flight_no) {
        this.flight_no = flight_no;
    }


    /**
     * Gets the no_of_seats value for this Flight.
     * 
     * @return no_of_seats
     */
    public int getNo_of_seats() {
        return no_of_seats;
    }


    /**
     * Sets the no_of_seats value for this Flight.
     * 
     * @param no_of_seats
     */
    public void setNo_of_seats(int no_of_seats) {
        this.no_of_seats = no_of_seats;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Flight)) return false;
        Flight other = (Flight) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.flight_name==null && other.getFlight_name()==null) || 
             (this.flight_name!=null &&
              this.flight_name.equals(other.getFlight_name()))) &&
            ((this.flight_no==null && other.getFlight_no()==null) || 
             (this.flight_no!=null &&
              this.flight_no.equals(other.getFlight_no()))) &&
            this.no_of_seats == other.getNo_of_seats();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFlight_name() != null) {
            _hashCode += getFlight_name().hashCode();
        }
        if (getFlight_no() != null) {
            _hashCode += getFlight_no().hashCode();
        }
        _hashCode += getNo_of_seats();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Flight.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model", "Flight"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flight_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "flight_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flight_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "flight_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_of_seats");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "no_of_seats"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

/**
 * Booking.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

public class Booking  implements java.io.Serializable {
    private java.lang.String destination;

    private java.lang.String flight_date;

    private java.lang.String flight_no;

    private int no_of_seats;

    private java.lang.String source;

    private int user_id;

    public Booking() {
    }

    public Booking(
           java.lang.String destination,
           java.lang.String flight_date,
           java.lang.String flight_no,
           int no_of_seats,
           java.lang.String source,
           int user_id) {
           this.destination = destination;
           this.flight_date = flight_date;
           this.flight_no = flight_no;
           this.no_of_seats = no_of_seats;
           this.source = source;
           this.user_id = user_id;
    }


    /**
     * Gets the destination value for this Booking.
     * 
     * @return destination
     */
    public java.lang.String getDestination() {
        return destination;
    }


    /**
     * Sets the destination value for this Booking.
     * 
     * @param destination
     */
    public void setDestination(java.lang.String destination) {
        this.destination = destination;
    }


    /**
     * Gets the flight_date value for this Booking.
     * 
     * @return flight_date
     */
    public java.lang.String getFlight_date() {
        return flight_date;
    }


    /**
     * Sets the flight_date value for this Booking.
     * 
     * @param flight_date
     */
    public void setFlight_date(java.lang.String flight_date) {
        this.flight_date = flight_date;
    }


    /**
     * Gets the flight_no value for this Booking.
     * 
     * @return flight_no
     */
    public java.lang.String getFlight_no() {
        return flight_no;
    }


    /**
     * Sets the flight_no value for this Booking.
     * 
     * @param flight_no
     */
    public void setFlight_no(java.lang.String flight_no) {
        this.flight_no = flight_no;
    }


    /**
     * Gets the no_of_seats value for this Booking.
     * 
     * @return no_of_seats
     */
    public int getNo_of_seats() {
        return no_of_seats;
    }


    /**
     * Sets the no_of_seats value for this Booking.
     * 
     * @param no_of_seats
     */
    public void setNo_of_seats(int no_of_seats) {
        this.no_of_seats = no_of_seats;
    }


    /**
     * Gets the source value for this Booking.
     * 
     * @return source
     */
    public java.lang.String getSource() {
        return source;
    }


    /**
     * Sets the source value for this Booking.
     * 
     * @param source
     */
    public void setSource(java.lang.String source) {
        this.source = source;
    }


    /**
     * Gets the user_id value for this Booking.
     * 
     * @return user_id
     */
    public int getUser_id() {
        return user_id;
    }


    /**
     * Sets the user_id value for this Booking.
     * 
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Booking)) return false;
        Booking other = (Booking) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.destination==null && other.getDestination()==null) || 
             (this.destination!=null &&
              this.destination.equals(other.getDestination()))) &&
            ((this.flight_date==null && other.getFlight_date()==null) || 
             (this.flight_date!=null &&
              this.flight_date.equals(other.getFlight_date()))) &&
            ((this.flight_no==null && other.getFlight_no()==null) || 
             (this.flight_no!=null &&
              this.flight_no.equals(other.getFlight_no()))) &&
            this.no_of_seats == other.getNo_of_seats() &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              this.source.equals(other.getSource()))) &&
            this.user_id == other.getUser_id();
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
        if (getDestination() != null) {
            _hashCode += getDestination().hashCode();
        }
        if (getFlight_date() != null) {
            _hashCode += getFlight_date().hashCode();
        }
        if (getFlight_no() != null) {
            _hashCode += getFlight_no().hashCode();
        }
        _hashCode += getNo_of_seats();
        if (getSource() != null) {
            _hashCode += getSource().hashCode();
        }
        _hashCode += getUser_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Booking.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model", "Booking"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destination");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "destination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flight_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "flight_date"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "user_id"));
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

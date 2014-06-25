/**
 * FlightDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

public class FlightDetails  implements java.io.Serializable {
    private java.lang.String avail_seats;

    private int crew_id;

    private java.lang.String destination;

    private java.lang.String flight_date;

    private java.lang.String flight_name;

    private java.lang.String flight_no;

    private int no_of_seats;

    private java.lang.String source;

    public FlightDetails() {
    }

    public FlightDetails(
           java.lang.String avail_seats,
           int crew_id,
           java.lang.String destination,
           java.lang.String flight_date,
           java.lang.String flight_name,
           java.lang.String flight_no,
           int no_of_seats,
           java.lang.String source) {
           this.avail_seats = avail_seats;
           this.crew_id = crew_id;
           this.destination = destination;
           this.flight_date = flight_date;
           this.flight_name = flight_name;
           this.flight_no = flight_no;
           this.no_of_seats = no_of_seats;
           this.source = source;
    }


    /**
     * Gets the avail_seats value for this FlightDetails.
     * 
     * @return avail_seats
     */
    public java.lang.String getAvail_seats() {
        return avail_seats;
    }


    /**
     * Sets the avail_seats value for this FlightDetails.
     * 
     * @param avail_seats
     */
    public void setAvail_seats(java.lang.String avail_seats) {
        this.avail_seats = avail_seats;
    }


    /**
     * Gets the crew_id value for this FlightDetails.
     * 
     * @return crew_id
     */
    public int getCrew_id() {
        return crew_id;
    }


    /**
     * Sets the crew_id value for this FlightDetails.
     * 
     * @param crew_id
     */
    public void setCrew_id(int crew_id) {
        this.crew_id = crew_id;
    }


    /**
     * Gets the destination value for this FlightDetails.
     * 
     * @return destination
     */
    public java.lang.String getDestination() {
        return destination;
    }


    /**
     * Sets the destination value for this FlightDetails.
     * 
     * @param destination
     */
    public void setDestination(java.lang.String destination) {
        this.destination = destination;
    }


    /**
     * Gets the flight_date value for this FlightDetails.
     * 
     * @return flight_date
     */
    public java.lang.String getFlight_date() {
        return flight_date;
    }


    /**
     * Sets the flight_date value for this FlightDetails.
     * 
     * @param flight_date
     */
    public void setFlight_date(java.lang.String flight_date) {
        this.flight_date = flight_date;
    }


    /**
     * Gets the flight_name value for this FlightDetails.
     * 
     * @return flight_name
     */
    public java.lang.String getFlight_name() {
        return flight_name;
    }


    /**
     * Sets the flight_name value for this FlightDetails.
     * 
     * @param flight_name
     */
    public void setFlight_name(java.lang.String flight_name) {
        this.flight_name = flight_name;
    }


    /**
     * Gets the flight_no value for this FlightDetails.
     * 
     * @return flight_no
     */
    public java.lang.String getFlight_no() {
        return flight_no;
    }


    /**
     * Sets the flight_no value for this FlightDetails.
     * 
     * @param flight_no
     */
    public void setFlight_no(java.lang.String flight_no) {
        this.flight_no = flight_no;
    }


    /**
     * Gets the no_of_seats value for this FlightDetails.
     * 
     * @return no_of_seats
     */
    public int getNo_of_seats() {
        return no_of_seats;
    }


    /**
     * Sets the no_of_seats value for this FlightDetails.
     * 
     * @param no_of_seats
     */
    public void setNo_of_seats(int no_of_seats) {
        this.no_of_seats = no_of_seats;
    }


    /**
     * Gets the source value for this FlightDetails.
     * 
     * @return source
     */
    public java.lang.String getSource() {
        return source;
    }


    /**
     * Sets the source value for this FlightDetails.
     * 
     * @param source
     */
    public void setSource(java.lang.String source) {
        this.source = source;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightDetails)) return false;
        FlightDetails other = (FlightDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.avail_seats==null && other.getAvail_seats()==null) || 
             (this.avail_seats!=null &&
              this.avail_seats.equals(other.getAvail_seats()))) &&
            this.crew_id == other.getCrew_id() &&
            ((this.destination==null && other.getDestination()==null) || 
             (this.destination!=null &&
              this.destination.equals(other.getDestination()))) &&
            ((this.flight_date==null && other.getFlight_date()==null) || 
             (this.flight_date!=null &&
              this.flight_date.equals(other.getFlight_date()))) &&
            ((this.flight_name==null && other.getFlight_name()==null) || 
             (this.flight_name!=null &&
              this.flight_name.equals(other.getFlight_name()))) &&
            ((this.flight_no==null && other.getFlight_no()==null) || 
             (this.flight_no!=null &&
              this.flight_no.equals(other.getFlight_no()))) &&
            this.no_of_seats == other.getNo_of_seats() &&
            ((this.source==null && other.getSource()==null) || 
             (this.source!=null &&
              this.source.equals(other.getSource())));
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
        if (getAvail_seats() != null) {
            _hashCode += getAvail_seats().hashCode();
        }
        _hashCode += getCrew_id();
        if (getDestination() != null) {
            _hashCode += getDestination().hashCode();
        }
        if (getFlight_date() != null) {
            _hashCode += getFlight_date().hashCode();
        }
        if (getFlight_name() != null) {
            _hashCode += getFlight_name().hashCode();
        }
        if (getFlight_no() != null) {
            _hashCode += getFlight_no().hashCode();
        }
        _hashCode += getNo_of_seats();
        if (getSource() != null) {
            _hashCode += getSource().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model", "FlightDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avail_seats");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "avail_seats"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crew_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "crew_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "source"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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

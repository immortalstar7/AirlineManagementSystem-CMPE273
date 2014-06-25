/**
 * FlightCustomerBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

public class FlightCustomerBean  implements java.io.Serializable {
    private java.lang.String f_name;

    private java.lang.String flight_no;

    private java.lang.String l_name;

    public FlightCustomerBean() {
    }

    public FlightCustomerBean(
           java.lang.String f_name,
           java.lang.String flight_no,
           java.lang.String l_name) {
           this.f_name = f_name;
           this.flight_no = flight_no;
           this.l_name = l_name;
    }


    /**
     * Gets the f_name value for this FlightCustomerBean.
     * 
     * @return f_name
     */
    public java.lang.String getF_name() {
        return f_name;
    }


    /**
     * Sets the f_name value for this FlightCustomerBean.
     * 
     * @param f_name
     */
    public void setF_name(java.lang.String f_name) {
        this.f_name = f_name;
    }


    /**
     * Gets the flight_no value for this FlightCustomerBean.
     * 
     * @return flight_no
     */
    public java.lang.String getFlight_no() {
        return flight_no;
    }


    /**
     * Sets the flight_no value for this FlightCustomerBean.
     * 
     * @param flight_no
     */
    public void setFlight_no(java.lang.String flight_no) {
        this.flight_no = flight_no;
    }


    /**
     * Gets the l_name value for this FlightCustomerBean.
     * 
     * @return l_name
     */
    public java.lang.String getL_name() {
        return l_name;
    }


    /**
     * Sets the l_name value for this FlightCustomerBean.
     * 
     * @param l_name
     */
    public void setL_name(java.lang.String l_name) {
        this.l_name = l_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlightCustomerBean)) return false;
        FlightCustomerBean other = (FlightCustomerBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.f_name==null && other.getF_name()==null) || 
             (this.f_name!=null &&
              this.f_name.equals(other.getF_name()))) &&
            ((this.flight_no==null && other.getFlight_no()==null) || 
             (this.flight_no!=null &&
              this.flight_no.equals(other.getFlight_no()))) &&
            ((this.l_name==null && other.getL_name()==null) || 
             (this.l_name!=null &&
              this.l_name.equals(other.getL_name())));
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
        if (getF_name() != null) {
            _hashCode += getF_name().hashCode();
        }
        if (getFlight_no() != null) {
            _hashCode += getFlight_no().hashCode();
        }
        if (getL_name() != null) {
            _hashCode += getL_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlightCustomerBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model", "FlightCustomerBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("f_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "f_name"));
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
        elemField.setFieldName("l_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model", "l_name"));
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

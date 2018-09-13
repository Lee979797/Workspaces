/**
 * SNCACertificate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.snca.caplatform.services.domailmodel.xsd;

public class SNCACertificate  implements java.io.Serializable {
    private java.lang.String cN;

    private java.lang.String dN;

    private java.lang.String endDay;

    private java.lang.String expandingValue;

    private java.lang.String issuer;

    private java.lang.String reference;

    private java.lang.String signDay;

    public SNCACertificate() {
    }

    public SNCACertificate(
           java.lang.String cN,
           java.lang.String dN,
           java.lang.String endDay,
           java.lang.String expandingValue,
           java.lang.String issuer,
           java.lang.String reference,
           java.lang.String signDay) {
           this.cN = cN;
           this.dN = dN;
           this.endDay = endDay;
           this.expandingValue = expandingValue;
           this.issuer = issuer;
           this.reference = reference;
           this.signDay = signDay;
    }


    /**
     * Gets the cN value for this SNCACertificate.
     * 
     * @return cN
     */
    public java.lang.String getCN() {
        return cN;
    }


    /**
     * Sets the cN value for this SNCACertificate.
     * 
     * @param cN
     */
    public void setCN(java.lang.String cN) {
        this.cN = cN;
    }


    /**
     * Gets the dN value for this SNCACertificate.
     * 
     * @return dN
     */
    public java.lang.String getDN() {
        return dN;
    }


    /**
     * Sets the dN value for this SNCACertificate.
     * 
     * @param dN
     */
    public void setDN(java.lang.String dN) {
        this.dN = dN;
    }


    /**
     * Gets the endDay value for this SNCACertificate.
     * 
     * @return endDay
     */
    public java.lang.String getEndDay() {
        return endDay;
    }


    /**
     * Sets the endDay value for this SNCACertificate.
     * 
     * @param endDay
     */
    public void setEndDay(java.lang.String endDay) {
        this.endDay = endDay;
    }


    /**
     * Gets the expandingValue value for this SNCACertificate.
     * 
     * @return expandingValue
     */
    public java.lang.String getExpandingValue() {
        return expandingValue;
    }


    /**
     * Sets the expandingValue value for this SNCACertificate.
     * 
     * @param expandingValue
     */
    public void setExpandingValue(java.lang.String expandingValue) {
        this.expandingValue = expandingValue;
    }


    /**
     * Gets the issuer value for this SNCACertificate.
     * 
     * @return issuer
     */
    public java.lang.String getIssuer() {
        return issuer;
    }


    /**
     * Sets the issuer value for this SNCACertificate.
     * 
     * @param issuer
     */
    public void setIssuer(java.lang.String issuer) {
        this.issuer = issuer;
    }


    /**
     * Gets the reference value for this SNCACertificate.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this SNCACertificate.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the signDay value for this SNCACertificate.
     * 
     * @return signDay
     */
    public java.lang.String getSignDay() {
        return signDay;
    }


    /**
     * Sets the signDay value for this SNCACertificate.
     * 
     * @param signDay
     */
    public void setSignDay(java.lang.String signDay) {
        this.signDay = signDay;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SNCACertificate)) return false;
        SNCACertificate other = (SNCACertificate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cN==null && other.getCN()==null) || 
             (this.cN!=null &&
              this.cN.equals(other.getCN()))) &&
            ((this.dN==null && other.getDN()==null) || 
             (this.dN!=null &&
              this.dN.equals(other.getDN()))) &&
            ((this.endDay==null && other.getEndDay()==null) || 
             (this.endDay!=null &&
              this.endDay.equals(other.getEndDay()))) &&
            ((this.expandingValue==null && other.getExpandingValue()==null) || 
             (this.expandingValue!=null &&
              this.expandingValue.equals(other.getExpandingValue()))) &&
            ((this.issuer==null && other.getIssuer()==null) || 
             (this.issuer!=null &&
              this.issuer.equals(other.getIssuer()))) &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.signDay==null && other.getSignDay()==null) || 
             (this.signDay!=null &&
              this.signDay.equals(other.getSignDay())));
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
        if (getCN() != null) {
            _hashCode += getCN().hashCode();
        }
        if (getDN() != null) {
            _hashCode += getDN().hashCode();
        }
        if (getEndDay() != null) {
            _hashCode += getEndDay().hashCode();
        }
        if (getExpandingValue() != null) {
            _hashCode += getExpandingValue().hashCode();
        }
        if (getIssuer() != null) {
            _hashCode += getIssuer().hashCode();
        }
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getSignDay() != null) {
            _hashCode += getSignDay().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SNCACertificate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://domailmodel.services.caplatform.snca.com/xsd", "SNCACertificate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domailmodel.services.caplatform.snca.com/xsd", "cN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domailmodel.services.caplatform.snca.com/xsd", "dN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domailmodel.services.caplatform.snca.com/xsd", "endDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expandingValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domailmodel.services.caplatform.snca.com/xsd", "expandingValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issuer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domailmodel.services.caplatform.snca.com/xsd", "issuer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domailmodel.services.caplatform.snca.com/xsd", "reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signDay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://domailmodel.services.caplatform.snca.com/xsd", "signDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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

/**
 * BI_GuestInfo.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_LeadInfoSync;

public class BI_GuestInfo  implements java.io.Serializable {
    private java.lang.String guestEmail;

    private java.lang.String guestEmergencyPhoneNumber;

    private java.lang.String guestKanjiName;

    private java.lang.String guestNameSingleByte;

    private java.lang.String guestPhoneNumber;

    private java.lang.String guestStateProvidence;

    private java.lang.String guestSurName;

    public BI_GuestInfo() {
    }

    public BI_GuestInfo(
           java.lang.String guestEmail,
           java.lang.String guestEmergencyPhoneNumber,
           java.lang.String guestKanjiName,
           java.lang.String guestNameSingleByte,
           java.lang.String guestPhoneNumber,
           java.lang.String guestStateProvidence,
           java.lang.String guestSurName) {
           this.guestEmail = guestEmail;
           this.guestEmergencyPhoneNumber = guestEmergencyPhoneNumber;
           this.guestKanjiName = guestKanjiName;
           this.guestNameSingleByte = guestNameSingleByte;
           this.guestPhoneNumber = guestPhoneNumber;
           this.guestStateProvidence = guestStateProvidence;
           this.guestSurName = guestSurName;
    }


    /**
     * Gets the guestEmail value for this BI_GuestInfo.
     * 
     * @return guestEmail
     */
    public java.lang.String getGuestEmail() {
        return guestEmail;
    }


    /**
     * Sets the guestEmail value for this BI_GuestInfo.
     * 
     * @param guestEmail
     */
    public void setGuestEmail(java.lang.String guestEmail) {
        this.guestEmail = guestEmail;
    }


    /**
     * Gets the guestEmergencyPhoneNumber value for this BI_GuestInfo.
     * 
     * @return guestEmergencyPhoneNumber
     */
    public java.lang.String getGuestEmergencyPhoneNumber() {
        return guestEmergencyPhoneNumber;
    }


    /**
     * Sets the guestEmergencyPhoneNumber value for this BI_GuestInfo.
     * 
     * @param guestEmergencyPhoneNumber
     */
    public void setGuestEmergencyPhoneNumber(java.lang.String guestEmergencyPhoneNumber) {
        this.guestEmergencyPhoneNumber = guestEmergencyPhoneNumber;
    }


    /**
     * Gets the guestKanjiName value for this BI_GuestInfo.
     * 
     * @return guestKanjiName
     */
    public java.lang.String getGuestKanjiName() {
        return guestKanjiName;
    }


    /**
     * Sets the guestKanjiName value for this BI_GuestInfo.
     * 
     * @param guestKanjiName
     */
    public void setGuestKanjiName(java.lang.String guestKanjiName) {
        this.guestKanjiName = guestKanjiName;
    }


    /**
     * Gets the guestNameSingleByte value for this BI_GuestInfo.
     * 
     * @return guestNameSingleByte
     */
    public java.lang.String getGuestNameSingleByte() {
        return guestNameSingleByte;
    }


    /**
     * Sets the guestNameSingleByte value for this BI_GuestInfo.
     * 
     * @param guestNameSingleByte
     */
    public void setGuestNameSingleByte(java.lang.String guestNameSingleByte) {
        this.guestNameSingleByte = guestNameSingleByte;
    }


    /**
     * Gets the guestPhoneNumber value for this BI_GuestInfo.
     * 
     * @return guestPhoneNumber
     */
    public java.lang.String getGuestPhoneNumber() {
        return guestPhoneNumber;
    }


    /**
     * Sets the guestPhoneNumber value for this BI_GuestInfo.
     * 
     * @param guestPhoneNumber
     */
    public void setGuestPhoneNumber(java.lang.String guestPhoneNumber) {
        this.guestPhoneNumber = guestPhoneNumber;
    }


    /**
     * Gets the guestStateProvidence value for this BI_GuestInfo.
     * 
     * @return guestStateProvidence
     */
    public java.lang.String getGuestStateProvidence() {
        return guestStateProvidence;
    }


    /**
     * Sets the guestStateProvidence value for this BI_GuestInfo.
     * 
     * @param guestStateProvidence
     */
    public void setGuestStateProvidence(java.lang.String guestStateProvidence) {
        this.guestStateProvidence = guestStateProvidence;
    }


    /**
     * Gets the guestSurName value for this BI_GuestInfo.
     * 
     * @return guestSurName
     */
    public java.lang.String getGuestSurName() {
        return guestSurName;
    }


    /**
     * Sets the guestSurName value for this BI_GuestInfo.
     * 
     * @param guestSurName
     */
    public void setGuestSurName(java.lang.String guestSurName) {
        this.guestSurName = guestSurName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BI_GuestInfo)) return false;
        BI_GuestInfo other = (BI_GuestInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.guestEmail==null && other.getGuestEmail()==null) || 
             (this.guestEmail!=null &&
              this.guestEmail.equals(other.getGuestEmail()))) &&
            ((this.guestEmergencyPhoneNumber==null && other.getGuestEmergencyPhoneNumber()==null) || 
             (this.guestEmergencyPhoneNumber!=null &&
              this.guestEmergencyPhoneNumber.equals(other.getGuestEmergencyPhoneNumber()))) &&
            ((this.guestKanjiName==null && other.getGuestKanjiName()==null) || 
             (this.guestKanjiName!=null &&
              this.guestKanjiName.equals(other.getGuestKanjiName()))) &&
            ((this.guestNameSingleByte==null && other.getGuestNameSingleByte()==null) || 
             (this.guestNameSingleByte!=null &&
              this.guestNameSingleByte.equals(other.getGuestNameSingleByte()))) &&
            ((this.guestPhoneNumber==null && other.getGuestPhoneNumber()==null) || 
             (this.guestPhoneNumber!=null &&
              this.guestPhoneNumber.equals(other.getGuestPhoneNumber()))) &&
            ((this.guestStateProvidence==null && other.getGuestStateProvidence()==null) || 
             (this.guestStateProvidence!=null &&
              this.guestStateProvidence.equals(other.getGuestStateProvidence()))) &&
            ((this.guestSurName==null && other.getGuestSurName()==null) || 
             (this.guestSurName!=null &&
              this.guestSurName.equals(other.getGuestSurName())));
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
        if (getGuestEmail() != null) {
            _hashCode += getGuestEmail().hashCode();
        }
        if (getGuestEmergencyPhoneNumber() != null) {
            _hashCode += getGuestEmergencyPhoneNumber().hashCode();
        }
        if (getGuestKanjiName() != null) {
            _hashCode += getGuestKanjiName().hashCode();
        }
        if (getGuestNameSingleByte() != null) {
            _hashCode += getGuestNameSingleByte().hashCode();
        }
        if (getGuestPhoneNumber() != null) {
            _hashCode += getGuestPhoneNumber().hashCode();
        }
        if (getGuestStateProvidence() != null) {
            _hashCode += getGuestStateProvidence().hashCode();
        }
        if (getGuestSurName() != null) {
            _hashCode += getGuestSurName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BI_GuestInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_GuestInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestEmergencyPhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestEmergencyPhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestKanjiName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestKanjiName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestNameSingleByte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestNameSingleByte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestPhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestPhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestStateProvidence");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestStateProvidence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestSurName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "GuestSurName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * メタデータオブジェクトの型を返却 / [en]-(Return type metadata object)
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

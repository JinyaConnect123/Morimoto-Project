/**
 * BI_TR_SyncResult.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_TR_LeadInfoSync;

public class BI_TR_SyncResult  implements java.io.Serializable {
    private java.lang.String message;

    private com.sforce.soap.schemas._class.BI_TR_LeadInfoSync.BI_TR_Result result;

    private java.lang.String sfdcId;

    private java.lang.String sfdcJobId;

    public BI_TR_SyncResult() {
    }

    public BI_TR_SyncResult(
           java.lang.String message,
           com.sforce.soap.schemas._class.BI_TR_LeadInfoSync.BI_TR_Result result,
           java.lang.String sfdcId,
           java.lang.String sfdcJobId) {
           this.message = message;
           this.result = result;
           this.sfdcId = sfdcId;
           this.sfdcJobId = sfdcJobId;
    }


    /**
     * Gets the message value for this BI_TR_SyncResult.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this BI_TR_SyncResult.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the result value for this BI_TR_SyncResult.
     * 
     * @return result
     */
    public com.sforce.soap.schemas._class.BI_TR_LeadInfoSync.BI_TR_Result getResult() {
        return result;
    }


    /**
     * Sets the result value for this BI_TR_SyncResult.
     * 
     * @param result
     */
    public void setResult(com.sforce.soap.schemas._class.BI_TR_LeadInfoSync.BI_TR_Result result) {
        this.result = result;
    }


    /**
     * Gets the sfdcId value for this BI_TR_SyncResult.
     * 
     * @return sfdcId
     */
    public java.lang.String getSfdcId() {
        return sfdcId;
    }


    /**
     * Sets the sfdcId value for this BI_TR_SyncResult.
     * 
     * @param sfdcId
     */
    public void setSfdcId(java.lang.String sfdcId) {
        this.sfdcId = sfdcId;
    }


    /**
     * Gets the sfdcJobId value for this BI_TR_SyncResult.
     * 
     * @return sfdcJobId
     */
    public java.lang.String getSfdcJobId() {
        return sfdcJobId;
    }


    /**
     * Sets the sfdcJobId value for this BI_TR_SyncResult.
     * 
     * @param sfdcJobId
     */
    public void setSfdcJobId(java.lang.String sfdcJobId) {
        this.sfdcJobId = sfdcJobId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BI_TR_SyncResult)) return false;
        BI_TR_SyncResult other = (BI_TR_SyncResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult()))) &&
            ((this.sfdcId==null && other.getSfdcId()==null) || 
             (this.sfdcId!=null &&
              this.sfdcId.equals(other.getSfdcId()))) &&
            ((this.sfdcJobId==null && other.getSfdcJobId()==null) || 
             (this.sfdcJobId!=null &&
              this.sfdcJobId.equals(other.getSfdcJobId())));
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
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        if (getSfdcId() != null) {
            _hashCode += getSfdcId().hashCode();
        }
        if (getSfdcJobId() != null) {
            _hashCode += getSfdcJobId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BI_TR_SyncResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TR_LeadInfoSync", "BI_TR_SyncResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TR_LeadInfoSync", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TR_LeadInfoSync", "result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TR_LeadInfoSync", "BI_TR_Result"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sfdcId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TR_LeadInfoSync", "sfdcId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sfdcJobId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TR_LeadInfoSync", "sfdcJobId"));
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

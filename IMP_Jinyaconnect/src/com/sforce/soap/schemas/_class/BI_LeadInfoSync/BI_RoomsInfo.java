/**
 * BI_RoomsInfo.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_LeadInfoSync;

public class BI_RoomsInfo  implements java.io.Serializable {
    private java.lang.Integer perRoomPaxCount;

    private java.lang.Integer roomChildA70Count;

    private java.lang.Integer roomPaxFemaleCount;

    private java.lang.Integer roomPaxMaleCount;

    private java.lang.String roomTypeCode;

    private java.lang.String roomTypeName;

    public BI_RoomsInfo() {
    }

    public BI_RoomsInfo(
           java.lang.Integer perRoomPaxCount,
           java.lang.Integer roomChildA70Count,
           java.lang.Integer roomPaxFemaleCount,
           java.lang.Integer roomPaxMaleCount,
           java.lang.String roomTypeCode,
           java.lang.String roomTypeName) {
           this.perRoomPaxCount = perRoomPaxCount;
           this.roomChildA70Count = roomChildA70Count;
           this.roomPaxFemaleCount = roomPaxFemaleCount;
           this.roomPaxMaleCount = roomPaxMaleCount;
           this.roomTypeCode = roomTypeCode;
           this.roomTypeName = roomTypeName;
    }


    /**
     * Gets the perRoomPaxCount value for this BI_RoomsInfo.
     * 
     * @return perRoomPaxCount
     */
    public java.lang.Integer getPerRoomPaxCount() {
        return perRoomPaxCount;
    }


    /**
     * Sets the perRoomPaxCount value for this BI_RoomsInfo.
     * 
     * @param perRoomPaxCount
     */
    public void setPerRoomPaxCount(java.lang.Integer perRoomPaxCount) {
        this.perRoomPaxCount = perRoomPaxCount;
    }


    /**
     * Gets the roomChildA70Count value for this BI_RoomsInfo.
     * 
     * @return roomChildA70Count
     */
    public java.lang.Integer getRoomChildA70Count() {
        return roomChildA70Count;
    }


    /**
     * Sets the roomChildA70Count value for this BI_RoomsInfo.
     * 
     * @param roomChildA70Count
     */
    public void setRoomChildA70Count(java.lang.Integer roomChildA70Count) {
        this.roomChildA70Count = roomChildA70Count;
    }


    /**
     * Gets the roomPaxFemaleCount value for this BI_RoomsInfo.
     * 
     * @return roomPaxFemaleCount
     */
    public java.lang.Integer getRoomPaxFemaleCount() {
        return roomPaxFemaleCount;
    }


    /**
     * Sets the roomPaxFemaleCount value for this BI_RoomsInfo.
     * 
     * @param roomPaxFemaleCount
     */
    public void setRoomPaxFemaleCount(java.lang.Integer roomPaxFemaleCount) {
        this.roomPaxFemaleCount = roomPaxFemaleCount;
    }


    /**
     * Gets the roomPaxMaleCount value for this BI_RoomsInfo.
     * 
     * @return roomPaxMaleCount
     */
    public java.lang.Integer getRoomPaxMaleCount() {
        return roomPaxMaleCount;
    }


    /**
     * Sets the roomPaxMaleCount value for this BI_RoomsInfo.
     * 
     * @param roomPaxMaleCount
     */
    public void setRoomPaxMaleCount(java.lang.Integer roomPaxMaleCount) {
        this.roomPaxMaleCount = roomPaxMaleCount;
    }


    /**
     * Gets the roomTypeCode value for this BI_RoomsInfo.
     * 
     * @return roomTypeCode
     */
    public java.lang.String getRoomTypeCode() {
        return roomTypeCode;
    }


    /**
     * Sets the roomTypeCode value for this BI_RoomsInfo.
     * 
     * @param roomTypeCode
     */
    public void setRoomTypeCode(java.lang.String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }


    /**
     * Gets the roomTypeName value for this BI_RoomsInfo.
     * 
     * @return roomTypeName
     */
    public java.lang.String getRoomTypeName() {
        return roomTypeName;
    }


    /**
     * Sets the roomTypeName value for this BI_RoomsInfo.
     * 
     * @param roomTypeName
     */
    public void setRoomTypeName(java.lang.String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BI_RoomsInfo)) return false;
        BI_RoomsInfo other = (BI_RoomsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.perRoomPaxCount==null && other.getPerRoomPaxCount()==null) || 
             (this.perRoomPaxCount!=null &&
              this.perRoomPaxCount.equals(other.getPerRoomPaxCount()))) &&
            ((this.roomChildA70Count==null && other.getRoomChildA70Count()==null) || 
             (this.roomChildA70Count!=null &&
              this.roomChildA70Count.equals(other.getRoomChildA70Count()))) &&
            ((this.roomPaxFemaleCount==null && other.getRoomPaxFemaleCount()==null) || 
             (this.roomPaxFemaleCount!=null &&
              this.roomPaxFemaleCount.equals(other.getRoomPaxFemaleCount()))) &&
            ((this.roomPaxMaleCount==null && other.getRoomPaxMaleCount()==null) || 
             (this.roomPaxMaleCount!=null &&
              this.roomPaxMaleCount.equals(other.getRoomPaxMaleCount()))) &&
            ((this.roomTypeCode==null && other.getRoomTypeCode()==null) || 
             (this.roomTypeCode!=null &&
              this.roomTypeCode.equals(other.getRoomTypeCode()))) &&
            ((this.roomTypeName==null && other.getRoomTypeName()==null) || 
             (this.roomTypeName!=null &&
              this.roomTypeName.equals(other.getRoomTypeName())));
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
        if (getPerRoomPaxCount() != null) {
            _hashCode += getPerRoomPaxCount().hashCode();
        }
        if (getRoomChildA70Count() != null) {
            _hashCode += getRoomChildA70Count().hashCode();
        }
        if (getRoomPaxFemaleCount() != null) {
            _hashCode += getRoomPaxFemaleCount().hashCode();
        }
        if (getRoomPaxMaleCount() != null) {
            _hashCode += getRoomPaxMaleCount().hashCode();
        }
        if (getRoomTypeCode() != null) {
            _hashCode += getRoomTypeCode().hashCode();
        }
        if (getRoomTypeName() != null) {
            _hashCode += getRoomTypeName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BI_RoomsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_RoomsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perRoomPaxCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "PerRoomPaxCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomChildA70Count");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "RoomChildA70Count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomPaxFemaleCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "RoomPaxFemaleCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomPaxMaleCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "RoomPaxMaleCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "RoomTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomTypeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "RoomTypeName"));
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

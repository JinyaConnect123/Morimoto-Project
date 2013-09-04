/**
 * BI_RoomAndGuestInfo.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_LeadInfoSync;

public class BI_RoomAndGuestInfo  implements java.io.Serializable {
    private com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_GuestInfo[] guestLst;

    private com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomsInfo room;

    private java.util.Date[] roomDateLst;

    public BI_RoomAndGuestInfo() {
    }

    public BI_RoomAndGuestInfo(
           com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_GuestInfo[] guestLst,
           com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomsInfo room,
           java.util.Date[] roomDateLst) {
           this.guestLst = guestLst;
           this.room = room;
           this.roomDateLst = roomDateLst;
    }


    /**
     * Gets the guestLst value for this BI_RoomAndGuestInfo.
     * 
     * @return guestLst
     */
    public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_GuestInfo[] getGuestLst() {
        return guestLst;
    }


    /**
     * Sets the guestLst value for this BI_RoomAndGuestInfo.
     * 
     * @param guestLst
     */
    public void setGuestLst(com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_GuestInfo[] guestLst) {
        this.guestLst = guestLst;
    }

    public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_GuestInfo getGuestLst(int i) {
        return this.guestLst[i];
    }

    public void setGuestLst(int i, com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_GuestInfo _value) {
        this.guestLst[i] = _value;
    }


    /**
     * Gets the room value for this BI_RoomAndGuestInfo.
     * 
     * @return room
     */
    public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomsInfo getRoom() {
        return room;
    }


    /**
     * Sets the room value for this BI_RoomAndGuestInfo.
     * 
     * @param room
     */
    public void setRoom(com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_RoomsInfo room) {
        this.room = room;
    }


    /**
     * Gets the roomDateLst value for this BI_RoomAndGuestInfo.
     * 
     * @return roomDateLst
     */
    public java.util.Date[] getRoomDateLst() {
        return roomDateLst;
    }


    /**
     * Sets the roomDateLst value for this BI_RoomAndGuestInfo.
     * 
     * @param roomDateLst
     */
    public void setRoomDateLst(java.util.Date[] roomDateLst) {
        this.roomDateLst = roomDateLst;
    }

    public java.util.Date getRoomDateLst(int i) {
        return this.roomDateLst[i];
    }

    public void setRoomDateLst(int i, java.util.Date _value) {
        this.roomDateLst[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BI_RoomAndGuestInfo)) return false;
        BI_RoomAndGuestInfo other = (BI_RoomAndGuestInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.guestLst==null && other.getGuestLst()==null) || 
             (this.guestLst!=null &&
              java.util.Arrays.equals(this.guestLst, other.getGuestLst()))) &&
            ((this.room==null && other.getRoom()==null) || 
             (this.room!=null &&
              this.room.equals(other.getRoom()))) &&
            ((this.roomDateLst==null && other.getRoomDateLst()==null) || 
             (this.roomDateLst!=null &&
              java.util.Arrays.equals(this.roomDateLst, other.getRoomDateLst())));
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
        if (getGuestLst() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGuestLst());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGuestLst(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRoom() != null) {
            _hashCode += getRoom().hashCode();
        }
        if (getRoomDateLst() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRoomDateLst());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRoomDateLst(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BI_RoomAndGuestInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_RoomAndGuestInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestLst");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "guestLst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_GuestInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("room");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "room"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_RoomsInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomDateLst");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "roomDateLst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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

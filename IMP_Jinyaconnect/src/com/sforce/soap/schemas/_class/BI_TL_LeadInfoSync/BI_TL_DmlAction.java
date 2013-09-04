/**
 * BI_TL_DmlAction.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_TL_LeadInfoSync;

public class BI_TL_DmlAction implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // コンストラクタ / [en]-(Constructor)
    protected BI_TL_DmlAction(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _CANCEL = "CANCEL";
    public static final java.lang.String _CONFIRM = "CONFIRM";
    public static final java.lang.String _INS = "INS";
    public static final java.lang.String _ISSUE = "ISSUE";
    public static final java.lang.String _OTHER = "OTHER";
    public static final java.lang.String _TEJIMA = "TEJIMA";
    public static final java.lang.String _UPD = "UPD";
    public static final BI_TL_DmlAction CANCEL = new BI_TL_DmlAction(_CANCEL);
    public static final BI_TL_DmlAction CONFIRM = new BI_TL_DmlAction(_CONFIRM);
    public static final BI_TL_DmlAction INS = new BI_TL_DmlAction(_INS);
    public static final BI_TL_DmlAction ISSUE = new BI_TL_DmlAction(_ISSUE);
    public static final BI_TL_DmlAction OTHER = new BI_TL_DmlAction(_OTHER);
    public static final BI_TL_DmlAction TEJIMA = new BI_TL_DmlAction(_TEJIMA);
    public static final BI_TL_DmlAction UPD = new BI_TL_DmlAction(_UPD);
    public java.lang.String getValue() { return _value_;}
    public static BI_TL_DmlAction fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        BI_TL_DmlAction enumeration = (BI_TL_DmlAction)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static BI_TL_DmlAction fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // メタデータ型 / [en]-(Type metadata)
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BI_TL_DmlAction.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_TL_LeadInfoSync", "BI_TL_DmlAction"));
    }
    /**
     * メタデータオブジェクトの型を返却 / [en]-(Return type metadata object)
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}

/**
 * BI_TL_LeadInfoSyncPortType.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_TL_LeadInfoSync;

public interface BI_TL_LeadInfoSyncPortType extends java.rmi.Remote {
    public com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_SyncResult upsertLeadInfo(com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_SyncInfo bookingInfo) throws java.rmi.RemoteException;
}

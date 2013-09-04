/**
 * BI_TR_LeadInfoSyncPortType.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync;

public interface BI_TR_LeadInfoSyncPortType extends java.rmi.Remote {
    public com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_SyncResult upsertLeadInfo(com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_SyncInfo bookingInfo) throws java.rmi.RemoteException;
}

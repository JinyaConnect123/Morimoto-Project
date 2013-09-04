package com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync;

public class BI_TR_LeadInfoSyncPortTypeProxy implements com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_LeadInfoSyncPortType {
  private String _endpoint = null;
  private com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_LeadInfoSyncPortType bI_TR_LeadInfoSyncPortType = null;
  
  public BI_TR_LeadInfoSyncPortTypeProxy() {
    _initBI_TR_LeadInfoSyncPortTypeProxy();
  }
  
  public BI_TR_LeadInfoSyncPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initBI_TR_LeadInfoSyncPortTypeProxy();
  }
  
  private void _initBI_TR_LeadInfoSyncPortTypeProxy() {
    try {
      bI_TR_LeadInfoSyncPortType = (new com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_LeadInfoSyncServiceLocator()).getBI_TR_LeadInfoSync();
      if (bI_TR_LeadInfoSyncPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bI_TR_LeadInfoSyncPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bI_TR_LeadInfoSyncPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bI_TR_LeadInfoSyncPortType != null)
      ((javax.xml.rpc.Stub)bI_TR_LeadInfoSyncPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_LeadInfoSyncPortType getBI_TR_LeadInfoSyncPortType() {
    if (bI_TR_LeadInfoSyncPortType == null)
      _initBI_TR_LeadInfoSyncPortTypeProxy();
    return bI_TR_LeadInfoSyncPortType;
  }
  
  public com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_SyncResult upsertLeadInfo(com.sforce.soap.schemas._class.ps.BI_TR_LeadInfoSync.BI_TR_SyncInfo bookingInfo) throws java.rmi.RemoteException{
    if (bI_TR_LeadInfoSyncPortType == null)
      _initBI_TR_LeadInfoSyncPortTypeProxy();
    return bI_TR_LeadInfoSyncPortType.upsertLeadInfo(bookingInfo);
  }
  
  
}
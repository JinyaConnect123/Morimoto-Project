package com.sforce.soap.schemas._class.BI_LeadInfoSync;

public class BI_LeadInfoSyncPortTypeProxy implements com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncPortType {
  private String _endpoint = null;
  private com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncPortType bI_LeadInfoSyncPortType = null;
  
  public BI_LeadInfoSyncPortTypeProxy() {
    _initBI_LeadInfoSyncPortTypeProxy();
  }
  
  public BI_LeadInfoSyncPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initBI_LeadInfoSyncPortTypeProxy();
  }
  
  private void _initBI_LeadInfoSyncPortTypeProxy() {
    try {
      bI_LeadInfoSyncPortType = (new com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncServiceLocator()).getBI_LeadInfoSync();
      if (bI_LeadInfoSyncPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bI_LeadInfoSyncPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bI_LeadInfoSyncPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bI_LeadInfoSyncPortType != null)
      ((javax.xml.rpc.Stub)bI_LeadInfoSyncPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncPortType getBI_LeadInfoSyncPortType() {
    if (bI_LeadInfoSyncPortType == null)
      _initBI_LeadInfoSyncPortTypeProxy();
    return bI_LeadInfoSyncPortType;
  }
  
  public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_SyncResult upsertLeadInfo(com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_SyncInfo bookingInfo) throws java.rmi.RemoteException{
    if (bI_LeadInfoSyncPortType == null)
      _initBI_LeadInfoSyncPortTypeProxy();
    return bI_LeadInfoSyncPortType.upsertLeadInfo(bookingInfo);
  }
  
  
}
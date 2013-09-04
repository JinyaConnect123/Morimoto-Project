package com.sforce.soap.schemas._class.BI_TL_LeadInfoSync;

public class BI_TL_LeadInfoSyncPortTypeProxy implements com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_LeadInfoSyncPortType {
  private String _endpoint = null;
  private com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_LeadInfoSyncPortType bI_TL_LeadInfoSyncPortType = null;
  
  public BI_TL_LeadInfoSyncPortTypeProxy() {
    _initBI_TL_LeadInfoSyncPortTypeProxy();
  }
  
  public BI_TL_LeadInfoSyncPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initBI_TL_LeadInfoSyncPortTypeProxy();
  }
  
  private void _initBI_TL_LeadInfoSyncPortTypeProxy() {
    try {
      bI_TL_LeadInfoSyncPortType = (new com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_LeadInfoSyncServiceLocator()).getBI_TL_LeadInfoSync();
      if (bI_TL_LeadInfoSyncPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bI_TL_LeadInfoSyncPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bI_TL_LeadInfoSyncPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bI_TL_LeadInfoSyncPortType != null)
      ((javax.xml.rpc.Stub)bI_TL_LeadInfoSyncPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_LeadInfoSyncPortType getBI_TL_LeadInfoSyncPortType() {
    if (bI_TL_LeadInfoSyncPortType == null)
      _initBI_TL_LeadInfoSyncPortTypeProxy();
    return bI_TL_LeadInfoSyncPortType;
  }
  
  public com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_SyncResult upsertLeadInfo(com.sforce.soap.schemas._class.BI_TL_LeadInfoSync.BI_TL_SyncInfo bookingInfo) throws java.rmi.RemoteException{
    if (bI_TL_LeadInfoSyncPortType == null)
      _initBI_TL_LeadInfoSyncPortTypeProxy();
    return bI_TL_LeadInfoSyncPortType.upsertLeadInfo(bookingInfo);
  }
  
  
}
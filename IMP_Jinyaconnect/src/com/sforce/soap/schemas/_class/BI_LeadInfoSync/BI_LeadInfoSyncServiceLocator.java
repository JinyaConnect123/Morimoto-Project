/**
 * BI_LeadInfoSyncServiceLocator.java
 *
 * このファイルはWSDLから自動生成されました / [en]-(This file was auto-generated from WSDL)
 * Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java生成器によって / [en]-(by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.)
 */

package com.sforce.soap.schemas._class.BI_LeadInfoSync;

public class BI_LeadInfoSyncServiceLocator extends org.apache.axis.client.Service implements com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncService {

    public BI_LeadInfoSyncServiceLocator() {
    }


    public BI_LeadInfoSyncServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BI_LeadInfoSyncServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // BI_LeadInfoSyncのプロキシクラスの取得に使用します / [en]-(Use to get a proxy class for BI_LeadInfoSync)
    private java.lang.String BI_LeadInfoSync_address = "https://na9-api.salesforce.com/services/Soap/class/BI_LeadInfoSync";

    public java.lang.String getBI_LeadInfoSyncAddress() {
        return BI_LeadInfoSync_address;
    }

    // WSDDサービス名のデフォルトはポート名です / [en]-(The WSDD service name defaults to the port name.)
    private java.lang.String BI_LeadInfoSyncWSDDServiceName = "BI_LeadInfoSync";

    public java.lang.String getBI_LeadInfoSyncWSDDServiceName() {
        return BI_LeadInfoSyncWSDDServiceName;
    }

    public void setBI_LeadInfoSyncWSDDServiceName(java.lang.String name) {
        BI_LeadInfoSyncWSDDServiceName = name;
    }

    public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncPortType getBI_LeadInfoSync() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BI_LeadInfoSync_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBI_LeadInfoSync(endpoint);
    }

    public com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncPortType getBI_LeadInfoSync(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncBindingStub _stub = new com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncBindingStub(portAddress, this);
            _stub.setPortName(getBI_LeadInfoSyncWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBI_LeadInfoSyncEndpointAddress(java.lang.String address) {
        BI_LeadInfoSync_address = address;
    }

    /**
     * 与えられたインターフェースに対して、スタブの実装を取得します。 / [en]-(For the given interface, get the stub implementation.)
     * このサービスが与えられたインターフェースに対してポートを持たない場合、 / [en]-(If this service has no port for the given interface,)
     * ServiceExceptionが投げられます。 / [en]-(then ServiceException is thrown.)
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncBindingStub _stub = new com.sforce.soap.schemas._class.BI_LeadInfoSync.BI_LeadInfoSyncBindingStub(new java.net.URL(BI_LeadInfoSync_address), this);
                _stub.setPortName(getBI_LeadInfoSyncWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("インターフェースに対するスタブの実装がありません: / [en]-(There is no stub implementation for the interface:)  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * 与えられたインターフェースに対して、スタブの実装を取得します。 / [en]-(For the given interface, get the stub implementation.)
     * このサービスが与えられたインターフェースに対してポートを持たない場合、 / [en]-(If this service has no port for the given interface,)
     * ServiceExceptionが投げられます。 / [en]-(then ServiceException is thrown.)
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BI_LeadInfoSync".equals(inputPortName)) {
            return getBI_LeadInfoSync();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_LeadInfoSyncService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/BI_LeadInfoSync", "BI_LeadInfoSync"));
        }
        return ports.iterator();
    }

    /**
    * 指定したポート名に対するエンドポイントのアドレスをセットします / [en]-(Set the endpoint address for the specified port name.)
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BI_LeadInfoSync".equals(portName)) {
            setBI_LeadInfoSyncEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" 未知のポートに対してはエンドポイントのアドレスをセットできません / [en]-(Cannot set Endpoint Address for Unknown Port)" + portName);
        }
    }

    /**
    * 指定したポート名に対するエンドポイントのアドレスをセットします / [en]-(Set the endpoint address for the specified port name.)
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

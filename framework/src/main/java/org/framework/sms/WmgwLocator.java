/**
 * WmgwLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.framework.sms;

public class WmgwLocator extends org.apache.axis.client.Service implements org.framework.sms.Wmgw {

    public WmgwLocator() {
    }


    public WmgwLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WmgwLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for wmgwSoap
    private java.lang.String wmgwSoap_address = "http://ws.montnets.com:9002/MWGate/wmgw.asmx";

    public java.lang.String getwmgwSoapAddress() {
        return wmgwSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wmgwSoapWSDDServiceName = "wmgwSoap";

    public java.lang.String getwmgwSoapWSDDServiceName() {
        return wmgwSoapWSDDServiceName;
    }

    public void setwmgwSoapWSDDServiceName(java.lang.String name) {
        wmgwSoapWSDDServiceName = name;
    }

    public org.framework.sms.WmgwSoap getwmgwSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wmgwSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwmgwSoap(endpoint);
    }

    public org.framework.sms.WmgwSoap getwmgwSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.framework.sms.WmgwSoapStub _stub = new org.framework.sms.WmgwSoapStub(portAddress, this);
            _stub.setPortName(getwmgwSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwmgwSoapEndpointAddress(java.lang.String address) {
        wmgwSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.framework.sms.WmgwSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.framework.sms.WmgwSoapStub _stub = new org.framework.sms.WmgwSoapStub(new java.net.URL(wmgwSoap_address), this);
                _stub.setPortName(getwmgwSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("wmgwSoap".equals(inputPortName)) {
            return getwmgwSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "wmgw");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "wmgwSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("wmgwSoap".equals(portName)) {
            setwmgwSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

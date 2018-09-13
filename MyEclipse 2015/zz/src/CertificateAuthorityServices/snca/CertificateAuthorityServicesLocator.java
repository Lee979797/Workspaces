/**
 * CertificateAuthorityServicesLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CertificateAuthorityServices.snca;

import java.util.HashMap;

public class CertificateAuthorityServicesLocator extends org.apache.axis.client.Service implements CertificateAuthorityServices {

	
	static HashMap hmap = new HashMap();
	static String Assip = null;
	static String Assport = null;
	static {
		if (hmap.get("ASS_IP") == null) {
			readConfig read = new readConfig();
			hmap = read.readcfg();
		}
		Assip = hmap.get("ASS_IP").toString();
		Assport = hmap.get("ASS_PORT").toString();
	    System.out.println("连接认证服务器地址："+Assip+">>>>"+Assport);
	}

	private static final String url_webservice = "http://" + Assip + ":"+ Assport;
	
    public CertificateAuthorityServicesLocator() {
    }


    public CertificateAuthorityServicesLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CertificateAuthorityServicesLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CertificateAuthorityServicesHttpSoap11Endpoint
    private java.lang.String CertificateAuthorityServicesHttpSoap11Endpoint_address = url_webservice+"/SNCA_CertificateAuthorityPlatform/services/CertificateAuthorityServices.CertificateAuthorityServicesHttpSoap11Endpoint/";

    public java.lang.String getCertificateAuthorityServicesHttpSoap11EndpointAddress() {
        return CertificateAuthorityServicesHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CertificateAuthorityServicesHttpSoap11EndpointWSDDServiceName = "CertificateAuthorityServicesHttpSoap11Endpoint";

    public java.lang.String getCertificateAuthorityServicesHttpSoap11EndpointWSDDServiceName() {
        return CertificateAuthorityServicesHttpSoap11EndpointWSDDServiceName;
    }

    public void setCertificateAuthorityServicesHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        CertificateAuthorityServicesHttpSoap11EndpointWSDDServiceName = name;
    }

    public CertificateAuthorityServicesPortType getCertificateAuthorityServicesHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CertificateAuthorityServicesHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCertificateAuthorityServicesHttpSoap11Endpoint(endpoint);
    }

    public CertificateAuthorityServicesPortType getCertificateAuthorityServicesHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CertificateAuthorityServicesSoap11BindingStub _stub = new CertificateAuthorityServicesSoap11BindingStub(portAddress, this);
            _stub.setPortName(getCertificateAuthorityServicesHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCertificateAuthorityServicesHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        CertificateAuthorityServicesHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (CertificateAuthorityServicesPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                CertificateAuthorityServicesSoap11BindingStub _stub = new CertificateAuthorityServicesSoap11BindingStub(new java.net.URL(CertificateAuthorityServicesHttpSoap11Endpoint_address), this);
                _stub.setPortName(getCertificateAuthorityServicesHttpSoap11EndpointWSDDServiceName());
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
        if ("CertificateAuthorityServicesHttpSoap11Endpoint".equals(inputPortName)) {
            return getCertificateAuthorityServicesHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://snca.CertificateAuthorityServices/", "CertificateAuthorityServices");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://snca.CertificateAuthorityServices/", "CertificateAuthorityServicesHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CertificateAuthorityServicesHttpSoap11Endpoint".equals(portName)) {
            setCertificateAuthorityServicesHttpSoap11EndpointEndpointAddress(address);
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

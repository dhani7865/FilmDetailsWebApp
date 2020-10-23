/**
 * FilmLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.daehosting.webservices.film;


// Creating FilmLocator class which extends  org.apache.axis.client.Service and implements com.daehosting.webservices.film.Film
public class FilmLocator extends org.apache.axis.client.Service implements com.daehosting.webservices.film.Film {

	/**
	 * Visual DataFlex Web Service for film details
	 */
	// FilmLocator method
	public FilmLocator() {
	}

	// FilmLocator method for the Engine Configuration
	public FilmLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	// FilmLocator for the string wsdl location
	public FilmLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for FilmSoap
	// Film soap address has been created to get a proxy class for FilmSoap
	private java.lang.String FilmSoap_address = "http://localhost:8080/FilmServer/services/FilmSoap";

	// java.an.string for the getFilmSoapAddress
	public java.lang.String getFilmSoapAddress() {
		// Return the soap address
		return FilmSoap_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String FilmSoapWSDDServiceName = "FilmSoap";

	// Public method for the getFilmSoapWSDDServiceName
	public java.lang.String getFilmSoapWSDDServiceName() {
		// Return the FilmSoapWSDDServiceName
		return FilmSoapWSDDServiceName;
	}

	// setting the FilmSoapWSDDServiceName
	public void setFilmSoapWSDDServiceName(java.lang.String name) {
		FilmSoapWSDDServiceName = name;
	}

	// Creating public web services for the film soap and calling the get film soap method
	public com.daehosting.webservices.film.FilmSoapType getFilmSoap() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		// try and catch for the film soap url
		try {
			endpoint = new java.net.URL(FilmSoap_address);
		}
		catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		// Return getFilmSoap
		return getFilmSoap(endpoint);
	}

	// Creating public com.daehosting.webservices.film.FilmSoapType to get the film soap
	public com.daehosting.webservices.film.FilmSoapType getFilmSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			com.daehosting.webservices.film.FilmSoapBindingStub _stub = new com.daehosting.webservices.film.FilmSoapBindingStub(portAddress, this);
			_stub.setPortName(getFilmSoapWSDDServiceName());
			return _stub;
		}
		catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	// Setting the FilmSoapEndpointAddress
	public void setFilmSoapEndpointAddress(java.lang.String address) {
		FilmSoap_address = address;
	}

	/**
	 * For the given interface, getting the stub implementation.
	 * If this service has no port for the given interface,
	 * then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		// Creating try and catch for get port
		try {
			if (com.daehosting.webservices.film.FilmSoapType.class.isAssignableFrom(serviceEndpointInterface)) {
				com.daehosting.webservices.film.FilmSoapBindingStub _stub = new com.daehosting.webservices.film.FilmSoapBindingStub(new java.net.URL(FilmSoap_address), this);
				_stub.setPortName(getFilmSoapWSDDServiceName());
				return _stub;
			}
		}
		catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		// Otherwise throw new ServiceException
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, getting the stub implementation.
	 * If this service has no port for the given interface,
	 * then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		// If the port name equals to null, return the port for the serviceEndpointInterface
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		// Input the port name and getting the local part
		java.lang.String inputPortName = portName.getLocalPart();
		// If the film soap equals to the inut port name, return get film soap
		if ("FilmSoap".equals(inputPortName)) {
			// Return the get film soap
			return getFilmSoap();
		}
		// Otherwise, get port service end point interface
		else  {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	// Public xml name space and returning the name space
	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "Film");
	}

	// Creating private java util for the hash set ports and giving it value null
	private java.util.HashSet ports = null;

	// Get ports
	public java.util.Iterator getPorts() {
		// If ports equal to null, create new hash set and adding new javax.xml.namespace.QName for the film soap
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://webservices.daehosting.com/film", "FilmSoap"));
		}
		// Otherwise, return the iterator
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
		// if film soap equals to the port name, then setting the film soap end point address
		if ("FilmSoap".equals(portName)) {
			setFilmSoapEndpointAddress(address);
		}
		// Otherwise, throw new javax xml rpc service exception
		else 
		{ 
			// Unknown Port Name
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

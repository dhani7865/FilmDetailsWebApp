/**
 * FilmSoapType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.daehosting.webservices.film;

public interface FilmSoapType extends java.rmi.Remote {

    /**
     * Converts a Celcius Temperature to a Fahrenheit value
     */
    public java.lang.String filmsList(java.lang.String parameters) throws java.rmi.RemoteException;

    /**
     * Converts a Fahrenheit Temperature to a Celcius value
     */
    public java.lang.String filmsXML(java.lang.String parameters) throws java.rmi.RemoteException;

    /**
     * Windchill temperature calculated with the formula of
     * 				Steadman
     */
    public java.lang.String filmsJSON(java.lang.String parameters) throws java.rmi.RemoteException;

    /**
     * Windchill temperature calculated with the formula of
     * 				Steadman
     */
    public java.lang.String filmsString(java.lang.String parameters) throws java.rmi.RemoteException;
}

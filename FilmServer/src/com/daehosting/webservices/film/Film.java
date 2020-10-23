package com.daehosting.webservices.film;

// Creating public interface for the film details
public interface Film extends javax.xml.rpc.Service{
	// getFilmSoapAddress
	public java.lang.String getFilmSoapAddress();
	//getFilmSoap
	public com.daehosting.webservices.film.FilmSoapType getFilmSoap() throws javax.xml.rpc.ServiceException;
	// get port address
	public com.daehosting.webservices.film.FilmSoapType getFilmSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

/**
 * FilmSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.daehosting.webservices.film;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;

// Creating public class FilmSoapBindingImpl which implements com.daehosting.webservices.film.FilmSoapType
public class FilmSoapBindingImpl implements com.daehosting.webservices.film.FilmSoapType {
	// Creating public lang.string for the films list
	public java.lang.String filmsList(java.lang.String parameters) throws java.rmi.RemoteException {
		// Calling the film dao class
		FilmDAO film = new FilmDAO();

		// Getting all films from the array list
		ArrayList<Film_> FilmList = FilmDAO.getAllFilms();
		// Getting id
		int id = 0;
		// Creating array list of films
		List<Film_> tmpList = new ArrayList<>();
		// Creating boolean value at the start and setting it to false
		boolean idRecvd = false;
		// Creating try and catch to get the id
		// if id has been recieved show the films
		try {
			// Convert string to int using integer.parseint
			id = Integer.parseInt(parameters);
			// When id has been recieved return true
			idRecvd = true;
		} catch (Exception e) {
		}
		// if id has been received return the films data
		if (idRecvd) {
			// Print message onto the console saying id has been received
			System.out.println("id received " + id);
			// Creating for loop to show the list of films
			for (int i = 0; i < FilmList.size(); i++) {
				Film_ tmpFlm = FilmList.get(i);
				// Get the id and print the film
				if (tmpFlm.getId() == id) {
					tmpList.add(tmpFlm);
					System.out.println(tmpFlm.toString());
				} // CLose if statement
			} // CLose for loop
			// print the films size message onto the console
			System.out.println("FilmsSize " + tmpList.size());
		} // CLose if statement for id recieved

		// String variable for rtval and setting it empty string
		String rtval = "";
		// Creating try and catch for the context for jxb and marshaller for the film list
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
			Marshaller jaxbMarshaller;
			jaxbMarshaller = jaxbContext.createMarshaller();
			// Creating film list for the list of films
			FilmList filmlist;
			/**
			 *  If the id has been received, return the list of films.
			 *  Otherwise return rtval
			 */
			if (idRecvd)
				// Creating new film list
				filmlist = new FilmList(tmpList);
			else
				filmlist = new FilmList(FilmList);
			// Crating new string writer
			StringWriter out = new StringWriter();
			// output pretty printed
			// jaxmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
			// true);
			jaxbMarshaller.marshal(filmlist, out); // out is the stream back to
			// browser
			rtval=out.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Otherwise return rtval
		return rtval;
	}

	// Public string for the films in xml format, with string parameters
	public java.lang.String filmsXML(java.lang.String parameters) throws java.rmi.RemoteException {
		// Calling the film dao class
		FilmDAO film = new FilmDAO();
		// Getting all films from the array list
		ArrayList<Film_> FilmList = FilmDAO.getAllFilms();
		// Getting id
		int id = 0;
		// Creating array list of films
		List<Film_> tmpList = new ArrayList<>();
		// Creating boolean value at the start and setting it to false
		boolean idRecvd = false;
		// Creating try and catch to get the id
		// if id has been received show the films
		try {
			// Convert string to int using integer.parseint
			id = Integer.parseInt(parameters);
			// When id has been recieved return true
			idRecvd = true;
		} catch (Exception e) {
		}
		// if id has been recieved return the films data
		if (idRecvd) {
			// Print message onto the console saying id has been received
			System.out.println("id received " + id);
			// Creating for loop to show the list of films
			for (int i = 0; i < FilmList.size(); i++) {
				Film_ tmpFlm = FilmList.get(i);
				// Get the id and print the film
				if (tmpFlm.getId() == id) {
					tmpList.add(tmpFlm);
					System.out.println(tmpFlm.toString());
				} // CLose if statement
			} // CLose for loop
			// print the films size message onto the console
			System.out.println("FilmsSize " + tmpList.size());
		} // CLose if statement for id recieved
		// Creating string for rtval and setting it to empty string
		String rtval = "";

		/**
		 *  If the id has been recieved, return the list of films.
		 *  Otherwise return rtval
		 */
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
			Marshaller jaxbMarshaller;
			jaxbMarshaller = jaxbContext.createMarshaller();

			// Creating film list for the list of films
			FilmList filmlist;

			// If the id has been recieved, return the films
			if (idRecvd)
				// Creating new film list
				filmlist = new FilmList(tmpList);
			else
				filmlist = new FilmList(FilmList);
			StringWriter out = new StringWriter();
			// output pretty printed
			// jaxmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
			// true);
			jaxbMarshaller.marshal(filmlist, out); // out is the stream back to
			// browser
			rtval=out.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// otherwise return the rtval
		return rtval;
	}

	// Creating string films json and string parameters
	public java.lang.String filmsJSON(java.lang.String parameters) throws java.rmi.RemoteException {
		// Calling the film dao class
		FilmDAO film = new FilmDAO();
		// Getting all films from the array list
		ArrayList<Film_> FilmList = FilmDAO.getAllFilms();
		// Getting id
		int id = 0;
		// Creating array list of films
		List<Film_> tmpList = new ArrayList<>();
		// Creating boolean value at the start and setting it to false
		boolean idRecvd = false;
		// Creating try and catch to get the id
		// if id has been recieved show the films
		try {
			// Convert string to int using integer.parseint
			id = Integer.parseInt(parameters);
			// When id has been recieved return true
			idRecvd = true;
		} catch (Exception e) {
		}
		// if id has been recieved return the films data
		if (idRecvd) {
			// Print message onto the console saying id has been received
			System.out.println("id received " + id);
			// Creating for loop to show the list of films
			for (int i = 0; i < FilmList.size(); i++) {
				Film_ tmpFlm = FilmList.get(i);
				// Get the id and print the film
				if (tmpFlm.getId() == id) {
					tmpList.add(tmpFlm);
					System.out.println(tmpFlm.toString());
				} // CLose if statement
			} // CLose for loop
			// print the films size message onto the console
			System.out.println("FilmsSize " + tmpList.size());
		} // CLose if statement for id recieved

		// Creating string rtval and setting it to empty string
		String rtval = "";
		/**
		 *  If the id has been recieved, return the list of films.
		 *  Otherwise return rtval
		 */		
		try {
			// Creating gson object
			Gson gson = new Gson();
			// if id has been recieved return the films data in json format
			if (idRecvd)
				// Convert the films list to json format
				rtval = gson.toJson(tmpList);
			else
				rtval = gson.toJson(FilmList);



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Otherwise, return rtval
		return rtval;
	}

	// Creating string for the films in string format and string parameters
	public java.lang.String filmsString(java.lang.String parameters) throws java.rmi.RemoteException {
		// Calling the film dao class
		FilmDAO film = new FilmDAO();
		// Getting all films from the array list
		ArrayList<Film_> FilmList = FilmDAO.getAllFilms();
		// Getting id
		int id = 0;
		// Creating array list of films
		List<Film_> tmpList = new ArrayList<>();
		// Creating boolean value at the start and setting it to false
		boolean idRecvd = false;
		// Creating try and catch to get the id
		// if id has been recieved show the films
		try {
			// Convert string to int using integer.parseint
			id = Integer.parseInt(parameters);
			// When id has been recieved return true
			idRecvd = true;
		} catch (Exception e) {
		}
		// if id has been recieved return the films data
		if (idRecvd) {
			// Print message onto the console saying id has been received
			System.out.println("id received " + id);
			// Creating for loop to show the list of films
			for (int i = 0; i < FilmList.size(); i++) {
				Film_ tmpFlm = FilmList.get(i);
				// Get the id and print the film
				if (tmpFlm.getId() == id) {
					tmpList.add(tmpFlm);
					System.out.println(tmpFlm.toString());
				} // CLose if statement
			} // CLose for loop
			// print the films size message onto the console
			System.out.println("FilmsSize " + tmpList.size());
		} // CLose if statement for id recieved
		// Creating string rtval and setting it to empty string
		String rtval = "";
		/**
		 *  If the id has been recieved, return the list of films.
		 *  Otherwise return rtval
		 */		
		try {
			// Creating new string wirter
			StringWriter out = new StringWriter();
			// Creating form loop for one film and then printing out the film
			for (int i = 0; i < tmpList.size(); i++) {
				// Get film
				Film_ oneFilm = tmpList.get(i);
				// Print films out onto the console
				rtval+=oneFilm.toStringNew()+"\n";

			} // Close for loop

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// otherwise, return rtval
		return rtval;
	}

}

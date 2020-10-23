package com.democo.jersey.film.client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.democo.jersey.film.model.Film;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.core.spi.scanning.Scanner;


// Creating public class for the tester
public class Tester {
	// Creating static string for the output
	static String output="";
	// Creating mainmethod for the tester
	public static void main(String[] args) {
		//ClientConfig config = new DefaultClientConfig();
		//Client client = Client.create(config);
		// Creating client and calling the create emthod
		Client client = Client.create();
		// Creating client add filter and printing out the logging filter
		client.addFilter(new LoggingFilter(System.out));

		//		URI url=new URI("com.democo.jersey.film");
		//		System.out.print(getBaseURI());
		// Creating web source
		WebResource service = client.resource(getBaseURI());
		// Create one film
		Film film = new Film(123456, 
				"Four Lions",
				2010,
				"Chris Morris, Omar, Hassan, Barry, Waj and Faisal",
				"Chris Morris, Omar, Hassan, Barry, Waj and Faisal",
				"Four Lions is an English movie released on 07 May, 2010. The movie is directed by Christopher Morris and featured Will Adamsdale and Adeel Akhtar as lead characters.");
		//		ClientResponse response = service.path("rest").path("films").path(film.getId()+"").accept(MediaType.APPLICATION_XML).put(ClientResponse.class, film);
		// Creating client response for the rest path
		ClientResponse response = service.path("rest").path("films").accept(MediaType.TEXT_XML).put(ClientResponse.class, film);
		// Return code should be 201 == created resource
		System.out.println(response.getStatus());
		// Output the path
		output+=service.path("rest").path("films").accept(
				MediaType.TEXT_XML).get(String.class);
		//System.out.println(service.path("rest").path("films").accept(
		//		MediaType.TEXT_XML).get(String.class));

		// Get the fim with id 10010
		output+=service.path("rest").path("films/10010").accept(
				MediaType.TEXT_XML).get(String.class);
		//System.out.println(service.path("rest").path("films/10010").accept(
		//		MediaType.TEXT_XML).get(String.class));
		// get film with id 10010
		Form delForm = new Form();
		delForm.add("id", 10010);
		//service.path("rest").path("films").path("delete").type(MediaType.APPLICATION_FORM_URLENCODED)
		//.post(ClientResponse.class, delForm);
		// Output the path
		output+=service.path("rest").path("films").path("delete").type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, delForm);
		//service.path("rest").path("films").delete();
		// Get all films, id 1 should be deleted
		
		// Output the path
		output+=service.path("rest").path("films").accept(
				MediaType.TEXT_XML).get(String.class);
		//System.out.println(service.path("rest").path("films").accept(
		//		MediaType.TEXT_XML).get(String.class));

		// Creating a new film
		Form form = new Form();
		form.add("id", 1234566);
		form.add("title", "One film");
		form.add("year", 2019);
		form.add("director", "Dhany");
		form.add("stars", "Dhany and John");
		form.add("review", "5 star");
		// add the film
		response = service.path("rest").path("films").type(MediaType.APPLICATION_FORM_URLENCODED)
				.post(ClientResponse.class, form);
		output+="Form response " + response.getEntity(String.class);
		// Print response
		//System.out.println("Form response " + response.getEntity(String.class));
		// Get the all films, id 4 should be created
		output+=service.path("rest").path("films").accept(
				MediaType.TEXT_XML).get(String.class);
		//System.out.println(service.path("rest").path("films").accept(
		//		MediaType.TEXT_XML).get(String.class));
		System.out.println(output);
	} // CLose main method

	// Creating privte static URI to get the base uri
	private static URI getBaseURI() {
		// Return the uri builder from the uro
		return UriBuilder.fromUri(
				"http://localhost:8080/com.democo.jersey.film").build();
	} // Close private static uri get base uri
} // Close public class tester
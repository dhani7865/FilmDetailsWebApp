package com.democo.jersey.film.resources;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.democo.jersey.film.model.Film;
import com.democo.jersey.film.model.FilmDAO;
/**
 * Creating film resource for the crdue mthods.
 * create, retrieve, update and delte
 * Retrive would get all the films on the browser
 * Update(put) would allow to update film.
 * Delete would delete the film from the database based on id
 * @author Dhanyaal. 
 */

//@Path("films")
public class FilmResource {
	// Creating new film dao and calling the FilmDAO class
	// it asks the dao and then prints out the list of films

	FilmDAO dao = new FilmDAO();
	// Creating context and creating variables for the UriInfo
	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	// Creating another context and creating variable for the request and int id
	@Context
	Request request;
	int id;

	//TODO function added
	//	// Getting all films from the array list
	//	ArrayList<Film> FilmList = FilmDAO.getAllFilms();	
	//	// Creating form loop for one film and then printing out the film
	//	for (int i=0; i<FilmList.size(); i++ ) {
	//		// Get film
	//		Film oneFilm = FilmList.get(i);
	//		// Print films out onto the console
	//		System.out.println(oneFilm.toString());
	//		System.out.println("All data displayed successfully");
	//	} // Close for loop

	// Creating public FilmResource method
	public FilmResource(UriInfo uriInfo, Request request, int id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	} // Close public FilmResource method

	//getAllFilms
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	// Crrating path to return all films
	@Path("/allFilms")
	// Creating public array list to get all the films data
	public ArrayList<Film> getAllFilms(){
		// Return all films
		return FilmDAO.getAllFilms();
	} // Close public array list getAllFilms


	//getFilmsMatching
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	// Creating path to search for the matching film
	@Path("/search/{search}")
	// Creating public array list to get matching film
	public ArrayList<Film> getFilmsMatching(@PathParam("search") String search){
		// Creating array list for films and geting the matching film
		ArrayList<Film> films = FilmDAO.getFilmsMatching(search);
		// If film equal null get film which has been searched
		if(films==null) {
			throw new RuntimeException("Get: Film containing " + search +  " not found");
		} // CLose if statement
		//Otherwise return the films
		return films;
	} // CLose public array list for getFilmsMatching

	// For the browser
	// Getting/reading the film on the browser
	@GET
	// Creating media type for the text_xml
	@Produces(MediaType.TEXT_XML)
	// Creating public film for the get film html
	public Film getFilmHTML() {
		// Calling the film class and filmdao to get the instance and getting the model for the id
		System.out.println("ID-"+id+"---");
		Film film = FilmDAO.getInstance().getModel().get(id+"");
		//Film film = FilmDAO.getInstance().searchFilm(id);

		// If statement for film equal to null
		if(film==null)
			film=new Film();
		//throw new RuntimeException("Get: film with " + id +  " not found");
		// Return the film
		return film;
	} // Close getFilmHTML method

	// Creating put to Update/Replace film
	@PUT
	// Creating media type for the putFIilm and creating media type for the xml
	@Consumes(MediaType.APPLICATION_XML)
	// Creating putFIilm method for the jax b element and callin ghte film class
	public Response putFIilm(JAXBElement<Film> film) {
		// getting value from the film class
		Film f = film.getValue();
		// Return the put and get responce
		return putAndGetResponse(f);
	} // CLose put film method


	// Creating delete to delete the film
	@DELETE
	// Creating public void deleteFilm method which would delete the film from the database
	public void deleteFilm() {
		// Calling the film class and filmdao to get the instance and getting the model.
		// removing the id from the database to delete the film
		Film f = FilmDAO.getInstance().getModel().remove(id);
		// If statement for f equal to null
		if(f==null)
			throw new RuntimeException("Delete: film with " + id +  " not found");
	} // Close delete film method

	// Creating public response for the put and get
	private Response putAndGetResponse(Film film) {
		// Variable for the response
		Response res;
		// if filmdao.instance get model contains key get the id
		if(FilmDAO.instance.getModel().containsKey(film.getId())) {
			// Creating res variable equal to response.noContent
			res = Response.noContent().build();
		} // Close if statement
		// Otherwise response.created
		else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		} // CLose else
		// Update the film
		FilmDAO.getInstance().getModel().put(film.getId()+"", film);
		// return response
		return res;
	} // Close private putAndGetResponse
}
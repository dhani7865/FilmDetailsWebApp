package com.democo.jersey.film.resources;


import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import com.democo.jersey.film.model.Film;
import com.democo.jersey.film.model.FilmDAO;


// Will map the resource to the URL films
@Path("/films")
// Creating public class FilmsResource
public class FilmsResource {
	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;


	// Return and get the list of films to the user in the browser
	@GET
	// Creating media type for the text_xml
	@Produces(MediaType.TEXT_XML)
	// Calling the getFilmsBrowser method and calling the list of films
	public List<Film> getFilmsBrowser() {
		// Creating new rray list of film
		List<Film> films = new ArrayList<Film>();
		// Adding all the films and calling the filmdao class.
		// Get instance and calling the getModel method 
		films.addAll( FilmDAO.getInstance().getModel().values());
		// Return the films
		return films; 
	} // CLose public getFilmsBrowser method

	// Return the list of films for applications
	@GET
	// Creating media type for the xml and json
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	// Creating public getFilms method
	public List<Film> getFilms() {
		// Creating new array list of films
		List<Film> films = new ArrayList<Film>();
		// Calling the film class and filmdao to get the instance and getting the model for the id
		// add all films
		films.addAll( FilmDAO.getInstance().getModel().values() );
		//		films.addAll( FilmDAO.getAllFilms());
		// Return the films
		return films; 
	} // Close public getFilms method


	// Returns the number of films
	// Use http://localhost:8080/com.democo.jersey.film/rest//count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	// Creating public string for the getCount method
	public String getCount() {
		// Creating integer count equal to filmdao to get the instance and calling the getModel in the filmDao class
		int count = FilmDAO.getInstance().getModel().size();
		// Return the strint value of the count
		return String.valueOf(count);
	} // Close get Count method



	// Posting the film using the form
	/**
	 *  Creating media type for the text_html and media type for the application form
	 *  Creating update form, to update data in the database. 
	 *  Creating form for the delete, which would then delete the film from the databasd,depending on id which has been inputted. 
	 * @param id
	 * @param title
	 * @param year
	 * @param director
	 * @param stars
	 * @param review
	 * @param servletResponse
	 * @throws IOException
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// Creating new film and calling the create film html form
	public void newFilm(
			// Creating form params for the different columns
			@FormParam("id") int id,
			@FormParam("title") String title,
			@FormParam("year") int year,
			@FormParam("director") String director,
			@FormParam("stars") String stars,
			@FormParam("review") String review,
			@Context HttpServletResponse servletResponse
			) throws IOException {
		// Creating new film
		Film film = new Film(id,title,year, director, stars, review);
		// If the title is not equal to null, return the title
		if (title!=null){
			film.setTitle(title);
		} // Close if statement for title not equal to null
		// Calling boolean value as false at the start to insert the data to the database. 
		// When the data has been added to the database the boolean value will then be true.
		boolean isInserted=false;
		// Creating try and catch to add the data to the database and calling the insertFilm method from the filmdao class
		try {
			// If data has been inserted, return true and calling the insertFilm method from the dao class
			isInserted=FilmDAO.getInstance().insertFilm(film);
			System.out.println("Data has been added successfully");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // CLose catch sql exception
		// If statement for the data has been inserted
		if(isInserted)
			FilmDAO.getInstance().getModel().put(id+"", film);
		// Calling the create_film.html for the servletResponse
		servletResponse.sendRedirect("../create_film.html");
	} // Close public void new film


	// Creating form for the put to update the data in the database
	@Path("update")
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// Creating update film, to update the data in the database and calling hte update_film.html form
	public void updateFilm(
			// Creating form params for the different columns
			@FormParam("id") int id,
			@FormParam("title") String title,
			@FormParam("year") int year,
			@FormParam("director") String director,
			@FormParam("stars") String stars,
			@FormParam("review") String review,
			@Context HttpServletResponse servletResponse
			) throws IOException {
		// Creating new film
		Film film = new Film(id,title,year, director, stars, review);
		// If the title is not equal to null, return the title
		if (title!=null){
			film.setTitle(title);
		} // Close if statement for title not equal to null
		// Calling boolean value as false at the start to update the data in the database.
		// When the data has been updated in the database the boolean value will then be true.
		boolean isInserted=false;
		// Creating try and catch to update the data from the database and calling the updatefilm method from the filmdao class
		try {
			// If data has been updated, return true and calling the updateFilm method from the dao class
			isInserted=FilmDAO.getInstance().updateFilm(film);
			System.out.println("Data has been updated successfully");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Close catch sql exception
		// If statement for the data has been updated
		if(isInserted)
			FilmDAO.getInstance().getModel().put(id+"", film);
		// Calling the update_film.html for the servletResponse
		URI uri = uriInfo.getBaseUriBuilder().path("../update_film.html").build();
		//servletResponse.sendRedirect("../update_film.html");
		servletResponse.sendRedirect(uri.toString());
	} // Close public void update film

	// Crating form for the delete
	@POST
	@Path("delete")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// Creating delete film form and calling the html form
	public void deleteFilm(
			// Creating form params for the id
			@FormParam("id") int id,
			@Context HttpServletResponse servletResponse
			) throws IOException {
		// Calling boolean value as false at the start to delete the data from the database, depending on the id which has been inserted. 
		// When the data has been deleted in the database the boolean value will then be true.
		// Creating try and catch to delete the data from the database and calling the deletefilm method from the filmdao class
		boolean isRemoved=false;
		try {
			// If data has been deleted, return true and calling the deleteFilm method from the dao class
			isRemoved=FilmDAO.getInstance().deleteFilm(id);
			System.out.println("Data has been deleted successfully");;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Close sql exception
		if(isRemoved){
			FilmDAO.getInstance().getModel().remove(id+"");
		}
		// Calling the delete_film.html for the servletResponse
		//servletResponse.sendRedirect("../delete_film.html");
		URI uri = uriInfo.getBaseUriBuilder().path("../delete_film.html").build();
		//servletResponse.sendRedirect("../update_film.html");
		servletResponse.sendRedirect(uri.toString());

	} // Close public void delete film

	/**
	 *  Defines that the next path parameter after film is
	 * treated as a parameter and passed to the FilmResources
	 * 	Allows to type http://localhost:8080/com.democo.jersey.film/rest/films/10001
	 * 10001 will be treated as parameter film and passed to FilmResource
	 * @param id
	 * @return
	 */
	@Path("{film}")
	@Produces(MediaType.TEXT_XML)
	public FilmResource getFilm(
			// Creating path param for the film and getting string id
			@PathParam("film") String id) {
		// Setting int id equal to 0
		int intId=0;
		// Creating try and catch for the int id and return new FilmResource 
		try{
			intId=Integer.parseInt(id);
		}catch(Exception e){}
		return new FilmResource(uriInfo, request, intId);
	} // Close public FilmResource for the get film
} // Close public class FilmsResource
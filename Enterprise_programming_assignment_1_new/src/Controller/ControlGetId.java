package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.Film;
import Model.FilmDAO;



/**
 * Servlet implementation class ControlGetId
 * This servlet would get the id of certain film and then display that data in the application.
 * It would also allow you to convert the data to different formats using htttp calls.
 * format=xml, will convert the data to xml format.
 * format=json, would convert the data to json format
 * format=string, would convert the data to string format.
 * The data will also be converted to json format.
 */
@WebServlet("/ControlGetId")
// Creating public class for the controller which extends http servlet
public class ControlGetId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * This controller class will display everything on the browser.
	 */
	// Creating public method for controller
	public ControlGetId() {
		super();
	} // Close controller method

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// Creating protected void doGet to print out the list of films on tbe browser
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		// Creating new film dao and calling the FilmDAO class
		// it asks the dao and then prints out the list of films
		FilmDAO film = new FilmDAO();
		// Getting all films from the array list
		ArrayList<Film> FilmList = FilmDAO.getAllFilms();	
		// Creating form loop for one film and then printing out the film
		for (int i=0; i<FilmList.size(); i++ ) {
			// Get film
			Film oneFilm = FilmList.get(i);
			// Print films out onto the console
			System.out.println(oneFilm.toString());
			System.out.println("All data displayed successfully");
		} // Close for loop
		
		// Creating int for the array of id's and calling the getIDs method
		int[] ids = getIDs(request);
		// Creating array of list of films
		List<Film> films = new ArrayList<Film>();
		// For loop for the int id and calling the filmddao.getFilmOrDefault
		for(int id: ids) {
			films.add(FilmDAO.getFilmOrDefault(id));
		    Film Films = FilmDAO.getFilm(id);
		} // CLose foor loop
		
		

		// Declaring gson object
		Gson gson = new Gson();
		// Creating string for the json bject and then converting it to json format
		String allFilmsJson = gson.toJson(films);
		// Print all films in json format
		System.out.println(allFilmsJson);

		/////////////////////////////////////// SELECTING ONE ID //////////////////////////////
		// Selecting the film id 10013
		Film f = film.getFilmByID(10013);
		System.out.println(f.toString());
		System.out.println(gson.toJson(f));


		// use mvc pattern
		// Setting the attributes for the films
		// put the films in request block
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		request.setAttribute("films", FilmList);
		// Requesting to format the parameters
		String format = request.getParameter("format");
		// Output page
		String outputPage;
		// If statement to format the different films xml, json, string format
		if ("xml".equals(format)) {
			response.setContentType("text/xml");
			outputPage = "results/films-xml.jsp";
		} else if ("json".equals(format)) {
			//			response.setContentType("text/javascript");
			response.setContentType("application/json");
			outputPage = "results/films-json.jsp";
		} else {
			response.setContentType("text/plain");
			outputPage = "results/films-string.jsp";
		} // Close else statement
		// The dispatcher will then output the page which you would like
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(outputPage);
		dispatcher.include(request, response);
	} // CLose protected void doGet method

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} // Close protected void doPost

	// Creating protected int to get the id's
	protected int[] getIDs(HttpServletRequest request) {
		//		int[] ids = { 1, 2};
		//		String[] ids = { "missing", "missing" };
		// Creating array of int id's
		int[] ids = { 1};
		// Creating foor loop for the length of the id's
		for(int  i=0; i<ids.length; i++) {
			//			int id = Integer.parseInt(id);
			//			int id = request.getParameterValues(123 + (i+1));
			// Converting get parameter string to integer using integer.getInteger
			int id = Integer.getInteger(request.getParameter("1234")).intValue();
			// Creating if statement for !isEmpty for id
			if (!isEmpty(id)) { ids[i] = id; }
		} // Close for loop
		// Return the id's
		return(ids);
	} // Close protected int array for getID's

	// Creating private boolean for is empty for the id, when user inputs the id, it will then return the data for that one film id.
	private boolean isEmpty(int id) {
//		return((id == null) || (id.trim().equals(123)));
		return false;
	} // CLose private boolean is empty of the id
} // Close public class conroller

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * Servlet implementation class ControlInsertFilm
 * Inserting new film to the database.
 * Converting the data to json format.
 * the data can then be iewed on the browser in different formats, e.g. xml, json and string. 
 */
@WebServlet("/ControlInsertFilm")
// Creating public class for the ControlInsertFilm which extends http servlet
public class ControlInsertFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * This controller class will display everything on the browser.
	 */
	// Creating public method for controller
	public ControlInsertFilm() {
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



		// creating the, insert and calling the method from the dao class
		// insert film to the datbase
		// Calling the film class and inserting the film to the database. 
		System.out.println("Testing the insert film");
		Film f = new Film(123456, "Wars", 2011, "Peter Jackson","100", "5 ");
		try {
			FilmDAO.insertFilm(f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DEBUG: Film Successfully inserted");


		// Creating variable for gson
		// Creating variable for gson
		// Declaring gson object
		// Json is data format which would express data objects consisting of attribute value pairs. 
		Gson gson = new Gson();
		// Creating string for the json bject and then converting it to json format
		String alFIlmJson = gson.toJson(f);
		// Print all rfid data in json format
		System.out.println(alFIlmJson);
		System.out.println("Film data successfully in json format!"); // printing success message



		// use mvc pattern
		// Setting the attributes for the films
		// put the films in request block
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		request.setAttribute("films", FilmList);
		// Requesting to format the parameters
		String format = request.getParameter("format");
//		String Film = request.getParameter("Lord");
		// Output page
		String outputPage;
		// If statement to format the different films xml format
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



} // Close public class conroller

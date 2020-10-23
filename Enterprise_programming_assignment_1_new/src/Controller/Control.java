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
 * Servlet implementation class Controller
 * This controller is used to test all the methods work in the server.
 * I have called the film dao class, to get all the fiilms outputted onto the rowser.
 * I have called the insertFilm method which which would add data to the database, from the film object.
 * The update method has also been called to update existing data in the method, from the film object.
 * The delete method has also been called to test themethod works and deltes the id from the database, which has been specified in the film object.
 * If the id has been recieved, convert the data to different format, e.g. xml, json, string.
 */
@WebServlet("/Control")
// Creating public class for the controller which extends http servlet
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * This controller class will display everything on the browser.
	 */
	// Creating public method for controller
	public Control() {
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
		//		// Creating form loop for one film and then printing out the film
		//		for (int i=0; i<FilmList.size(); i++ ) {
		//			// Get film
		//			Film oneFilm = FilmList.get(i);
		//			// Print films out onto the console
		//			System.out.println(oneFilm.toString());
		//			System.out.println("All data displayed successfully");
		//		} // Close for loop




		// Declaring gson object
		Gson gson = new Gson();
		// Creating string for the json bject and then converting it to json format
		String allFilmsJson = gson.toJson(FilmList);
		// Print all films in json format
		System.out.println(allFilmsJson);

		//		/////////////////////////////////////// SELECTING ONE ID //////////////////////////////
		//		// Selecting the film id 10013
		//		Film f = film.getFilmByID(10013);
		//		System.out.println(f.toString());
		//		System.out.println(gson.toJson(f));



		// Getting id
		int id=0;
		// Creating array list of films
		List<Film> tmpList=new ArrayList<>();
		// Creating boolean value at the start and setting it to false
		boolean idRecvd=false;
		// Creating try and catch to get the id
		// if id has been recieved show the films
		try{
			// Convert string to int using integer.parseint
			id=Integer.parseInt(request.getParameter("id").toString());
			// When id has been recieved return true
			idRecvd=true;
		}catch(Exception e){}
		// if id has been recieved return the films data
		if(idRecvd) {
			// Print message onto the console saying id has been received
			System.out.println("id received "+id);
			// Creating for loop to show the list of films
			for(int i=0;i<FilmList.size();i++){
				Film tmpFlm=FilmList.get(i);
				//Get the id and print the film
				if(tmpFlm.getId()==id){
					tmpList.add(tmpFlm);
					System.out.println(tmpFlm.toString());
				} // CLose if statement
			} // CLose for loop
			// print the films size message onto the console
			System.out.println("FilmsSize "+tmpList.size());
		} // CLose if statement for id recieved


		// use mvc pattern
		// Setting the attributes for the films
		// put the films in request block
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// If the id has been recieved return the films
		if(idRecvd)
			// Creating request to set the attribute for the films and tmplist
			request.setAttribute("films", tmpList);//TODO changed here FilmList
		// Requesting to format the parameters
		else
			request.setAttribute("films", FilmList);
		String format = request.getParameter("format");
		// Output page
		String outputPage;
		/**
		 *  If statement to format the different films xml format
		 *  If statement to format the different films json format
		 *  If statement to format the different films string format
		 */
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

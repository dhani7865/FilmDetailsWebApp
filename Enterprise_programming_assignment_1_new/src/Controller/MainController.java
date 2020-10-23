package Controller;

import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;

import Model.Film;
import Model.FilmDAO;


/**
 * This class is to test the film dao and to see if all the different sections work.
 *Calling the filmdao class and getting the films from the array list. 
 *Then printing out all the films to the console. 
 *Insert - will insert film to the database.
 *Update - will update film in the database.
 *Delete - will delete the film from the database.
 * @author dhanyaal.
 */



// Creating public class for the main controller
public class MainController {
	// Main method
	public static void main(String[] args) throws SQLException {
		// Creating new film dao and calling the FilmDAO class
		FilmDAO film = new FilmDAO();
		// Getting all films from the array list
		ArrayList<Film> films = film.getAllFilms();		
		// Creating form loop for one film and then printing out the film
		for (int i=0; i<films.size(); i++ ) {
			// Get film
			Film oneFilm = films.get(i);
			// Print films out onto the console
			System.out.println(oneFilm.toString());
			System.out.println("All data displayed successfully");
		} // Close for loop


		//		// Declaring gson object
		//		Gson gson = new Gson();
		//		// Creating string for the json bject and then converting it to json format
		//		String allFilmsJson = gson.toJson(films);
		//		// Print all films in json format
		//		System.out.println(allFilmsJson);


		//		Film f = film.getFilmByID(10013);
		//		System.out.println(f.toString());
		//		System.out.println(gson.toJson(f));



		// creating the CRUD insert, retrieve, update, delete
		// insert film to the datbase
		// Calling the film class and inserting the film to the database. 
		System.out.println("Testing the insert film");
		Film f= new Film(123456, "Wars", 2011, "Peter Jackson","100", "5 star");
		FilmDAO.insertFilm(f);
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

//						System.out.println("Testing the update film");
//						Film f= new Film(1234, "Lord", 2013, "peter","100", "5 star");
//						FilmDAO.updateFilm(f);
//						System.out.println("Film successfully updated");
		//		
		//				// Json is data format which would express data objects consisting of attribute value pairs. 
		//				Gson gson = new Gson();
		//				// Creating string for the json bject and then converting it to json format
		//				String alFIlmJson = gson.toJson(f);
		//				// Print all rfid data in json format
		//				System.out.println(alFIlmJson);
		//				System.out.println("Film data successfully in json format!"); // printing success message
		//				

		//		// Delete films from the database
		//		System.out.println("Testing the delete film");
		//		FilmDAO.deleteFilm(11000);
		//		System.out.println("Film successfully deleted");


	} // Close  main method
} // CLose public class MainController

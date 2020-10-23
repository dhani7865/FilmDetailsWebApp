package com.democo.jersey.film.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


import java.sql.*;

/**
 * The DOM specification gives methods to find elements and attributes with specific names. 
 * Element method getElementsByTagname(String id) yields a Nodelist containing all immediate subelements with the specified tag. 
 * For a given element, getAttribute(String id) returns the value of the attribute whose id is the argument. getAttributeNode(String id) does the same thing, 
 * except it delivers the whole attribute object instead of just the value.
 *  import connection to this class and also creating new class called FilmsDAO
 * creating public array list for films and creating method called
 * getallfilms
 * The CRUD operations are created in this class.
 * Create would create connection to the database.
 *  Retrieve would Retrieve the data from the database.
 *  Update would update the data which the user has inputed and update it in the database. 
 *  Delete would let you delete a film, based on the id.
 *  I have created a array to store all films into a array.
 * @author Dhanyaal 
 */
// public class for film dao
public class FilmDAO {

	public static  FilmDAO instance = null;
	static Film oneFilm = null; // creating object for film equal to null
	static Connection conn = null; // creating object for db connection and setting it to null
	static Statement stmt = null; // Creating object for statement  setting it to null
	private static Map<String, Film> contentProvider = new HashMap<String, Film>();
	private static Map<String,Film> simplefilms;
	private static ArrayList<Film> filmsList;
	// Adding the mysql workbench username and assword, in order to connect to the database
	String user = "rashidd";
	String password = "rooSedef6";
	//  Usiing port 6306 instead of 3306 and connecting to the mudfoot server
	String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

	// Creating public static film dao get instance method, which gets instance
	public static FilmDAO getInstance(){
		// If instance is equal to null, return new instance
		if(instance==null)
			instance=new FilmDAO();
		return instance;
	}

	/**
	 * creating public filmdao method
	 * Getting all the list of films
	 */
	public FilmDAO() {
		// get all the list of films
		filmsList=getAllFilms();
		// For loop to return the list of films
		for(int i=0;i<filmsList.size();i++){
			Film tmp=filmsList.get(i);
			contentProvider.put(tmp.getId()+"", tmp);
			System.out.println("Entered ID ="+tmp.getId()+" GettingtI"+contentProvider.get(""+tmp.getId()));
		}
		//contentProvider=
	} // CLose film dao method

	// Creating search film method and creating try and catch for the string id
	public static Film searchFilm(String strid){
		// Setting the id equal to 0 at the start
		int id=0;
		// Creating try and catch for the string id and then converting the string id to int using parseInt
		try{
			id=Integer.parseInt(strid);
		}catch(Exception e){}
		// this for loop, will then display the list of films
		for(int i=0;i<filmsList.size();i++){
			Film tmp=filmsList.get(i);
			System.out.println("ID ="+tmp.getId()+" Search="+id);
			if(tmp.getId()==id){

				System.out.println("Search Completed ID ="+tmp.getId()+"== Search="+id);
				//film=tmp;
				return tmp;
			}
		}
		return null;
	}
	// Creating public map string for the film and getting the model
	public Map<String, Film> getModel(){
		// Return contentProvider
		return contentProvider;
	} // Close public map


	// Creating hash map for the films and creating new film
	static {
		simplefilms = new LinkedHashMap<String,Film>();
		simplefilms.put("123456", 
				new Film(123456, "Four Lions", 2010, "Chris Morris, Omar, Hassan, Barry, Waj and Faisal", 
						"Chris Morris, Omar, Hassan, Barry, Waj and Faisal",
						"Four Lions is an English movie released on 07 May, 2010. The movie is directed by Christopher Morris and featured Will Adamsdale and Adeel Akhtar as lead characters."));
	} // CLose static

	// Creating hashmap string for the simple films and returning he simple films
	public static Map<String,Film> getSampleFilms() {
		return(simplefilms);
	}

	/**
	 * GetFilm method to get the film
	 * If film is not equal to 0 return the films
	 * @param id
	 * @return
	 */
	public static Film getFilm(int id) {
		if (id == 0) {
			id = 12345;
		} // CLose if statement for id not equal to 0
		return(simplefilms.get(id));
	} // CLose public static film get film method

	/** Given an id, returns either the corresponding film
	 *  object or a new film object with values for the different feilds. 
	 */

	public static Film getFilmOrDefault(int id) {
		//		Film film = getFilmByID(id);
		Film film = getFilm(id);
		if (film == null) {
			Film films = new Film(123456,
					"Four Lions", 
					2010, 
					"Chris Morris, Omar, Hassan, Barry, Waj and Faisal", 
					"Chris Morris, Omar, Hassan, Barry, Waj and Faisal",
					"Four Lions is an English movie released on 07 May, 2010. The movie is directed by Christopher Morris and featured Will Adamsdale and Adeel Akhtar as lead characters.");
		}
		return(film);
	}

	/** Given a id, title, year, director, stars, review would returns either
	 *  the corresponding film object or null. Assumes
	 *  that there are no films with the same
	 *  id, title, year, director, stars and review.
	 */

	public static Film getNamedFilm(int id, String title, int year, String director, String stars, String review) {
		Collection<Film> films = getSampleFilms().values();
		for(Film f: films) {
			//			if(Integer.toString(f.getId()(id)) &&
			//			if(f.getId() == (id) &&
			if(f.getId() == id &&
					(f.getTitle().equalsIgnoreCase(title)) && 
					(f.getYear()==year) &&
					//					Integer.toString(f.getYear()) &&
					(f.getDirector()==(director)) &&
					(f.getStars().equalsIgnoreCase(stars)) &&
					(f.getReview().equalsIgnoreCase(review))) {
				return(f);
			}
		}
		return(null);
	}



	// Creating private void to open the connection
	private static void openConnection(){
		// loading jdbc driver for mysql
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// Connecting to the films database
		try{
			// Connection string for the database, and adding the username and password for the database
			conn = DriverManager.getConnection
					("jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/rashidd?user=rashidd&password=rooSedef6");
			//(url, user, password);
			// Creating connection for the statement
			stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
	} // Close private void open connection
	// Creating private void to close the connection
	private static void closeConnection(){
		// Creating try to close the connection
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Close catch sql exception
	} //CLose private void close connection

	// Creating private film to get the next film in the result
	private static Film getNextFilm(ResultSet rs){
		Film thisFilm = null; // Creating film variable equal to null
		// Creating try to get the result of all the films
		try {
			thisFilm = new Film(
					//  Getting int for the result of the id
					rs.getInt("id"),
					// Getting string for the result of the film title
					rs.getString("title"),
					// Getting int for the result of the film year
					rs.getInt("year"),
					// Getting string for the result of the film director
					rs.getString("director"),
					// Getting string for the result of the film stars
					rs.getString("stars"),
					// Getting string for the result of the film reviews
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // CLose catch sql exception
		return thisFilm; // Return the film
	} // Close private film to get the result of the next film
	/**
	 * Creating the crud methods
	 * Create, retrieve, update and delete
	 * Create: insertFilm(Film)- this inserts a new row into the table book.
	 * Read: getAllFilms() - this retrieves all rows; it would then return all the films from the database.
	 * Update: updateFilm(Film)- this updates an existing row in the database.
	 * Delete: deleteFilm(FIlm) - this removes an existing row in the database based on the FilmID.
	 * @return dhanyaal
	 */
	// Creating public array list to get/list all films from the array
	public static ArrayList<Film> getAllFilms() {
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection(); // open database connection


		// Creating select statement and executing it
		// Selecting everything from the films database
		try {
			// Creating string to create sql statement to select everything from the films table.
			//			String selectSQL = "select * from films LIMIT 10";
			String selectSQL = "select * from films";
			// Execute the query and show the result
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			// Retrieve the results
			while(rs1.next()){
				oneFilm = getNextFilm(rs1);
				allFilms.add(oneFilm);
			} // Close while loop
			stmt.close(); // close sql dtatement
			closeConnection(); // CLose connection
			disconnect(); // Callig the disconnect method
		} catch(SQLException se) { System.out.println(se); }
		// Otherwise, return all the films
		return allFilms;
	} // close public array list for get all films

	// Creating protected static void disconnect method for when the connection has been disconnected
	protected static void disconnect() throws SQLException {
		// If the connection is null, the connection will then be closed
		if (conn != null && !conn.isClosed()) {
			// CLose connection
			conn.close();
		} // CLose if statement for if connection equal to null
	} // CLose protected static void disconnect method

	/**
	 *  insert statement
	 *  input	is	a	Film object	to insert in the database,	
	 *  return value is	an integer representing	how	many were inserted successfully	(1	or	0), depnding if the row exists. 
	 *  Creating public static boolean for insert film, which creates database
	 *  Connection and creates sql query, which lets the user insert film to the database. 
	 *  I have also created parameter Film films for insertFilms.
	 *  Creating public boolean for insert film to insert films to the database
	 * @param film
	 * @return
	 * @throws SQLException
	 */
	public static boolean insertFilm(Film film) throws SQLException {
		openConnection(); // open database connection
		Statement statement = null; // statement object = null
		ResultSet resultset = null; // resultset object = null
		// Creating try to open the connection
		boolean allGood=false;
		try {
			// Creating the INSERT statement from the parameters
			// set time inserted to be the current time on database server
			String selectSQL = "INSERT INTO films (id,title,year,director,stars,review) "
					+ "VALUES ('" + film.getId() + "', '" + film.getTitle() + "', '" + film.getYear() + "', '"
					+ film.getDirector() + "', '" + film.getStars() + "', '" + film.getReview() + "')";
			// Print message out onto the console
			System.out.println("DEBUG: Insert: " + selectSQL);
			//			int rs = stmt.executeUpdate(selectSQL);
			stmt.executeUpdate(selectSQL);
			System.out.println("DEBUG: Insert successful ");
			allGood=true;
		} catch (SQLException se) {
			// Problem with update, return failure message
			System.out.println(se);
		} // CLose catch

		// all ok,  return
		return allGood;
	} // Close static void insrtfilm table

	/**
	 *  Update statement
	 * 	Creating public static boolean for update film, which creates database
	 * 	Connection and creates sql query, which lets the user update the data from the database. 
	 * 	I have also created parameter student stu for UpdateStu
	 * 	Creating public array list to update films from the array
	 * @param film
	 * @return
	 * @throws SQLException
	 */
	public static boolean updateFilm(Film film) throws SQLException {
		openConnection(); // open database connection
		Statement statement = null; // statement object = null
		ResultSet resultset = null; // resultset object = null
		// Creating try to open the connection
		boolean ok=false;
		try {
			// Creating the INSERT statement from the parameters
			// set time inserted to be the current time on database server
			String selectSQL =  "UPDATE films SET  title = '"+film.getTitle()+"', Year = '"+film.getYear()+"', Director = '"+film.getDirector()+"', "
					+ "Stars ='"+film.getStars()+"',  Review = '"+film.getReview()+"' WHERE id = " + film.getId();

			// Print message out onto the console
			System.out.println("DEBUG: Update: " + selectSQL);
			int rs = stmt.executeUpdate(selectSQL);
			System.out.println("DEBUG: Update successful ");
			ok=true;
		} catch (SQLException se) {
			// Problem with update, return failure message
			System.out.println(se);
			System.out.println("\nDEBUG: Update error - see error trace above for help. ");
		} // CLose catch
		// all ok,  return
		return ok;
	} // Close static void UpdateFilm table

	/**
	 *  Creating public  for delete films, which creates database
	 * connection and creates sql query, which lets the user delete any data from
	 *  the database, which they wouldn't like
	 *  also creating DeleteFilm with parameter int ID
	 * Delete statement
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static boolean deleteFilm(int id) throws SQLException {
		openConnection(); // open database connection
		Statement statement = null; // statement object = null
		ResultSet resultset = null; // resultset object = null
		// Creating try to open the connection
		boolean ok=false;
		try {
			// Creating the INSERT statement from the parameters
			// set time inserted to be the current time on database server
			String selectSQL = "DELETE FROM films where Id =" + id;

			// Print message out onto the console
			System.out.println("DEBUG: Delete: " + selectSQL);
			int rs = stmt.executeUpdate(selectSQL);
			System.out.println("DEBUG: Delete successful ");
			ok=true;
		} catch (SQLException se) {
			// Problem with update, return failure message
			System.out.println(se);
			System.out.println("\nDEBUG: Delete error - see error trace above for help. ");
		} // CLose catch
		// all ok,  return
		return ok;
	} // Close static void UpdateFilm table

	// Get the film by ID
	public static Film getFilmByID(int id){
		// Open the connection
		openConnection();
		oneFilm = null; // Creating object for one film equal to null
		// Creating select statement and executing it
		try {
			// Creating string for the sql statement and selecting everything from the films table where the ID equal to ID.
			String selectSQL = "select * from films where id="+id;
			// Executing the query and showing the result
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			// Retrieve the results, to get the next film
			while(rs1.next()){
				oneFilm = getNextFilm(rs1);
			} // Close while loop

			stmt.close(); // Close statement
			closeConnection(); // Close the connection
		} catch(SQLException se) { System.out.println(se); 
		} // Close sql exception
		// Otherwise, return the film details for one film
		return oneFilm;
	} // CLose public film for get film by ID

	// getFilm(String filmTitle etc), would return	an array list of Films with	matching name (or substring).	
	public static Film getFilms(String filmTitle, String filmYear, String filmDirector, String filmStars,
			String filmReview) {
		// TODO Auto-generated method stub
		return null;
	}
	public static ArrayList<Film> getFilmsMatching(String search) {
		// TODO Auto-generated method stub
		return null;
	}
} // Close public class film dao
package com.daehosting.webservices.film;
import javax.xml.bind.annotation.XmlRootElement;

// Creating xml root element
@XmlRootElement

/**
 *  Creating public class for film
 *  Creating variables for the different fields
 *  Setters and getters for the different fields.
 *  Java is something when we want an object to represent a string.
 * @author Dhanyaal
 */
// Creating public class film
public class Film {
	public Film() {
		super();
		this.id = 0;
		this.title = "";
		this.year = 0;
		this.director = "";
		this.stars = "";
		this.review = "";
	}
	/**
	 *  Creating public constructor for the different fields.
	 *  Super is used inside a sub-class method definition to call a method defined in the super class.
	 *   Private methods of the super-class cannot be called. 
	 *  Only public and protected methods can be called by the super keyword. 
	 *  Creating int for the id and year
	 *  String has been created for title, director, stars and review
	 * @param id
	 * @param title
	 * @param year
	 * @param director
	 * @param stars
	 * @param review
	 */
	public Film(int id, String title, int year, String director, String stars,String review) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.stars = stars;
		this.review = review;
	}
	// Setting the variables for id, title, year, stars and review
	int id;
	String title;
	int year;
	String director;
	String stars;
	String review;

	// Creating public int for the get id and returning the id
	// Setter and getter for id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	// Setter and getter for title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	// Setter and getter for year
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	// Setter and getter for director
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

	// Setter and getter for stars
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}

	// Setter and getter for review
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * The toString() method returns the string representation of the object. 
	 * If you print any object, java compiler would internally invoke the toString() method on the object. 
	 * Overriding the toString() method, would return the desired output. 
	 *  it shows the state of an object. 
	 *  Adding # for every new column and value
	 */
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", year=" + year
				+ ", director=" + director + ", stars=" + stars + ", review="
				+ review + "]";
	}   

	public String toStringNew() {
		return id + "#" + title + "#" + year
				+ "#" + director + "#" + stars + "#"
				+ review;
	}  

}

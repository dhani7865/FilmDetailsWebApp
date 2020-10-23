package com.democo.jersey.film.model;

import java.util.ArrayList;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

// Creating rot element for the film list and xml Accessor type
@XmlRootElement(name = "FilmList")
@XmlAccessorType (XmlAccessType.FIELD)


/**
 * This class would return the list of films
 * Creating array of films and then return the films
 * Xml element name is films
 * @author dh11a
 *
 */
// Creating public class FilmList
public class FilmList {
	// xml eleemnt name for film
    @XmlElement(name="film")
    // Creating private array list of films
    private List<Film> films;
    
    // Creating public film list and calling the array list of films
    public FilmList(List<Film> inFilms) {
    	// Creating variable for films equal to in films
        films=inFilms;
    } // Close film list method
    
    // Creating array list off films and creating getFilmList methid, which would then return the films
    public List<Film> getFilmList() {
    	// Return the films
        return films;
    } // CLose get film list method

    // Creating public void setFilms to set the list of films
    public void setFilms(List<Film> films) {
        this.films = films;
    } // CLose set films method
    
    // Creating empty method for the film list
    public FilmList() {}
} // Close public class film list
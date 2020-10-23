
<%@ page import="java.util.List"%>
<%@ page import="javax.xml.bind.JAXBContext"%>
<%@ page import="javax.xml.bind.JAXBException"%>
<%@ page import="javax.xml.bind.Marshaller"%>
<%@ page import="Model.Film"%>
<%@ page import="Model.FilmList"%>
<%@ page contentType="text/plain"%>


<%@ page trimDirectiveWhitespaces="true"%>

<%
	//ctrl u, to view in chrome
	// Getting the list of films and calling the FIlm class. Also,  getting the attribute for the films.
	List<Film> films = (List<Film>) request.getAttribute("films");
	// Creating form loop for one film and then printing out the film
	for (int i = 0; i < films.size(); i++) {
		// Get film
		Film oneFilm = films.get(i);
		// Print films out onto the console
		out.println(oneFilm.toStringNew());
		
	} // Close for loop
	response.setContentType("text/plain");
%>
<%@ page import="java.util.List"%>
<%@ page import="javax.xml.bind.JAXBContext"%>
<%@ page import="javax.xml.bind.JAXBException"%>
<%@ page import="javax.xml.bind.Marshaller"%>
<%@ page import="Model.Film"%>
<%@ page import="Model.FilmList"%>


<%@ page trimDirectiveWhitespaces="true"%>

<%
//ctrl u, to view in chrome
// Getting the list of films and calling the FIlm class. Also,  getting the attribute for the films.
List<Film> films = (List<Film>) request.getAttribute("films");

try{
	// Creating context for jxb and marshaller.
	JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    FilmList filmlist = new FilmList(films);
    // output pretty printed jaxmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.marshal(filmlist, out); // out is the stream back to browser
	}
catch (JAXBException e) {e.printStackTrace();
}
%>
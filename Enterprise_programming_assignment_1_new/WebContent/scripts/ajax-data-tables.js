//Creating function to get the films table
function getFilmsTable(rows) {
	// Creating the different headings for the table
	var headings = 
		[ "id", "title", "year", "director", "stars", "review" ];
	// Return the table with the headings and rows
	return(getTable(headings, rows));
} // CLose function get films table

//////////////////////////////////XML Format /////////////////////////////////
//Creating function for xmlFilmsTableresult
function xmlFilmsTableresult(resultRegion, field1, field2) {
	// Creating address for show films
	var address = "show-films";
	// Creating var data for make param string
	var data = makeParamString(field1, field2, "xml");
	// Creating ajax post for the address data and function request
	// The function request will then showXmlFilmsInfo
	ajaxPost(address, data, 
			function(request) {
		showXmlFilmsInfo(request, resultRegion); 
	}); // Close ajax post and function request
} // Close function xmlFilmsTableresult



//Creating docuemnt.ready function for the films in xml format
//Calling btnXmlFilmsTable and creating jquery
$(document).ready(function() {
	$("#btnXmlFilmsTable").click(function() {
		// Creating var id value and calling the xmlFilmsTable
		var idValue=$("#xmlFilmsTable").val();
		// Show alert pop up box if id has been recieved
//		alert("Id" +idValue);
//		console.log("id" +idValue);
		// Id address for the data in xml format
		var address = "http://localhost:8080/Enterprise_programming_assignment_1_new/Control?format=xml&id="+idValue;


		// Client = 123
		// Crating var data and setting it to empty string
		var data = "";
		// Crating ajax and calling the url, and calling the showXmlFilmsInfo function
		$.ajax({
			url: address,
			success:  function(data) {
				showXmlFilmsInfo(data);
			} // Close function data
		}); // close ajax
	}); // Close .click function for the jquery
}); // Close document.ready function for the jquery


//Creating function for the showXmlFilmsInfo
function showXmlFilmsInfo(request) {
	// Creating if statement for request not equal to null
	if (request!=null) {
		// Creating var for xmlDocument equal to request 
		var xmlDocument = request;
		// Getting the eleement by tag name (film)
		var films = xmlDocument.getElementsByTagName("film");
		// Creating var for rows and new array
		var rows = new Array();
		// Creating for loop for the films length
		for(var i=0; i<films.length; i++) {
			var film = films[i];
			// Creating var for the sub elements
			var subElements = [ "id", "title", "year", "director", "stars", "review" ];
			// Get element values
			rows[i] = getElementValues(film, subElements);
		} // Close for loop
		// Creating var table and getting the films table
		var table = getFilmsTable(rows);
		// Calling the xml films table
		$("#xml-films-table").html(table);
	} // Close if statement for request not equal to null
} // Close function showXmlFilmsInfo

////////////////////////////////////////json format /////////////////////////////////////////////
//Creating function for jsonFilmsTableresult
function jsonFilmsTableresult(resultRegion, field1, field2) {
	// Creating address for show films
	var address = "show-films";
	// Creating var data for make param string
	var data = makeParamString(field1, field2, "json");
	// Creating ajax post for the address data and function request
	// The function request will then showJsonFilmsInfo
	ajaxPost(address, data, 
			function(request) {
		showJsonFilmsInfo(request, resultRegion); 
	}); // Close ajax post and function request
} // Close function jsonFilmsTableresult



//Creating docuemnt.ready function for the films in json format
//Calling btnJsonFilmsTable and creating jquery
$(document).ready(function() {
	$("#btnJsonFilmsTable").click(function() {
		var idValue=$("#jsonFilmsTable").val();
		
//		alert("Id" +idValue);
//		console.log("id" +idValue);
		
		// Creating url to convert the film to json format
		var address = "http://localhost:8080/Enterprise_programming_assignment_1_new/Control?format=json&id="+idValue;
		

		// Crating var data and setting it to empty string
		var data = "";
		// Crating ajax and calling the url, and calling the showJsonFilmsInfo function
		$.ajax({
			url: address,
			success:  function(data) {
				showJsonFilmsInfo(data);
			} // Close function data
		}); // close ajax
	}); // Close .click function for the jquery
}); // Close document.ready function for the jquery


//Creating function for the showJsonFilmsInfo
function showJsonFilmsInfo(request) {
	// Creating if statement for request not equal to null
	if (request!=null) {
//		console.log(request);
//		alert(request);
		var rawData = request;
		console.log(rawData);
		
		// Creating var for rows and new array
		var rows = new Array();
		//var films = "";

		// Creating for loop for the films length
		for(var i=0; i<rawData.length; i++) {
			var Film = rawData[i];
			//console.log(Film);
			rows[i] = [Film.id, Film.title,
				Film.year, Film.director, Film.stars, Film.review];
		} // Close for loop
		// Creating var table and getting the films table
		var table = getFilmsTable(rows);
		// Calling the json films table
		$("#json-films-table").html(table);
	} // Close if statement for request not equal to null
} // Close function showXmlFilmsInfo



///////////////////////////////////////// String format //////////////////////////
//Creating function for stringFilmsTableresult
function stringFilmsTableresult(resultRegion, field1, field2) {
	// Creating address for show films
	var address = "show-films";
	// Creating var data for make param string
	var data = makeParamString(field1, field2, "string");
	// Creating ajax post for the address data and function request
	// The function request will then showStringFilmsInfo
	ajaxPost(address, data, 
			function(request) {
		showStringFilmsInfo(request, resultRegion); 
	}); // Close ajax post and function request
} // Close function stringFilmsTableresult



//Creating docuemnt.ready function for the films in string format
//Calling btnStringFilmsTable and creating jquery
$(document).ready(function() {
	$("#btnStringFilmsTable").click(function() {
		// Creating variable for the id value equal to jquery value and calling the stringFilmsTable
		var idValue=$("#stringFilmsTable").val();
		// if value id has been shown reutrn alert box letting the user know a id value has been sent
//		alert("Id" +idValue);
		// Print the value
//		console.log("id" +idValue);
		
		// Creating url to convert the film to json format
		var address = "http://localhost:8080/Enterprise_programming_assignment_1_new/Control?format=string&id="+idValue;
		
		
		// Crating var data and setting it to empty string
		var data = "";
		// Crating ajax and calling the url, and calling the showStringFilmsInfo function, which would then display the data
		$.ajax({
			url: address,
			success:  function(data) {
				showStringFilmsInfo(data);
			} // Close function data
		}); // close ajax
	}); // Close .click function for the jquery
}); // Close document.ready function for the jquery


//Creating function for the showStringFilmsInfo
function showStringFilmsInfo(request) {
	// If the request ready state is 4 and request status is 200 return the data
	//if ((request.readyState == 4) && (rsequest.status == 200)) {
	// Variable for var raw data equal to responsetext
	var rawData = request;
	// Creating variable for film equal to raw data and splitting the data on new line each time
	var film = rawData.split("\n");
	// Console.log rawdata
	console.log(rawData);
	// Creating variable for rows and creating new array list
	var rows = new Array();
	// Creating for loop to iterate over the films and display the films data
	for(var i=0; i<film.length; i++) {
		if (film[i].length > 1) {  // Ignore blank lines
			rows.push(film[i].split("#"));
		} // Close if statement
	} // Close for loop
	
	// Creating var table and getting the films table
	var table = getFilmsTable(rows);
	// Calling the string films table
	$("#string-films-table").html(table);
	//} // Close if statement for request not equal to null
} // CLose foor loop show string


////////////////////////////////////////////Creating the table with the different colmns //////////////////
[ "id", "title", "year", "director", "stars", "review" ];

function filmsTable(filmTypeField, formatField, resultRegion) {
	var address = "show-films";
	var filmid = getValue(filmTypeField);
	var filmtitle = getValue(filmTypeField);
	var filmyear = getValue(filmTypeField);
	var filmdirector = getValue(filmTypeField);
	var filmstars = getValue(filmTypeField);
	var filmreview = getValue(filmTypeField);
	var format = getValue(formatField);
	var data = "filmid=" + filmid +
	"filmtitle=" + filmtitle +
	"filmyear=" + filmyear +
	"filmdirector=" + filmdirector +
	"filmstars=" + filmstars +
	"filmreview=" + filmreview +
	"&format=" + format;
	var responseHandler = findHandler(format);
	ajaxPost(address, data, 
			function(request) { 
		responseHandler(request, resultRegion); 
	});
}


//Reminder: unlike in Java, in JavaScript it is OK to 
//use == to compare strings.

function findHandler(format) {
	// If format xml, show data in xml format.
	// If format json, show data in json format.
	// If format string, show data in string format.
	if (format == "xml") {
		return(showXmlFilmsInfo);
	} else if (format == "json") {
		return(showJsonFilmsInfo);
	} else {
		return(showStringFilmsInfo);
	} // Close else
} // CLose find handler function
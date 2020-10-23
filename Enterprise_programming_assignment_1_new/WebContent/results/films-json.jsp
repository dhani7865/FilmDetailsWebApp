<%@ page import="java.util.List" %>
<%@ page import ="com.google.gson.Gson" %>
<%@ page import="Model.Film"%>

<%@ page trimDirectiveWhitespaces="true"  %>

<%
List<Film> films = (List<Film>) request.getAttribute("films");
Gson gson = new Gson();
String jsonInString = gson.toJson(films);
response.setContentType("application/json");
response.getWriter().println(jsonInString);

%>


<%@page import="domain.model.Speler"%>
<%@page import="domain.db.Spelersdb"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Hoofdpagina </title>
    <link rel="stylesheet" type="text/css" href="styleVoetbelApp.css">
</head>

<body>
    <h1>Deze spelers zijn momenteel toegevoegd</h1>
    <table>
        <tr>
    <th>naam</th>
    <th>voornaam</th>
    <th>ploeg</th>
    <th>aantal wedstrijden</th>
    <th>doelpunten</th>
    <th>verwijder</th>
    <th>update</th>
            
  </tr>
<% ArrayList<Speler> spelers = (ArrayList<Speler>) request.getAttribute("alleSpelers");
for (Speler s:spelers)  {%>
	<tr>
   	 	<td><%=s.getNaam()%></td>
    	<td><%=s.getVoornaam() %></td>
    	<td><%=s.getPloeg() %></td>
    	<td><%=s.getAantalWedstrijden() %></td>
    	<td><%=s.getAantalDoelpunten() %></td>
    	<td><a href="SpelerServlet?actie=verwijderConfirm&naam=<%= s.getNaam() %>&voornaam=<%=s.getVoornaam()%>">Verwijder</a></td>
    	<td><a href="SpelerServlet?actie=updateForm&naam=<%= s.getNaam() %>&voornaam=<%=s.getVoornaam()%>">pas aan</a></td>
   
  </tr>
 <%}  %>
 
    </table><br><br>
    <a href="SpelerServlet?actie=formulier">voeg speler toe</a><br><br>
    <a href="SpelerServlet?actie=welkomspagina">terug naar welkomspagina</a>
</body>
</html>
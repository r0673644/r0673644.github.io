<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "domain.model.Speler" %>
<!DOCTYPE html lang="nl">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>speler verwijderen?</title>
 <link rel="stylesheet" type="text/css" href="styleVoetbelApp.css">
</head>
<body>
<%Speler s = (Speler)request.getAttribute("speler"); %>
<h1><strong>Bent u zeker dat u <%=s.getNaam() %> <%=s.getVoornaam() %> wilt verwijderen?</strong></h1>
	<p><%=s.getNaam() %> <%=s.getVoornaam() %> speelt bij <%=s.getPloeg() %>, heeft
	<%=s.getAantalWedstrijden() %> wedstrijden gespeeld en hierin <%=s.getAantalDoelpunten() %> keer gescoord.</p>
	
    <a href="SpelerServlet?actie=verwijder&naam=<%= s.getNaam() %>&voornaam=<%=s.getVoornaam()%>">Verwijder</a>
	
</body>
</html>
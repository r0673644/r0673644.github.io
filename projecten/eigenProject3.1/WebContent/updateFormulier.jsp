<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "domain.model.Speler" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> speler aanpassen</title>
	<link rel="stylesheet" type="text/css" href="styleVoetbelApp.css">
</head>
<%Speler s = (Speler)request.getAttribute("speler"); %>
<%int nr=s.getAantalDoelpunten(); %>
<%int wedstr = s.getAantalWedstrijden(); %>
<body>
	<h1><strong>speler <%=s.getNaam()%> <%=s.getVoornaam() %> aanpassen</strong></h1>
		
		<form action="SpelerServlet?actie=update" method="post">
		<%String naam = s.getNaam(); 
		String voornaam = s.getVoornaam(); %>
            <label for="naam">naam</label><br>
            <input type="hidden" id="naam" name="naam" value="<%=naam %>">
            <%=s.getNaam() %><br><br>
            <label for="voornaam">voornaam</label><br>
            <input type="hidden" id="voornaam" name="voornaam" value="<%=voornaam %>">
            <%=s.getVoornaam() %><br><br>
            <label for="ploeg">Ploeg</label><br>
            <input type="text" id="ploeg" name="ploeg" value="<%=s.getPloeg() %>"><br><br>
            <label for="wedstrijden">Aantal Wedstrijden</label><br>
            <input type="number" id="wedstrijden" name="wedstrijden" value="<%=wedstr%>"><br><br>
            <label for="doelpunten">Aantal Doelpunten</label><br>
            <input type="number" id="doelpunten" name="doelpunten" value="<%=nr%>"><br><br>  
          <input type="submit" id="pas aan" value="pas aan!">
    </form>

</body>
</html>
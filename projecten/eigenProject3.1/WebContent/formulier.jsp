<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html lang="nl">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Speler Toevoegen</title>
<link rel="stylesheet" type="text/css" href="styleVoetbelApp.css">
</head>
<body>
  <h1>Voeg hier een speler toe</h1>
   <form action="SpelerServlet?actie=nieuw" method="post">
            <label for="naam">Naam</label><br>
            <input type="text" id="naam" name="naam"/><br><br>
            <label for="voornaam">Voornaam</label><br>
            <input type="text" id="voornaam" name="voornaam"/><br><br>
            <label for="ploeg">Ploeg</label><br>
            <input type="text" id="ploeg" name="ploeg"/><br><br>
            <label for="wedstrijden">Aantal Wedstrijden</label><br>
            <input type="number" id="wedstrijden" name="wedstrijden"/><br><br>
            <label for="doelpunten">Aantal Doelpunten</label><br>
            <input type="number" id="doelpunten" name="doelpunten"/><br><br>  
          <input type="submit" id="bewaar" value="Klaar!">
    </form>
</body>
</html>
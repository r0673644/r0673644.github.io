<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>speler toevoegen?</title>
<link rel="stylesheet" type="text/css" href="styleVoetbelApp.css">
</head>
<body>
<h1><strong>Bent u zeker dat u deze speler wilt toevoegen?</strong></h1>
	<p>naam:<%=request.getAttribute("naam") %></p>
	<p>voornaam:<%=request.getAttribute("voornaam") %></p>
	<p>ploeg:<%=request.getAttribute("ploeg") %></p>
	<p>aantal wedstrijden:<%=request.getAttribute("wedstrijden") %></p>
	<p>aantal doelpunten:<%=request.getAttribute("doelpunten") %></p>
	<p><input type="submit" value="toevoegen">	<input type="submit" value="annuleren"><p>
	


</body>
</html>
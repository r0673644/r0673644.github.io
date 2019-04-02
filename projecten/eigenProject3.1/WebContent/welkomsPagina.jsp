<%@page import="domain.db.Spelersdb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Welkomspagina</title>
    <link rel="stylesheet" type="text/css" href="styleVoetbelApp.css">
</head>
<body>
<%! Spelersdb db = new Spelersdb(); %>
  <h1> welkom!</h1>
   <h2 id=topschutter>De huidige topschutter is <%= request.getAttribute("topschutter") %> met <%= request.getAttribute("topschutterDoelpunt") %> doelpunten.</h2>
   <a href="SpelerServlet?actie=hoofdpagina">bekijk volledige lijst</a>
</body>
</html>
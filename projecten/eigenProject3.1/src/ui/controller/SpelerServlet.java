package ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Request;

import domain.db.Spelersdb;
import domain.model.Speler;

@WebServlet("/SpelerServlet")
public class SpelerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Spelersdb databank = new Spelersdb();
       
    public SpelerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verwerkRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verwerkRequest(request, response);
	}
	
	protected void verwerkRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String doel;
		String actie = request.getParameter("actie");
		if (actie == null) actie = "";
		switch(actie) {
		case "hoofdpagina":
			doel = toonSpelers(request, response);
			break;
		case "formulier":
			doel = "formulier.jsp";
			break;
		case "verwijder":
			doel = verwijder(request, response);
			break;
		case "verwijderConfirm":
			doel = verwijderSpeler(request,response);
			break;
		case "nieuw":
			doel = maakSpeler(request, response);
			break;
		case "updateForm":
			doel = updateSpeler(request, response);
			break;
		case "update":
			doel = update(request, response);
			break;
		default:
			request.setAttribute("topschutter", databank.getTopschutter());
			request.setAttribute("topschutterDoelpunt", databank.getHoogsteAantalDoelpunten());
			doel = "welkomsPagina.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(doel);
		rd.forward(request, response);
	}
	



	private String update(HttpServletRequest request, HttpServletResponse response) {
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String ploeg = request.getParameter("ploeg");
		int doelpunt=Integer.parseInt(request.getParameter("doelpunten"));
		int wedstrijd=Integer.parseInt(request.getParameter("wedstrijden"));
		Speler s = databank.zoekSpeler(naam.trim(), voornaam.trim());
		s.updateSpeler(ploeg, wedstrijd, doelpunt);
		return toonSpelers(request, response);
	}

	private String toonSpelers(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("alleSpelers", databank.getSpelers());
		return "hoofdpagina.jsp";
	}
	private String verwijderSpeler(HttpServletRequest request, HttpServletResponse response) {
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		request.setAttribute("speler", databank.zoekSpeler(naam, voornaam));
		
		return "verwijderConfirm.jsp";
	}
	private String verwijder(HttpServletRequest request, HttpServletResponse response) {
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		databank.verwijder(databank.zoekSpeler(naam, voornaam));
		return toonSpelers(request, response);
	}
	private String updateSpeler(HttpServletRequest request, HttpServletResponse response) {
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		request.setAttribute("speler", databank.zoekSpeler(naam, voornaam));
		
		return "updateFormulier.jsp";
	}
	private String maakSpeler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Speler speler = new Speler();
		List<String> fouten = new ArrayList<String>();
		verwerkNaam(speler, request, fouten);
		verwerkVoornaam(speler, request, fouten);
		verwerkPloeg(speler, request, fouten);
		verwerkWedstrijden(speler, request, fouten);
		verwerkDoelpunten(speler, request, fouten);
		if (fouten.isEmpty()) {
			databank.voegSpelerToe(speler);
			return toonSpelers(request, response);
		} else {
			request.setAttribute("fouten", fouten);
			return "formulier.jsp";
		}
	}
	


	private void verwerkNaam(Speler s, HttpServletRequest request, List<String> fouten) {
		String naam = request.getParameter("naam");
		try {
			s.setNaam(naam);
			request.setAttribute("ingevuldeNaam", naam);
		} catch (Exception e) {
			fouten.add(e.getMessage());
		}
	}
	private void verwerkVoornaam(Speler s, HttpServletRequest request, List<String> fouten) {
		String voornaam = request.getParameter("voornaam");
		try {
			s.setVoornaam(voornaam);
			request.setAttribute("ingevuldeVoornaam", voornaam);
		} catch (Exception e) {
			fouten.add(e.getMessage());
		}
	}
	private void verwerkPloeg(Speler s, HttpServletRequest request, List<String> fouten) {
		String ploeg = request.getParameter("ploeg");
		try {
			s.setPloeg(ploeg);
			request.setAttribute("ingevuldePloeg", ploeg);
		} catch (Exception e) {
			fouten.add(e.getMessage());
		}
	}
	private void verwerkWedstrijden(Speler s, HttpServletRequest request, List<String> fouten) {
		String wedstrijdenstr = request.getParameter("wedstrijden");
		try {
			int wedstrijdenint = Integer.parseInt(wedstrijdenstr);
			s.setWedstrijd(wedstrijdenint);
			request.setAttribute("ingevuldeWedstrijd", wedstrijdenint);
		} catch (Exception e) {
			fouten.add(e.getMessage());
		}
	}
	private void verwerkDoelpunten(Speler s, HttpServletRequest request, List<String> fouten) {
		String doelpuntenstr = request.getParameter("doelpunten");
		try {
			int doelpuntenint = Integer.parseInt(doelpuntenstr);
			s.setDoelpunt(doelpuntenint);
			request.setAttribute("ingevuldeWedstrijd", doelpuntenint);
		} catch (Exception e) {
			fouten.add(e.getMessage());
		}
	}

}

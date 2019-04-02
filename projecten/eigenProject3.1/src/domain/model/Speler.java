package domain.model;

public class Speler {
	private String naam;
	private String voornaam;
	private String ploeg;
	private int aantalWedstrijden;
	private int aantalDoelpunten;
	
	public Speler(String naam, String voornaam, String ploeg, int wedstrijden, int doelpunten) {
		/*this.naam=naam;
		this.voornaam=voornaam;
		this.ploeg=ploeg;
		this.aantalWedstrijden=wedstrijden;
		this.aantalDoelpunten=doelpunten;
		*/setNaam(naam);
		setVoornaam(voornaam);
		setPloeg(ploeg);
		setWedstrijd(wedstrijden);
		setDoelpunt(doelpunten);
	}
	public Speler(String naam, String voornaam, String ploeg) {
		this(naam,voornaam,ploeg,0,0);
	}
	public Speler(String naam, String voornaam) {
		this(naam, voornaam, "onbekend",0,0);
	}
	public Speler() {
	}
	public void updateSpeler(String ploeg,int wedstrijden,int doelpunten){
		setPloeg(ploeg);
		setWedstrijd(wedstrijden);
		setDoelpunt(doelpunten);
	}
	public void setNaam(String naam) {
		if (naam!=null&&!naam.trim().isEmpty()) {
			this.naam=naam;
		}
		else {
			
			throw new IllegalArgumentException("Naam mag niet leeg zijn.");
		}
		
	}
	
	public void setVoornaam(String voornaam) {
		if (voornaam!=null&&!voornaam.trim().isEmpty()) {
			this.voornaam=voornaam;
		}else {
			
		throw new IllegalArgumentException("Voornaam mag niet leeg zijn.");
		}
		
	}
	public void setPloeg(String ploeg) {
		if (ploeg!=null&&!ploeg.trim().isEmpty()) {
			this.ploeg=ploeg;
		}else {
			
			this.ploeg = "onbekend";
		}
	}
		
	public void setWedstrijd(int wedstrijden) {
		if(wedstrijden>=0) {
			this.aantalWedstrijden=wedstrijden;
		}else {
		throw new IllegalArgumentException("Aantal wedstrijden kan niet onder 0 zijn.");
		}
	}
	public void setDoelpunt(int doelpunten) {
		if(doelpunten>=0) {
			this.aantalDoelpunten=doelpunten;
		}else {
			throw new IllegalArgumentException("Aantal doelpunten kan niet onder 0 zijn.");
		}		
	}
	public String getNaam() {
		return naam;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public String getPloeg() {
		return ploeg;
	}
	public int getAantalWedstrijden() {
		return aantalWedstrijden;
	}
	public int getAantalDoelpunten() {
		return aantalDoelpunten;
	}
	

}

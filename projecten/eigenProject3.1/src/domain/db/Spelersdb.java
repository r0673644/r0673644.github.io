package domain.db;

	import java.util.ArrayList;

	import domain.model.Speler;

	public class Spelersdb {
		
		private ArrayList<Speler> spelers = new ArrayList<>();
		
	public Spelersdb() {
		Speler Brend = new Speler ("Reniers","Brend","Aplia Tildonk - A",10,7);
		Speler Klaas = new Speler ("Festraets","Klaas","KVC Haacht - u21",12,5);
		Speler Niels = new Speler ("Van Den Eynde","Niels","KVC Haacht - B",8,2);
		Speler Jens = new Speler ("Kuklis","Jens","KVC Haacht - res",9,1);
		Speler Jochem = new Speler ("Hermans","Jochem","Alpia Tildonk - A",13,0);
			voegSpelerToe(Brend);
			voegSpelerToe(Klaas);
			voegSpelerToe(Niels);
			voegSpelerToe(Jens);
			voegSpelerToe(Jochem);
			
		}
	public void voegSpelerToe(Speler speler) {
			spelers.add(speler);
		}
	 public String getTopschutter(){
		 int topschutterAantal = spelers.get(0).getAantalDoelpunten();
		 String topschutter=spelers.get(0).getNaam() + " " + spelers.get(0).getVoornaam();
		 for (Speler S : spelers) {
				if (S.getAantalDoelpunten()>topschutterAantal) {
				 topschutterAantal = S.getAantalDoelpunten();
				 topschutter=S.getNaam() + " " + S.getVoornaam();
				}
		 }
		return topschutter;
	 }
	 public int getHoogsteAantalDoelpunten(){
		 int topschutterAantal = spelers.get(0).getAantalDoelpunten();
		 for (Speler S : spelers) {
			 if (S.getAantalDoelpunten()>topschutterAantal)
				 topschutterAantal = S.getAantalDoelpunten();
		 }
		 return topschutterAantal;
	 }
	 public ArrayList<Speler> getSpelers(){
			return spelers;
		}
	 public String printDB() {
		 String s = "";
		 for (Speler S : spelers) {
			 s+=S.getNaam() + " ";
		 }
		return s;
		 
	 }
	 public Speler zoekSpeler(String naam, String voornaam){
		 for (Speler S : spelers) {
			 if(S.getNaam().toLowerCase().trim().equals(naam.toLowerCase().trim())&&S.getVoornaam().toLowerCase().trim().equals(voornaam.toLowerCase().trim())) {
				 return S;
			 }
		 }
		throw new IllegalArgumentException("Speler " + naam + " " + voornaam + " is niet gevonden.");
	
		 
	 }
	public void verwijder(String naam,String voornaam) {
		for (int i=0;i<spelers.size();i++) {
			 if(spelers.get(i).getNaam().equals(naam)&&spelers.get(i).getVoornaam().equals(voornaam)) {
				 spelers.remove(i);
			 	}
		}
	
	}
	public void verwijder(Speler speler) {
		spelers.remove(speler);
		
	}
}

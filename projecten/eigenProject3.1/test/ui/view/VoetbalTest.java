package ui.view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import domain.db.Spelersdb;
import domain.model.Speler;

public class VoetbalTest {
	private WebDriver driver;
	private String url = "http://localhost:8080/eigenProject3.1/";

	Spelersdb db = new Spelersdb();

	private boolean paginaBevatTdMetText(List<WebElement> tds, String tekst) {
		for (WebElement td : tds) {
			if (td.getText().equals(tekst)) {
				return true;
			}
		}
		return false;
	}
	
	private void vulFormulierIn(String naam, String voornaam, String ploeg, String wedstrijden, String doelpunten) {

		WebElement naamField = driver.findElement(By.id("naam"));

		System.out.println(naamField.getTagName());
		naamField.clear();
		
		naamField.sendKeys(naam);
		
		WebElement voornaamField = driver.findElement(By.id("voornaam"));

		voornaamField.clear();
		
		voornaamField.sendKeys(voornaam);
		
		WebElement ploegField = driver.findElement(By.id("ploeg"));

		ploegField.clear();
		
		ploegField.sendKeys(ploeg);

		WebElement wedstrijdenField = driver.findElement(By.id("wedstrijden"));

		wedstrijdenField.clear();

		wedstrijdenField.sendKeys(wedstrijden);
		
		WebElement doelpuntenField = driver.findElement(By.id("doelpunten"));

		doelpuntenField.clear();
		
		doelpuntenField.sendKeys(doelpunten);
		
		WebElement button = driver.findElement(By.cssSelector("input[type='submit']"));

		button.click();

	
		}
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Brend\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Brend\\Documents\\school\\2017-2018\\2de semester\\web2\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void welkomspagina_heeft_berekende_waarde() {
		
		driver.get(url);

		WebElement calculatedValue = driver.findElement(By.id("topschutter"));


		assertEquals("De huidige topschutter is " + db.getTopschutter() + " met " + db.getHoogsteAantalDoelpunten() + " doelpunten." , calculatedValue.getText());
	}
	
	@Test
	public void overzichtspagina_is_correct() {

		driver.get(url + "SpelerServlet?actie=hoofdpagina");

		ArrayList<WebElement> tableElements = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));

		ArrayList<Speler> spelers = db.getSpelers();


		int teller = 0;
		
		
		for (int i = 0; i < spelers.size(); i++) {

			assertEquals(spelers.get(i).getNaam(), tableElements.get(teller).getText());

			teller++;

			assertEquals(spelers.get(i).getVoornaam().toLowerCase(), tableElements.get(teller).getText().toLowerCase());

			teller++;
			
			assertEquals(spelers.get(i).getPloeg().toLowerCase(), tableElements.get(teller).getText().toLowerCase());

			teller++;
			
			assertEquals(spelers.get(i).getAantalWedstrijden(), Integer.parseInt(tableElements.get(teller).getText()));

			teller++;
			
			assertEquals(spelers.get(i).getAantalDoelpunten(),  Integer.parseInt(tableElements.get(teller).getText()));

			teller++;
			
		}
	}

	@Test // Voer deze test uit als je je project opgeladen hebt
	public void isValidHtml() {
		driver.get("https://validator.w3.org/#validate_by_uri+with_options");
		WebElement invulveld = driver.findElement(By.id("uri"));
		// verander naamVanJeEigenSite naar de juiste naam
		invulveld.sendKeys("http://java.cyclone2.khleuven.be:38034/1tx10_ReniersBrend/");

		Select dropdown = new Select(driver.findElement(By.id("uri-doctype")));
		dropdown.selectByValue("HTML5");

		WebElement button = driver.findElement(By.cssSelector(".submit_button"));
		button.click();

		WebElement pass = driver.findElement(By.cssSelector("p.success"));
		assertEquals("Document checking completed. No errors or warnings to show.", pass.getText());

	}
	@Test
	public void als_formulier_correct_ingevuld_is_wordt_overzicht_met_nieuwe_waarde_getoond() {

		driver.get(url + "SpelerServlet?actie=formulier");

		String naam = "Colier";

		String voornaam = "Kenneth";

		String ploeg = "KAC Betekom";
		
		String wedstrijden = "5";
		
		String doelpunten = "0";

		vulFormulierIn(naam, voornaam, ploeg, wedstrijden, doelpunten);

		
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Colier"));
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Kenneth"));
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "KAC Betekom"));
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "5"));
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "0"));

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}

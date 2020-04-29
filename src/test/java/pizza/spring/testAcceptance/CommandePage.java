package pizza.spring.testAcceptance;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CommandePage {
	
	private WebDriver webDriver;

	public CommandePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public CommandePage open() {
		webDriver.navigate().to("http://localhost:8081/pizza-spring/commande");
		assertTrue("Titre de page inattendu " + webDriver.getTitle(), webDriver.getTitle().startsWith("Pizza Spring"));
		return this;
	}

	public static CommandePage openWith(WebDriver webDriver) {
		CommandePage commandePage = new CommandePage(webDriver);
		commandePage.open();
		return commandePage;
	}
	
	public CommandePage selectionPizza() {
		CommandePage selectionpizza = new CommandePage(webDriver);
		
		return this;
	}

	public CommandePage enterKeywordsNom(String... words) {
		WebElement searchInput = webDriver.findElement(By.name("nom"));
		searchInput.sendKeys(String.join(" ", words));
		return this;
	}
	
	public CommandePage enterKeywordsTel(String... words) {
		WebElement searchInput = webDriver.findElement(By.name("telephone"));
		searchInput.sendKeys(String.join(" ", words));
		return this;
	}

	public ResultPage clickOnSubmit() {
		WebElement submitButton = webDriver.findElement(By.id("BoutonSubmit"));
		submitButton.click();
		return new ResultPage(webDriver);
	}

}

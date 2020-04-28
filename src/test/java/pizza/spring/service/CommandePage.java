package pizza.spring.service;

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

	public CommandePage enterKeywords(String... words) {
		WebElement searchInput = webDriver.findElement(By.name("q"));
		searchInput.sendKeys(String.join(" ", words));
		return this;
	}

	public ResultPage clickOnSearch() {
		WebElement searchButton = webDriver.findElement(By.id("search_button_commandePage"));
		searchButton.click();
		return new ResultPage(webDriver);
	}

}

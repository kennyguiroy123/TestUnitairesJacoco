package pizza.spring.testAcceptance;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
	
	private WebDriver webDriver;

	public ResultPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		assertTrue("Titre de page inattendu " + webDriver.getTitle(), webDriver.getTitle().endsWith("Pizza Spring"));
	}
	
	public boolean isPizzaCommander() {
		return ! webDriver.findElement(By.id("pizzaId")).isSelected();
	}
	
	public boolean isPizzaNomSaisie() {
		return ! webDriver.findElements(By.id("nom.errors")).isEmpty();
	}
	
	public boolean isPizzaTelSaisie() {
		return ! webDriver.findElements(By.id("telephone.errors")).isEmpty();
	}
}

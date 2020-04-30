package pizza.spring.testAcceptance;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommandePizzaAcceptanceTest {
	
	private WebDriver webDriver;
	
	@Before
	public void createWebDriver() {
		webDriver = new ChromeDriver();
	}

	@After
	public void closeWebDriver() {
		webDriver.quit();
	}

	@Test
	public void checkSeleniumDevSiteFoundCommandePizza() throws Exception {
		ResultPage resultPage = CommandePage.openWith(webDriver)
										.selectionPizza()
				                        .enterKeywordsNom("Guiroy")
				                        .enterKeywordsTel("09427816327").clickOnSubmit();
		
		assertTrue(resultPage.isPizzaCommander());
		assertTrue(resultPage.isPizzaNomSaisie());
		assertTrue(resultPage.isPizzaTelSaisie());
		
	}

}

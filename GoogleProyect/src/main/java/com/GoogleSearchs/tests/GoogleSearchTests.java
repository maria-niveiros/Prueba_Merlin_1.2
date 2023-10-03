package com.GoogleSearchs.tests;

import com.GoogleSearchs.base.BasePage;
import com.GoogleSearchs.base.BaseTest;
import com.GoogleSearchs.pages.GoogleHomePage;
import com.GoogleSearchs.pages.GoogleResultsPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.extentreports.ExtentFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;




public class GoogleSearchTests extends BaseTest {
	static BasePage _basePage = new BasePage();
	static GoogleHomePage googleHomePage = new GoogleHomePage();
	static GoogleResultsPage googleResultsPage = new GoogleResultsPage();
	private static WebDriver driver;
	static  boolean condition;

	private String  item = "Automatización"  ;



	@BeforeAll
	static void setUp() {
		_basePage = new BasePage();
		driver = _basePage.getDriver();
		extent.attachReporter(spark);
	}

	@BeforeEach
	public void initialPage() {
		_basePage.openApp();
	}

	@Test
	@DisplayName("Page title refers to search")
	public void searchProductTitle() throws IOException {

			googleHomePage.standarSearchItem(item);
			condition = driver.getTitle().contains(item);
			_basePage.checkCondition("PageTitle_"+item, condition);



	}

	@Test
	@DisplayName("Wikipedia´s link present on 1st result page")
	public void wikiLinkPresent() throws IOException {

			googleHomePage.standarSearchItem(item);
			condition = driver.getCurrentUrl().contains("wikipedia");
			_basePage.checkCondition("Wikipedia_"+ item,googleResultsPage.searchWikiLink());
			googleResultsPage.goToHomePage();


	}

	@Test
	@DisplayName("Go to wikipedia website")
	public void wikipediaPage() throws IOException {

		googleHomePage.standarSearchItem(item);
		_basePage.clickElementByText("wikipedia");
		condition= driver.getTitle().contains(item);
		_basePage.checkCondition("Has title " + item,condition);
	}

	@Test
	@DisplayName("Find first automation process date")
	public void automationDate() throws IOException {
		googleHomePage.standarSearchItem(item);
		_basePage.clickElementByText("wikipedia");
		List<WebElement> paragraphsList = driver.findElements(By.tagName("p"));
		for (WebElement paragraph: paragraphsList){
			if (paragraph.getText().contains("primer mecanismo de control")) {
				condition=true;
				_basePage.getJs().executeScript("arguments[0].scrollIntoView();", paragraph);
				_basePage.checkCondition("Primer proceso automatizado", condition);
				_basePage.highlightElement(paragraph);
				_basePage.takeScreenshot("Primer proceso automatizado");

			}else {
				condition = false;
			}
		}



	}





	@AfterAll
	public static void finishTest() { driver.quit();}

}
	

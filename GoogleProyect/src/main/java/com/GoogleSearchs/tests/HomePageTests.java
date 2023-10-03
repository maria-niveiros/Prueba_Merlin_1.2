package com.GoogleSearchs.tests;

import com.GoogleSearchs.base.BasePage;
import com.GoogleSearchs.base.BaseTest;
import com.GoogleSearchs.pages.GoogleHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.extentreports.ExtentFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class HomePageTests extends BaseTest {

	static BasePage _basePage = new BasePage();

	static  GoogleHomePage googleHomePage= new GoogleHomePage();
	private static WebDriver driver;

	private  boolean condition ;
	static  ExtentSparkReporter spark = ExtentFactory.getInstances();
	static ExtentReports extent = ExtentFactory.getInstance();


	@BeforeAll
	static void setUp() {
		driver = _basePage.getDriver();
		extent = ExtentFactory.getInstance();
		extent.attachReporter(spark);
	}

	@BeforeEach
	public void initialPage() {
		_basePage.openApp();
	}

	@Test
	@DisplayName("Verify page title")
	public void pageTitle() throws InterruptedException, IOException {
		condition = GoogleHomePage.getTitle().equals("Google");
		_basePage.checkCondition("Check page title", condition);
	}


	@Test
	@DisplayName("Country configuration must be Argentina")
	public void pageElements() throws InterruptedException, IOException {
		condition = googleHomePage.getCountry().equals("Argentina");
		_basePage.checkCondition("Check_country_configuration", condition);
	}

	@Test
	@DisplayName("Element is present")
	public void elementIsPresent() throws InterruptedException, IOException {
	condition= googleHomePage.getWebElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
		_basePage.checkCondition("Element_is_present", condition);
	}




}
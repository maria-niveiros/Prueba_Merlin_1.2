package com.GoogleSearchs.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.extentreports.ExtentFactory;
import lombok.Getter;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.GoogleSearchs.base.BaseTest.extent;


public class BasePage {
	
	protected static WebDriver _driver;
	public static WebDriverWait wait;
	protected static final String URL = "https://google.com.ar";
	@Getter
	JavascriptExecutor js = ((JavascriptExecutor) _driver);

	ExtentReports extentReports;


	
	public BasePage() {
		if (_driver == null) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
			_driver = new ChromeDriver();
			_driver.manage().window().maximize();
		}
	}


	public void openApp() {
		_driver.get(URL);
	}

	public WebDriver getDriver() {
		return _driver;
	}



	public WebElement getWebElement(By locator) {
		WebElement elem = null;
		try
		{
			elem = _driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("There is no an Element: " + locator);
			System.out.println("Exception message: " + e);
		}
		return elem;
	}


	public void clickElement(String locator) {
		WebElement element = getWebElement(By.xpath(locator));
		element.click();
	}

	public void clickElementByText(String locator){
		WebElement element = getWebElement(By.partialLinkText(locator));
		element.click();
	}

	public void writeText(String locator,String text){
		WebElement element = getWebElement(By.xpath(locator));
		element.sendKeys(text);
	}

	public String getText(String locator){
		WebElement element = getWebElement(By.xpath(locator));
		return element.getText();
	}

	public static String getTitle(){
	 return	_driver.getTitle();
	}

	public void checkCondition (String nameTest, Boolean condition) {
		ExtentTest test = extent.createTest(nameTest);

		if (condition) {
			test.pass("Test passed as expected");
		}else {
			test.fail("Test failed.");
		}
	}

	public void takeScreenshot (String nameTest) throws IOException {
		String screenshotPath =ExtentFactory.getScreenshot(_driver,nameTest);
		MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();
	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) _driver;

		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}

}
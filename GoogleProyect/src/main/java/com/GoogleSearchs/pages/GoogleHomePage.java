package com.GoogleSearchs.pages;

import lombok.Getter;
import com.GoogleSearchs.base.BasePage;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GoogleHomePage extends BasePage {

	@Getter
	private static final String MainSearchInput = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea";
	@Getter
	private static final String buttonGoogleSearch = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]";

	@Getter
	private static final String buttonLuckySearch= "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[2]";

	private static final String countrySettings ="/html/body/div[1]/div[6]/div[1]";


	public void standarSearchItem(String item){

		writeText(MainSearchInput, item);
		clickElement("/html/body/div[1]/div[2]/div/img");
		Wait wait1 = new WebDriverWait(_driver, Duration.ofSeconds(3));
		clickElement(buttonGoogleSearch);
	}
	public void luckySearchItem(String item){
		writeText(MainSearchInput, item);
		clickElement(buttonLuckySearch);
	}

	public String getCountry() {
		return getText(countrySettings);
	}


}
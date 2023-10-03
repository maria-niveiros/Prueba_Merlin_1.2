package com.GoogleSearchs.pages;

import com.GoogleSearchs.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class GoogleResultsPage extends BasePage {

    static GoogleHomePage googleHomePage = new GoogleHomePage();
    static BasePage basePage = new BasePage();
    String googleSmallLogo = "/html/body/div[3]/div[2]/form/div[1]/div[1]/div[1]/a/img";




    public void goToHomePage(){
        Wait wait1 = new WebDriverWait(_driver, Duration.ofSeconds(3));

        basePage.clickElement(googleSmallLogo);}

    public Boolean searchWikiLink(){
        try {
            WebElement wiki = getDriver().findElement(By.partialLinkText("wikipedia"));
            basePage.getJs().executeScript("arguments[0].scrollIntoView();", wiki);
            return wiki.isDisplayed();
        } catch (Exception e){
            return false;
        }

    }



}



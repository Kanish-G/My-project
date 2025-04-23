package com.CoverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	// Variables--> WebElements
	@FindBy(xpath="//div[text()='Female']") private WebElement gender;
	
	// Constructor
	public CoverFoxHomePage (WebDriver driver) {
		PageFactory.initElements(driver,this);	
		}
	
	// Methods
	public void clickOnGender() {
	  	Reporter.log("Clicking on gender", true);
        gender.click();
	}

}

package com.CoverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {
	@FindBy(className="next-btn") private WebElement nextButton;
	
	public CoverFoxHealthPlanPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void clickOnNextButtonHealthPlanPage() {
	  	Reporter.log("Clicking on next button of health plan page", true);
		nextButton.click();
	}

}

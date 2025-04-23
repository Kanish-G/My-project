package com.CoverFox_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage {
	@FindBy(tagName="select") private WebElement ageDropDown;
	@FindBy(className="next-btn") private WebElement nextButton;
	
	public CoverFoxMemberDetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	public void handleAgeDropDown(String age) {
      
		Reporter.log("Handeling age drop down", true);
		Select sAge=new Select(ageDropDown);
		sAge.selectByVisibleText(age);
		//sAge.selectByValue(age+"y");
		
		
	}
	public void clickOnNextButtonOfMemberDetailsPage() 
	{
		
		Reporter.log("Clicking On NextButton Of MemberDetails Page", true);
		nextButton.click();
	}

}

package com.CoverFox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPage {
	@FindBy(xpath="//div[contains(text(),'matching')]") private WebElement PlanResult;
	@FindBy(className= "plan-card-container") private List<WebElement> PlanCards;
	public CoverFoxResultPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void validatePlans() throws InterruptedException  {
		String result = PlanResult.getText();
		String[] result1 = result.split(" ");
		int resultInNumber = Integer.parseInt(result1[0]);
		Thread.sleep(3000);
		int totalPlans = PlanCards.size();
		
		if(totalPlans==resultInNumber) {
			System.out.println("TC is passed");
		}
		else {
			System.out.println("TC is failed");
		}
		
	}
	
	public int getPlanNumberFromText()
  	{
                 	Reporter.log("Getting plan number from text", true);
                 	String result = PlanResult.getText();
                 	String[] result1 = result.split(" ");
                 	int planNumber = Integer.parseInt(result1[0]);
                 	return planNumber;
  	}
	public int getPlanNumberFromPlanCards()
  	{
                 	Reporter.log("Getting plan number from plan cards", true);
                 	int planNumberFromCards = PlanCards.size();
                 	return planNumberFromCards;
  	}
  	
}





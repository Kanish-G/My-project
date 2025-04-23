package com.CoverFox_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.CoverFox_Base.Base1;
import com.CoverFox_POM.CoverFoxAddressDetailsPage;
import com.CoverFox_POM.CoverFoxHealthPlanPage;
import com.CoverFox_POM.CoverFoxHomePage;
import com.CoverFox_POM.CoverFoxMemberDetailsPage;
import com.CoverFox_POM.CoverFoxResultPage;
import com.CoverFox_Utility.Utility1;

public class CoverFoxTestUsingTestNG extends Base1 {
	
	public static Logger Logger;
  	CoverFoxHomePage coverFoxHomePage;
  	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage;
  	CoverFoxAddressDetailsPage coverFoxAddressDetailsPage;
  	CoverFoxHealthPlanPage coverFoxHealthPlanPage;
  	CoverFoxResultPage coverFoxResultPage;


  @BeforeClass
  public void launchBrowser() throws EncryptedDocumentException, IOException
 {
		  Logger= Logger.getLogger("CoverFox");
		  PropertyConfigurator.configure("log4j.properties");
		  Logger.info("Welcome to CoverFox Testing");
	  

	openBrowser(); 
	Logger.info("Launching Browser");
   	coverFoxHomePage= new CoverFoxHomePage(driver);
   	coverFoxAddressDetailsPage= new CoverFoxAddressDetailsPage(driver);
   	coverFoxMemberDetailsPage= new CoverFoxMemberDetailsPage(driver);
   	coverFoxHealthPlanPage= new CoverFoxHealthPlanPage(driver);
   	coverFoxResultPage= new CoverFoxResultPage(driver);

  }
  @BeforeMethod
  public void  coverFoxPreconditions()throws InterruptedException, EncryptedDocumentException, IOException{
	   
	    
	      coverFoxHomePage.clickOnGender();
	      Logger.info("Clicking on Gender");
	      coverFoxHealthPlanPage.clickOnNextButtonHealthPlanPage();
	      Logger.info("Clicking on next button health plan page");
	      coverFoxMemberDetailsPage.handleAgeDropDown(Utility1.readDataFromExcel("Sheet6", 0, 0));
	      Logger.info("Handle age drop down");
	      coverFoxMemberDetailsPage.clickOnNextButtonOfMemberDetailsPage();
	      Logger.info("Clicking on next button of member details page");
	      coverFoxAddressDetailsPage.enterPinCode(Utility1.readDataFromExcel("Sheet6", 0, 1));
	      Logger.info("Enter Pincode: ");
	      coverFoxAddressDetailsPage.enterMobileNumber(Utility1.readDataFromExcel("Sheet6", 0, 2));
	      Logger.info("Enter Mobile number: ");
	      coverFoxAddressDetailsPage.clickOnContinueButton();
	      Logger.info("Clicking on continue button");
	      Thread.sleep(4000);
	  }

  @Test
  public void validateCoverFoxPlans() throws IOException {
	      //Assert.fail();
          int planNumberFromText = coverFoxResultPage.getPlanNumberFromText();
          int planNumberFromCards = coverFoxResultPage.getPlanNumberFromPlanCards();
          Logger.info("Validating CoverFoxPlan");
          Assert.assertEquals(planNumberFromText, planNumberFromCards,"Test case failed, number are not matching");
          Reporter.log("Plan number are matching TC is passed", true);
          Utility1.takeScreenshot(driver, "validateCoverFoxPlans");       	
          	}
  @AfterClass
  public void closeBrowser() throws InterruptedException
	{
	    Logger.info("Closing Browser");
		closeBrowserWindow();
	}

}



  
          	



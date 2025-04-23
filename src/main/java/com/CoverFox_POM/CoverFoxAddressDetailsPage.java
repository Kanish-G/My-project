package com.CoverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.CoverFox_Base.Base1;
import com.CoverFox_Utility.Utility1;

public class CoverFoxAddressDetailsPage {
	//@FindBy(className="mp-input-text") private WebElement pinCodeField;
	//@FindBy(id= "want-expert") private WebElement mobileNumberField;
	@FindBy(xpath = "//input[@placeholder='6 Digit Pincode']") private WebElement pinCodeField;

    @FindBy(xpath = "//input[@placeholder='Your mobile number']") private WebElement mobileNumberField;
	@FindBy(xpath="//div[text()='Continue']") private WebElement continueButton;
	
	
	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}



	public void enterPinCode(String pinCode) {
	  	Reporter.log("Entering PinCode", true);
		pinCodeField.sendKeys(pinCode);
	}
	public void enterMobileNumber(String mobileNumber) {
		Reporter.log("Entering mobileNumber", true);
        mobileNumberField.sendKeys(mobileNumber);
	}
	public void clickOnContinueButton() {
		Reporter.log("Clicking On Continue Button", true);
        continueButton.click();
	}

}

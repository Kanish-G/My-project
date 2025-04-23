package com.CoverFox_Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import com.CoverFox_Utility.Utility1;



public class Base1 {
       protected static WebDriver driver;
	
	public void openBrowser() throws IOException {
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver=new ChromeDriver(opt);
//		String url = Utility1.readDataFromPropertiesFile("url");
        //driver.get("https://www.coverfox.com/");
		driver.get(Utility1.readDataFromPropertiesFile("url"));	
		driver.manage().window().maximize()	;	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		Reporter.log("Launching browser",true);
		}
	public void closeBrowserWindow() {
		Reporter.log("Closing browser",true);
		driver.quit();
	}

}

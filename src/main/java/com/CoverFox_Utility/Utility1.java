package com.CoverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.w3c.dom.events.EventException;

public class Utility1 {
	public static String readDataFromExcel(String sheetName,int row,int cell) throws EventException, IOException
	{
		FileInputStream myFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\DemoEXcel.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
		 DataFormatter formatter = new DataFormatter(); // handles string + numeric cells
		 String data = formatter.formatCellValue(mySheet.getRow(row).getCell(cell)).trim();
		 Reporter.log("Reading data from excel: " + data, true);
		 return data;
//		 String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
	    	}
	
	public static void takeScreenshot(WebDriver driver, String screenShotName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File dest= new File("C:\\Users\\DELL\\eclipse-workspace\\Selenium_demo\\screenshot\\"+screenShotName+".png");
		String path = System.getProperty("user.dir") + "\\screenshot\\" + screenShotName + ".png";
	    File dest = new File(path);
		FileHandler.copy(src, dest);
		Reporter.log("Taking screenshot, saved at"+path, true);	
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scrolling into view", true);
	}

	public static String readDataFromPropertiesFile(String key) throws IOException {
	    Properties prop = new Properties();
	    FileInputStream myFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\CoverFox.properties");
	    prop.load(myFile);
	    String value = prop.getProperty(key);
	    Reporter.log("Reading " + key + " from properties file", true);
	    return value;
	}

		
	}





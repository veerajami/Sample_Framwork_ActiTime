package com.actitime.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.actitime.base.BaseTest;

public class Utility extends BaseTest{
	
	String path="D:\\java\\New Eclipse\\ActiTimeTest\\src\\main\\java\\com\\actitime\\tesdata\\TestData.xlsx";
	
	Workbook workbook;
	  Sheet sheet;

	public  Object[][] getTestData(String sheetname)
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(path);
			workbook=WorkbookFactory.create(fis);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetname);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		
	
		
		return data;
		
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String current_dir=System.getProperty("user.dir");
		FileUtils.copyFile(src,new File(current_dir+"/Screenshots/"+System.currentTimeMillis()+".png") );
		
	}
	
	public static void scrollIntoView(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public static WebElement switchFrame(String name,String xpath)
	{
		driver.switchTo().frame(name);
		return driver.findElement(By.xpath(xpath));
	}
	public static void swithToDefaultFrame() {
		
		driver.switchTo().defaultContent();
		
	}
	
	public static boolean clickOnAlert(boolean alert)
	{
		if(alert) {
		try {
		driver.findElement(By.xpath("//span[div[@class='intercom-borderless-dismiss-button']]")).click();
		return true;
		}
		catch(Exception e)
		{
		
			return false;
		}
		}
		return alert;
	}
	
	
  public static WebElement synchronize(WebDriver driver, String xpath,int time)
  {	     WebElement element=null;
	  for(int i=0;i<time;i++)
	  {
		
		  try {
			 element= driver.findElement(By.xpath(xpath));
			 return element;
		  }
		  catch(NoSuchElementException e)
		  {
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				System.out.println("Wating for Element");
			}
		  }
		  
		  }
	
	  return element;
  }
	
	
	
}

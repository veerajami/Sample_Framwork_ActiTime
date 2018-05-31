package practice.selenium;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;



public class IEDemo1 {

	@Test
	public void test() {
	
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	    capabilities.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
	    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	    capabilities.setCapability("ignoreZoomSetting", true);
	    capabilities.setCapability("ignoreProtectedModeSettings", true);
	    capabilities.setCapability("initialBrowserUrl","http://127.0.0.1/login.do");
	    System.setProperty("webdriver.ie.driver", "D:\\Selenium\\driver\\IEDriverServer.exe");
	    InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
	    driver.manage().window().maximize();
		//driver.get("http://127.0.0.1/login.do");
		
		WebElement username_textbox=driver.findElement(By.name("username"));
		WebElement password_textbox=driver.findElement(By.name("pwd"));
		WebElement login_button=driver.findElement(By.name("//input[contains(@value,'Login now')]"));
		username_textbox.sendKeys("admin");
		password_textbox.sendKeys("manager");
		login_button.click();
	
	}

}






/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class IEDemo1 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.ie.driver","D:\\Selenium\\driver\\IEDriverServer.exe" );
		WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1/login.do");
		
		WebElement username_textbox=driver.findElement(By.name("username"));
		WebElement password_textbox=driver.findElement(By.name("pwd"));
		WebElement login_button=driver.findElement(By.name("//input[contains(@value,'Login now')]"));
		username_textbox.sendKeys("admin");
		password_textbox.sendKeys("manager");
		login_button.click();
	
	}

}*/

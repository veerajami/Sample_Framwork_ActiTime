package com.actitime.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.actitime.utility.WebEventListener;

public class BaseTest {
	public static WebDriver driver;
	public static Properties property;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener listner;
	public static DesiredCapabilities cap;
	
	//Initialize the driver in the constructor so that it's child classes of pages and tests can inherit this same driver
	public BaseTest(){
		
		
		try {
			property=new Properties();
			FileInputStream fis=new FileInputStream("D:\\java\\New Eclipse\\ActiTimeTest\\src\\main\\java\\com\\actitime\\config\\config.properties");
			property.load(fis);
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		
		
	}

	public static void initialize()
	{
		
		String browser=property.getProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", property.getProperty("chromedriver_path"));
			
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", property.getProperty("ffdriver_path"));
			driver=new FirefoxDriver();
		}
		e_driver=new EventFiringWebDriver(driver);
		listner=new WebEventListener();
		e_driver.register(listner);
		driver=e_driver;
		
		
		driver.manage().timeouts().implicitlyWait(Long.parseLong(property.getProperty("implicitwait_timeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(property.getProperty("pageload_timeout")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));
		
	}
	
	public static void initialize(String browser,String remoteURL)
	{
		
	//	String browser=property.getProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", property.getProperty("chromedriver_path"));
			cap=new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			try {
				driver=new RemoteWebDriver(new URL(remoteURL), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", property.getProperty("ffdriver_path"));
			cap=new DesiredCapabilities().firefox();
			cap.setBrowserName("firefox");
			try {
				driver=new RemoteWebDriver(new URL(remoteURL), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(browser.equals("ie"))
		{
/*			System.setProperty("webdriver.ie.driver", property.getProperty("iedriver_path"));
			cap=new DesiredCapabilities().internetExplorer();
			cap.setBrowserName("internet explorer");*/
			
			cap = DesiredCapabilities.internetExplorer();
			cap.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			cap.setCapability("ignoreZoomSetting", true);
			cap.setCapability("ignoreProtectedModeSettings", true);
			//cap.setCapability("initialBrowserUrl","http://127.0.0.1/login.do");
		    System.setProperty("webdriver.ie.driver", "D:\\Selenium\\driver\\IEDriverServer.exe");
		  //  InternetExplorerDriver driver = new InternetExplorerDriver(cap);
			
			
			
			try {
				driver=new RemoteWebDriver(new URL(remoteURL), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		e_driver=new EventFiringWebDriver(driver);
		listner=new WebEventListener();
		e_driver.register(listner);
		driver=e_driver;
		
		
		driver.manage().timeouts().implicitlyWait(Long.parseLong(property.getProperty("implicitwait_timeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(property.getProperty("pageload_timeout")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));
		
	}
	
	

}

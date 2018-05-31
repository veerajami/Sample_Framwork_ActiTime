package practice.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.base.BaseTest;
import com.actitime.utility.WebEventListener;

public class AlertsDemo extends BaseTest{
	
	AlertsDemo(){
		super();
	}
	
	public static void initialize() {
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
	//	driver.get(property.getProperty("url"));
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initialize();
		AlertsDemo ad=new AlertsDemo();
	}

/*	@Test
	public void bootStrapModal() throws InterruptedException {
		
		driver.get("http://www.seleniumeasy.com/test/bootstrap-modal-demo.html");
		driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a")).click();
		
	   // Alert alert=driver.switchTo().alert();
	//    alert.dismiss();
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='myModal0']/div/div/div[4]/a[2]")).click();
		driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a")).click();
		driver.switchTo().activeElement();
		WebElement element=driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[4]/a[2]"));
		
		System.out.println(element.isDisplayed());
		System.out.println(element.isEnabled());
		
		Thread.sleep(2000);
		
	}*/
	
/*	
	@Test
	public void AlertWindow() throws InterruptedException {
		
		driver.get("http://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]")).click();
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		String parent=itr.next();
		String child=itr.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//*[@id='follow-login-form']/fieldset[2]/input")).click();
		driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("vinjami");
		driver.switchTo().window(parent);
		
		driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/a")).click();
		
		Thread.sleep(2000);
		
	}
	*/
/*	@Test
	public void progressBar() throws InterruptedException {
		
		driver.get("http://www.seleniumeasy.com/test/bootstrap-progress-bar-dialog-demo.html");
		WebElement progress_bar=driver.findElement(By.xpath("html/body/div[2]/div/div[2]/button[1]"));
		progress_bar.click();
		Thread.sleep(4000);
		progress_bar.click();
		
	}
	*/
	
	@Test
	public void JavascriptAlert() throws InterruptedException {
		
		driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/button")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[3]/div[2]/button")).click();
		alert.sendKeys("vinjami");
		Thread.sleep(2000);	
	}
	
	
	@AfterMethod
	public void end() throws Exception
	{
		Thread.sleep(4000);
		driver.close();
	}
	
}

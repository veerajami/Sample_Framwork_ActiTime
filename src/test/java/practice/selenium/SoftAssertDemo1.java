package practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.base.BaseTest;
import com.actitime.pages.LoginPage;

public class SoftAssertDemo1 extends BaseTest{
	
	LoginPage loginpage;
	SoftAssert s_assert=new SoftAssert();
	public SoftAssertDemo1() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialize();
		loginpage=new LoginPage();
		
	}
	
	@Test
	public void validateLoginPage() {
		
		s_assert.assertTrue(loginpage.validateActiTimeLogo());
		s_assert.assertEquals(loginpage.validateLoginTitle(), "Login Page");
		s_assert.assertAll();
		Select select=new Select(driver.findElement(By.id("vin")));
		Actions action=new Actions(driver);
		
		
	}
	

}

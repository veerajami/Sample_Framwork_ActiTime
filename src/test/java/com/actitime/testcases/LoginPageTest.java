package com.actitime.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actitime.base.BaseTest;
import com.actitime.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	
	LoginPage loginpage;
	
	LoginPageTest(){
		
		super();
	}
	
//	for selenium grid	
/*    @BeforeMethod
	@Parameters({"browser","remoteURL"})
	public void setup(String browser,String remoteURL)
	{
    	System.out.println("browser value is:"+browser);
		initialize(browser, remoteURL);
		System.out.println("browser value is:"+browser);
		System.out.println("remote URL is:"+remoteURL);
	//	initialize();
		loginpage=new LoginPage();
	}*/
	
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageIconValidate()
	{
		Assert.assertTrue(loginpage.validateActiTimeLogo());
	}
	
	@Test(priority=2)
	public void logintest()
	{
		loginpage.loginWithKeyboard();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

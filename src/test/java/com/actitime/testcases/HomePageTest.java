package com.actitime.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.base.BaseTest;
import com.actitime.pages.HomePage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.ProjectsAndCustomersPage;




public class HomePageTest extends BaseTest {
	
	public HomePageTest() {
		super();
	}
	
	LoginPage loginpage;
	HomePage homepage;
	ProjectsAndCustomersPage projectsandcustomerspage;
	@BeforeMethod
	public void setup()
	{
	 initialize();
	 loginpage=new LoginPage();
	 homepage=loginpage.login();

	 
	}
	
	@Test(priority=1)
	public void validateHomePageTest() {
		String title=homepage.validateHomePageTitle();
		Assert.assertTrue(title.contains("Open Tasks"));
		
	}
	
	@Test(priority=2)
	public void showtasksTest() {
		
		homepage=homepage.showTasksFor("Fedex", "Fedex");
		int count=homepage.countCustomers("Fedex");
		Assert.assertEquals(count, 2);
		
	}
	
	public void verifyByClickOnProjectsAndCustomersLinkTest() {
		projectsandcustomerspage=homepage.clickOnProjectsAndCustomers();
	    Assert.assertTrue(projectsandcustomerspage.getTitle().contains("actiTIME - Active Projects & Customers"));
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}

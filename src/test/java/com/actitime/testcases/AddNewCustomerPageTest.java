package com.actitime.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.actitime.base.BaseTest;
import com.actitime.pages.AddNewCustomerPage;
import com.actitime.pages.AddNewTasksPage;
import com.actitime.pages.HomePage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.OpenTasksPage;
import com.actitime.pages.ProjectsAndCustomersPage;
import com.actitime.utility.Utility;

public class AddNewCustomerPageTest extends BaseTest{
	
	LoginPage loginpage;
	HomePage homepage;
	OpenTasksPage opentaskspage;
	ProjectsAndCustomersPage projectsandcustomerspage;
	AddNewTasksPage addnewtaskspage;
	AddNewCustomerPage addnewcustomerpage;
	String sheetname="customers";
	
	public AddNewCustomerPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		loginpage=new LoginPage();
		homepage=loginpage.login();
		projectsandcustomerspage=homepage.clickOnProjectsAndCustomers();
		addnewcustomerpage=projectsandcustomerspage.clickOnAddNewCustomer();
		
	}
	
	
	@Test(priority=1,dataProvider="getActiTimeData")
	public void verifyAddNewCustomerTest(String customer,String description) {
		projectsandcustomerspage=	addnewcustomerpage.addNewCustomer(customer, description);
		}
	
	@DataProvider
	public Object[][] getActiTimeData() {
		//Object[][] obj=
		return new Utility().getTestData(sheetname);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	

}

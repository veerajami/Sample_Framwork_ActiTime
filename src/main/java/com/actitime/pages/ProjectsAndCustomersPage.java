package com.actitime.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.base.BaseTest;

public class ProjectsAndCustomersPage extends BaseTest{
	
	
	@FindBy(xpath="//input[@value='Add New Customer']")
	public WebElement addNewCustomer_button;
	
	@FindBy(xpath="//input[@value='Add New Project']")
	public WebElement addNewProject_button;
	
	@FindBy(name="selectedCustomer")
	public WebElement selectCustomer_dropdown;
	
	
	public ProjectsAndCustomersPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String getTitle() {
	
		return driver.getTitle();
	}
	
	public AddNewCustomerPage clickOnAddNewCustomer() {
		addNewCustomer_button.click();
		return new AddNewCustomerPage();
	}
	
	
	
	
	

}

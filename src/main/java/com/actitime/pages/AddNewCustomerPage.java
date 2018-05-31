package com.actitime.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.base.BaseTest;

public class AddNewCustomerPage extends BaseTest{
	
	@FindBy(name="name")
	public WebElement customerName_textbox;
	
	@FindBy(name="description")
	public WebElement customerDescription_textbox;
	
	@FindBy(name="createCustomerSubmit")
	public WebElement createCustomer_button;
	
	public AddNewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public ProjectsAndCustomersPage addNewCustomer(String name,String description) {
		
		customerName_textbox.sendKeys(name);
		customerDescription_textbox.sendKeys(description);
		createCustomer_button.click();
		return new ProjectsAndCustomersPage();
		
	}

}

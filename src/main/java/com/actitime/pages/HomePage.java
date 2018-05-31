package com.actitime.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.actitime.base.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(xpath="//a[text()='Completed Tasks']")
	WebElement completedTasks_link;
	
	@FindBy(xpath="//a[contains(text(),'Projects & Customers')]")
	WebElement projectsAndCustomers_link;
	
	@FindBy(xpath="//select[@name='customerProject.shownCustomer']")
	WebElement customer_dropdown;
	
	@FindBy(xpath="//select[@name='customerProject.shownProject']")
	WebElement project_dropdown;
	
	@FindBy(xpath="//select[@name='customerProject.shownProject']")
	WebElement showTasks_button;
	
	@FindBy(xpath="//span[contains(text(),'Administrator')]")
	WebElement validate_user;
	
	@FindBy(xpath="//input[@value='Add New Tasks']")
	WebElement addNewTasks_button;
	
	@FindBy(xpath="//a[contains(text()'Archives')]")
	WebElement archives_link;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ProjectsAndCustomersPage clickOnProjectsAndCustomers()
	{
		projectsAndCustomers_link.click();
		return new ProjectsAndCustomersPage();
	}
	
	public void selectCustomer(String customer) {
		Select select=new Select(customer_dropdown);
		select.selectByVisibleText(customer);
	}
	
	public void selectProject(String project) {
		Select select=new Select(project_dropdown);
		select.selectByVisibleText(project);
	}
	
	public HomePage clickOnShowTasks() {
		showTasks_button.click();
		return new HomePage();
	}
	
	public HomePage showTasksFor(String customer,String project)
	{
		Select select=new Select(customer_dropdown);
		select.selectByVisibleText(customer);
		select=new Select(project_dropdown);
		select.selectByVisibleText(project);
		return new HomePage();
	}
	
	public int countCustomers(String customer) {
		List<WebElement> customers=driver.findElements(By.xpath("//tr[th[a[text()='Customer']]]/following-sibling::tr/td[1][contains(text(),'"+customer+"')]"));
		return customers.size();
	}
}

package com.actitime.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.base.BaseTest;

public class LoginPage extends BaseTest{
	

	
	//-----------------  Elements  -----------------------
	
	@FindBy(name="username")
	public WebElement username_textbox;
	
	@FindBy(name="pwd")
	public WebElement password_textbox;
	
	@FindBy(xpath="//input[contains(@value,'Login now')]")
	public WebElement login_button;
	
	@FindBy(xpath="//img[contains(@src,'/img/default/logo.gif')]")
	public WebElement actiTime_logo;
	
	@FindBy(xpath="//td[contains(@class,'© 2008 Actimind, Inc.')]")
	public WebElement copyright;
	
	@FindBy(xpath="a[@class='copyright']")
	public WebElement copyright_link;
	

	public LoginPage()
	{
	
		PageFactory.initElements(driver, this);
	}
	
	
	//-----------------  Methods  ------------------------
	
	public boolean validateActiTimeLogo()
	{
		
		return actiTime_logo.isDisplayed();
	}
	
	public String validateLoginTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login()
	{
		username_textbox.sendKeys("admin");
		password_textbox.sendKeys("manager");
		login_button.click();
		return new HomePage();
	}
	
	public HomePage loginWithKeyboard()
	{
		username_textbox.sendKeys("admin",Keys.TAB,"manager",Keys.ENTER);
		return new HomePage();
	}
	public String validateCopyright()
	{
		return copyright.getText();
	}
	
	public void validateCopyrightLink()
	{
		 copyright_link.click();
	}
	
	
}

package com.testautomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage {
	WebDriver driver;
	public LinkedinLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="username")
	public WebElement UserName;
	
	@FindBy(how=How.ID,using="password")
	public WebElement Password;
	
	@FindBy(how=How.XPATH,using="//button[@class='btn__primary--large from__button--floating']")
	public WebElement LoginButton;
	
	@FindBy(how=How.LINK_TEXT,using="(1) LinkedIn")
	public WebElement NamePage;
	
	
	public String NavigateToLinkedinHomePage(String Login , String Pwd) throws Exception  
	{
	
	UserName.sendKeys(Login);
	Password.sendKeys(Pwd);
	LoginButton.click();
	
	return driver.getTitle();
	}
	public String LinkedinHomePage() throws Exception  
	{
	
	return driver.getTitle();
	}

}

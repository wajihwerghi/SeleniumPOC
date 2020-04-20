package com.testautomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPage {
	WebDriver driver;
	public OrangeLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="txtUsername")
	public WebElement UserName;
	
	@FindBy(how=How.ID,using="txtPassword")
	public WebElement Password;
	
	@FindBy(how=How.XPATH,using="btnLogin")
	public WebElement LoginButton;
	
	@FindBy(how=How.LINK_TEXT,using="Mot de passe oublié?")
	public WebElement ForgotPassword;
	
	
	public void NavigateToHomePage(String LoginO , String PwdO) {
		
		UserName.sendKeys(LoginO);
		Password.sendKeys(PwdO);
		LoginButton.click();
	
	}

}

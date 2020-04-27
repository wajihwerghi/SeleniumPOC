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
	
	@FindBy(how=How.ID,using="btnLogin")
	public WebElement LoginButton;
	
	@FindBy(how=How.LINK_TEXT,using="Forgot your password?")
	public WebElement ForgotPassword;
	
	@FindBy(how=How.ID,using="logInPanelHeading")
	public WebElement LoginPanel;
	
	
	public void SaisirMotDePasse(String User , String Pwd)  {
		
		UserName.sendKeys(User);
		Password.sendKeys(Pwd);
	
	}
	
	  public void  ClickSurLeButton()  {
		
		LoginButton.click();
	
	} 
	  
	  public String getTitle() throws Exception
		{
			Thread.sleep(2000);
			return driver.getTitle();
		}
	  
	  public String linkText() {
		  
		  return LoginPanel.getText();
		  
	  }

}

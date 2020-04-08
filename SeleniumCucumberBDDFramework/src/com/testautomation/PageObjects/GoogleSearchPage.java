package com.testautomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	WebDriver driver;
	public GoogleSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME,using="q")
	public WebElement SearchTextBox;
	
	@FindBy(how=How.XPATH,using="(//input[@name='btnK'])[1]")
	public WebElement SearchButton;
	
	public void NavigateToResultPage(String LoginLink) {
		SearchTextBox.sendKeys(LoginLink);
		SearchButton.click();
	}

}

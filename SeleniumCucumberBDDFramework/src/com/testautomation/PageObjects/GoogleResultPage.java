package com.testautomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {
	WebDriver driver;
	public GoogleResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(//h3[@class='LC20lb DKV0Md'])[1]")
	public WebElement LinkLogin;
	
	public void NavigateToLinkedinLoginPage() {
		

	LinkLogin.click();
	}

}

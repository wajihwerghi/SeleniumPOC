package com.testautomation.StepDef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.testautomation.PageObjects.GoogleResultPage;
import com.testautomation.PageObjects.GoogleSearchPage;
import com.testautomation.PageObjects.LinkedinLoginPage;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LinkedinLoginValidations {
	
	PropertiesFileReader obj= new PropertiesFileReader(); 
	private WebDriver driver;
	
	
	@Given("^Open Chrome browser with URL$")
	public void open_Chrome_browser_with_URL() throws Throwable {
		
		Properties properties=obj.getProperty();
		
		driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"),properties.getProperty("browser.baseURL"));
	}

	
	@When("^Search login link \"([^\"]*)\"$")
	public void search_login_link(String LoginLink) throws Throwable {
		new GoogleSearchPage(driver).NavigateToResultPage(LoginLink);
	}

	@When("^Click on link$")
	public void click_on_link() throws Throwable {
	 new GoogleResultPage(driver).NavigateToLinkedinLoginPage();
	}


	@Then("^Saisir \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Saisir_Login_and_pwd(String Login , String Pwd) throws Throwable {
		new LinkedinLoginPage(driver).NavigateToLinkedinHomePage(Login,Pwd);
//	    String expectedChannelName="(1) LinkedIn";
//	    String actualChannelName=new LinkedinLoginPage(driver).getTitle();
	}

}

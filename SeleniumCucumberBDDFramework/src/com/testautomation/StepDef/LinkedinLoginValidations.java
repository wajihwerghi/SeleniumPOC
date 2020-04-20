package com.testautomation.StepDef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.PageObjects.GoogleResultPage;
import com.testautomation.PageObjects.GoogleSearchPage;
import com.testautomation.PageObjects.LinkedinLoginPage;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LinkedinLoginValidations extends ExtentReportListener {
	
	PropertiesFileReader obj= new PropertiesFileReader(); 
	private WebDriver driver;
	
	
	@Given("^Open Chrome browser with URL$")
	public void open_Chrome_browser_with_URL() throws Throwable {
		ExtentTest logInfo=null;
		try {
			test = extent.createTest(Feature.class, "Linkedin Login Validation");							
			test=test.createNode(Scenario.class, "Linkedin Login Validation");						
			logInfo=test.createNode(new GherkinKeyword("Given"), "Open Chrome browser with URL");
			
			Properties properties=obj.getProperty();
			
			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"),properties.getProperty("browser.baseURL"));
			logInfo.pass("Opened chrome browser and entred URL");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		
		
		
	}

	
	@When("^Search login link \"([^\"]*)\"$")
	public void search_login_link(String LoginLink) throws Throwable {
		ExtentTest logInfo=null;
		try {
								
			logInfo=test.createNode(new GherkinKeyword("When"), "Search login link");
			new GoogleSearchPage(driver).NavigateToResultPage(LoginLink);
			
			logInfo.pass("Searching LoginLink");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
		
		
	}

	@When("^Click on link$")
	public void click_on_link() throws Throwable {
		ExtentTest logInfo=null;
		try {
								
			logInfo=test.createNode(new GherkinKeyword("When"), "Click on link");
			new GoogleResultPage(driver).NavigateToLinkedinLoginPage();
			
			logInfo.pass("clicked on Link");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
		
	 
	}


	@Then("^Saisir \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Saisir_Login_and_pwd(String Login , String Pwd) throws Throwable {
		ExtentTest logInfo=null;
		try {
								
			logInfo=test.createNode(new GherkinKeyword("Then"), "Saisir Login and pwd");
			new LinkedinLoginPage(driver).NavigateToLinkedinHomePage(Login,Pwd);
//		    String expectedChannelName="(1) LinkedIn";
//		    String actualChannelName=new LinkedinLoginPage(driver).getTitle();
			logInfo.pass("saisi Login and Password");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			driver.quit();
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
		

	}

}

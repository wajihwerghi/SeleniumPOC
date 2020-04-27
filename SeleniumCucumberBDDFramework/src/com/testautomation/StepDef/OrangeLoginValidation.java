package com.testautomation.StepDef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.PageObjects.OrangeLoginPage;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeLoginValidation extends ExtentReportListener  {
	
	PropertiesFileReader obj= new PropertiesFileReader(); 
	private WebDriver driver;
	
	@Given("^je suis sur la page d'authentication$")
	public void je_suis_sur_la_page_d_authentication() throws Throwable {
		ExtentTest logInfo=null;
		try {
			test = extent.createTest(Feature.class, "valider l'authentication Orange");							
			test=test.createNode(Scenario.class,"verifier l'authentication avec username et mots de passe correcte","verifier l'authentication avec mots de passe incorrecte");						
			logInfo=test.createNode(new GherkinKeyword("Given"), "Open Chrome browser with URL orange");
			
			Properties properties=obj.getProperty();
			
			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"),properties.getProperty("browser.baseURL1"));
			logInfo.pass("Opened chrome browser and entred URL");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
	}

	@When("^Saisir le \"([^\"]*)\" et le \"([^\"]*)\"$")
	public void saisir_le_et_le(String User, String Pwd) throws Throwable {
		
		ExtentTest logInfo=null;
		try {
								
			logInfo=test.createNode(new GherkinKeyword("When"), "Saisir le Login et le pwd");
			new OrangeLoginPage(driver).SaisirMotDePasse(User,Pwd);
			logInfo.pass("saisi  le Login et le Password");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
		
	}

	@When("^Cliquer sur le bouton login$")
	public void cliquer_sur_le_bouton_login() throws Throwable {
		ExtentTest logInfo=null;
		try {
								
			logInfo=test.createNode(new GherkinKeyword("When"), "Cliquer sur le bouton login");
			new OrangeLoginPage(driver).ClickSurLeButton();	
			logInfo.pass("clique sur le bouton login");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
	  
	}
	@When("^Saisir un \"([^\"]*)\" et un \"([^\"]*)\" incorrectes$")
	public void saisir_un_et_un_incorrectes(String User, String Pwd) throws Throwable {
		ExtentTest logInfo=null;
		try {
								
			logInfo=test.createNode(new GherkinKeyword("When"), "Saisir le Login et le pwd");
			new OrangeLoginPage(driver).SaisirMotDePasse(User,Pwd);
			logInfo.pass("saisi  le Login et le Password");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	    
	}



	@Then("^acceder a la page d'acceuil$")
	public void acceder_a_la_page_d_acceuil() throws Throwable {
		ExtentTest logInfo=null;
		try {
								
			logInfo=test.createNode(new GherkinKeyword("Then"), "Acceder a la page d'acceuil");
			String expectedChannelName="OrangeHRM";
    	    String actualChannelName=new OrangeLoginPage(driver).getTitle();
    	    Assert.assertEquals(actualChannelName, expectedChannelName,"Channel names are not matching");
			logInfo.pass("accede a la page d'acceuil");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			driver.quit();
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
	   
	}	
	
	@Then("^connection invalide$")
	public void connection_invalide() throws Throwable {
	    
		ExtentTest logInfo=null;
		try {
								
			logInfo=test.createNode(new GherkinKeyword("Then"), "Acceder a la page d'acceuil");
			String expectedElementName="LOGIN Panel";
    	    String actualElementName=new OrangeLoginPage(driver).linkText();
    	    Assert.assertEquals(actualElementName, expectedElementName,"Element names are not matching");
			logInfo.pass("accede a la page d'acceuil");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			driver.quit();
		
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	}
	
}

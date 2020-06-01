package com.healthkart.regression;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.healthkart.Pages.HealthkartHomePage;

import extent.ExtentReportingBaseUtil;
import util.WebDriverUtil;

public class TestLoginFlowHealthKart extends ExtentReportingBaseUtil {

	HealthkartHomePage hm;
	@Test(priority = 1, enabled = true)
	public void testLoginAmazon() throws Exception {

		homePage.openNewTab();
		
		
		/* homePage.clickLoginButton(); */
homePage.clickonDropDown();
		
		  WebDriverUtil.staticWait(4); Assert.assertTrue(homePage.verifyHomepage(),
		  "Not verified");
		  
		  homePage.proceedToLogin(testdata.get("Username"),testdata.get("Password"));
		  
		  homePage.proceedToLogin("1111111111","auto@12345");
		  Assert.assertTrue(homePage.verifySuccessfullLogin(), "Unable to logged IN");
		  
		/* WebDriverUtil.openNewTab(driver, "https://fb.com"); */
		  homePage.searchProduct();
		  
		  System.out.println("Product has been searched sucessfully");
		 

	}
	
	@BeforeClass
	
	public void c1() {
		
		System.out.println("Class");
	}
	@AfterClass
	
	public void c2() {
		System.out.println("Class After");
		
	}
}

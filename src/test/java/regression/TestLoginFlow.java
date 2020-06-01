package regression;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import browser.base;
import extent.ExtentReportingBaseUtil;
import util.WebDriverUtil;

public class TestLoginFlow  extends ExtentReportingBaseUtil{

	
	/*
	 * homePage home=new homePage(driver); Properties prop=new Properties();
	 */	 
	/* HomePage home=new HomePage(driver); */
	
	
	
	@Test 
	public void testLogin() throws IOException {
		
		
		
		WebDriverUtil.staticWait(2);
	Assert.assertTrue(home.verifyHomepage(), "homePage not loaded");
	home.proceedToLogin();
		 registration.fillRegistrationForm(); 
		/* home.fillRegistrationForm(); */ 
	System.out.println("Success :)");
	}
}

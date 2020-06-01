package com.healthkart.Pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import browser.base;
import util.WebDriverUtil;

public class HealthkartHomePage  {

	
	
	
	
	WebDriver driver;
	
	WebDriver wait;
	
	WebDriverUtil util=new WebDriverUtil();
	
	/*
	 * //*Place all Element Here//*
	 */	
	
	By homeicon=By.xpath("(//span[text()='Search']/following::input)[1]");
	 
	By clickLogin=By.xpath("//a[contains(text(),'Login')]");
	By enterUserId=By.xpath("//input[@id='email']");
	By enterpassword=By.xpath("(//input[@name='password'])[1]");
	By submit=By.xpath("(//input[@type='submit'])[1]");
	By loginUsername=By.xpath("//span[text()='Hi User']");
	By clickSearch=By.xpath("//span[text()='Search']");
	
	By copy=By.xpath("//p[@class='copyright']//a[1]");
	
	By loginMypat=By.xpath("//a[@id='login-btn-home']");
	
	By DropDown=By.xpath("(//a[@data-toggle='dropdown'])[2]");
	
	By Day=By.xpath("//select[@title='Day']");
	By month=By.xpath("//select[@id='month']");
	By Year =By.xpath("//select[@id='year']");
	
	
	public HealthkartHomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	
	

	public boolean verifyHomepage() throws IOException {
		
		boolean flag=false;
		/* WebDriverUtil.scrollTillbottom(driver); */
		System.out.println("value of driver is "+driver);
		 if(WebDriverUtil.isElementDisplayedBy(driver, homeicon)) {
			
			System.out.println("we are on home page");
			
			flag=true;
		}
		return flag;
		
}
	
	/*
	 * public boolean verifyLoginpage() {
	 * 
	 * WebDriverUtil.staticWait(2); WebDriverUtil.mouseHover(driver,HoverSignIn);
	 * WebDriverUtil.staticWait(2); WebDriverUtil.click(clickSignIn, driver);
	 * 
	 * boolean flag=false; if (WebDriverUtil.isElementDisplayedBy(driver,loginPage))
	 * {
	 * 
	 * System.out.println("we are at login page");
	 * 
	 * flag=true; } return flag;
	 * 
	 * }
	 */
		
	public void proceedToLogin(String username,String password) {
		
		
		
		if(WebDriverUtil.isElementPresent(clickLogin, driver,5)) {
		WebDriverUtil.click(clickLogin, driver);
		
		WebDriverUtil.sendkeys(enterUserId, username, driver);
		WebDriverUtil.sendkeys(enterpassword, password, driver);

		WebDriverUtil.click(submit, driver);}
		else {
			
			System.out.println("login button not displayed");
		}
		
	}
	
	public boolean verifySuccessfullLogin() throws Exception {
		
		boolean flag=false;
		
		String loginUser=driver.findElement(loginUsername).getText();
		
		System.out.println("login user text is " +loginUser);
		
		if(loginUser.equalsIgnoreCase("Hi user")) {
			
			System.out.println("User have logged In sucessFully");
			
			flag=true;
			
		}
		return flag;
		
	}
	
	public void searchProduct() {
		
		util.staticWait(5);
		util.sendkeys(homeicon, "muscleblaze", driver);
		util.click(clickSearch, driver);
		
		
	}
	
	public void  selectFirstProduct() {
		
		
		 util.scrollToBottom(driver); 
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * jse.executeScript("arguments[0].scrollIntoView(true);", copy);
		 */
		/*
		 * java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		 * 
		 * System.out.println(links.size());
		 * 
		 * for (int i = 1; i<=links.size(); i=i+1)
		 * 
		 * {
		 * 
		 * System.out.println(i + links.get(i).getText());
		 * 
		 * links.get(10).click(); String a= driver.getCurrentUrl();
		 * 
		 * System.out.println(a); util.staticWait(2);
		 * 
		 * }
		 */
		
		  
			
			
	}
	
	public void clickLoginButton() {
		
	driver.findElement(loginMypat).click();
		
	}
	
	public void clickonDropDown() {
		
		driver.findElement(DropDown).click();
		List<WebElement> ls=driver.findElements(By.tagName("a"));
		
		System.out.println(ls.size());
		
	}
	
	public void openNewTab() {
		
		util.openNewTab(driver, "https://google.com",1);
		util.staticWait(4);
		util.openNewTab(driver, "https://fb.com",2);
		
		util.staticWait(2);
		WebElement daySelect=driver.findElement(Day);
		
		Select day=new Select(daySelect);
		
		day.selectByValue("1");
		
		WebElement monthSelect=driver.findElement(month);
		
		Select month=new Select(monthSelect);
		
		month.selectByValue("7");
		
		System.out.println("selected");
		
		
		
		
		
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs2.get(1));
		
		String verify=driver.getTitle();
		
		System.out.println(verify);
		
	}
	
}

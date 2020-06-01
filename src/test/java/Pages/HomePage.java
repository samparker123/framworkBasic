package Pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import browser.base;
import util.WebDriverUtil;

public class HomePage  {

	
	
	
	
	WebDriver driver;

	WebDriver wait;
	
	/*
	 * //*Place all Element Here//*
	 */	
	
	
	 By loginText=By.xpath("//span[text()='Login']"); 
	By homePageVerify=By.xpath("//div[@class='logo']//img[1]");
	By clickRegistrationTab=By.xpath("//ul[@id='toggleNav']/li[6]/a[1]");
	By  verifyRegistrationform=By.xpath("//h3[text()='Registration Form']");
	By name=By.xpath("(//input[@type='text' and @name='name']");
	By phone=By.xpath("//input[@type='tel']");
	By email=By.xpath("//input[@type='email']");
	By city=By.xpath("(//label[text()='City:']/following::input)[1]");
	By username=By.xpath("(//input[@name='username'])[2]");
	By password=By.xpath("(//input[@type='password'])[2]");
	By submit=By.xpath("(//input[@type='submit'])[2]");
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	/* @FindBy(xpath="//span[text()='Login']") */
	
	/* private WebElement loginText; */
	
	
	

	public boolean verifyHomepage() throws IOException {
		
		boolean flag=false;
		/* WebDriverUtil.scrollTillbottom(driver); */
		System.out.println("value of driver is "+driver);
		 if(WebDriverUtil.isElementDisplayedBy(driver, homePageVerify)) {
			
			System.out.println("we are on home page");
			
			flag=true;
		}
		return flag;
		
}
public void proceedToLogin() throws IOException {
		
		boolean result=verifyHomepage();
		
		if(result=true) {
			
			WebDriverUtil.click(clickRegistrationTab, driver);
		}
	}
	
	
	
}

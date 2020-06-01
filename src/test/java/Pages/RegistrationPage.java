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

public class RegistrationPage  {

	
	Properties prop=new Properties();
	
	
	
	WebDriver driver;

	WebDriver wait;
	
	/*
	 * //*Place all Element Here//*
	 */	
	 
	By name=By.xpath("//input[@type='text' and @name='name']");
	By phone=By.xpath("//input[@type='tel']");
	By email=By.xpath("//input[@type='email']");
	By city=By.xpath("(//label[text()='City:']/following::input)[1]");
	By username=By.xpath("(//input[@name='username'])[2]");
	By password=By.xpath("(//input[@type='password'])[2]");
	By submit=By.xpath("(//input[@type='submit'])[2]");
	
	public RegistrationPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	/* @FindBy(xpath="//span[text()='Login']") */
	
	/* private WebElement loginText; */
	
	public void fillRegistrationForm() {
		
		WebDriverUtil.staticWait(4);
		System.out.println("going to fill registration form");
		try {
			
			WebDriverUtil.staticWait(4);
			WebDriverUtil.switchTabs(driver, "1");
				System.out.println("enter name ");
			 WebDriverUtil.sendkeys(name,"shivamtest",driver); 
				
			/* WebDriverUtil.sendkeys(name,prop.getProperty("Name"),driver); */
				
				WebDriverUtil.sendkeys(phone,"9898989898",driver);
				WebDriverUtil.sendkeys(email,"rockingmishra888@gmail.com",driver);
				WebDriverUtil.sendkeys(city,"gurgaon",driver);
				WebDriverUtil.sendkeys(username,"TestUser1",driver);
				WebDriverUtil.sendkeys(password,"abcdef",driver);
				WebDriverUtil.click(submit, driver);
				System.out.println("Form has been submitted");
			
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
}

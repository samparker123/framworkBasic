package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.base;

public class WebDriverUtil {

	WebDriver driver;
	public static void staticWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public static boolean isElementPresent(By by,WebDriver driver,int seconds) {
			  try {
			    driver.findElement(by);
			    return true;
			  }
			catch (org.openqa.selenium.NoSuchElementException e) {
			    return false;
			  }
			}
		
		 public static void click(By elementLocation,WebDriver driver) {
		        driver.findElement(elementLocation).click();
		    }
		
		 public static void sendkeys(By elementLocation,String text,WebDriver driver) {
			 
			 driver.findElement(elementLocation).clear();
			 driver.findElement(elementLocation).sendKeys(text);
		 }
		 
		 public static void setKeyboardKey(By elementLocation, Keys key,WebDriver driver) {

		        driver.findElement(elementLocation).sendKeys(key);

		    }
		 
		 public static void scrollpage(String direction,WebDriver driver) {
			 
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
			 if(direction=="down") {
			 jse.executeScript("window.scrollBy(0,250)");
		 }
			 else if(direction=="up") {
				 jse.executeScript("window.scrollBy(0,-250)");
			 }
		 }
		 
		 public static void openNewTab(WebDriver driver,String string,int tabno) {
			 
			 ((JavascriptExecutor) driver).executeScript("window.open()");
			 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			 driver.switchTo().window(tabs.get(tabno));
			 driver.get(string);
		 }
		 
		 public static void waitForElementToBeDisplayedBy(WebDriver driver, int seconds, By by) {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}
		 
		 public static boolean isElementDisplayedBy(WebDriver driver, By by)
		    {
				boolean flag = false;
		    	try
		    	{
		    		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    		flag = driver.findElement(by).isDisplayed();
		    		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		    		return flag;
		    	}
		    	catch(NoSuchElementException e)
		    	{
		    		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		    		return flag;
		    	}
		    }
		 
		 public static void switchTabs(WebDriver driver,String tab) {
			 
			 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			 if(tab=="1") {
			 driver.switchTo().window(tabs.get(1));
			 }
			 else if(tab=="2")
			 driver.switchTo().window(tabs.get(2));
		 }
		 
		 public static void  mouseHover(WebDriver driver,By elementLocation) {
			 
			 Actions builder = new Actions(driver);
			 WebElement element = driver.findElement(elementLocation);
			 builder.moveToElement(element).build().perform();
		 }
		 
		 public static String getUrl(WebDriver driver) {
			 
			String url= driver.getCurrentUrl();
			return url;
		 }
		 
		 public static void scrollToBottom(WebDriver driver) {
			 
			 ((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 }
	}
	

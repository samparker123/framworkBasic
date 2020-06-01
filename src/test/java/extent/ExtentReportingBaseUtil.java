package extent;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.healthkart.Pages.HealthkartHomePage;

import Pages.HomePage;
import Pages.RegistrationPage;
import browser.base;


/*import com.aventstack.extentreports.LogStatus;
*/public class ExtentReportingBaseUtil{

	protected WebDriver driver;
	protected Map<String,String> testdata;
	private util.DataProvider data;
	protected HomePage home;
	protected RegistrationPage registration;
	protected HealthkartHomePage homePage;
	@BeforeMethod
	
	public void setup() throws IOException {
		
		data=new util.DataProvider();
		data.loadMap();
		testdata=data.getDataMap();
		driver=base.initilizeDriver();
		home=PageFactory.initElements(driver, HomePage.class);
		registration=PageFactory.initElements(driver, RegistrationPage.class);
		homePage=PageFactory.initElements(driver, HealthkartHomePage.class);
		
	}
	 @AfterMethod 
	public void afterMethod() {
		
		driver.quit();
	
	}
	
	/*
	 * @BeforeClass public static void startTest() { report = new ExtentReports
	 * (System.getProperty("user.dir")+"\\ExtentReportResults.html"); test =
	 * report.startTest("ExtentDemo"); }
	 */
}

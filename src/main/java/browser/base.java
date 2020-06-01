package browser;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class base {

	
	
	public static  WebDriver driver;
	private static Properties masterProp = null;

	@BeforeMethod
	public static WebDriver initilizeDriver() throws IOException {
		
		
	
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\MyNewProject\\myTest\\data.properties");
	 
		prop.load(fis);
	String browserName=	prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		prop.setProperty("webdriver.chrome.driver", "D:\\MyNewProject\\myTest\\chromedriver.exe");
	
	 driver=new ChromeDriver(options);
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 options.addArguments("enable-automation");
	 options.addArguments("--headless");
	 options.addArguments("--window-size=1920,1080");
	 options.addArguments("--no-sandbox");
	 options.addArguments("--disable-extensions");
	 options.addArguments("--dns-prefetch-disable");
	 options.addArguments("--disable-gpu");
	 
			 driver.get((String) prop.get("url1")); 
	
	}
	else if (browserName.equals("firefox")) {
		
		
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	}
	
	
}

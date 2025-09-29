package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {

	Properties prop;
	FileInputStream fs;
	
	public WebDriver driver;
	
	@Parameters("browsers")
	@BeforeMethod(alwaysRun=true)
		public void initialiseBrowser(String browsers) throws Exception {
		
		prop = new Properties();
		fs = new FileInputStream(Constants.CONFIGPATH);
		prop.load(fs);
		
		if(browsers.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver();
		 driver= new EdgeDriver();
		}
		else {
			throw new Exception("Invalid browser");
		}
		    // WebDriverManager.edgedriver().setup();
			driver.get(prop.getProperty("url"));
			
			driver.manage().window().maximize();
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		
	  @AfterMethod(alwaysRun=true)
	  public void driverQuit(ITestResult iTestResult) throws IOException {
		//ITestResult is an interface which contain details of test execution
		//getStatus() is a method of the ITestResult interface. getStatus() returns the result status of the test
		  if (iTestResult.getStatus() == ITestResult.FAILURE) {

		  ScreenshotUtility screenShot = new ScreenshotUtility();
	    // Capture and save screenshot using the test method's name
		  screenShot.getScreenshot(driver, iTestResult.getName());
		  }
		 // driver.quit();

		  }
		
}

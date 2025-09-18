package automationcore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class Base {

	public WebDriver driver;
	
	  @BeforeMethod
		public void initialiseBrowser() {
			
			driver= new ChromeDriver();
			//driver= new FirefoxDriver();
		    // WebDriverManager.edgedriver().setup();
			// driver= new EdgeDriver();	
			driver.get("https://groceryapp.uniqassosiates.com/admin/login");
			driver.manage().window().maximize();
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		
	  @AfterMethod
	  public void driverQuit(ITestResult iTestResult) throws IOException {
		// iTestResult interface
		  if (iTestResult.getStatus() == ITestResult.FAILURE) {

		  ScreenshotUtility screenShot = new ScreenshotUtility();
		  screenShot.getScreenshot(driver, iTestResult.getName());
		  }
		 // driver.quit();

		  }
		
}

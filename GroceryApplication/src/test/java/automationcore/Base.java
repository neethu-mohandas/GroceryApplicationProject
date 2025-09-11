package automationcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
		}
		
	  @AfterMethod
		public void browserClose() {
		//	driver.close();
		//	driver.quit();
		}
		
}

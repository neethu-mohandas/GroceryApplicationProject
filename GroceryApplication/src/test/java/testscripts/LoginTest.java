package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	HomePage homepage;
	
	@Test(groups={"smoke"},priority=1,description="User login using valid username and valid password",retryAnalyzer = retry.Retry.class)
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		
		homepage = loginPage.clickOnLoginButton();
		
		boolean dashboarddisplay = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay,Constants.VALIDCREDENTIALERROR);
	}
	
	@Test(priority=2,description="User login using invalid username and valid password")
	   public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {
			
			String usernameValue= ExcelUtility.readStringData(1, 0, "LoginPage");
			String passwordValue=ExcelUtility.readStringData(1, 1, "LoginPage");
			LoginPage loginPage=new LoginPage(driver);
			
			loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickOnLoginButton();
			
			String actual =loginPage.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDUSERNAMEERROR);
		}
		
		@Test(priority=3, description="User login using valid username and invalid password")
	    public void verifyLoginWithValidUsernameAndInvalidPassword() throws IOException {
			
			String usernameValue= ExcelUtility.readStringData(2, 0, "LoginPage");
			String passwordValue=ExcelUtility.readStringData(2, 1, "LoginPage");
			LoginPage loginPage=new LoginPage(driver);
			
			loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickOnLoginButton();
			
			String actual =loginPage.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDPASSWORDERROR);
		}
		
		@Test(groups={"smoke"},priority=4,description="User login using invalid username and invalid password",dataProvider = "loginProvider")
	   public void verifyLoginWithInvalidCredentials(String usernameValue, String passwordValue) throws IOException {
			
			//String usernameValue= ExcelUtility.readStringData(3, 0, "LoginPage"); //commenting since taking data from dataProvider
			//String passwordValue=ExcelUtility.readStringData(3, 1, "LoginPage"); //commenting since taking data from dataProvider
			LoginPage loginPage=new LoginPage(driver);
			
			loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickOnLoginButton();
			
			String actual =loginPage.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALSERROR);	
		}
	
		@DataProvider(name = "loginProvider")
		public Object[][] getDataFromDataProvider() throws IOException {

			return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
					// new Object[] {ExcelUtility.getStringData(3,
					// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
			};
		}
}

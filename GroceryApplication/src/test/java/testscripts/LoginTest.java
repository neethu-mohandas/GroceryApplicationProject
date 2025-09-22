package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	@Test(groups={"smoke"})
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnLoginButton();
		
		boolean dashboarddisplay = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay,Constants.VALIDCREDENTIALERROR);
	}
	
	@Test
	   public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {
			
			String usernameValue= ExcelUtility.readStringData(1, 0, "LoginPage");
			String passwordValue=ExcelUtility.readStringData(1, 1, "LoginPage");
			LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUsernameOnUsernameField(usernameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickOnLoginButton();
			
			String actual =loginPage.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDUSERNAMEERROR);
		}
		
		@Test
	    public void verifyLoginWithValidUsernameAndInvalidPassword() throws IOException {
			
			String usernameValue= ExcelUtility.readStringData(2, 0, "LoginPage");
			String passwordValue=ExcelUtility.readStringData(2, 1, "LoginPage");
			LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUsernameOnUsernameField(usernameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickOnLoginButton();
			
			String actual =loginPage.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDPASSWORDERROR);
		}
		
		@Test(groups={"smoke"})
	   public void verifyLoginWithInvalidCredentials() throws IOException {
			
			String usernameValue= ExcelUtility.readStringData(3, 0, "LoginPage");
			String passwordValue=ExcelUtility.readStringData(3, 1, "LoginPage");
			LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUsernameOnUsernameField(usernameValue);
			loginPage.enterPasswordOnPasswordField(passwordValue);
			loginPage.clickOnLoginButton();
			
			String actual =loginPage.getPageTitle();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constants.INVALIDCREDENTIALSERROR);	
		}
		
}

package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	
	HomePage homepage;

	@Test(description="Verify that user can log out")
	public void verifyUserAbleToLogout() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		
		homepage = loginPage.clickOnLoginButton();
		
		homepage.clickOnAdmin();
		
		loginPage = homepage.clickOnLogout();
		
		String actual =loginPage.getPageTitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constants.LOGOUTERROR);
	}
	
	@Test
	public void verifyClickOnAdminUsersMoreInfo() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnLoginButton();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAdminUsersMoreInfo();
	}
	
}

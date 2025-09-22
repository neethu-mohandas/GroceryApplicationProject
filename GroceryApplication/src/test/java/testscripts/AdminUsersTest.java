package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{

	@Test
	public void verifyUserAbleToAddNewUser() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnLoginButton();
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAdminUsersMoreInfo();
		
		AdminUsersPage adminusersPage=new AdminUsersPage(driver);
		RandomDataUtility randomdata = new RandomDataUtility();
		adminusersPage.clickOnNew();
		
		String newUsername= randomdata.randomUsername();
		String newPassword= randomdata.randomPassword();
		
		adminusersPage.enterNewUsername(newUsername); //random username will be entered using faker class
		adminusersPage.enterNewPassword(newPassword); //random password will be entered using faker class
		adminusersPage.selectNewUserType();
		adminusersPage.clickOnNewSave();
		
		String adminuserssuccessmessage=adminusersPage.adminUsersSaveSuccessMsgTexts();
		Assert.assertTrue(adminuserssuccessmessage.contains("User Created Successfully"),Constants.ADDNEWADMINUSERERROR);
	}
	
	@Test
	public void verifyUserAbleToSearchNewlyAddedUser() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnLoginButton();
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAdminUsersMoreInfo();
		
		String searchUsername=ExcelUtility.readStringData(0, 0, "AdminUsersPage");
		AdminUsersPage adminusersPage=new AdminUsersPage(driver);
		adminusersPage.clickOnSearch();
		adminusersPage.enterSearchUsername(searchUsername);
		adminusersPage.selectSearchUserType();
		adminusersPage.clickOnSearchAdminUser();
		
		boolean userssearchtabledisplay = adminusersPage.isUserSearchTableDisplayed();
		Assert.assertTrue(userssearchtabledisplay,Constants.SEARCHADMINUSERERROR);
	}
	
	
	@Test
	public void verifyUserAbleToResetUserList() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnLoginButton();
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAdminUsersMoreInfo();
		
		AdminUsersPage adminusersPage=new AdminUsersPage(driver);
		adminusersPage.clickOnReset();
		
		boolean adminuserstabledisplay = adminusersPage.isAdminusersTableDisplayed();
		Assert.assertTrue(adminuserstabledisplay,Constants.RESETADMINUSERERROR);
	}
	
}

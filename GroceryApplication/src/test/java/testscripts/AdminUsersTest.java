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
	
	HomePage homepage;
	AdminUsersPage adminuserspage;

	@Test(description="Verify that user can add a new admin user")
	public void verifyUserAbleToAddNewUser() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		
		homepage = loginPage.clickOnLoginButton();
		
		adminuserspage = homepage.clickOnAdminUsersMoreInfo();
		
		RandomDataUtility randomdata = new RandomDataUtility();
		adminuserspage.clickOnNew();
		
		String newUsername= randomdata.randomUsername();
		String newPassword= randomdata.randomPassword();
		
		//random username and random password will be entered using faker class
		adminuserspage.enterNewUsername(newUsername).enterNewPassword(newPassword).selectNewUserType().clickOnNewSave();
		
		String adminuserssuccessmessage=adminuserspage.adminUsersSaveSuccessMsgTexts();
		Assert.assertTrue(adminuserssuccessmessage.contains("User Created Successfully"),Constants.ADDNEWADMINUSERERROR);
	}
	
	@Test(description="Verify that user can search an admin user")
	public void verifyUserAbleToSearchNewlyAddedUser() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		
		homepage = loginPage.clickOnLoginButton();
		
		adminuserspage = homepage.clickOnAdminUsersMoreInfo();
		
		String searchUsername=ExcelUtility.readStringData(0, 0, "AdminUsersPage");
		
		adminuserspage.clickOnSearch().enterSearchUsername(searchUsername).selectSearchUserType().clickOnSearchAdminUser();
		
		boolean userssearchtabledisplay = adminuserspage.isUserSearchTableDisplayed();
		Assert.assertTrue(userssearchtabledisplay,Constants.SEARCHADMINUSERERROR);
	}
	
	@Test(description="Verify that user can refresh the admin users list")
	public void verifyUserAbleToResetUserList() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		
		homepage = loginPage.clickOnLoginButton();
			
		adminuserspage = homepage.clickOnAdminUsersMoreInfo();
		
		adminuserspage.clickOnReset();
		
		boolean adminuserstabledisplay = adminuserspage.isAdminusersTableDisplayed();
		Assert.assertTrue(adminuserstabledisplay,Constants.RESETADMINUSERERROR);
	}
	
}

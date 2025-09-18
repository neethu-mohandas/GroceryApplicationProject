package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test
	public void verifyUserAbleToAddNews() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnLoginButton();
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnManageNewsMoreInfo();

		String newsTitle=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		ManageNewsPage managenewsPage=new ManageNewsPage(driver);
		managenewsPage.clickOnNewNewsButton();
		managenewsPage.enterNewsOnTextarea(newsTitle);
		managenewsPage.clickOnSaveNews();
		
		String newssuccessmessage=managenewsPage.newsSaveSuccessMsgTexts();
		Assert.assertTrue(newssuccessmessage.contains("News Created Successfully"), "Entered news not saved");
}
	
	@Test
	public void verifyUserAbleToSearchNews() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnLoginButton();
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnManageNewsMoreInfo();

		String newsTitle=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		ManageNewsPage managenewsPage=new ManageNewsPage(driver);
		managenewsPage.clickOnNewsSearch();
		managenewsPage.enterNewsTitleForSearch(newsTitle);
		managenewsPage.clickOnNewsSearchSubmit();
		
		String actual =managenewsPage.newsSearchResults();
		String expected="Sample test news data";
		Assert.assertEquals(actual, expected,"User not able to get correct search results");
	}
	
	@Test
	public void verifyUserAbleToResetNews() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnLoginButton();
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnManageNewsMoreInfo();

		ManageNewsPage managenewsPage=new ManageNewsPage(driver);
		managenewsPage.clickOnNewsReset();
		
		boolean newstabledisplay = managenewsPage.isNewsTableDisplayed();
		Assert.assertTrue(newstabledisplay,"User couldnot reset the news");	
	}
		
}

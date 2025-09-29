package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	HomePage homepage;
	ManageNewsPage managenewspage;
	
	@Test(description="Verify that user can add news")
	public void verifyUserAbleToAddNews() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		
		homepage = loginPage.clickOnLoginButton();
		
		managenewspage = homepage.clickOnManageNewsMoreInfo();

		String newsTitle=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		
		managenewspage.clickOnNewNewsButton().enterNewsOnTextarea(newsTitle).clickOnSaveNews();
		
		String newssuccessmessage=managenewspage.newsSaveSuccessMsgTexts();
		Assert.assertTrue(newssuccessmessage.contains("News Created Successfully"),Constants.ADDNEWSERROR);
     }
	
	@Test(description="Verify that user can search for news")
	public void verifyUserAbleToSearchNews() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		
		homepage = loginPage.clickOnLoginButton();
		
		managenewspage = homepage.clickOnManageNewsMoreInfo();

		String newsTitle=ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		
		managenewspage.clickOnNewsSearch().enterNewsTitleForSearch(newsTitle).clickOnNewsSearchSubmit();
		
		String actual =managenewspage.newsSearchResults();
		String expected="Sample test news data";
		Assert.assertEquals(actual, expected,Constants.SEARCHNEWSERROR);
	}
	
	@Test(description="Verify that user can refresh the news list")
	public void verifyUserAbleToResetNews() throws IOException {
		String usernameValue= ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		
		homepage = loginPage.clickOnLoginButton();
		
		managenewspage = homepage.clickOnManageNewsMoreInfo();

		managenewspage.clickOnNewsReset();
		
		boolean newstabledisplay = managenewspage.isNewsTableDisplayed();
		Assert.assertTrue(newstabledisplay,Constants.RESETNEWSERROR);	
	}
		
}

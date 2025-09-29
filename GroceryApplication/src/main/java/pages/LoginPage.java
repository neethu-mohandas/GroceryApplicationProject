package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	// Constructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	 // Locators
	@FindBy(name="username") private WebElement username;
	@FindBy(name="password") private WebElement password;
	@FindBy(xpath="//button[text()='Sign In']") private WebElement login;
	@FindBy(xpath="//p[text()='Dashboard']") private WebElement dashboardtext;
	@FindBy(xpath="//b[text()='7rmart supermarket']") private WebElement loginpagetitle;
	
	// Actions
	public LoginPage enterUsernameOnUsernameField(String usernameValue) {
		username.sendKeys(usernameValue);
		return this;
	}
	
    public LoginPage enterPasswordOnPasswordField(String passwordValue) {	
	password.sendKeys(passwordValue);
	return this;
	}
	
	 public HomePage clickOnLoginButton() {
		login.click();
		return new HomePage(driver);
	}
	 
	 public boolean isDashboardDisplayed() {
		 return dashboardtext.isDisplayed();
	 }
	 
	 public String getPageTitle() {
		  return loginpagetitle.getText();
	 }
	 
}

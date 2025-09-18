package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {


	public WebDriver driver;
	
	// Constructor
	public AdminUsersPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	 // Locators
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") private WebElement newbutton;
	@FindBy(xpath="//input[@id='username']") private WebElement newusername;
	@FindBy(xpath="//input[@id='password']") private WebElement newpassword;
	@FindBy(id="user_type") private WebElement newusertypedropdown;
	@FindBy(xpath="//button[@name='Create']") private WebElement savenewuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchbutton;
	@FindBy(xpath="//input[@id='un']") private WebElement searchusername;
	@FindBy(id="ut") private WebElement searchusertypedropdown;
	@FindBy(xpath="//button[@name='Search']") private WebElement searchadminuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") private WebElement resetbutton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement newadminusersuccessalerts;
	@FindBy(xpath="//a[@class='page-link']") private WebElement usersearchresulttable;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']") private WebElement adminuserstable;
	
	
	// Actions
	public void clickOnNew() {
		newbutton.click();
	}
	
	public void enterNewUsername(String newUsername) {
		newusername.sendKeys(newUsername);
	}
	
	public void enterNewPassword(String newPassword) {
		newpassword.sendKeys(newPassword);
	}
	
	public void selectNewUserType() {
		Select select =new Select(newusertypedropdown);
		select.selectByValue("staff");
	}
	
	public void clickOnNewSave() {
		savenewuser.click();
	}
	
	public void clickOnSearch() {
		searchbutton.click();
	}
	
	public void enterSearchUsername(String searchUsername) {
		searchusername.sendKeys(searchUsername);
	}
	
	public void selectSearchUserType() {
		Select select =new Select(searchusertypedropdown);
		select.selectByValue("staff");
	}
	
	public void clickOnSearchAdminUser() {
		searchadminuser.click();
	}
	
	public void clickOnReset() {
		resetbutton.click();
	}
	
	public String adminUsersSaveSuccessMsgTexts() {
	    String userdialogtexts = newadminusersuccessalerts.getText();
	    System.out.println(userdialogtexts);
	    return userdialogtexts;
	}

	 public boolean isUserSearchTableDisplayed() {
		 return usersearchresulttable.isDisplayed();
	 }
	 
	 public boolean isAdminusersTableDisplayed() {
		 return adminuserstable.isDisplayed();
	 }
	 
}

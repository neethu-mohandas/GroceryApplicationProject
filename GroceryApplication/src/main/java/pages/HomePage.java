package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement admin;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logout;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	private WebElement adminusersmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	private WebElement managenewsmoreinfo;

	// Actions
	public HomePage clickOnAdmin() {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogout() {
		logout.click();
		return new LoginPage(driver);
	}

	public AdminUsersPage clickOnAdminUsersMoreInfo() {
		adminusersmoreinfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickOnManageNewsMoreInfo() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

}

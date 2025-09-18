package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
	
	// Constructor
	public ManageNewsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	 // Locators
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") private WebElement newnewsbutton;
	@FindBy(id="news") private WebElement enternewstextarea;
	@FindBy(xpath="//button[@name='create']") private WebElement savenews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchnewsbutton;
	@FindBy(xpath="//input[@name='un']") private WebElement searchnewstitle;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") private WebElement newssearchsubmit;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") private WebElement resetnewsbutton;
	
	//assertion elements
	//@FindBy(xpath="//h5[text()=' Alert!']") private WebElement addnewssuccess;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement newssuccessalerts;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody/tr[1]/td[1]") private WebElement newssearchresulttable;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']") private WebElement newstable;

	// Actions
		public void clickOnNewNewsButton() {
			newnewsbutton.click();
		}

		public void enterNewsOnTextarea(String newsTitle) {
			enternewstextarea.sendKeys(newsTitle);
		}
		
		public void clickOnSaveNews() {
			savenews.click();
		}
		/*
		public boolean successNewsDisplayed() {
				 return addnewssuccess.isDisplayed();
			 }
		*/
		public String newsSaveSuccessMsgTexts() {
		    String dialogtexts = newssuccessalerts.getText();
		    System.out.println(dialogtexts);
		    return dialogtexts;
		}

		public void clickOnNewsSearch() {
			searchnewsbutton.click();
		}
		
		public void enterNewsTitleForSearch(String newsTitle) {
			searchnewstitle.sendKeys(newsTitle);
		}
		public void clickOnNewsSearchSubmit() {
			newssearchsubmit.click();
		}
		
		public String newsSearchResults() {
		    String searchresultstexts = newssearchresulttable.getText();
		    System.out.println(searchresultstexts);
		    return searchresultstexts;
		}
		
		public void clickOnNewsReset() {
			resetnewsbutton.click();
		}
		 public boolean isNewsTableDisplayed() {
			 return newstable.isDisplayed();
		 }
		 
		
}

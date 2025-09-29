package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	 // Select drop down by value
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);
	}
	
	// Select drop down by visible text
    public void selectDropdownWithVisibleText(WebElement element, String text) {
    	
        Select object = new Select(element);
        object.selectByVisibleText(text);
    }
    
    // Select drop down by index
    public void selectDropdownWithIndex(WebElement element, int index) {
    	
        Select object = new Select(element);
        object.selectByIndex(index);
    }
    
   // Performs right-click
    public void mouseRightClick(WebDriver driver, WebElement element) {
    	
    	Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
    }
    
    // Performs mouse hover
    public void mouseHoverAnElement(WebDriver driver, WebElement element) {
    	
    	Actions action=new Actions(driver);
   	    action.moveToElement(element).build().perform();		
    }
    
    // Performs drag and drop
    public void dragAndDropElements(WebDriver driver, WebElement dragElement, WebElement dropElement) {
    	
		Actions action=new Actions(driver);
		action.dragAndDrop(dragElement, dropElement).build().perform();	
    }
    
     //Perform scroll
    public void scrollByPixels(WebDriver driver,int x, int y) {
    	
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
    }

   
}

package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {

		// TakesScreenshot - interface
		// Cast the WebDriver instance to TakesScreenshot to enable screenshot
		// capability
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		// Capture the screenshot and store it as a file object
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		// Generate a timestamp string to append to the screenshot filename
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		// Create a File object for the OutputScreenShot directory within the project
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");
		// Check if the screenshot directory does not exist
		if (!f1.exists()) {
			// Create the directory if it doesn't already exist
			f1.mkdirs();
		}
		// Define the full destination path for the screenshot file including the test
		// case name and timestamp
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
		// ".png";

		// Create a File object for the final destination of the screenshot
		File finalDestination = new File(destination);
		// Copy the captured screenshot to the specified destination path
		FileHandler.copy(screenShot, finalDestination);
	}

}

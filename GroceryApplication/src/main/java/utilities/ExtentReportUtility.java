package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	public static final ExtentReports extentReports = new ExtentReports();// static instance of ExtentReports that can 
	//be shared across the application

	public synchronized static ExtentReports createExtentReports() {

	// Creates an HTML reporter and defines the output file path for the report
	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
	reporter.config().setReportName("7RMartSupermarketProject"); //set the name or title of the report
	extentReports.attachReporter(reporter); // Attaches the configured reporter to the ExtentReports instance
	
	extentReports.setSystemInfo("Organization", "Obsqura");
	extentReports.setSystemInfo("Name", " Neethu"); // provides context of the report
	return extentReports; //Returns the configured ExtentReports instance to be used across tests

	}

}

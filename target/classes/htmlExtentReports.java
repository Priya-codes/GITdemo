package resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class htmlExtentReports {
	static ExtentReports extent;
 @BeforeTest
 public static ExtentReports extentReport()
 {
	 //ExtentRxeports ExtentSparkReporter
	 String path=System.getProperty("user.dir")+"\\reports\\index.html";
	 ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	 reporter.config().setReportName("WebAutomation Report");
	 reporter.config().setDocumentTitle("Test Report");
	 
	  extent= new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Tester", "Priya");
	 return extent;
 }
 
}

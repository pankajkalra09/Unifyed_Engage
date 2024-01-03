package Unifyed.Unifyed_Engage.CommonUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterTestNG {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Sanity Testing Report");
		reporter.config().setDocumentTitle("Test Report");
		
		ExtentReports extent = new ExtentReports(); // 1. creating object of ExtentReports
		extent.attachReporter(reporter); //2. here we are attaching reporter that is telling us the config/metadata we have made.
		extent.setSystemInfo("QA", "Philip Parker");
		//extent.createTest(path); //3. This will create entry for our test. We need not to write this for each and every test,
								//so to overcome this we have TestNGListeners, so we will create a class under Test called Listeners.
		return extent;
	}
	
}

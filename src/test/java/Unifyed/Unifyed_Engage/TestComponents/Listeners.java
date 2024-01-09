package Unifyed.Unifyed_Engage.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Unifyed.Unifyed_Engage.CommonUtils.ExtentReporterTestNG;

public class Listeners extends BaseClass implements ITestListener{
	//ITestListener is one of the interface provided by TestNG. SO when we implement it we have to utilize the methods.
	// As the name suggested every method perform a specific task. 
	//So if we want to take screenshot in case of test fail only, we will write the screenshot code there only.
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterTestNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();// if we want to run parellel tests with thread safety.
	@Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub	
		// we want the report to get generated at the start of every test. so we are using below statement.
		// this class is not aware about extent, so we are returning the extent object from ExtentReporterTestNG and change the method to static.
		//createTest needs the name of the Test we want to execute so we use result object.
		//now every test when reaches here and we are dynamically retrieving the test case name using getmethodname.
		test = extent.createTest(result.getMethod().getMethodName());	
		//let's say we are running parallely in this case test object got overridden by the second instance that is running parallely.
		//to Overcome this problem we will use ThreadLocal class and it will assign a unique threadID to each test.
		extentTest.set(test); //unique thread id is created.
    }
	
	@Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub	
		//since we have a unique thread id for each test so replace test with extentTent.get().
		//extentTest.get().log(Status.PASS, "Test Passed");
		test.log(Status.PASS, "Test Passed");
        		
    }
	
	@Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub				
		extentTest.get().log(Status.FAIL, "Test Failed"); //print log message.
		extentTest.get().fail(result.getThrowable()); // this will return the error as well.
		
		//we need to pass life to the driver so this try cathc block helps  us in achieving the same.
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		// we want to take screenshot once our test got failed.
		// screenshot taking code is in BaseClass so we need to extend that class.
		String filePath = null;
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());	
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }	
    
    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }
    
    @Override		
    public void onStart(ITestContext context) {					
        // TODO Auto-generated method stub				
        		
    }
	
	@Override		
    public void onFinish(ITestContext context) {					
        // TODO Auto-generated method stub				
        		extent.flush();
        		
    }		

    //Our TestNG.xml should recognize the Listeners, so we have to modify our testng.xml.
    //

    		

    		
	

}

package Unifyed.Unifyed_Engage.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int count=0;
	int maxTry=2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry) {
			//to rerun we expect this method to return true. As long as this returns true our test keeps on retrying.
			//by default it returns false, if we want to retry run.
			count++; //here we are incrementing count as we don't want to run again.
			return true;
			//so suppose next time again test fail and it reaches to this method, now count=1, so which means we have reached max try to test will not run again.
			
		}
		return false; //the moment w retun false, it means that this method stop retrying
	}
	//whenever test fails it comes inside this method and confirm if this test needs to be rerun.
	//so inside this method we have to write the logic to rerun the test cases, how many times.
	//all the test metadata(details) are stored in result variable.
	
	//to make our test aware about this, we need to include class name with @test
	

}

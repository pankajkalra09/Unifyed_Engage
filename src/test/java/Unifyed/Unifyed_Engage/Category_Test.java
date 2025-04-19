package Unifyed.Unifyed_Engage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Unifyed.Unifyed_Engage.AdminPages.AdminCategoryListingClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminLandingPageClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminLoginPageClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminPreferencePageClass;
import Unifyed.Unifyed_Engage.CommonUtils.DataDriven;
import Unifyed.Unifyed_Engage.TestComponents.BaseClass;
import Unifyed.Unifyed_Engage.TestComponents.Retry;
//8c8f14a683d71e4707eac3aebd5a025cc280da19
public class Category_Test extends BaseClass{
	
	String categoryName = "AutomationCategory";
	
	AdminCategoryListingClass categorylistmethod = new AdminCategoryListingClass(driver);
	AdminLandingPageClass landingPage = new AdminLandingPageClass(driver);

	DataDriven datadriven = new DataDriven();
	
	@Test (priority=1, retryAnalyzer=Retry.class)	
	public void categoryCreate() throws Exception {	
		loginpage = new AdminLoginPageClass(driver);
		//AdminLandingPageClass landingPage = loginpage.loginMethodMethod(prop.getProperty("username"), prop.getProperty("password"));
		AdminLandingPageClass landingPage = loginpage.loginMethodMethod(prop.getProperty("username"), prop.getProperty("password"));
		landingPage.landingHamburgerMethod();
		AdminPreferencePageClass preferencePage = landingPage.landingPreferencesMethod();
		categorylistmethod = preferencePage.preferenceManageCategoryMethod();
		categorylistmethod.categoryCreationMethod(categoryName);
		//test
	}
	  @Test (priority=2, enabled=true, retryAnalyzer=Retry.class)	
	  public void categoryEdit() throws InterruptedException {
	  categorylistmethod.CategoryEditMethod(categoryName); 
	  }
	  
	  @Test (priority=3, enabled=true, retryAnalyzer=Retry.class)	
	  public void categoryDelete() throws InterruptedException {
	  categorylistmethod.categoryDeleteMethod(categoryName); 
	  }
	  
	  //checking branching
	  //new changes
	  //pankajBranch
	  
	/*
	 * @DataProvider public Object[][] getLogin() throws IOException{
	 * List<HashMap<String, String>> data =
	 * readerToMap(System.getProperty("user.dir")
	 * +"//src//main//java//Unifyed//Unifyed_Engage//Resources//jsonData.json");
	 * 
	 * return new Object[][] {{data.get(0)}, {data.get(1)}}; }
	 */
}



package Unifyed.Unifyed_Engage;

import java.io.IOException;

import org.testng.annotations.Test;

import Unifyed.Unifyed_Engage.AdminPages.AdminLandingPageClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminLoginPageClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminMyDriveClass;
import Unifyed.Unifyed_Engage.TestComponents.BaseClass;
import Unifyed.Unifyed_Engage.TestComponents.Retry;

public class MyDrive_Test extends BaseClass{
	
	AdminLandingPageClass landingPage = new AdminLandingPageClass(driver);

	
	@Test (priority=1, retryAnalyzer=Retry.class)	
	public void loginAdminside() throws Exception {	
		loginpage = new AdminLoginPageClass(driver);
		//AdminLandingPageClass landingPage = loginpage.loginMethodMethod(prop.getProperty("username"), prop.getProperty("password"));
		AdminLandingPageClass landingPage = loginpage.loginMethodMethod(prop.getProperty("username"), prop.getProperty("password"));
		landingPage.landingHamburgerMethod();
	}
	
	@Test (priority=2, retryAnalyzer=Retry.class)	
	public void myDriveFileUpload() throws InterruptedException, IOException {
		AdminMyDriveClass driveObject = new AdminMyDriveClass(driver);
		driveObject.AddFile();
		driveObject.fileDownload();
	}
//testing 10 mar 25
}

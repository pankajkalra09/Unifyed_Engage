package Unifyed.Unifyed_Engage;


import org.testng.annotations.Test;

import Unifyed.Unifyed_Engage.AdminPages.AdminLandingPageClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminLoginPageClass;
import Unifyed.Unifyed_Engage.CommonUtils.DataProviders;
import Unifyed.Unifyed_Engage.TestComponents.BaseClass;
import Unifyed.Unifyed_Engage.TestComponents.Retry;

public class LoginLogoutTest extends BaseClass{
	
	AdminLandingPageClass landingPage = new AdminLandingPageClass(driver);

//testing
	@Test (dataProvider="LoginTest", dataProviderClass = DataProviders.class, priority=1, retryAnalyzer = Retry.class)	
	public void LoginLogoutMethod(String user_name, String pass_word) throws Exception {	
		loginpage = new AdminLoginPageClass(driver);
		//AdminLandingPageClass landingPage = loginpage.loginMethodMethod(prop.getProperty("username"), prop.getProperty("password"));
		AdminLandingPageClass landingPage = loginpage.loginMethodMethod(user_name, pass_word);
		landingPage.landingHamburgerMethod();
		landingPage.landingLogoutMethod();	
		loginpage.loginPageTitle();
	}

}

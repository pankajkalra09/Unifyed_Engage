package stepDefinations;

import Unifyed.Unifyed_Engage.AdminPages.AdminCategoryListingClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminLandingPageClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminLoginPageClass;
import Unifyed.Unifyed_Engage.AdminPages.AdminPreferencePageClass;
import Unifyed.Unifyed_Engage.TestComponents.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationClass extends BaseClass{
	
	public AdminLoginPageClass loginpage;
	public AdminLandingPageClass landingPage;
	AdminPreferencePageClass preferencePage;
	AdminCategoryListingClass categorylistmethod;
	
	@Given("I landed onto enagage login page")
	public void I_landed_onto_enagage_login_page() throws Exception {
		loginpage = launchAppMethod();
	}
	
	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password) throws InterruptedException {
		landingPage = loginpage.loginMethodMethod(username, password);
	}
	
	@When("I click on the profile drop down and click on the Logout option and click yes for the warning message")
	public void I_click_on_the_profile_drop_down() throws InterruptedException {
		landingPage.landingHamburgerMethod();
		landingPage.landingLogoutMethod();	
	}
	
	@Then("{string} page title is showing up")
	public void page_title_showed(String string) {
		loginpage.loginPageTitle();
		driver.close();
	}
	
	@When("^I click on the profile drop down and click on the Preference option User is able to create a category with Name (.+)$")
	public void i_click_on_the_profile_drop_down_and_click_on_the_preference_option_User_is_able_to_create_a_category_with_Name(String categoryName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		landingPage.landingHamburgerMethod();
		preferencePage = landingPage.landingPreferencesMethod();
		categorylistmethod = preferencePage.preferenceManageCategoryMethod();
		categorylistmethod.categoryCreationMethod(categoryName);
		categorylistmethod.CategoryEditMethod(categoryName); 
		 categorylistmethod.categoryDeleteMethod(categoryName); 
	}
	@Then("Browser close")
	public void browser_close() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.close();
	}

}

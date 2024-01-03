package Unifyed.Unifyed_Engage.AdminPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Unifyed.Unifyed_Engage.CommonUtils.CommonUtilsClass;

public class AdminLandingPageClass extends CommonUtilsClass {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//div[@id='addToggleMode']/img") WebElement hamburger;
	@FindBy(xpath = "//a[@id='accessDropdown']/span") WebElement profileDropDown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Preferences')]") WebElement preferenceElement;
	@FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Studio')]") WebElement studioElement;
	@FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Profile')]") WebElement profileElement;
	@FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Logout')]") WebElement logoutElement;
	@FindBy(xpath = "//div[@class='jconfirm-buttons']/button[contains(text(),'YES')]") WebElement logoutYes;
	@FindBy (xpath="//input[@id='searchBox']") WebElement searchTextElement;
	
	
	public AdminLandingPageClass(WebDriver driver) {
		//since we are extending commonutil class and we want to pass the driver to that class. So from child to parent we can sent the driver
				//using the super() method. So if we are sending driver through super then that driver should be caught in commonutil class with the help of constructor.
				super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void explicitWaitmethod(By findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void search(String searchtext) {
		searchTextElement.sendKeys(searchtext);
	}
	
	public void landingHamburgerMethod() throws InterruptedException {		
		//Thread.sleep(10000);
		hamburger.click();
		Thread.sleep(2000);	
	}
	
	public AdminPreferencePageClass landingPreferencesMethod() throws InterruptedException {
		profileDropDown.click();
		Thread.sleep(2000);
		preferenceElement.click();  
		Thread.sleep(2000);
		AdminPreferencePageClass preferencePage = new AdminPreferencePageClass(driver);
		return preferencePage;
	}
	public void landingStudioMethod() throws InterruptedException {
		profileDropDown.click();
		Thread.sleep(1000);
		studioElement.click();  
		Thread.sleep(2000);
		
	}
	public void landingProfileMethod() throws InterruptedException {
		profileDropDown.click();
		Thread.sleep(1000);
		profileElement.click();  
		Thread.sleep(2000);
	}
	
	public void landingLogoutMethod() throws InterruptedException {
		profileDropDown.click();
		Thread.sleep(1000);
		logoutElement.click();
		Thread.sleep(1000);
		logoutYes.click();
		Thread.sleep(4000);	
		
	}
	

	
}

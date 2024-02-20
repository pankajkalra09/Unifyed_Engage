package Unifyed.Unifyed_Engage.CommonUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Unifyed.Unifyed_Engage.AdminPages.AdminPreferencePageClass;

public class CommonUtilsClass {
	WebDriver driver;

	@FindBy(xpath = "//div[@id='addToggleMode']/img") WebElement hamburger;
	@FindBy(xpath = "//a[@id='accessDropdown']/span") WebElement profileDropDown;
	@FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Preferences')]") WebElement preference;
	
	
	public CommonUtilsClass(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void explicitWaitmethod(By findBy) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void landingHamburgerMethod() throws InterruptedException {		
		//Thread.sleep(10000);
		hamburger.click();
		Thread.sleep(2000);
	}
	
	public AdminPreferencePageClass landingPreferencesMethod() throws InterruptedException {
		profileDropDown.click();
		Thread.sleep(1000);
		preference.click();  
		Thread.sleep(2000);
		AdminPreferencePageClass preferencePage = new AdminPreferencePageClass(driver);
		return preferencePage;
		
	}
}

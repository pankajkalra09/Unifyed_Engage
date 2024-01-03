package Unifyed.Unifyed_Engage.AdminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Unifyed.Unifyed_Engage.CommonUtils.CommonUtilsClass;

public class AdminPreferencePageClass extends CommonUtilsClass {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(text(), 'Manage Categories')]/following-sibling::div/button[contains(text(), 'Manage')]")
	WebElement manageCategory;

	public AdminPreferencePageClass(WebDriver driver) {
		// since we are extending commonutil class and we want to pass the driver to
		// that class. So from child to parent we can sent the driver
		// using the super() method. So if we are sending driver through super then that
		// driver should be caught in commonutil class with the help of constructor.
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public AdminCategoryListingClass preferenceManageCategoryMethod() throws InterruptedException {
		manageCategory.click();
		Thread.sleep(2000);
		return new AdminCategoryListingClass(driver);
		
	}

}

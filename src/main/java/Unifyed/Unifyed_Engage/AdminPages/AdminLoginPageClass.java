package Unifyed.Unifyed_Engage.AdminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Unifyed.Unifyed_Engage.CommonUtils.CommonUtilsClass;

public class AdminLoginPageClass extends CommonUtilsClass {

	public WebDriver driver;

	@FindBy(xpath = "//div[contains(@class, 'profile')]//button[@class='btn btn-primary']")	WebElement loginButton;
	@FindBy(xpath = "//input[@id='username']") WebElement username;
	@FindBy(id = "password") WebElement password;
	@FindBy(id = "submitButton") WebElement singInButton;

	public AdminLoginPageClass(WebDriver driver) {
		// since we are extending common util class and we want to pass the driver to that class. So from child to parent we can sent the driver
		// using the super() method. So if we are sending driver through super then that driver should be caught in commonutil class with the help of constructor.
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void loginPageTitle() {
		String pageTitle = driver.getTitle();
		pageTitle.contains("Verify IDP");
	}
	public AdminLandingPageClass loginMethodMethod(String uname, String pword) throws InterruptedException {
		loginButton.click();
		Thread.sleep(3000);
		username.sendKeys(uname);
		Thread.sleep(1000);
		password.sendKeys(pword);
		Thread.sleep(1000);
		singInButton.click();
		Thread.sleep(6000);
		//checking PR
		AdminLandingPageClass landingPage = new AdminLandingPageClass(driver);
		return landingPage;
	}

}

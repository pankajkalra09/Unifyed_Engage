package Unifyed.Unifyed_Engage.AdminPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Unifyed.Unifyed_Engage.CommonUtils.CommonUtilsClass;

public class AdminCategoryListingClass extends CommonUtilsClass {

	public WebDriver driver;

	@FindBy(xpath = "//div[@role='list']/div/div[1]") List<WebElement> listOfCategory;
	@FindBy(id = "groupSearchText")	WebElement CategoryAdmin;
	@FindBy(id = "audienceSearchText") WebElement CategoryAudience;
	@FindBy(xpath = "//input[@id='searchEmain0']//following-sibling::div")	WebElement AdminCheck;
	@FindBy(xpath = "//div[text() = 'CONNECT ADMIN ']")	WebElement randomClick;
	@FindBy(xpath = "//li[@role='listitem']//div[contains(@class,'indicator')]")	WebElement AudienceCheck;
	@FindBy(xpath = "//div[@class='createCategory']/button[1]")	WebElement CreateCategory;
	@FindBy(id = "categoryName")	WebElement CategoryName;
	@FindBy(xpath = "//div[@class='text-right']/button[2]")	WebElement SaveButton;
	By editicon = By.xpath(".//following-sibling::div/button[contains(@aria-label,'edit')]");
	By deleteicon = By.xpath(".//following-sibling::div/button[contains(@aria-label,'delete')]");
	By allCategory = By.xpath("//div[@role='list']/div/div[1]");
	@FindBy(xpath = "//button[@class='uniTextButton textPrimary']")	WebElement BackIcon;
	@FindBy(xpath = "//div[@class='jconfirm-buttons']/button[contains(text(), 'DELETE')]")	WebElement deleteconfirmation;

	public AdminCategoryListingClass(WebDriver driver) {
		// since we are extending commonutil class and we want to pass the driver to
		// that class. So from child to parent we can sent the driver
		// using the super() method. So if we are sending driver through super then that
		// driver should be caught in commonutil c lass with the help of constructor.
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public List<WebElement> categorylistingMethod() {
		explicitWaitmethod(allCategory);
		return listOfCategory;
	}

	public void categoryCreationMethod(String name) throws InterruptedException {
		CreateCategory.click();
		Thread.sleep(2000);
		CategoryName.sendKeys(name);
		Thread.sleep(2000);
		SaveButton.click();
		Thread.sleep(2000);
	}

	public WebElement categoryNameCheckMethod(String categoryName) {
		WebElement newCategory = listOfCategory.stream().filter(s -> s.getText().equals(categoryName)).findFirst().orElse(null);
		return newCategory;
	}
	WebElement cat;
	public void CategoryEditMethod(String name) throws InterruptedException {
		cat = categoryNameCheckMethod(name);
		if (cat != null) {
			Actions act = new Actions(driver);
			Thread.sleep(2000);
			cat.findElement(editicon).click();
			Thread.sleep(2000);
			CategoryAdmin.sendKeys("bus");
			Thread.sleep(2000);
			AdminCheck.click();
			Thread.sleep(2000);
			randomClick.click();
			CategoryAudience.sendKeys("Business");
			Thread.sleep(2000);
			AudienceCheck.click();
			Thread.sleep(2000);
			randomClick.click();
			Thread.sleep(2000);
			BackIcon.click();
			Thread.sleep(2000);
		}
	}
	public void categoryDeleteMethod(String name) throws InterruptedException {
		cat = categoryNameCheckMethod(name);
		if (cat != null) {
			cat.findElement(deleteicon).click();
			Thread.sleep(2000);
			deleteconfirmation.click();
			Thread.sleep(2000);
		}

	}

}

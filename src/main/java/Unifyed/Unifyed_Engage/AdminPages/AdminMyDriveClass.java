package Unifyed.Unifyed_Engage.AdminPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Unifyed.Unifyed_Engage.CommonUtils.CommonUtilsClass;

public class AdminMyDriveClass extends CommonUtilsClass{
	
public WebDriver driver;
	
	@FindBy(xpath = "//a[@id='d714f79a30d7e033']/span") WebElement myDriveLink;
	@FindBy(xpath = "//div[contains(text(),'My Documents')]") WebElement myDocumnets;
	@FindBy(xpath = "//div[@id='addDirectory']//i") WebElement addFile;
	@FindBy(xpath = "//*[@id='addDirectory']/div/ul/li[2]/a") WebElement uploadFile;
	@FindBy(xpath = "//div[@id='newFile']//div[@class='modal-body']//label[@class='fileInputCont']") WebElement browserFile;
	@FindBy(xpath="//div[@id='newFile']//div[@class='modal-footer']/button") WebElement submitButton;
	@FindBy(xpath="//div[@id='newFile']//div[@class='modal-header']/button") WebElement crossButton;
	
	
	public AdminMyDriveClass(WebDriver driver) {
		//since we are extending commonutil class and we want to pass the driver to that class. So from child to parent we can sent the driver
				//using the super() method. So if we are sending driver through super then that driver should be caught in commonutil class with the help of constructor.
				super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void AddFile() throws InterruptedException, IOException {
		myDriveLink.click();
		Thread.sleep(1000);
		myDocumnets.click();
		Thread.sleep(1000);
		addFile.click();
		Thread.sleep(1000);
		uploadFile.click();
		Thread.sleep(1000);
		browserFile.click();
		Thread.sleep(4000);		
		Runtime.getRuntime().exec("E:\\Projects\\Unifyed_Engage\\FileUpload.exe");
		Thread.sleep(4000);
		submitButton.click();
		Thread.sleep(5000);
		crossButton.click();
		Thread.sleep(2000);
	}

}

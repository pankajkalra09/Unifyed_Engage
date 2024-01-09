package Unifyed.Unifyed_Engage.AdminPages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy(xpath="//span[@class='fa fa-download']") WebElement downloadbutton;
	
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
	public void fileDownload() throws InterruptedException {
		List<WebElement> checkboxFile = driver.findElements(By.xpath("//span[contains(@class,'displayInlineBlock directoryNameBox')]/input"));
		for (int i = 0; i < checkboxFile.size(); i++) {
			WebElement minor_element = checkboxFile.get(i);
			minor_element.click();
		}
		Thread.sleep(2000);
		downloadbutton.click();
		Thread.sleep(5000);
		//we are creating a path inside our project where the downloaded file gets displayed.		
		//now we have the path created. 
		//Next challenge is to ensure that chrome downloads the file inside our project and not on our machine.
		// we will make use of chromeOptions class before invoking the browser so that our chrome knows where to download the file.
		// we will create object of chromeoptions and a method called "setExperiementalOptions" with 2 arguments.
		//1st attribute if "prefs" and 2nd is value which defines which pref we want to set for our chrome browser. value is given by chrome team as a hashmap, which is written in baseclass.
		//once we set the method then we pass option object as an argument in the chrome invoking statement "WebDriver driver = new ChromeDriver(option)"
		//so that our chrome is aware about where to download.
		
		String currentDir = System.getProperty("user.dir");
        // Create a File object for the current directory
        File dir = new File(currentDir);
        // Create a File object with a wildcard for any ZIP file in the directory
        File[] zipFiles = dir.listFiles((dir1, name) -> name.toLowerCase().endsWith(".zip"));
        // Display the names of ZIP files
        if (zipFiles != null && zipFiles.length > 0) {
            for (File zipFile : zipFiles) {
                System.out.println("ZIP is downloaded with name as: " + zipFile.getName());
            }
        } else {
            System.out.println("No ZIP files found in the current directory.");
        }
        
        if (dir.delete()) {
            System.out.println("Directory is deleted.");
        } else {
            System.out.println("Failed to delete directory. It may not be empty.");
        }
	}
}

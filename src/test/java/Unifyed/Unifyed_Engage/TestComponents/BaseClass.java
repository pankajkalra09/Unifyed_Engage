package Unifyed.Unifyed_Engage.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import Unifyed.Unifyed_Engage.AdminPages.AdminLoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public AdminLoginPageClass loginpage;

	public static WebDriver initilizeBrowserMethod() throws Exception {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\Unifyed\\Unifyed_Engage\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		// if condition 1 "System.getProperty("browser")!=null" is true which means we are getting value of browser at runtime from command prompt
		//then run condition 2 "System.getProperty("browser")".
		
		// if condition 1 "System.getProperty("browser")!=null" is false which means we are not getting value of browser at runtime from command prompt
		//then run condition 3 "prop.getProperty("browser")".
		
		//prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			//this code is to set the default download location of a file inside our project's parent location.
			String downloadPath = System.getProperty("user.dir");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings_popups", 0);
			chromePrefs.put("download.default_directory", downloadPath);
			
			ChromeOptions option = new ChromeOptions(); //used to run tests in headless mode
			option.setExperimentalOption("prefs", chromePrefs);
			//till here
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				option.addArguments("headless");
			}
			
			driver = new ChromeDriver(option);
			driver.manage().window().setSize(new Dimension(1440, 900)); //to maximize window in headless mode to make sure all the elements are showing up.
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webDriver.edge.driver", "path");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	/*
	 * public List<HashMap<String, String>>readerToMap(String jsonFilePath) throws
	 * IOException { String jsonContent = FileUtils.readFileToString(new
	 * File(jsonFilePath), StandardCharsets.UTF_8); ObjectMapper mapper = new
	 * ObjectMapper(); List<HashMap<String, String>> data =
	 * mapper.readValue(jsonContent, new TypeReference <List<HashMap<String,
	 * String>>>(){}); return data; }
	 */
	
	
	//We want to take screenshots for the failed test cases only.
	  //this method is taking the screenshot and returning us the path of the screenshot
	 
	 public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  File file = new File(System.getProperty("user.dir") + "//FailedScreenShots//" + testCaseName + ".png");
		  FileUtils.copyFile(source, file);
		  return System.getProperty("user.dir") + "//FailedScreenShots//" + testCaseName + ".png";
		  
		  
	  }
	
	@BeforeTest
	public static AdminLoginPageClass launchAppMethod() throws Exception {
		initilizeBrowserMethod();
		driver.get(prop.getProperty("url"));
		return new AdminLoginPageClass(driver);
		
	}
	
	@AfterTest
	public void driveClose() {
		driver.quit();
	}

}

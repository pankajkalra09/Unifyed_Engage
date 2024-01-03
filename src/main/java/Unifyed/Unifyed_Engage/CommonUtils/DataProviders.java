package Unifyed.Unifyed_Engage.CommonUtils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginTest")
	public static Object[][] getLoginData() throws Exception 
	{
	Object getLoginObj[][] = DataDriven.getTestData(System.getProperty("user.dir")+ "\\src\\main\\java\\Unifyed\\Unifyed_Engage\\Resources\\dataDriven.xlsx");	
	return getLoginObj;
	}
	
}

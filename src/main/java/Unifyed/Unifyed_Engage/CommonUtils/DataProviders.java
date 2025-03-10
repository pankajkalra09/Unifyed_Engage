package Unifyed.Unifyed_Engage.CommonUtils;


import org.testng.annotations.*;

public class DataProviders {
	
	@DataProvider(name="LoginTest")
	public static Object[][] getLoginData() throws Exception 
	{
	Object getLoginObj[][] = DataDriven.getTestData(System.getProperty("user.dir")+ "\\src\\main\\java\\Unifyed\\Unifyed_Engage\\Resources\\dataDriven.xlsx");	
	return getLoginObj;
	}
	
}

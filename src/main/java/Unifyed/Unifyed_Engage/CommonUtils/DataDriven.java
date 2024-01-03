package Unifyed.Unifyed_Engage.CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String sheetname, String columnName, String testName) throws IOException {
		// identify TestCases column by scanning the entire 1st row
		// Once column is identified then scan entire column to identify login test case.
		// after you grab the login test case row, pull all the data of that row and feed into test.
		// create a arraylist to store the data and pass it to our test.

		ArrayList<String> testDataArray = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\Unifyed\\Unifyed_Engage\\Resources\\dataDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // we have to give fileinputstream argument of the excel which we want to access

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetname)) {
				XSSFSheet sheet = workbook.getSheetAt(i); // sheet is having data of all the rows.
				// Now we have to iterate the rows
				Iterator<Row> rows = sheet.iterator(); // sheet is a collection of rows.
				// Now we have to get to the row using next.
				Row firstRow = rows.next(); // control is on the 1st row now.
				// Now we want to scan row 1 and find our the column we want to use.
				Iterator<Cell> cell = firstRow.cellIterator(); // row is collection of cells.
				// now we have to read each and every column value and compare with the value we want.
				int k = 0;// using this as we want to know the index of the column we want.
				int columnIndex = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase(columnName)) {
						// we need to know the column index
						columnIndex = k; // column index is stored here.
						// now we know the column index and we will scan who
					}
					k++;
				}
				System.out.println(columnIndex);
				// Once column is identified then scan entire column to identify login test case.
				// first get the count of all the rows since we don't have the methods for
				// columns like wise we have for rows.
				// iterate through each and every row but this time we can scan only the column
				// we have identified.
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testName)) {
						// getting the cell value for only the column index we have finalised.
						// after you grab the login test case row, pull all the data/cell content of
						// that row and feed into test.
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING) {
								testDataArray.add(cv.next().getStringCellValue());
							}
							else {
								testDataArray.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
							
						}
					}

				}
			}

		}
		return testDataArray;
	}
	
	public static Object[][] getTestData(String filepath) throws IOException {
			
			FileInputStream fis = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println(rowCount);
			XSSFRow rows = sheet.getRow(0);
			int columnCount = rows.getLastCellNum();
			//System.out.println(columnCount);
			
			Object[][] data = new Object[rowCount-1][columnCount];
			for(int i=0;i<rowCount-1;i++) {
				rows = sheet.getRow(i+1);
				//System.out.println("rows are: "+rows);
				for (int j=0;j<columnCount;j++) {
					
					data[i][j] =rows.getCell(j).getStringCellValue();
					//System.out.println(rows.getCell(j));
				}
			}
			return data;
		}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

}

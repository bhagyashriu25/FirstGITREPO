package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;


import com.crm.qa.base.TestBase;
import org.apache.commons.io.FileUtils;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH = "D:/Selenium/FreeCRMMaven/"
			+"src/main/java/com/crm/qa/testdata/FreeCRM_AddNewTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName) throws IOException {

FileInputStream fis= new FileInputStream(TESTDATA_SHEET_PATH);

 book=new XSSFWorkbook(fis);
 sheet=book.getSheet(sheetName);
		
		System.out.println("Rows:"+sheet.getLastRowNum());
		System.out.println("column:"+sheet.getRow(0).getPhysicalNumberOfCells());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getPhysicalNumberOfCells()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			System.out.println(sheet.getLastRowNum());
			for (int k = 0; k < sheet.getRow(0).getPhysicalNumberOfCells(); k++) {
				System.out.println(sheet.getRow(0).getPhysicalNumberOfCells());
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				
				 System.out.println("Row : "+i + " Column : " +k +" = "+data[i][k]);
			}
		}
		 
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String currentDir = System.getProperty("user.dir");
		//String currentDir = System.getProperty("D:/Selenium\FreeCRMMaven");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
}

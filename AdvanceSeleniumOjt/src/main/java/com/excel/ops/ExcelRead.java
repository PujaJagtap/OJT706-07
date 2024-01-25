package com.excel.ops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelRead {

	public static String getCellData(int row, int col) throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:\\MyFiles\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("login");
		
		int rows = sh.getLastRowNum(); // to know the number of rows having data
		for(int i=0; i<rows; i++) {
			int cols = sh.getRow(i).getLastCellNum(); // to know the columns for each row
			for(int j=0; j<cols; j++) {
				Cell c = sh.getRow(i).getCell(j);
				System.out.println(df.formatCellValue(c)+" ");
			}
			System.out.println();
		}
		return df.formatCellValue(sh.getRow(row).getCell(col));
	}

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/PUSHKRAJ/Downloads/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys(getCellData(0, 0));
		driver.findElement(By.id("password")).sendKeys(getCellData(0, 1));
	}
}

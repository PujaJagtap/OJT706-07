package com.tka.excel.read_write;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadAndWriteData {
	public WebDriver driver;
	public static Logger log = Logger.getLogger(ExcelReadAndWriteData.class);
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static SoftAssert softAssert;
	public static Object[][] addData;
	public FileOutputStream fos;
	int count = 1;

	@BeforeMethod
	public void setUp() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("log4j.properties"));
		PropertyConfigurator.configure(properties);

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"file:///C:/Users/PUSHKRAJ/Downloads/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		softAssert = new SoftAssert();
	}

	@Test(dataProvider = "retrieveDataFromExcel")
	public void loginMultipleUsers(String email, String password) throws Exception {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Dashboard";

		log.info("Compare Result: " + actTitle + " " + expTitle);
		log.info("Excel Data in Test Method" + Arrays.deepToString(addData));

		if (driver.getTitle().equals(expTitle))
			WriteData.writeDataInCell("LogilData.xlsx", "Email and Password", count, 2, "Pass");
		else
			WriteData.writeDataInCell("LogilData.xlsx", "Email and Password", count, 2, "Fail");
		count++;

	}

	@DataProvider
	public Object retrieveDataFromExcel() throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:\\MyFiles\\TestData.xlsx");
		workbook = WorkbookFactory.create(fis);
		sheet = workbook.getSheet("Email and Password");
        System.out.println(sheet);
		int lastRowNo = sheet.getLastRowNum(); // to know the number of rows having data
		ArrayList<Object[]> addList = new ArrayList<Object[]>();
		for (int i = 1; i < lastRowNo; i++) {
			row = sheet.getRow(i);
			String email = df.formatCellValue(row.getCell(0));
			String password = df.formatCellValue(row.getCell(1));
			Object[] userCredentials = { email, password };
			addList.add(userCredentials);
		}
		Object[][] addData = new Object[addList.size()][2];
		for (int i = 1; i < addList.size(); i++) {
			addData[i] = addList.get(i);
		}
		log.info("Excel Data" + Arrays.deepToString(addData));
		return addData;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}

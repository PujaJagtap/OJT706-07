package com.tka.excel.read_write;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class WriteData {
	public WebDriver driver;
	public static Logger log = Logger.getLogger(ExcelReadAndWriteData.class);
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;

	public static void writeDataInCell(String fileName, String sheetName, int rowNum, int col, String data)
			throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream(fileName);
		workbook = WorkbookFactory.create(fis);
		if (workbook.getSheet(sheetName) == null) {
			workbook.createSheet(sheetName);
			row = sheet.createRow(rowNum);
			cell = row.createCell(col);
		} else {
			sheet = workbook.getSheet(sheetName);
			if (sheet.getRow(rowNum) == null) {
				row = sheet.createRow(rowNum);
				cell = row.createCell(col);
			} else {
				row = sheet.getRow(rowNum);
				if (row.getCell(col) == null)
					cell = row.createCell(col);
				else {
					String rowOldValue = df.formatCellValue(row.getCell(col));
					log.info("Row old Value: " + rowOldValue);
					cell = row.getCell(col);
				}
			}
		}
		cell.setCellValue(data);
		String rowNewValue = df.formatCellValue(row.getCell(col));
		log.info("Row new Value: " + rowNewValue);
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		workbook.close();

	}
}
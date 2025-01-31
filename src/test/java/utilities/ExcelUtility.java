package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	FileInputStream File;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {

		File = new FileInputStream(path);
		workbook = new XSSFWorkbook(File);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		File.close();
		return rowcount;

	}

	public int getCellCount(String sheetName, int rownum) throws IOException {

		File = new FileInputStream(path);
		workbook = new XSSFWorkbook(File);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		File.close();
		return cellcount;

	}

	public String getCelldata(String sheetName, int rownum, int colnum) throws IOException {

		File = new FileInputStream(path);
		workbook = new XSSFWorkbook(File);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String Data;
		try {
			Data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			Data = "";
		}
		workbook.close();
		File.close();
		return Data;

	}

	
	}

	
	



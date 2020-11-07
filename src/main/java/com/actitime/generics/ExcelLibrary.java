package com.actitime.generics;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements ConstantItems {
	public static String getData(int row, int cell) throws Exception{
		FileInputStream fis = new FileInputStream(excel_path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		String value = wb.getSheet(excel_Sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
}

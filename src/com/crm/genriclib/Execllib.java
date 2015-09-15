package com.crm.genriclib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Execllib {
	public String getExeclData(String SheetName , int rowNum ,int ColNum) throws InvalidFormatException, IOException{
		String excelpath ="C:\\Workspace_selenium\\workspace\\Framework\\TestData\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(ColNum);
		String data =cel.getStringCellValue();
		return data;
		
		
	}
	public void setExcelData(String Sheetname , int rownum , int colnum ,String data) throws InvalidFormatException, IOException{
		String excelpath ="C:\\Workspace_selenium\\workspace\\Framework\\TestData\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		Row row = sh.getRow(rownum);
		Cell cel = row.createCell(colnum);
		cel.setCellType(cel.CELL_TYPE_STRING);
		FileOutputStream fos = new FileOutputStream(excelpath);
		cel.setCellValue(data);
		wb.write(fos);
		wb.close();
	}

}

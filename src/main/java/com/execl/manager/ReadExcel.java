package com.execl.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public void getExcelData(int rowIndex,int columnIndex) throws IOException {
		// excel location or path
		File file = new File("./src/test/resources/TestingExcel.xlsx");
		// convert data to stream
		FileInputStream fis = new FileInputStream(file);// checked==>FileNotFoundException
		// Apache POI methods to read excel
		// new or old ==> .xlsx =new ==>XSSF
		// 1st steps = read whole excel as a book= workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);// Checked = IOException
		// XSSFSheet sht = wb.getSheetAt(1);//sheet no
		XSSFSheet sht = wb.getSheet("NY branch");// name
		// int totalRow =sht.getPhysicalNumberOfRows();// total row num
		// loop all rows
		for (int i = 0; i < sht.getPhysicalNumberOfRows(); i++) {
			if(i==rowIndex) {
			Row row = sht.getRow(i);
			// row.getLastCellNum();//total column number
			// start another loop for column
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if(j==columnIndex) {
					Cell cell = row.getCell(j);// cell data by column index
					System.out.println(cell.getStringCellValue());
				}
				
			}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new ReadExcel().getExcelData(3,2);//bye
	}
}

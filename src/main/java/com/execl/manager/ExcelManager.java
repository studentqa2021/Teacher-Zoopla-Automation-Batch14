
package com.execl.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ExcelManager {

	public static JSONArray getExcelDataAsJsonObject(String string, String sheetName) throws Throwable {

		JsonObject sheetsJsonObject = new JsonObject();
		Workbook workbook = null;
		JsonArray sheetArray = null;
		try {
			workbook = new XSSFWorkbook(string);
		} catch (IOException e) {

		}

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

			sheetArray = new JsonArray();
			ArrayList<String> columnNames = new ArrayList<String>();
			Sheet sheet = workbook.getSheetAt(i);
			Iterator<Row> sheetIterator = sheet.iterator();

			while (sheetIterator.hasNext()) {

				Row currentRow = sheetIterator.next();
				JsonObject jsonObject = new JsonObject();

				if (currentRow.getRowNum() != 0) {

					for (int j = 0; j < columnNames.size(); j++) {

						if (currentRow.getCell(j) != null) {
							DataFormatter df = new DataFormatter();
							jsonObject.addProperty(columnNames.get(j), df.formatCellValue(currentRow.getCell(j)));

						} else {
							jsonObject.addProperty(columnNames.get(j), "");
						}

					}

					sheetArray.add(jsonObject);

				} else {
					// store column names
					for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
						columnNames.add(currentRow.getCell(k).getStringCellValue());

					}
				}

			}

			sheetsJsonObject.add(workbook.getSheetName(i), sheetArray);

		}
		JSONObject jsonObj = new JSONObject(sheetsJsonObject.toString()); // convert to json object
		JSONArray objSearchOrdersDto = jsonObj.getJSONArray(sheetName); // convert to json array
		return objSearchOrdersDto;

	}
	
	public static  String getTestData(String path,String sheet,String testNOHeader,String testNO,String columnValue) throws Throwable{
		String strStatusType = null;
		JSONArray objSearchOrdersDto = ExcelManager
				.getExcelDataAsJsonObject(path, sheet);

					for (int i = 0; i < objSearchOrdersDto.length(); ++i) {

						JSONObject rec = objSearchOrdersDto.getJSONObject(i);
						if(rec.getString(testNOHeader).contains(testNO)) {
							
							 strStatusType = rec.getString(columnValue);

								System.out.println(strStatusType);
								break;
						}
						

	}
					return strStatusType;
	}

	public static void main(String[] args) throws Throwable {
		getTestData("./src/test/resources/Login Test cases_smoke.xlsx", "NY","TC_ID","tc_001", "STEPS");
		getTestData("./src/test/resources/Login Test cases_smoke.xlsx", "NY","TC_ID","tc_001", "EXPECTED");
		}

	
}

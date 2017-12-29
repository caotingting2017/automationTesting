/**
 * @author tina.cao
 * 工具描述：读写文件
 */
package com.TestngDemo001.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONObject;

public class FileUtils {

	File directory = new File("");// 获取workspace的路径

	/**
	 * 读取json文件的数据
	 * 
	 * @param filename被读取的文件名
	 * 
	 * @return json格式的对象
	 */
	public JSONObject getJsondataFromFile(String filename) {
		JSONObject jsonObj = null;
		String dataFilePath = directory.getAbsolutePath().toString() + "\\resources\\jsonfiles\\";
		try {
			InputStream inputStream = new FileInputStream(dataFilePath + filename);
			Scanner scanner = new Scanner(inputStream, "UTF-8");
			String jsonString = scanner.useDelimiter("\\Z").next();

			// 去掉所有空格
			String regex = "\\s+";
			String inputStreamstr = jsonString.replaceAll(regex, "");
			jsonObj = new JSONObject(inputStreamstr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObj;
	}

	/**
	 * 读取Excel文件中的数据
	 * 
	 * @param fileName 被读取的excel文件名
	 * @param sheetName 工作簿名字
	 * @return
	 */
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		String dataFilePath = directory.getAbsolutePath().toString() + "\\resources\\xlsxFiles\\";
		try {
			FileInputStream fis = new FileInputStream(dataFilePath + fileName);
			Workbook excelWBook = WorkbookFactory.create(fis);
			fis.close();

			Sheet excelWSheet = excelWBook.getSheet(sheetName);

			int totalOfRows = excelWSheet.getLastRowNum();// 行数
			int totalCountOfCols = excelWSheet.getRow(0).getLastCellNum();// 列数
			arrayExcelData = new String[totalOfRows][totalCountOfCols];

			for (int i = 1; i <= totalOfRows; i++) {// 从第2行开始读，第一行为标题
				for (int j = 0; j < totalCountOfCols; j++) {
					Cell cell = excelWSheet.getRow(i).getCell(j);
					cell.setCellType(CellType.STRING);
					arrayExcelData[i - 1][j] = cell.getStringCellValue();
					// System.out.println("excel
					// data:["+(i-1)+"]["+j+"]:"+arrayExcelData[i-1][j]);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

}

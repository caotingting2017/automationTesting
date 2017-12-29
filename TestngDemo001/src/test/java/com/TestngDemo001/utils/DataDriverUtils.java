/**
 * 提供方法参数的读取方法
 */
package com.TestngDemo001.utils;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;

public class DataDriverUtils {

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
//		Object[][] obj = { { "tina@163.com", "123456" }, { "testuser_1", "Test@123" } };
		
//		return new Object[][] { { "tina@163.com", "123456" }, { "testuser_1", "Test@123" } };
		return new Object[][] { { "tina@163.com", "123456" } };
	}
	
	@DataProvider(name = "loginAuthentication")
	public static Object[][] getLoginAuthentication(){
		//测试美国版时，第二个参数为：American，印尼版本时，第二个参数改为Indonesia
//		Object[][] dataObj = (new FileUtils()).getExcelData("authentication1.xlsx", "American");//jxl
		
		//poi read file
		Object[][] dataObj = (new FileUtils()).getExcelData("authentication1.xlsx", "American");
		
		return dataObj;
	}
	
}

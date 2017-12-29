package com.TestngDemo001.test;

import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestngDemo001.utils.DataDriverUtils;
import com.TestngDemo001.utils.FileUtils;
import com.TestngDemo001.utils.HTTPUtils;

public class LoginTest {

	static FileUtils fileUtils = new FileUtils();
	static String testData;
	HTTPUtils httpUitls = new HTTPUtils();
	JSONObject loginJsonObj = fileUtils.getJsondataFromFile("login_post.json");

	@BeforeMethod
	public void setUp() throws Exception {
		// 重装login request data
		HttpResponse response = httpUitls.sendPost("https://api.test.ododtech.com/account/v1/validate",
				fileUtils.getJsondataFromFile("validate_post.json").toString());
		JSONObject respJsonObj = httpUitls.convertRespInfoToJsonObj(response);
		JSONObject tokenInfo = respJsonObj.getJSONObject("data").getJSONObject("token");

		loginJsonObj.put("token", tokenInfo);// 将login post json中的token信息替换为validate响应的token
	}

	@Test(enabled=false)
	public void testLogin() throws Exception {
		// 发送login post请求
		HttpResponse loginResponse = httpUitls.sendPost("https://api.test.ododtech.com/account/v1/login",
				loginJsonObj.toString());
		
		// 输出服务器响应的数据
		System.out.println("login response info : " + httpUitls.convertRespInfoToJsonObj(loginResponse).toString());
	}

	@Test(dataProvider = "Authentication", dataProviderClass = DataDriverUtils.class)
	public void testloginByProviderData(String identity, String password) throws Exception {
		loginJsonObj.getJSONObject("data").put("identity", identity);
		loginJsonObj.getJSONObject("data").put("password", password);
		
		// 发送login post请求
		HttpResponse loginResponse = httpUitls.sendPost("https://api.test.arisan1000.com/account/v1/login",
				loginJsonObj.toString());
		
		// 输出服务器响应的数据
		System.out.println("login response info : " + httpUitls.convertRespInfoToJsonObj(loginResponse).toString());
	}
	
	@Test(dependsOnMethods="testloginByProviderData" , invocationCount=10, threadPoolSize=1)
	public void testLuckWheelRecords() throws Exception{
		//System.out.println("===begin===");
		HttpResponse response = httpUitls.sendPost("https://test.arisan1000.com/luckywheel/v1/recent_lucky_records",
				fileUtils.getJsondataFromFile("luckyRecords_post.json").toString());
		//System.err.println(httpUitls.convertRespInfoToJsonObj(response));
		//System.out.println("===end===");
	}
	
//	@Test(enabled=false,dataProvider = "loginAuthentication", dataProviderClass = DataDriverUtils.class)
//	public void testLoginWithExcelData(String identity,String password) throws Exception{//dataProvider提供的obj[][]对象中，数组对象对几列，则有可以使用几个参数
//		System.out.println("identity:"+identity + " password:"+password);
//	}
//
//	@AfterMethod
//	public void tearDown() {
//	}
}

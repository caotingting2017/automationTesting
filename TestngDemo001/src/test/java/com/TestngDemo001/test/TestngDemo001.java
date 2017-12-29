package com.TestngDemo001.test;

import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestngDemo001.RandomEmailGenerator;
import com.TestngDemo001.utils.FileUtils;
import com.TestngDemo001.utils.HTTPUtils;

public class TestngDemo001 {

	FileUtils fileUtils = new FileUtils();
	HTTPUtils httpUitls = new HTTPUtils();
	
	@BeforeMethod
	public void beforeMethod(){
	}
	
	@Test
	public void testEmailGenerator() {
		System.out.println("testEmailGenerator");
		RandomEmailGenerator obj = new RandomEmailGenerator();
		String email = obj.generate();
		Assert.assertNotNull(email);
        Assert.assertEquals(email, "feedback@yiibai.com");
	}
	
	@Test
	public void test002(){
		System.out.println("test002");
	}
	
	@Test
	public void testReadJsonFile(){
		JSONObject validataJsonObj =	fileUtils.getJsondataFromFile("validate_post.json");
		System.out.println("validate post data :"+validataJsonObj.toString());
		
	}
	
	@Test
	public void testSendPost() throws Exception{
		HttpResponse response = httpUitls.sendPost("https://api.test.onedollarget.com/account/v1/validate", fileUtils.getJsondataFromFile("validate_post.json").toString());
		System.out.println("response info : "+httpUitls.convertRespInfoToJsonObj(response).toString());
	}
	
	@Test
	public void testLogin() throws Exception{
		//发送validate请求,获取响应的token信息
		HttpResponse response = httpUitls.sendPost("https://api.test.onedollarget.com/account/v1/validate", 
				fileUtils.getJsondataFromFile("validate_post.json").toString());
		JSONObject respJsonObj = httpUitls.convertRespInfoToJsonObj(response);
		JSONObject tokenInfo = respJsonObj.getJSONObject("data").getJSONObject("token");
		//读取login post json
		JSONObject loginJsonObj = fileUtils.getJsondataFromFile("login_post.json");
		//将login post json中的token信息替换为validate响应的token
		loginJsonObj.put("token", tokenInfo);
		//发送login post请求
		HttpResponse loginResponse = httpUitls.sendPost("https://api.test.onedollarget.com/account/v1/login", 
				loginJsonObj.toString());
		//检查服务器响应的数据
		System.out.println("login response info : "+httpUitls.convertRespInfoToJsonObj(loginResponse).toString());
	}
	@AfterMethod
	public void afterMethod(){
	}
}

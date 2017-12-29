/**
 * 处理http请求、响应相关的处理方法
 */
package com.TestngDemo001.utils;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class HTTPUtils {

	/**
	 * 发送一个post请求
	 * @param url
	 * @param data
	 * @return response
	 * @throws Exception
	 */
	public HttpResponse sendPost(String url,String data) throws Exception{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		StringEntity entity = new StringEntity(data);
		request.addHeader("content-type", "application/json");
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);//发送Validate请求
		return response;
	}
	
	/**
	 * 解析response的content数据，并转化为json格式的对象
	 * @param response
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	public JSONObject convertRespInfoToJsonObj(HttpResponse response) throws Exception{
		InputStream respStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(respStream, "UTF-8");
        String respStr = scanner.useDelimiter("\\Z").next();
        scanner.close();
		
        //将respStr转化为Json对象
        JSONObject jsonObj = new JSONObject(respStr);
		return jsonObj;
	}
}

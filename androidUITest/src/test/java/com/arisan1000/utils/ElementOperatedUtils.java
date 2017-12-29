package com.arisan1000.utils;

import java.sql.Driver;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.support.StaticApplicationContext;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

public class ElementOperatedUtils {

	public static final String NAME = "name";
	public static final String RESOURCEID = "resource-id";
	public static final String CONTENTDESC = "content-desc";
	public static final String XPATH = "xpath";
	public static final String Text = "text";
	// public static final String LANGUAGE =
	// "english";//english:美国版;indonesal:印尼版
	public static final String LANGUAGE = "indonesal";
	public static final int TIMEOUT = 3;// 默认超时时间，单位秒
	public static final int LONGTIMEOUT = 15; // 较长的超时时间，单位秒
	private WebElement el = null;

	ReadXmlFileUtils rXmlFileUtils = new ReadXmlFileUtils();

	/**
	 * 在filename文件中查找索引为id的DOM对象，并根据该结构体中提供的可用标签，确定查找元素的方式
	 * 
	 * @param driver
	 * @param id
	 *            要查找的元素名称（在xml文档中为element 标签中，name的属性值 ）
	 * @param filename
	 *            xml文件名
	 * @return
	 * @throws Exception
	 */
	public WebElement findElement(AppiumDriver<WebElement> driver, String text, String filename) throws Exception {

		// android platform
		Map<String, Object> elementMap = rXmlFileUtils.getElement(filename, text);

		System.out.println("elementMap.get(RESOURCEID):"+elementMap.get(RESOURCEID));
		if ((elementMap.get(CONTENTDESC) != null) && !("".equals(elementMap.get(CONTENTDESC)))) {

			el = driver.findElementByAccessibilityId((String) elementMap.get(CONTENTDESC));
		} else if ((elementMap.get(RESOURCEID) != null) && !("".equals(elementMap.get(RESOURCEID)))) {
			
			el = driver.findElement(By.id((String) elementMap.get(RESOURCEID)));
		} else if ((elementMap.get(XPATH) != null) && !("".equals(elementMap.get(XPATH)))) {

			String xpathstr = this.getXpath(text, filename);
			el = driver.findElementByXPath(xpathstr);
		}

		return el;
	}
	
	/**
	 * 查找id相同的一批元素
	 * @param driver
	 * @param text
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> findElements(AppiumDriver<WebElement> driver, String elementName,String filename) throws Exception{
		List<WebElement> elList = null;
		String accessibilityStr = rXmlFileUtils.getElementsAccessibility(elementName,filename);
		System.out.println("accessibilityStr：" + accessibilityStr);
//		elList = driver.findElementsByAccessibilityId(accessibilityStr);
		elList = driver.findElements(By.id(accessibilityStr));
//		for(int i = 0;i<elList.size();i++){
//			System.out.println("el:"+elList.get(i).getText());
//		}
//		
		return elList;
	}
	

	/**
	 * 等待某一元素出现
	 * 
	 * @param driver
	 * @param text：元素的名称（自定义存储在xml
	 *            文档中element标签中，name的属性值）
	 * @param filename
	 *            存储元素定位id的xml文件
	 * @param time
	 *            等待时间：（单位：秒）
	 * @return boolean false:元素未出现; true:元素出现
	 * @throws Exception
	 */
	public Boolean hasWaitedElement(AppiumDriver<WebElement> driver, String text, String filename, int time)
			throws Exception {

		Boolean waited = false;// 未出现

		Map<String, Object> elementMap = rXmlFileUtils.getElement(filename, text);

		try{
			
			if ((elementMap.get(CONTENTDESC) != null) && !("".equals(elementMap.get(CONTENTDESC)))) {
				
				new WebDriverWait(driver, time).until(ExpectedConditions
						.presenceOfElementLocated(MobileBy.AccessibilityId((String) elementMap.get(CONTENTDESC))));
				waited = true;
				
			} else if ((elementMap.get(RESOURCEID) != null) && !("".equals(elementMap.get(RESOURCEID)))) {
				new WebDriverWait(driver, time)
				.until(ExpectedConditions.presenceOfElementLocated(By.id((String) elementMap.get(RESOURCEID))));
				waited = true;
				
			} else if ((elementMap.get(XPATH) != null) && !("".equals(elementMap.get(XPATH)))) {
				String xpathstr = this.getXpath(text, filename);
				new WebDriverWait(driver, time)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath((String) elementMap.get(xpathstr))));
				waited = true;
			}
		}catch (Exception e){
			waited = false;
		}

		return waited;
	}

	/**
	 * 等待某一元素出现
	 * 
	 * @param driver
	 * @param id:
	 *            element content-desc or name
	 * @param timeout
	 *            超时时间
	 * 
	 */
	public Boolean waitedElementById(AppiumDriver<WebElement> driver, String id, int timeout) {
		Boolean waited = false;// 未出现
		try{
			new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(id)));
		waited = true;
		}catch (Exception e) {
			waited = false;
		}
		

		return waited;
	}

	/**
	 * 等待某一元素出现
	 * 
	 * @param driver
	 * @param resourceid：
	 *            element resource-id
	 * @param timeout
	 *            超时时间
	 * 
	 */
	public Boolean waitedElementByResId(AppiumDriver<WebElement> driver, String resourceid, int timeout) {
		Boolean waited = false;// 未出现
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.id(resourceid)));
			waited = true;
		} catch (Exception e) {
			waited = false;
		}
		return waited;

	}

	/**
	 * 等待某一元素出现
	 * 
	 * @param driver
	 * @param xpath：
	 *            element xpath
	 * @param timeout
	 *            超时时间
	 * 
	 */
	public Boolean waitedElementByXpath(AppiumDriver<WebElement> driver, String xpath, int timeout) {
		Boolean waited = false;// 未出现
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		waited = true;

		return waited;
	}

	/**
	 * 滑动屏幕(上下滑动)，直到找到某元素
	 * 
	 * @param text
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public void scrollToElement(AppiumDriver<WebElement> driver, String text, String filename) throws Exception {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		TouchAction action = new TouchAction(driver);
		int count = 0;

		Map<String, Object> elementMap = rXmlFileUtils.getElement(filename, text);

		if ((elementMap.get(CONTENTDESC) != null) && !("".equals(elementMap.get(CONTENTDESC)))) {

			String contentdescStr = (String) elementMap.get(CONTENTDESC);
			do {
				action.press(x / 2 - (x * count / 2), y / 4 * 3 - (y * (count + 1) / 4))
						.moveTo(driver.findElementByAccessibilityId(contentdescStr)).release().perform();
				count++;
			} while (waitedElementById(driver, contentdescStr, TIMEOUT));

		} else if ((elementMap.get(RESOURCEID) != null) && !("".equals(elementMap.get(RESOURCEID)))) {

			String resString = (String) elementMap.get(RESOURCEID);
			do {
				action.press(x / 2 - (x * count / 2), y / 4 * 3 - (y * (count + 1) / 4))
						.moveTo(driver.findElement(By.id(resString))).release().perform();
				count++;
			} while (waitedElementByResId(driver, resString, TIMEOUT));

		} else if ((elementMap.get(XPATH) != null) && !("".equals(elementMap.get(XPATH)))) {

			// 获取元素的xpath
			String xpathstr = this.getXpath(text, filename);
			do {
				action.press(x / 2 - (x * count / 2), y / 4 * 3 - (y * (count + 1) / 4))
						.moveTo(driver.findElementByXPath(xpathstr)).release().perform();
				count++;
			} while (waitedElementByXpath(driver, xpathstr, TIMEOUT));
		}

	}

	/**
	 * 滑动屏幕(从左向右滑动)，直到找到某元素
	 * 
	 * @param text
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public void scrollToLeftFindElement(AppiumDriver<WebElement> driver, String text, String filename)
			throws Exception {

		TouchAction action = new TouchAction(driver);
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		int count = 0;
		Map<String, Object> elementMap = rXmlFileUtils.getElement(filename, text);

		if ((elementMap.get(CONTENTDESC) != null) && !("".equals(elementMap.get(CONTENTDESC)))) {

			String contentdescStr = (String) elementMap.get(CONTENTDESC);
			do {
				//TODO
				// action.press(x / 4 * 3 - (x * (count+1) / 4), y / 2 - (y *
				// count/ 2))
				// .moveTo(count, count).release().perform();
				count++;
			} while (waitedElementById(driver, contentdescStr, TIMEOUT));

		} else if ((elementMap.get(RESOURCEID) != null) && !("".equals(elementMap.get(RESOURCEID)))) {

			String resString = (String) elementMap.get(RESOURCEID);
			while (waitedElementByResId(driver, resString, TIMEOUT) == false) {
//				action.press(x / 4 * 3 - (x * (count + 1) / 4), y / 2 - (y * count / 2)).moveTo(-x / 4 * 1, 0).release()
//						.perform();
				action.press(x *1 - (x * (count + 1) / 4), y / 2 - (y * count / 2)).moveTo(-x / 2 * 1, 0).release()
				.perform();//第二次滑动屏幕，滑了两页？？
				count++;
			}

		} else if ((elementMap.get(XPATH) != null) && !("".equals(elementMap.get(XPATH)))) {
			
			// 获取元素的xpath
			String xpathstr = this.getXpath(text, filename);
			do {
				//TODO press
				action.press(x / 2 - (x * count / 2), y / 4 * 3 - (y * (count + 1) / 4))
						.moveTo(driver.findElementByXPath(xpathstr)).release().perform();
				count++;
			} while (waitedElementByXpath(driver, xpathstr, TIMEOUT) == false);
		}

	}

	/**
	 * 获取元素文本的期望值（该值配置在xml文件的text标签中）
	 * 
	 * @param text
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public String getExpectedText(String text, String filename) throws Exception {
		Map<String, Object> elementMap = rXmlFileUtils.getElement(filename, text);
		Map<String, String> textMap = (Map<String, String>) elementMap.get(Text);
		String expectedText = textMap.get(LANGUAGE);
		return !("".equals(expectedText)) && expectedText != null ? expectedText : ("此元素上无文本或xml文件中未配置元素的文本信息");
	}

	public String getListChildElementExceptedText(String listElementName,String filename,String index) throws Exception{
		Map<String, Object> elementMap = rXmlFileUtils.getListElementChild(listElementName,filename,index);
		Map<String, Object> textMap = (Map<String, Object>) elementMap.get(Text);
		String expectedText = (String) textMap.get(LANGUAGE);
		System.out.println("expectedText: " + expectedText);
		return !("".equals(expectedText)) && expectedText != null ? expectedText : ("此元素上无文本或xml文件中未配置元素的文本信息");
	}
	
	/**
	 * 获取元素的xpath
	 * 
	 * @param text
	 *            元素名称
	 * @param filename
	 *            存储元素的xml文件名
	 * @return 元素的xpath
	 * @throws Exception
	 */
	public String getXpath(String text, String filename) throws Exception {
		Map<String, Object> elementMap = rXmlFileUtils.getElement(filename, text);
		Map<String, String> xpathMap = (Map<String, String>) elementMap.get(XPATH);
		String xpathStr = xpathMap.get(LANGUAGE);

		return !("".equals(xpathStr)) && xpathStr != null ? xpathStr : ("未配置该元素的xpath信息");
	}

}

/**
 * located all the elements of GuidePage
 * author: tina
 * Date:2017/07/03
 */
package com.arisan1000.elements;

import org.openqa.selenium.WebElement;

import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class GuidePageElements {

	private static final String FILENAME = "GuidePageElements.xml";
	public String elementName = null;
	WebElement el = null;
	ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();

	/*
	 * 判断当前页面是否是启动时的预览页
	 */
	public Boolean isGuidePage(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "view";
		try{
			return elementOperatedUtils.hasWaitedElement(driver, elementName, FILENAME, 5);
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
		
	}
	
	/**
	 * 获取next按钮
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateNextBtn(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "nextBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 获取next按钮上文本的期望值
	 * @return
	 * @throws Exception
	 */
	public String getNextBtnExceptedText() throws Exception{
		elementName = "nextBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//TODO
	
	public WebElement locatePage1Title(){
		elementName = "page1_title";
		return null;
	}
	
	public String getPage1TitleExceptedText() throws Exception{
		elementName = "page1_title";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	public WebElement locatePage2Title()  throws Exception{
		elementName = "page2_title";
		return null;
	}
	
	public String getPage2TitleExceptedText()  throws Exception{
		elementName = "page2_title";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	public WebElement locatePage3Title()  throws Exception{
		elementName = "page3_title";
		return null;
	}
	
	public String getPage3TitleExceptedText()  throws Exception{
		elementName = "page3_title";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	public WebElement locatePage4Title()  throws Exception{
		elementName = "page4_title";
		return null;
	}
	
	public String getPage4TitleExceptedText()  throws Exception{
		elementName = "page4_title";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	
	/**
	 * 启动引导页面【开始】按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateStartBtn(AppiumDriver driver) throws Exception {
		elementName = "start";
		Thread.sleep(3000);
//		elementOperatedUtils.scrollToLeftFindElement(driver, elementName, FILENAME);
		for(int i=0;i<3;i++){
			locateNextBtn(driver).click();
		}
		
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 获取【开始】按钮上的文本
	 * @return
	 * @throws Exception
	 */
	public String getStartExceptedText() throws Exception {
		elementName = "start";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

}

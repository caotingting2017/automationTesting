/**
 * app启动时，四个滑动文案的检查
 * 运行时条件：将noReset 的值设置为false
 */
package com.arisan1000.test;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arisan1000.elements.GuidePageElements;
import com.arisan1000.utils.DriverConfig;
import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class SplashGuidePageTest extends BaseTest{

	GuidePageElements guidePageElements = new GuidePageElements();
	ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();
	WebElement el = null;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverConfig.CreatAppiumDriver();
	}
	
	//是否加载出滑动的引导页面
	@Test
	public void test001IsScrollGuidePage() throws Exception{
		assertTrue(guidePageElements.isGuidePage(driver));
	}
	
	//检查next按钮文案
	@Test
	public void test002NextBtnStrCheck() throws Exception{
		Thread.sleep(5000);
		el = guidePageElements.locateNextBtn(driver);
		assertEquals(el.getText(), guidePageElements.getNextBtnExceptedText());
	}
	
	// 四个可滑动的引导页面文案检查
	@Test
	public void test003ScrollGuidePageTextCheck() throws Exception {
		//TOTO
	}

}

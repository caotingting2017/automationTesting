/**
 * app启动时，四个滑动文案的检查
 * 运行时条件：将noReset 的值设置为false
 */
package com.arisan1000.test;


import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.arisan1000.utils.DriverConfig;

import io.appium.java_client.AppiumDriver;

public class BaseTest {

	protected AppiumDriver<WebElement> driver;

//	@BeforeMethod
//	public void setUp() throws Exception {
//		driver = DriverConfig.CreatAppiumDriver();
//	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

}

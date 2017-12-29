package com.arisan1000.test;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arisan1000.utils.DriverConfig;

import io.appium.java_client.AppiumDriver;

public class TwentyFourEventTest {

	public AppiumDriver<WebElement> driver;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverConfig.CreatAppiumDriver();
		// 登录
		driver.findElementByAccessibilityId("com.arisan1000.android:id/tab_view_click_me").click();
		driver.findElementByAccessibilityId("com.arisan1000.android:id/me_icon").click();
		driver.findElementByAccessibilityId("com.arisan1000.android:id/email_login").click();
		// driver.findElementByXPath("//android.widget.TextView[@text=\"E-mail\"]").sendKeys("id001@a.com");
		// driver.findElementByXPath("//android.widget.TextView[@text=\"E-mail\"]").sendKeys("id001@a.com");
		ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElementsByClassName("android.widget.EditText");
		for (WebElement el : list) {
			System.out.println("syso info :" + el.getText());
		}

	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

	// 24小时充值活动验证
	@Test
	public void test24Event30() {

	}
}

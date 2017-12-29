//https://github.com/appium/sample-code/blob/master/sample-code/examples/java/junit/src/test/java/com/saucelabs/appium/BaseDriver.java
package com.arisan1000.test;

import static org.testng.Assert.assertEquals;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arisan1000.elements.GuidePageElements;
import com.arisan1000.elements.HomePageElements;
import com.arisan1000.utils.DriverConfig;
import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class StartApp {

	public AppiumDriver<WebElement> driver;
//	public ElementOperatedUtils elementPeratedUtils = null;
//	private static final String FILENAME = "GuidePageElements.xml";
	GuidePageElements guidePageElements = null;
	HomePageElements homePageElements = null;
	WebElement el = null;
	@BeforeMethod
	public void setUp() throws Exception{
		driver = DriverConfig.CreatAppiumDriver();
		guidePageElements = new GuidePageElements();
		homePageElements = new HomePageElements();
		
		System.out.println("start ok!");
	}
	
	@Test
	public void startAppTest() throws Exception{
		el = guidePageElements.locateStartBtn(driver);
		assertEquals(el.getText(), guidePageElements.getStartExceptedText());
		System.out.println("start Text====="+el.getText());
	}
	
//	@Test(enabled = false)
	@Test
	public void xpathTest() throws Exception{
		Thread.sleep(5000);
		el = guidePageElements.locateStartBtn(driver);
		el.click();//关闭引导页
		
		el= driver.findElement(By.id("com.arisan1000.android:id/close"));
		el.click();
		
		el = homePageElements.locateAppTitle(driver);
		System.out.println("title:"+el.getText());
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		guidePageElements = null;
		if (driver != null) {
            driver.quit();
        }
    }
	
}

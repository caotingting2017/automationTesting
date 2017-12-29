package com.arisan1000.test;

import java.util.List;

import static org.testng.Assert.*;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arisan1000.elements.GuidePageElements;
import com.arisan1000.elements.HomePageElements;
import com.arisan1000.utils.DriverConfig;
import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class HomePageTest {

		public AppiumDriver<WebElement> driver;
		ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();
		HomePageElements homePageElements = new HomePageElements();
		WebElement el = null;

		@BeforeMethod
		public void setUp() throws Exception  {
			driver = DriverConfig.CreatAppiumDriver();
			try {
				// 是否有引导页面
				GuidePageElements guidePageElements = new GuidePageElements();
				if (guidePageElements.isGuidePage(driver) == true) {
					el = guidePageElements.locateStartBtn(driver);
					el.click();

					// 关闭新手大礼包弹框
					homePageElements.locateCloseBtn(driver).click();

				}

			} catch (Exception e) {

			} finally {
				Thread.sleep(3000);
			}

		}

		// 是否打开Home页面
		@Test
		public void test001HomePage() throws Exception {
			assertTrue(homePageElements.isHomePage(driver), "home page loading error !");
		}

		// app标题文案检查
		@Test
		public void test002AppTitleStrCheck() throws Exception {
			el = homePageElements.locateAppTitle(driver);
			assertEquals(el.getText(), homePageElements.getApptitleExceptedText());
		}

		// 判断导航菜单的文案是否正确
		@Test
		public void test003NavigationTitleStrCheck() throws Exception{
			List<WebElement> elList = homePageElements.locateNavigationTitle(driver);
			for(int i = 0; i < elList.size();i++){
				assertEquals(elList.get(i).getText(), homePageElements.getNavigationTitleExceptedStr(i+""));
			}
		}

		// 判断底部各Tab页面文案是否正确

		// 点击新手引导，是否打开新手引导的页面

		/** 未登录功能验证 **/

		// 四个导航按钮：com.arisan1000.android:id/entry_iv



}

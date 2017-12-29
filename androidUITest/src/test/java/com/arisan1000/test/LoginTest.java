package com.arisan1000.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arisan1000.elements.GuidePageElements;
import com.arisan1000.elements.HomePageElements;
import com.arisan1000.elements.LoginRegisterPageElements;
import com.arisan1000.elements.MePageElements;
import com.arisan1000.utils.CommonMethodUtils;
import com.arisan1000.utils.DriverConfig;

import io.appium.java_client.AppiumDriver;

public class LoginTest{
	public AppiumDriver<WebElement> driver;
	WebElement el = null;
	HomePageElements homePageElements = new HomePageElements();
	LoginRegisterPageElements loginRegisterPageElements = new LoginRegisterPageElements();
	MePageElements mePageElements = new MePageElements();
	
	@BeforeMethod
	public void setUp() throws Exception{
		driver = DriverConfig.CreatAppiumDriver();
		try {
			// 是否有引导页面
			GuidePageElements guidePageElements = new GuidePageElements();
			if (guidePageElements.isGuidePage(driver) == true) {
				el = guidePageElements.locateStartBtn(driver);
				el.click();
				
			}
			// 关闭新手大礼包弹框
			homePageElements.locateCloseBtn(driver).click();

		} catch (Exception e) {

		} finally {
//			//进入个人中心
////			driver.findElementByAccessibilityId("com.arisan1000.android:id/tab_view_click_me").click();
//			driver.findElement(By.id("com.arisan1000.android:id/tab_view_click_me")).click();
//			//进入登录注册页面
////			driver.findElementByAccessibilityId("com.arisan1000.android:id/me_icon").click();
//			driver.findElement(By.id("com.arisan1000.android:id/me_icon")).click();
//			//进入登录页面
////			driver.findElementByAccessibilityId("com.arisan1000.android:id/email_login").click();
//			driver.findElement(By.id("com.arisan1000.android:id/email_login")).click();
			
			homePageElements.locateSettingIcon(driver).click();
			mePageElements.locateMeIcon(driver).click();
		}
		
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}
	
	//登录页面标题检查
	@Test
	public void test001LoginPage() throws Exception{
		loginRegisterPageElements.locateEmailLoginBtn(driver).click();
		Thread.sleep(3000);
		el = loginRegisterPageElements.locateLoginPageTitle(driver);
		System.out.println("title"+el.getText());
		assertEquals(el.getText(), loginRegisterPageElements.getLoginPageTitleExceptedText());
	}
	
	//打开app,进入个人中心，点击登录--Email登录（输入正确的用户名和密码）：用户名：test001@163.com , 密码：123456 //印尼 id001@a.com,密码123456
	@Test
	public void test002Login() throws Exception{
		loginRegisterPageElements.locateEmailLoginBtn(driver).click();
		Thread.sleep(3000);
		String email = "id002@a.com";
		String pwd = "123456";
		
		WebElement emailInput = loginRegisterPageElements.locatorEmailInput(driver);//Email输入框
		WebElement pwdInput = loginRegisterPageElements.locatorPwdInput(driver);
		
		emailInput.clear();
		emailInput.sendKeys(email);
		
		pwdInput.clear();
		pwdInput.sendKeys(pwd);
		
		loginRegisterPageElements.locatorLoginBtn(driver).click();
		
		//登录成功，跳转到其他页面。当前页面不是登录页面
		assertFalse(loginRegisterPageElements.isLoginPage(driver));
		
		//退出登录
		mePageElements.locateMeIcon(driver).click();//点击头像
		mePageElements.locateLogoutBtn(driver).click();//点击退出按钮
		mePageElements.locateLogoutAlertYes(driver).click();
		
	}
	
	//退出登录
	@Test
	public void test002Logout() throws Exception{
		new CommonMethodUtils().logout(driver);
	}
}

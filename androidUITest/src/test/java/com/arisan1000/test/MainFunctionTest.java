package com.arisan1000.test;

import static org.testng.Assert.*;

import java.beans.VetoableChangeListenerProxy;
import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.arisan1000.elements.GuidePageElements;
import com.arisan1000.elements.HomePageElements;
import com.arisan1000.elements.LoginRegisterPageElements;
import com.arisan1000.elements.MePageElements;
import com.arisan1000.elements.ProductPageElements;
import com.arisan1000.elements.RechargePageElements;
import com.arisan1000.utils.CommonMethodUtils;
import com.arisan1000.utils.DriverConfig;
import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class MainFunctionTest {

	public AppiumDriver<WebElement> driver;

	ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();
	HomePageElements homePageElements = new HomePageElements();
	LoginRegisterPageElements loginRegisterPageElements = new LoginRegisterPageElements();
	MePageElements mePageElements = new MePageElements();
	RechargePageElements rechargePageElements = new RechargePageElements();
	ProductPageElements productPageElements = new ProductPageElements();
	CommonMethodUtils commonMethod = new CommonMethodUtils();
	WebElement el = null;

	String PAYPHONE = "089507209582";
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverConfig.CreatAppiumDriver();
		try {
			// 是否有引导页面
			GuidePageElements guidePageElements = new GuidePageElements();
			if (guidePageElements.isGuidePage(driver) == true) {
				guidePageElements.locateStartBtn(driver).click();
			}
			// 关闭新手大礼包弹框//关闭满返券弹框//com.arisan1000.android:id/btn_now_buy
			homePageElements.locateCloseBtn(driver).click();

		} catch (Exception e) {

		} finally {
			homePageElements.isHomePage(driver);
			Thread.sleep(3000);
		}

	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

	// 是否打开Home页面
	@Test
	public void test001HomePage() throws Exception {
		assertTrue(homePageElements.isHomePage(driver), "home page loading error !");
	}

	// 登录与退出登录流程
	@Test
	public void test002Login() throws Exception {
		// 进入个人中心 -- 登录页面
		commonMethod.gotoLoginRegisterPage(driver);
		loginRegisterPageElements.locateEmailLoginBtn(driver).click();

		// 登录
		String email = "id004@a.com";
		String pwd = "123456";
		
//		String email = "tina.cao@mobisummer.com";
//		String pwd = "123456";
		WebElement emailInput = loginRegisterPageElements.locatorEmailInput(driver);// Email输入框
		WebElement pwdInput = loginRegisterPageElements.locatorPwdInput(driver);

		emailInput.clear();
		emailInput.sendKeys(email);

		pwdInput.clear();
		pwdInput.sendKeys(pwd);

		loginRegisterPageElements.locatorLoginBtn(driver).click();

		// 登录成功，跳转到其他页面。当前页面不是登录页面
		assertFalse(loginRegisterPageElements.isLoginPage(driver));

		// TODO 关闭弹框：签到送积分弹框？新手大礼包弹框？

		// commonMethod.logout(driver);

	}

	// 用户注册流程:注册用户不能与老用户相同
	@Test(enabled = false)
	public void test003Register() throws Exception {
		// 进入注册页面
		commonMethod.gotoRegisterPager(driver);
		// 注册用户
		String emailInput = "ar003@ar.com";
		String pwd = "123456";
		WebElement regEmailInput = loginRegisterPageElements.locatorRegEmailInput(driver);
		WebElement regPwdInput = loginRegisterPageElements.locatorRegPwdInput(driver);
		WebElement regPwdConfirmInput = loginRegisterPageElements.locatorRegPwdConfirmInput(driver);

		regEmailInput.clear();
		regEmailInput.sendKeys(emailInput);
		regPwdInput.sendKeys(pwd);
		regPwdConfirmInput.sendKeys(pwd);

		loginRegisterPageElements.locatorRegBtn(driver).click();

		// 邀请好友页面
		assertTrue(loginRegisterPageElements.isInvitedFriendsPage(driver));
		loginRegisterPageElements.locateInvitePageSkipBtn(driver).click();

		// 退出当前用户
		commonMethod.logout(driver);
	}

	// TODO 充值流程:indosal充值 （测试的支付账号，好像不能用了）
	@Test
	public void test004RechargeWithIndosal() throws Exception {
		// 登录
		// commonMethod.gotoLoginRegisterPage(driver);
		// commonMethod.loginWithEmailAndPwd("id002@a.com", "123456", driver);
		// 进入充值页面
		homePageElements.locateRechargeIcon(driver).click();

		// 充值
		Thread.sleep(3000);
		rechargePageElements.locatorChargeMethodList(driver).get(0).click();
		int size = rechargePageElements.locatorSelectedBtnList(driver).size();
		rechargePageElements.locatorSelectedBtnList(driver).get(size - 1).click();
		rechargePageElements.locateSelectedAmountConfirm(driver).click();

		Thread.sleep(5000);
		// 获取当前context
		Set<String> contextNames = driver.getContextHandles();
		// for (String contextName : contextNames) {
		// System.out.println("contextName:"+contextNames); //prints out
		// something like NATIVE_APP \n WEBVIEW_1
		// }

		driver.context(contextNames.toArray()[1].toString());
		WebElement element = rechargePageElements.locateInputPhoneNumber(driver);
		element.clear();
		element.sendKeys(PAYPHONE);
		rechargePageElements.locateMdnSubmit(driver).click();
		rechargePageElements.locateInputOtp(driver).sendKeys("777");
		rechargePageElements.locateOtpSubmit(driver).click();
		// rechargePageElements.locateCodalPayConfirmBtn(driver).click();//报错
		Thread.sleep(3000);
		driver.findElement(By.className("continue")).click();

		Thread.sleep(5000);

		// 退出登录
		// commonMethod.logout(driver);

	}

	// 充值流程:Google Play充值(index=3)
	@Test
	public void test005RechargeWithGP() throws Exception {
		homePageElements.locateRechargeIcon(driver).click();
		Thread.sleep(3000);
		rechargePageElements.locatorChargeMethodList(driver).get(3).click();
		rechargePageElements.locatorSelectedBtnList(driver).get(0).click();
		rechargePageElements.locateSelectedAmountConfirm(driver).click();
		Thread.sleep(3000);

		// 点击GP充值弹框的【购买】按钮
		rechargePageElements.locateGPRechargeBtg(driver).click();
		Thread.sleep(5000);// 等待支付结果
		// 跳转到支付成功页面
		assertEquals(rechargePageElements.locatePayResultText(driver).getText(),
				rechargePageElements.getPayResultTextExceptedStr());

		rechargePageElements.locatePayResultConfirmBtn(driver).click();
		assertTrue(homePageElements.isHomePage(driver), "home page loading error !");
	}

	// 商品列表，购买1份商品（余额充足）
	@Test
	public void test006ProductListBuy() throws Exception {
		homePageElements.locatorBuyBtnList(driver).get(0).click();
		commonMethod.purchaseOne(driver);
		assertEquals(productPageElements.locatePurchaseResultText(driver).getText(),
				productPageElements.getPurchaseResultTextExceptedStr());

	}

	// 商品列表，购买1份，确认购买
	@Test
	public void test007PurchaseConfirm() throws Exception {
		homePageElements.locatorBuyBtnList(driver).get(0).click();
		commonMethod.purchaseOne(driver);
		assertEquals(productPageElements.locatePurchaseResultText(driver).getText(),
				productPageElements.getPurchaseResultTextExceptedStr());
		productPageElements.locatePurchaseConfirmBtn(driver).click();
		assertTrue(homePageElements.isHomePage(driver));
	}

	// 商品列表，购买1份，再次购买1份
	@Test
	public void test008PurchaseAgain() throws Exception {
		homePageElements.locatorBuyBtnList(driver).get(0).click();
		commonMethod.purchaseOne(driver);
		productPageElements.locatePurchaseAgainBtn(driver).click();
		productPageElements.locateProductPageBuyBtn(driver).click();
		commonMethod.purchaseOne(driver);
		assertEquals(productPageElements.locatePurchaseResultText(driver).getText(),
				productPageElements.getPurchaseResultTextExceptedStr());
	}

	// 商品详情页购买1份，购买成功
	@Test
	public void test009BuyInProductPage() throws Exception {
		homePageElements.locatorProductIconList(driver).get(0).click();// 进入商品详情页
		productPageElements.locateProductPageBuyBtn(driver).click();
		commonMethod.purchaseOne(driver);
		assertEquals(productPageElements.locatePurchaseResultText(driver).getText(),
				productPageElements.getPurchaseResultTextExceptedStr());
	}

	// 商品详情页购买1份，购买成功（若时间紧急，可以不执行此用例。只执行test011）
	@Test
	public void test010BuyInProductPageConfirm() throws Exception {
		homePageElements.locatorProductIconList(driver).get(0).click();// 进入商品详情页
		productPageElements.locateProductPageBuyBtn(driver).click();
		commonMethod.purchaseOne(driver);
		assertEquals(productPageElements.locatePurchaseResultText(driver).getText(),
				productPageElements.getPurchaseResultTextExceptedStr());
	}
	
	//商品详情页购买1份，购买成功,再次购买 
	@Test
	public void test011BuyAgainInProductPage() throws Exception {
		homePageElements.locatorProductIconList(driver).get(0).click();// 进入商品详情页
		productPageElements.locateProductPageBuyBtn(driver).click();
		commonMethod.purchaseOne(driver);
		//再次购买
		productPageElements.locatePurchaseAgainBtn(driver).click();
		productPageElements.locateProductPageBuyBtn(driver).click();
		commonMethod.purchaseOne(driver);
		assertEquals(productPageElements.locatePurchaseResultText(driver).getText(),
				productPageElements.getPurchaseResultTextExceptedStr());
	}
	
	//首页--商品列表--购买1份商品（余额不足）-- 充值成功 --购买成功
	@Test
	public void test012BuyAndRecharge() throws Exception {
		commonMethod.gotoLoginRegisterPage(driver);
		//登录一个没钱的账号
		commonMethod.loginWithEmailAndPwd("id009@a.com", "123456", driver);
//		commonMethod.loginWithEmailAndPwd("test003@mobisummer.com", "123456", driver);
		homePageElements.locateCheckInCloseBtn(driver).click();//关闭签到框
		
		homePageElements.locatorBuyBtnList(driver).get(0).click();
		commonMethod.purchaseThree(driver);
		
		//充值
		rechargePageElements.locatorChargeMethodList(driver).get(3).click();
		Thread.sleep(3000);
		rechargePageElements.locateGPRechargeBtg(driver).click();
		Thread.sleep(5000);
		assertEquals(productPageElements.locatePurchaseResultText(driver).getText(),
				productPageElements.getPurchaseResultTextExceptedStr());
	}
	
	
	//首页--商品列表--购买3份商品（余额不足）-- GP充值成功 --购买成功 --确认
	@Test
	public void test013BuyAndRechargeConfirm() throws Exception {
		
	}
	
	//首页--商品列表--购买1份商品（余额不足）-- 充值成功 --购买成功 --再次购买
	@Test
	public void test014RechargeBuyAgain() throws Exception {
		
	}
	
	
	
	
	

	// TODO 商品列表购买充值（余额不足）：购买一份 (等待下一次发包给购买充值页面加id)
	@Test(enabled = false)
	public void test099PurchaseRecharge() throws Exception {
		// 登录一个未充值的账号
		commonMethod.gotoLoginRegisterPage(driver);

		commonMethod.loginWithEmailAndPwd("id013@a.com", "123456", driver);

		homePageElements.locatorBuyBtnList(driver).get(0).click();
		commonMethod.purchaseOne(driver);

		// 是否需要充值
		if (true) {
			// 充值
		}

		assertEquals(productPageElements.locatePurchaseResultText(driver).getText(),
				productPageElements.getPurchaseResultTextExceptedStr());
	}

	// 元素定位测试
	@Test(enabled = false)
	public void test100ElementLocator() throws Exception {

	}

	// 退出登录
	@Test
	public void test101Logout() throws Exception {
		homePageElements.locateSettingIcon(driver).click();
		commonMethod.logout(driver);
		assertTrue(homePageElements.isHomePage(driver));
	}
}

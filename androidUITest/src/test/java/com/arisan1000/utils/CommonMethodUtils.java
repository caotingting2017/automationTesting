/**
 * 公共方法：无其他因素干扰时，可使用公共方法
 */
package com.arisan1000.utils;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.arisan1000.elements.HomePageElements;
import com.arisan1000.elements.LoginRegisterPageElements;
import com.arisan1000.elements.MePageElements;
import com.arisan1000.elements.ProductPageElements;
import com.sun.jna.platform.win32.OaIdl.VARKIND;

import io.appium.java_client.AppiumDriver;

public class CommonMethodUtils {
	LoginRegisterPageElements loginRegisterPageElements = new LoginRegisterPageElements();
	MePageElements mePageElements = new MePageElements();
	HomePageElements homePageElements = new HomePageElements();
	ProductPageElements productPageElements = new ProductPageElements();

	// 进入登录注册页面
	public void gotoLoginRegisterPage(AppiumDriver<WebElement> driver) throws Exception {
		// 如果已有用户登录，则先退出当前登录用户
		if (isUserLogin(driver)) {
			logout(driver);
			homePageElements.locateSettingIcon(driver).click();
		}
		mePageElements.locateMeIcon(driver).click();
		Thread.sleep(3000);
	}

	// 进入Email注册页面
	public void gotoRegisterPager(AppiumDriver<WebElement> driver) throws Exception {
		gotoLoginRegisterPage(driver);
		loginRegisterPageElements.locateRegisterLinkStr(driver).click();
		loginRegisterPageElements.locateEmailRegisterBtn(driver).click();
	}

	// 登录
	public void loginWithEmailAndPwd(String email, String pwd, AppiumDriver<WebElement> driver) throws Exception {
		loginRegisterPageElements.locateEmailLoginBtn(driver).click();
		WebElement emailInput = loginRegisterPageElements.locatorEmailInput(driver);// Email输入框
		WebElement pwdInput = loginRegisterPageElements.locatorPwdInput(driver);

		emailInput.clear();
		emailInput.sendKeys(email);

		pwdInput.clear();
		pwdInput.sendKeys(pwd);

		loginRegisterPageElements.locatorLoginBtn(driver).click();
		Thread.sleep(3000);
	}

	// 退出登录
	public void logout(AppiumDriver<WebElement> driver) throws Exception {
		// try{
		// homePageElements.locateSettingIcon(driver).click();
		// }catch (Exception e) {
		//
		// }
		mePageElements.locateMeIcon(driver).click();// 点击头像
		mePageElements.locateLogoutBtn(driver).click();// 点击退出按钮
		mePageElements.locateLogoutAlertYes(driver).click();
	}

	// 购买1份商品
	public void purchaseOne(AppiumDriver<WebElement> driver) throws Exception {
		productPageElements.locateChoiceOneBtn(driver).click();
		productPageElements.locateChoiceConfirmBtn(driver).click();
		Thread.sleep(5000);
	}

	// 购买3份商品
	public void purchaseThree(AppiumDriver<WebElement> driver) throws Exception {
		WebElement el = productPageElements.locateChoiceEditInput(driver);
		el.clear();
		el.sendKeys("3");
		productPageElements.locateChoiceConfirmBtn(driver).click();
		Thread.sleep(3000);
	}

	// 注册

	// 补充邀请人

	// 充值

	// 判断是否有登录用户,true:已登录;false:未登录
	public Boolean isUserLogin(AppiumDriver<WebElement> driver) throws Exception {
		homePageElements.locateSettingIcon(driver).click();
		return (!mePageElements.getNicknameExceptedStr().equals(mePageElements.locateNickname(driver).getText()));
	}

}

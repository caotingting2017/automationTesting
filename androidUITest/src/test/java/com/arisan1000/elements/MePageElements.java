/**
 * located all the elements of MePage
 * author: tina
 * Date:2017/10/20
 */
package com.arisan1000.elements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class MePageElements {

	private static final String FILENAME = "MePageElements.xml";
	public String elementName = null;
	public String elListName = null;
	WebElement el = null;
	ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();

	/**
	 * 头像定位
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateMeIcon(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "meIcon";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 昵称定位 ===因nickname 与 balance的id是一样的，此方法不能定位到nickname.
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateNickname(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "nickname";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 未登录时，昵称的预期文案
	 * @return
	 * @throws Exception
	 */
	public String getNicknameExceptedStr() throws Exception {
		elementName = "nickname";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	/**
	 * 充值按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateTopUpBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "topUp";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 充值按钮的预期文案
	 * @return
	 * @throws Exception
	 */
	public String getTopUpBtnExceptedStr() throws Exception {
		elementName = "topUp";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	/**
	 * 【退出登录】按钮定位
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateLogoutBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "logout";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 【退出登录】按钮文案预期值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getEeceiveAwardBtnExceptedStr() throws Exception {
		elementName = "logout";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	public WebElement locateLogoutAlertYes(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "logoutAlertYes";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	public WebElement locateLogoutAlertCancel(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "logoutAlertCancel";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

}

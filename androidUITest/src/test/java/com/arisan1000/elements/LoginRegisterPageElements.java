/**
 * 登录注册页面，登录页面，注册页面元素
 */
package com.arisan1000.elements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class LoginRegisterPageElements {
	private static final String FILENAME = "LoginRegisterPageElements.xml";
	public String elementName = null;
	public String elListName = null;
	WebElement el = null;
	ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();

	/* 登录注册页面 */
	// 登录Tab页面

	/**
	 * 定位注册的文本链接，点击后滑动到注册Tab
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateRegisterLinkStr(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "registerLinkStr";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 定位FB登录按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateFBLoginBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "FBLoginBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 定位GP登录按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateGPLoginBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "GPLoginBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 定位Email登录按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateEmailLoginBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "emailLoginBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	// 注册Tab页面
	/**
	 * 登录文本链接
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateLoginLinkStr(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "loginLinkStr";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * FB注册按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateFBRegisterBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "FBRegisterBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * GP注册按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateGPRegisterBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "GPRegisterBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 定位Email注册按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateEmailRegisterBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "emailRegisterBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/* 登录页面 */
	/**
	 * 定位登录页面标题
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateLoginPageTitle(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "LoginPageTitle";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 获取登录页面标题 的文本期望值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getLoginPageTitleExceptedText() throws Exception {
		elementName = "LoginPageTitle";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	/**
	 * 获取所有的文本编辑框
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> locatorLoginPageEditInputElementList(AppiumDriver<WebElement> driver) throws Exception {
		elListName = "EditInput";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}

	// Email文本输入框
	public WebElement locatorEmailInput(AppiumDriver<WebElement> driver) throws Exception {
		return locatorLoginPageEditInputElementList(driver).get(0);// index=0:Email输入框,index=1:密码输入框
	}

	// 密码输入框
	public WebElement locatorPwdInput(AppiumDriver<WebElement> driver) throws Exception {
		return locatorLoginPageEditInputElementList(driver).get(1);// index=0:Email输入框,index=1:密码输入框
	}

	/**
	 * 定位登录按钮
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locatorLoginBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "loginBtn";
		return elementOperatedUtils.findElement(driver, elementName, FILENAME);
	}

	public String getLoginBtnExceptedText() throws Exception {
		elementName = "loginBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	public Boolean isLoginPage(AppiumDriver<WebElement> driver) {
		Boolean result = true;// false:不是登录页面，true:是登录页面
		try {
			locateLoginPageTitle(driver);
		} catch (Exception e) {
			result = false;
		} finally {
			return result;
		}

	}

	/* 注册页面 */
	/**
	 * 定位注册页面标题
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateRegisterPageTitle(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "registerPageTitle";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 获取注册页面标题 的文本期望值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getRegisterPageTitleExceptedText() throws Exception {
		elementName = "registerPageTitle";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	/**
	 * 获取三个文本输入框：Email、password、repassword
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> locatorRegisterPageTextInputElementList(AppiumDriver<WebElement> driver) throws Exception {
		elListName = "textInput";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}

	// Email文本输入框
	public WebElement locatorRegEmailInput(AppiumDriver<WebElement> driver) throws Exception {
		return locatorRegisterPageTextInputElementList(driver).get(0);// index=0:Email输入框,index=1:密码输入框
	}

	// 密码输入框
	public WebElement locatorRegPwdInput(AppiumDriver<WebElement> driver) throws Exception {
		return locatorRegisterPageTextInputElementList(driver).get(1);// index=0:Email输入框,index=1:密码输入框
	}

	// 密码确认输入框
	public WebElement locatorRegPwdConfirmInput(AppiumDriver<WebElement> driver) throws Exception {
		return locatorRegisterPageTextInputElementList(driver).get(2);// index=0:Email输入框,index=1:密码输入框
	}
	
	//注册按钮
	public WebElement locatorRegBtn(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "regBtn";
		return elementOperatedUtils.findElement(driver, elementName, FILENAME); 
	}
	
	public String getRegBtnExceptedText() throws Exception {
		elementName = "regBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	/**
	 * 当前页面是否是注册页面
	 * 
	 * @param driver
	 * @return
	 */
	public Boolean isRegisterPage(AppiumDriver<WebElement> driver) {
		Boolean result = true;// false:不是登录页面，true:是登录页面
		try {
			locateRegisterPageTitle(driver);
		} catch (Exception e) {
			result = false;
		} finally {
			return result;
		}
	}
	
	/**
	 * 定位邀请好友页面标题
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateInvitePageTitle(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "invitePageTitle";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 获取邀请好友页面标题 的文本期望值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getInvitePageTitleExceptedText() throws Exception {
		elementName = "invitePageTitle";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	//跳过
	public WebElement locateInvitePageSkipBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "inviteSkip";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 当前页面是否是补充邀请人页面
	 * 
	 * @param driver
	 * @return
	 */
	public Boolean isInvitedFriendsPage(AppiumDriver<WebElement> driver) {
		Boolean result = true;// false:不是登录页面，true:是登录页面
		try {
			elementName = "invitePageTitle";
			return (new ElementOperatedUtils().hasWaitedElement(driver, elementName, FILENAME, 5));
		} catch (Exception e) {
			result = false;
		} finally {
			return result;
		}
	}
	
	
	
}







/**
 * located all the elements of GuidePage
 * author: tina
 * Date:2017/07/03
 */
package com.arisan1000.elements;


import java.util.List;

import org.openqa.selenium.WebElement;

import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class HomePageElements {

	private static final String FILENAME = "HomePageElements.xml";
	public String elementName = null;
	public String elListName = null;
	WebElement el = null;
	ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();

	/**
	 * 首次打开首页时，弹出的新手大礼包弹框上的文案元素：
	 * 登录领取价值$50刀的优惠券
	 * 即有机会赢取丰厚奖品
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateNoticeStr(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "noticeStr";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 新手大礼包弹框上的文案的预期值
	 * @return
	 * @throws Exception
	 */
	public String getNoticeExceptedStr() throws Exception{
		elementName = "noticeStr";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	/**
	 * 弹框上的确定按钮
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateReceiveAwardBtn(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "receiveAwardBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 新手大礼包弹框--确定按钮文案预期值
	 * @return
	 * @throws Exception
	 */
	public String getEeceiveAwardBtnExceptedStr() throws Exception{
		elementName = "receiveAwardBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	/**
	 * 弹框的关闭按钮
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateCloseBtn(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "closeBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 当前页面是否是首页
	 * @param driver
	 * @return
	 */
	public Boolean isHomePage(AppiumDriver<WebElement> driver){
		elementName = "homePage";
		try{
			elementOperatedUtils.hasWaitedElement(driver, elementName, FILENAME, 5);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * App标题
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateAppTitle(AppiumDriver driver) throws Exception {
		elementName = "AppTitle";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}

	/**
	 * 获取标题元素上的文本期望值（在xml文件中配置）
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getApptitleExceptedText() throws Exception {
		elementName = "AppTitle";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	/**
	 * 获取导航菜单按钮的icon
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> locateNavigationIcon(AppiumDriver<WebElement> driver) throws Exception{
		elListName = "navigationIcon";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}
	
	/**
	 * 导航菜单标题（4个）
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> locateNavigationTitle(AppiumDriver<WebElement> driver) throws Exception{
		elListName = "navigationTitle";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}
	
	/**
	 * 导航菜单标题的期望值（4个）
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public String getNavigationTitleExceptedStr(String index) throws Exception{
		elListName = "navigationTitle";
//		elementOperatedUtils.getListChildElementExceptedText(elListName, FILENAME, index);
//		System.out.println(elementOperatedUtils.getListChildElementExceptedText(elListName, FILENAME, index));
		return elementOperatedUtils.getListChildElementExceptedText(elListName, FILENAME, index);
	}
	
	/*首页底部的Tab页签*/
	/**
	 * index Tab 定位
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateIndexTab(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "tabIndex";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * event Tab 定位
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateEventTab(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "tabEvent";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * me Tab 定位
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public WebElement locateMeTab(AppiumDriver<WebElement> driver) throws Exception{
		elementName = "tabMe";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/**
	 * 底部Tab菜单标题的期望值（4个）
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public String getTabMenuTitleExceptedStr(String index) throws Exception{
		elListName = "tabMenuTitle";
		return elementOperatedUtils.getListChildElementExceptedText(elListName, FILENAME, index);
	}
	
	//菜单icon  com.arisan1000.android:id/app_bar_navigation
	public WebElement locateSettingIcon(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "settingIcon";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	//首页充值icon com.arisan1000.android:id/menu_home_top_up
	public WebElement locateRechargeIcon(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "rechargeIcon";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//获取商品列表页面所有的购买按钮
	public List<WebElement> locatorBuyBtnList(AppiumDriver<WebElement> driver) throws Exception {
		elListName = "buyBtn";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}
	
	//获取商品列表的所有商品图 com.arisan1000.android:id/icon
	public List<WebElement> locatorProductIconList(AppiumDriver<WebElement> driver) throws Exception {
		elListName = "productIcon";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}
	
	//签到弹框的关闭按钮 com.arisan1000.android:id/check_in_close_iv
	public WebElement locateCheckInCloseBtn(AppiumDriver<WebElement> driver)throws Exception{
		elListName = "checkInCloseBtn";
		return elementOperatedUtils.findElement(driver, elListName, FILENAME);
	}
	
	
}

/**
 * 份数选择框、商品详情页、商品购买结果页面元素
 */
package com.arisan1000.elements;

import org.openqa.selenium.WebElement;

import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class ProductPageElements {
	
	private static final String FILENAME = "ProductPageElements.xml";
	public String elementName = null;
	public String elListName = null;
	WebElement el = null;
	ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();
	
	/**份数选择框**/
	//份数减按钮 com.arisan1000.android:id/add_reduce_view_minus
	public WebElement locateChoiceMinusBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceMinusBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	//份数输入框 com.arisan1000.android:id/add_reduce_view_edit
	public WebElement locateChoiceEditInput(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceEditInput";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	//份数加按钮 com.arisan1000.android:id/add_reduce_view_plus
	public WebElement locateChoicePlusBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choicePlusBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//选择1份 com.arisan1000.android:id/choice_view_one_times
	public WebElement locateChoiceOneBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceOneBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	//选择5份 com.arisan1000.android:id/choice_view_five_times
	public WebElement locateChoiceFiveBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceFiveBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	//选择10份 com.arisan1000.android:id/choice_view_ten_times
	public WebElement locateChoiceTenBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceTenBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	//选择20份 com.arisan1000.android:id/choice_view_twenty_times
	public WebElement locateChoiceTwentyBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceTwentyBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	//选择50份 com.arisan1000.android:id/choice_view_fifty_times
	public WebElement locateChoiceFiftyBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceFiftyBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	//剩余份数 com.arisan1000.android:id/choice_view_all Semua
	public WebElement locateChoiceAllBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceAllBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//份数确认按钮 com.arisan1000.android:id/choice_view_confirm （4.81‰ kesempatan menang）	
	public WebElement locateChoiceConfirmBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "choiceConfirmBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	
	/**购买结果页面**/
	//结果文案 com.arisan1000.android:id/tv_pay_result Berhasil membeli
	public WebElement locatePurchaseResultText(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "purchaseResultText";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getPurchaseResultTextExceptedStr() throws Exception{
		elementName = "purchaseResultText";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//结果提示信息
	/*
	 * com.arisan1000.android:id/tv_pay_result_tip
	 * Lengkapi biodata akun anda dan lihat pengumuman pemenang di (Akun - Semua)
	 * */
	public WebElement locateResultTips(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "resultTips";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getResultTipsExceptedStr() throws Exception{
		elementName = "resultTips";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}

	//再次购买 com.arisan1000.android:id/btn_double_left Beli lagi
	public WebElement locatePurchaseAgainBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "purchaseAgainBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getPurchaseAgainBtnExceptedStr() throws Exception{
		elementName = "purchaseAgainBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//确认 com.arisan1000.android:id/btn_double_right  Konfirmasi
	public WebElement locatePurchaseConfirmBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "purchaseConfirmBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getPurchaseConfirmBtnExceptedStr() throws Exception{
		elementName = "purchaseConfirmBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	/***商品详情页***/
	//购买按钮 com.arisan1000.android:id/product_detail_buy_now menangkan sekarang
	public WebElement locateProductPageBuyBtn(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "productPageBuyBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getProductPageBuyBtnExceptedStr() throws Exception{
		elementName = "productPageBuyBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	
	//所有参与者记录菜单栏（all participants Record）com.arisan1000.android:id/ll_record_detail
	public WebElement locateAllParticipantsRecordMenu(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "allParticipantsRecordMenu";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//历史中奖记录菜单栏（historical winner）com.arisan1000.android:id/ll_historical_winners
	public WebElement locateHistoricalWinnerMenu(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "historicalWinnerMenu";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//商品介绍菜单栏（Detail）com.arisan1000.android:id/ll_product_detail 
	public WebElement locateProductDetailMenu(AppiumDriver<WebElement> driver)throws Exception{
		elementName = "productDetailMenu";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
}

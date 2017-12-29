/**
 * 充值页面元素
 */
package com.arisan1000.elements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.arisan1000.utils.ElementOperatedUtils;

import io.appium.java_client.AppiumDriver;

public class RechargePageElements {
	private static final String FILENAME = "RechargePageElements.xml";
	public String elementName = null;
	public String elListName = null;
	WebElement el = null;
	ElementOperatedUtils elementOperatedUtils = new ElementOperatedUtils();
	
	//返回按钮com.arisan1000.android:id/title_bar_left_first
	public WebElement locateGoBackIcon(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "goBackIcon";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//标题com.arisan1000.android:id/title_bar_title Isi ulang
	public WebElement locateChargeTitle(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "chargeTitle";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getChargeTitleExceptedStr() throws Exception {
		elementName = "chargeTitle";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//选择充值方式（文案）com.arisan1000.android:id/tv_recharge_pay_message
	public WebElement locateChargeMethodStr(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "chargeMethodStr";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getChargeMethodStrExceptedStr() throws Exception {
		elementName = "chargeMethodStr";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//充值方式列表 com.arisan1000.android:id/item_recharge_pay_method
	public List<WebElement> locatorChargeMethodList(AppiumDriver<WebElement> driver) throws Exception {
		elListName = "chargeMethodList";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}
	
	/*充值金额弹框*/
	//弹框标题：	com.arisan1000.android:id/select_amount Pilih jumlah pembayaran
	public WebElement locateChargeAlertTitle(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "chargeAlertTitle";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getChargeAlertTitleExceptedStr() throws Exception {
		elementName = "chargeAlertTitle";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//充值金额值（列表）：com.arisan1000.android:id/charge_amount 
	public List<WebElement> locatorChargeAmountList(AppiumDriver<WebElement> driver) throws Exception {
		elListName = "chargeAmountList";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}
	
	//cashback值（列表）：com.arisan1000.android:id/charge_amount_cash_back
	public List<WebElement> locatorCashBackList(AppiumDriver<WebElement> driver) throws Exception {
		elListName = "cashBackList";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}
	
	//充值金额单选框（列表）：com.arisan1000.android:id/iv_selected_item
	public List<WebElement> locatorSelectedBtnList(AppiumDriver<WebElement> driver) throws Exception {
		elListName = "selectedBtnList";
		return elementOperatedUtils.findElements(driver, elListName, FILENAME);
	}
	
	//金额选择确认按钮com.arisan1000.android:id/select_amount_confirm
	
	public WebElement locateSelectedAmountConfirm(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "selectedAmountConfirm";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getSelectedAmountConfirmExceptedStr() throws Exception {
		elementName = "selectedAmountConfirm";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	
	/*codapay 充值页面*/
	//电话输入框:input_phone_number
	public WebElement locateInputPhoneNumber(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "inputPhoneNumber";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	} 
	
	//电话输入确认按钮：mdn-submit
	public WebElement locateMdnSubmit(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "mdnSubmit";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//验证码输入框：input_otp
	public WebElement locateInputOtp(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "inputOtp";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//验证码确认按钮：otp-submit
	public WebElement locateOtpSubmit(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "otpSubmit";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	//codal支付确认按钮 continue
	public WebElement locateCodalPayConfirmBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "codalPayConfirm";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/*取消充值确认弹框*/
	//标题：com.arisan1000.android:id/tv_title  Proses akhir untuk dapat Hadiah
	public WebElement locateCancelChargeAlertTitle(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "cancelChargeAlertTitle";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getCancelChargeAlertTitleExceptedStr() throws Exception {
		elementName = "cancelChargeAlertTitle";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//继续按钮：com.arisan1000.android:id/btn_continue   Lanjutkan
	public WebElement locateContinueBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "continueBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getContinueBtnExceptedStr() throws Exception {
		elementName = "continueBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//取消按钮：com.arisan1000.android:id/tv_cancel  Batal
	public WebElement locateCancelBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "cancelBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getCancelBtnExceptedStr() throws Exception {
		elementName = "cancelBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	/****GP充值****/
	//购买按钮 com.android.vending:id/continue_button
	public WebElement locateGPRechargeBtg(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "gpRechargeBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	/****充值结果页面****/
	//购买成功文案com.arisan1000.android:id/tv_pay_result  Berhasil Isi ulang
	public WebElement locatePayResultText(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "payResultText";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getPayResultTextExceptedStr() throws Exception {
		elementName = "payResultText";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
	
	//确定按钮 com.arisan1000.android:id/btn_single Konfirmasi
	public WebElement locatePayResultConfirmBtn(AppiumDriver<WebElement> driver) throws Exception {
		elementName = "payResultConfirmBtn";
		el = elementOperatedUtils.findElement(driver, elementName, FILENAME);
		return el;
	}
	
	public String getPayResultConfirmBtnExceptedStr() throws Exception {
		elementName = "payResultConfirmBtn";
		return elementOperatedUtils.getExpectedText(elementName, FILENAME);
	}
}

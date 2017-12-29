package com.arisan1000.utils;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class DriverConfig {

//	private static AppiumDriverLocalService service;

	/**
	 * 初始化appium driver
	 * @return
	 * @throws Exception
	 */
	public static AppiumDriver<WebElement> CreatAppiumDriver() throws Exception {
		AppiumDriver<WebElement> driver = null;
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "Apps");
        
        File app = new File(appDir.getCanonicalPath(), "ARISAN_OD_V2.1.1.540.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Emulator");
//        capabilities.setCapability("deviceName","127.0.0.1:62001");
//        capabilities.setCapability("appPackage", "com.arisan1000.android");
//        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("noReset", true);
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		return driver;
	}
}

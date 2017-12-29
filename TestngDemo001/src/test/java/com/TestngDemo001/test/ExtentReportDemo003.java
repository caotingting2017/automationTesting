package com.TestngDemo001.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.TestngDemo001.utils.ExtentReportConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo003 {

	public static ExtentReports extentReports;
	public static ExtentTest test;
	@BeforeSuite
	public void beforeSuite() {
		extentReports = ExtentReportConfig.getInstance();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method){
		test = extentReports.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName()); 
		test.assignAuthor("tina");
		test.assignCategory(this.getClass().getSimpleName()); 
	}
	
	@Test(groups="demoTest003")
	public void test001(){
		System.out.println("demo test");
		assertEquals("abc", "acc");
	}
	
	@Test(groups="demoTest003")
	public void test002(){
		assertTrue(true);
	}
	
	@Test(groups="demoTest003")
	public void test003(){
		assertEquals("abb", "abc");
	}
	
	@Test
	public void test004(){
		assertEquals("bcd", "bcd");
	}
	
	
	@AfterMethod(groups="demoTest003")
	public void afterMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE){
//			test.log(null, "结果与期望值不符");
			test.log(LogStatus.FAIL, ""+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(LogStatus.PASS, ""+result.getName()+"::"+result.toString());
		}else{
			test.log(LogStatus.INFO, result.toString());
		}
		
		extentReports.endTest(test);
		extentReports.flush();
	}
	
	@AfterSuite
	public void afterSuite() {
		// System.out.println("in afterSuite");
//		extentReports.close(); // close the Test Suite
	}
}

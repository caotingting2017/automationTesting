package com.TestngDemo001.test;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo001 {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTestInterruptedException testexception;

	@BeforeSuite
	public void beforeSuite() {
		// Report Directory and Report Name
		extent = new ExtentReports(new File(System.getProperty("user.dir"))+"/extendReports/report.html"); 
		// Provide Desired Report Directory Location and Name
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml")); // Supporting File for Extent Reporting
		extent.addSystemInfo("Environment", "QA-Sanity"); // It will provide Execution Machine Information
		System.out.println("before suite==========="+new File(System.getProperty("user.dir")).getAbsolutePath());
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(" in Before Test ");
	}

	// Messages on Categories Section of HTML Report

	@BeforeMethod
	public void beforeMethod(Method method) {
		test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName()); 
		// Test Case Start Here
		test.assignAuthor("tina"); // Test Script Author Name
		test.assignCategory(this.getClass().getSimpleName()); 
		// Test Category Defined Here
	}

	// Write Your Test Script Here

	// Test Case 1
	@Test
	public void testCase1() {
		System.out.println("in test case 2");
		test.log(LogStatus.PASS, "Step details");
	}

	// Test Case 2
	@Test
	public void testCase2() {
		System.out.println("in test case 2");
		test.log(LogStatus.FAIL, "Step details");
	}

	// Test Case Reporting Ends Here
	@AfterMethod
	public void afterMethod() {
		extent.endTest(test);
		extent.flush();
	}

	@AfterTest
	public void afterTest() {
		System.out.println(" in After Test");
	}

	@AfterSuite(groups = { "Sanity" })
	public void afterSuite() {
		// System.out.println("in afterSuite");
		extent.close(); // close the Test Suite
	}
}

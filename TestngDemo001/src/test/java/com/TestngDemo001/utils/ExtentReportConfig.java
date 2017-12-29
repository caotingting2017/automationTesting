package com.TestngDemo001.utils;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportConfig {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance(){
		if(extent == null){
			extent = new ExtentReports(new File(System.getProperty("user.dir"))+"/extendReports/report002.html"); 
			// Provide Desired Report Directory Location and Name
			extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml")); // Supporting File for Extent Reporting
			extent.addSystemInfo("Environment", "arisan1000"); // It will provide Execution Machine Information
		}
		return extent;
	}
}

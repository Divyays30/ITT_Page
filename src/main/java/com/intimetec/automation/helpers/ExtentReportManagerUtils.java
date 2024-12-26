package com.intimetec.automation.helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManagerUtils {
    public static ExtentReports extent;
    private static ExtentTest test;

    // Initialize ExtentReports
    public static synchronized ExtentReports createExtentReports() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-reports/report.html"); // Output report file
            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester", "QA Team");
            extent.setSystemInfo("Environment", "Production");
        }
        return extent;
    }

    // Create a test instance
    public static synchronized ExtentTest createTest(String testName) {
        if (extent != null) {
            test = extent.createTest(testName);
        }
        return test;
    }

    // Close the report
    public static synchronized void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static synchronized ExtentTest getTest() {
        return test;
    }
}

package com.max;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(
                "C:\\Users\\mohan\\OneDrive\\Documents\\Workspaces\\Software-Testing_22-26\\Day 10\\extendreports\\test-output\\report.html");
        extent.attachReporter(reporter);
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setDocumentTitle("Test Report");
        ExtentTest test1 = extent.createTest("TC_001");
        test1.log(Status.PASS, "TC_001 : Pass");
        ExtentTest test2 = extent.createTest("TC_002");
        test2.log(Status.FAIL, MediaEntityBuilder
        .createScreenCaptureFromPath("C:\\Users\\mohan\\OneDrive\\Documents\\Workspaces\\Software-Testing_22-26\\Day 10\\extendreports\\screenshots\\1.png")
        .build());

        extent.flush();

    }
}

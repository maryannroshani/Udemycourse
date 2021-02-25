package Selenium;

import Resources.ExtentReporterNG;
import Resources.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends base implements ITestListener {
    ExtentTest test;

    ExtentReports extent = ExtentReporterNG.getReportObject();

    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest("First Demo");
    }

    public void onTestSuccess(ITestResult result) {
    test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());
        //Screenshot
        WebDriver driver = null;
    String testMethodName= result.getMethod().getMethodName();
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e)
        {

        }
        try {
            getScreenshot(testMethodName, driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
    extent.flush();
    }
}

package utils;

import base.BaseUI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.getReportObject();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("🔥 LISTENER HIT - FAILURE TRIGGERED");

        try {
            WebDriver driver = BaseUI.driver;

            if (driver == null) return;

            String base64 = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BASE64);

            test.fail(result.getThrowable(),
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(base64)
                            .build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
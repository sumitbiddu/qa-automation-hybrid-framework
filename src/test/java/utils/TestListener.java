package utils;

import base.BaseUI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    ExtentReports extent;
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.getReportObject();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
    	System.out.println("🔥 LISTENER HIT - FAILURE TRIGGERED");

        test.get().fail(result.getThrowable());

        try {
            WebDriver driver = BaseUI.driver;

            if (driver == null) return;

            // ✅ CI SAFE: Base64 screenshot (BEST PRACTICE)
            String base64 = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BASE64);

            test.get().addScreenCaptureFromBase64String(base64);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
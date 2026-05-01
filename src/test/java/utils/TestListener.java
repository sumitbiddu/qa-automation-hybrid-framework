package utils;

import base.BaseUI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {

    ExtentReports extent;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.getReportObject();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().pass("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("🔥 LISTENER HIT - FAILURE TRIGGERED");

        getTest().fail("Test Failed: " + result.getMethod().getMethodName());
        getTest().fail(result.getThrowable());

        try {
            WebDriver driver = BaseUI.driver;

            if (driver == null) {
                System.out.println("❌ DRIVER IS NULL");
                return;
            }

            // 📸 Screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String folderPath = System.getProperty("user.dir") + "/screenshots/";
            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String fileName = result.getMethod().getMethodName()
                    + "_" + System.currentTimeMillis() + ".png";

            File dest = new File(folderPath + fileName);

            FileUtils.copyFile(src, dest);

            System.out.println("🔥 SCREENSHOT SAVED AT: " + dest.getAbsolutePath());

            getTest().addScreenCaptureFromPath("screenshots/" + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("🔥 EXTENT REPORT GENERATED");
    }
}
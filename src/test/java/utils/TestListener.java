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

            if (driver == null) {
                System.out.println("❌ DRIVER IS NULL");
                return;
            }

            // 📸 Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 📁 Create folder
            String folderPath = System.getProperty("user.dir") + "/screenshots/";
            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            // 🖼️ File name
            String fileName = result.getMethod().getMethodName()
                    + "_" + System.currentTimeMillis() + ".png";

            File dest = new File(folderPath + fileName);

            // 💾 Save screenshot
            FileUtils.copyFile(src, dest);

            System.out.println("🔥 SCREENSHOT SAVED AT: " + dest.getAbsolutePath());

            // 📊 Attach to Extent Report
            test.fail(result.getThrowable());
            test.addScreenCaptureFromPath("screenshots/" + fileName);

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
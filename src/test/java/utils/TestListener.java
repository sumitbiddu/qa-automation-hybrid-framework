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
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.getReportObject();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        try {
            WebDriver driver = BaseUI.driver;

            if (driver == null) return;

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

            test.get().addScreenCaptureFromPath("screenshots/" + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
    	String path = "reports/index.html";
        System.out.println("🔥 EXTENT REPORT GENERATED AT: " + path);

        extent.flush();
    }
}
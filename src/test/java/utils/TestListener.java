package utils;

import base.BaseUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    //  Screenshot method
    public void captureScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + testName + ".png");

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  On Test Failure
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            WebDriver driver = BaseUI.driver;

            if (driver == null) {
                System.out.println("Driver is null, cannot take screenshot");
                return;
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File folder = new File(System.getProperty("user.dir") + "/screenshots");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String fileName = result.getName() + "_" + System.currentTimeMillis() + ".png";

            File dest = new File(folder, fileName);

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // (Optional but good for logs)
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }
}

package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {

        if (extent == null) {

            // 🔥 FORCE ROOT SAFE PATH
            String path = System.getProperty("user.dir") + "/reports/index.html";

            File reportDir = new File(System.getProperty("user.dir") + "/reports");
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("QA Automation Results");
            reporter.config().setDocumentTitle("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", "Sumit");
            extent.setSystemInfo("Env", "CI + Local");
        }

        return extent;
    }
}